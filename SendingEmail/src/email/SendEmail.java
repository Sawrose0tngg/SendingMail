package email;

import java.util.Properties;

import javax.mail.*; 
import javax.mail.PasswordAuthentication;
import javax.mail.internet.*;


public class SendEmail {
	
	public static void main(String[] args) {

		/*To make work first of:
		 * 1. all turn off window firewall(goto window and search for window firewall and turn off all the window firewall features)
		 * 2. Goto gmail and make you gmail less secure app. 
		 * 3. restart your eclipse and run it.. Now it is done...*/
		
		final String username = "sender_ID";
		final String password = "password";

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
			message.setFrom(new InternetAddress("sender_ID"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("receiver_ID"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Saw,"
				+ "I just wanted to check whether mail is sent from me or not??");
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
