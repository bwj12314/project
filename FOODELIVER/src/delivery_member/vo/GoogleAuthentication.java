package delivery_member.vo;



import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GoogleAuthentication extends Authenticator{
	PasswordAuthentication	passAuth;

	public GoogleAuthentication() {
		passAuth =new PasswordAuthentication("bwj12313", "fthtkclywgnmmeql");
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return passAuth;
	}
	
}
