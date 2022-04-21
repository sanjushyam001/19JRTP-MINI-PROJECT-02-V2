package in.ashokit.service.impl;



import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import in.ashokit.service.EmailService;


@Service
public class EmailServiceImpl implements EmailService{

	
	//create java mail sender object
	@Autowired
	private JavaMailSender mailSender;
	
	
	
	@Override
	public boolean sendEmail(String toEmail, String subject, String body) {
	
		
		try {
			MimeMessage mimeMessage=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
			
			helper.setFrom("kumarsanjuashokit@gmail.com");
			helper.setTo(toEmail);
			helper.setSubject(subject);
			helper.setText(body,true);
			
			
			mailSender.send(mimeMessage);
			return true;
		}catch (Exception e) {
			System.out.println(e.getMessage()); 
			return false;
		}
		
	}

}
