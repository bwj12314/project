package rider.mailtest;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GoogleAuthentication extends Authenticator{
	PasswordAuthentication passAuth;
	
	public GoogleAuthentication() {
		passAuth=new PasswordAuthentication("opti5453@gmail.com","uduunglrtrlsppiz");
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return passAuth;
	}
}
