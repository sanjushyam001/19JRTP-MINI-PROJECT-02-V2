package in.ashokit.service;

public interface EmailService {

	public boolean sendEmail(String toEmail,String subject,String body);
}
