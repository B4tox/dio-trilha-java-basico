package br.com.rappi.sp.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

	@Autowired
	Environment env;

	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost(env.getRequiredProperty("spring.mail.host"));
		mailSender.setPort(Integer.parseInt(env.getProperty("spring.mail.port")));

		mailSender.setUsername( env.getRequiredProperty("spring.mail.username")  );
		mailSender.setPassword( env.getRequiredProperty("spring.mail.password") );
		mailSender.setDefaultEncoding("utf-8");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.smtp.auth", env.getRequiredProperty("spring.mail.properties.mail.smtp.auth"));
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.test-connection", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}


}


