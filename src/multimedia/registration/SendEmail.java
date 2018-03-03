package multimedia.registration;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
    
	String token;
	
	SendEmail(String token){
		this.token = token;
	}
	
	boolean toAddress(String receiver) {

			final String username = "wallpapersite1@gmail.com";
			final String password = "adi101992";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("wallpapersite1@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
				message.setSubject("Password Reset");
				message.setText("your one time token is "+"http://localhost:8080/multimedia/resources/passwordChangeOtp/email="+receiver+"&token="+token);
				Transport.send(message);
   
				return true;

			} catch (MessagingException e) {
				e.printStackTrace();
				return false;
			}
		}
}
