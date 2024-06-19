package br.com.rappi.sp;

import java.util.Date;

import br.com.rappi.sp.config.AuthInterceptor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableBatchProcessing
@EnableScheduling
@EnableFeignClients
@SpringBootApplication
public class RappiExportApplication {

	private static final Logger log = LogManager.getLogger(RappiExportApplication.class);

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	@Autowired 
	JavaMailSender mailSender;

	@Autowired
	Environment env; 
	
	
	public static void main(String[] args) {
		SpringApplication.run(RappiExportApplication.class, args);
	}
	
	@Bean
	public AuthInterceptor authFeign() {
		return new AuthInterceptor();
	}

	// SCHEDULE QUE EXECUTA A CADA TEMPO
	@Scheduled(cron = "0 0/30 8-19 * * *", zone="America/Sao_Paulo")
	public void executaJobScheduler() {

		try {
			JobParameters params = new JobParametersBuilder()
					.addString("JobID", String.valueOf(System.currentTimeMillis()))
					.toJobParameters();
			jobLauncher.run(job, params);
		} catch (Exception e) {
			log.log(Level.ERROR, () -> "Erro na execução da Job: " + e.getMessage()); 
			sendEmail("Erro na execução da Job");
		}
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

}
