package com.example.sendemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@SpringBootApplication
public class SpringBootSendEmailApplication implements CommandLineRunner {
	@Autowired
	private JavaMailSender javaMailSender;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSendEmailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sending Email...");
		sendEmail();
		System.out.println("Done");
	}
	void sendEmail() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("sourceemail@gmail.com", "destinationemail@gmail.com");
		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");
		javaMailSender.send(msg);
	}
	void sendEmailWithAttachment() throws MessagingException, IOException {
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo("1@gmail.com");
		helper.setSubject("Testing from Spring Boot");
		helper.setText("<h1>Check attachment for image!</h1>", true);
		helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));
		javaMailSender.send(msg);
	}
}
