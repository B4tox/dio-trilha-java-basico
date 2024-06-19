package br.com.rappi.sp.exception;

import java.io.IOException;
import java.util.Date;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

	private static final Logger log = LogManager.getLogger(CustomErrorDecoder.class);

	private final ErrorDecoder errorDecoder = new Default();

	@Autowired
	Environment env;

	@Autowired 
	JavaMailSender mailSender;

	@Override
	public Exception decode(String methodKey, Response response) {
		String message = null;
		StringBuilder sb = new StringBuilder();

		try {

			// NAO AUTORIZADO
			if( response.status() == 401) {
				log.error("Status 401: Verifique a API_KEY");
				return new ResponseStatusException(HttpStatus.valueOf(response.status()), " Verifique a API_KEY"); 
			} 

			Decoder.Default decoder = new Decoder.Default();
			String body = (String) decoder.decode(response, String.class);

			//USE A JACKSON OBJECTMAPPER TO CONVERT THE JSON STRING INTO A POJO
			ObjectMapper mapper = new ObjectMapper();

			//jUST IN CASE YOU MISSED AN ATTRIBUTE IN THE POJO     
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

			//MAPEIA O RETORNO 400
			ExceptionMessage exceptionMessage = mapper.readValue(body, ExceptionMessage.class);

			message = exceptionMessage.toString();

		} catch (IOException e) {
			log.error("Erro ", e);
		}

		switch (response.status()) {
		case 400:
			sb.append(message);
			log.log(Level.ERROR, () -> "Status 400: " + sb.toString()); 
			sendEmail(sb.toString());
			break; 
		case 403:
			sb.append(message);
			log.log(Level.ERROR, () -> "Status 403: " + sb.toString());
			sendEmail(sb.toString());
			break; 
		case 404:
			sb.append(message);
			log.log(Level.ERROR, () -> "Status 404: " + sb.toString());
			sendEmail(sb.toString());
			break;
		default:
			sb.append(message);
			log.log(Level.ERROR, () -> "Status " + response.status() + ": " + sb.toString());
			sendEmail(sb.toString());
		}

		return errorDecoder.decode(methodKey, response);
	}

	// SEND NOTIFICATION EMAIL
	private void sendEmail(String pMensagem) {

		try {

			String pEmails = env.getProperty("configuracao.rappi.emails");

			if( ! pEmails.equals("") ) {

				SimpleMailMessage msg = new SimpleMailMessage();
				msg.setTo(pEmails);

				msg.setSubject("Rappi Export Error");
				msg.setText(new Date()  + "\n" + "Erro: " + pMensagem);

				mailSender.send(msg);
			}

		} catch (Exception e) {
			log.log(Level.ERROR, () -> "Erro ao enviar email: " + e.getMessage());
		}
	}

	// EXCEPTION CLASS DETAILS
	public static class ExceptionMessage{

		private String field;
		private String description;
		private String internal;
		private int row;
		private String row_id;
		private String message;

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getInternal() {
			return internal;
		}

		public void setInternal(String internal) {
			this.internal = internal;
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public String getRow_id() {
			return row_id;
		}

		public void setRow_id(String row_id) {
			this.row_id = row_id;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		@Override
		public String toString() {
			return "Erro: [Campo=" + field + ", descricao=" + description + ", internal=" + internal
					+ ", row=" + row + ", row_id=" + row_id + ", mensagem=" + message + "]";
		}

	}



}