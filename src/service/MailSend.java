package service;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * mail�� ������ ���� Ŭ�����̴�.
 * @author GHKwon
 *
 */
public class MailSend  {
	/**
	 * �߼��� �̸��� �ּҵ�
	 */
	private String[] sendAddress;
	/**
	 * ���� �����»��.
	 */
	private String emailFromAddress;
	/**
	 * ���� ���� ����.
	 */
	private String emailMsgTxt;
	/**
	 * ���� ����.
	 */
	private String emailSubjectTxt;
	
	/**
	 * �Ѹ��� �̸����� �߼��� �� ȣ��Ǵ� �������̴�. 
	 * @param sendAddress ������� �Ѹ��� �̸����ּ�.
	 * @param emailFromAddress �̸��� �߼��ϴ»��.
	 * @param emailMsgTxt �̸��� ����
	 * @param emailSubjectTxt �̸��� ����.
	 */
	public MailSend(String sendAddress, String emailFromAddress, String emailMsgTxt,String emailSubjectTxt) {
		this(new String[]{sendAddress},emailFromAddress,emailMsgTxt,emailSubjectTxt);
	}
	/**
	 * �������� �̸����� �߼��� �� ȣ��Ǵ� �������̴�.
	 * @param sendAddress ������� �������� �̸����ּ�.
	 * @param emailFromAddress �̸��� �߼��ϴ»��.
	 * @param emailMsgTxt �̸��� ����.
	 * @param emailSubjectTxt �̸��� ����.
	 */
	public MailSend(String sendAddress[], String emailFromAddress, String emailMsgTxt,String emailSubjectTxt) {
		this.sendAddress=sendAddress;
		this.emailFromAddress=emailFromAddress;
		this.emailMsgTxt=emailMsgTxt;
		this.emailSubjectTxt=emailSubjectTxt;
		testMailSend();
	}
	/**
	 * ������ ������ �޼ҵ�.
	 * ���ο��� private��, postMail�޼ҵ带 ȣ���Ѵ�.
	 */
	public void testMailSend(){
		try {
			// ���Ϻ����� 
			postMail( sendAddress , emailSubjectTxt, emailMsgTxt, emailFromAddress);
			/*System.out.println("��� ����ڿ��� ������ ���������� ��������~~");*/
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �̸����� �����ִ� �޼ҵ�.
	 * @param recipients �޴»��(n)�� �ּ�.
	 * @param subject �̸��� ����
	 * @param message �̸��� ����.
	 * @param from �̸��� �����»��.
	 * @throws MessagingException �޽��� ���ۿ� �ʿ��� �޼ҵ���� �̿� �ش��ϴ� �ͼ����� �߻��Ѵ�.
	 */
	private void postMail(String recipients[], String subject, String message, String from) throws MessagingException {
		boolean debug = false;
		java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		String SMTP_HOST_NAME = "gmail-smtp.l.google.com";
		// Properties ����
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
 
		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props, auth);
 
		session.setDebug(debug);
 
		// create a message
		Message msg = new MimeMessage(session);
		
		// set the from and to address
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);
 
		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++) {
			addressTo[i] = new InternetAddress(recipients[i]);
		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);
 
		// Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(message, "text/plain; charset=utf-8");

		Transport.send(msg);
	}
	/**
	 * ���� ����� ���� ���� ���̵�/�н� ����
	 * userName��  �Ǳ�ȣ�� ������ �Ǳ�ȣ ���̵��̰�.
	 * password�� �Ǳ�ȣ�� �߱޹��� password�̴�.
	 */
	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			String username =  "rlgh9351@gmail.com"; // gmail �����;
			String password = "nhmcgqairfplgwvl"; // �н�����;
			return new PasswordAuthentication(username, password);
		}
	}
	/*
	 * �����׽�Ʈ
	 */
	public static void main(String []args) {
		new MailSend("rlgh9351@gmail.com","rlgh9351@gmail.com","asdf�ѱ�","��������");
	}
}
