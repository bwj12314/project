package delivery_member.controller.mailcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery_member.vo.GoogleAuthentication;

/**
 * Servlet implementation class MailSendCertifyServlet
 */
@WebServlet("/mailSendCertify")
public class mailSendCertifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mailSendCertifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String certifykey=(String)session.getAttribute("certifykey");
		String checkemail=(String)session.getAttribute("checkemail");
		String sender="bwj12313@gmail.com";
		String receiver="bwj12313@gmail.com";
		String subject="이메일 인증 번호입니다.";
		String content=(String)session.getAttribute("certifykey");
		response.setContentType("text/html;charset=UTF-8"); //응답받아서 처리하는 구분이 html charset=UTF-8
		PrintWriter out=response.getWriter();
		try {
			Properties properties=System.getProperties();
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host","smtp.gmail.com");
			properties.put("mail.smtp.auth","true");
			properties.put("mail.smtp.port","587");
			Authenticator auth=new GoogleAuthentication();
			Session s=Session.getDefaultInstance(properties,auth);
			Message message=new MimeMessage(s);
			Address sender_address=new InternetAddress(sender);
			Address receiver_address=new InternetAddress(receiver);
			message.setHeader("content-type", "text/html;charset=UTF-8");
			message.setFrom(sender_address);
			message.addRecipient(Message.RecipientType.TO, receiver_address);
			message.setSubject(subject);
			message.setContent(content,"text/html;charset=UTF-8");
			message.setSentDate(new java.util.Date());
			Transport.send(message);
			
			
			out.println("<script>");
			out.println("alert('메일이 전송되었습니다. 전송되지 않았을 경우에 정보를 다시 확인하세요');");
			out.println("window.close()");
			out.println("</script>");
			
			
		}catch(Exception e) {
			out.println("<script>");
			out.println("alert('이메일을 입력하세요');");
			out.println("window.close();");
			out.println("</script>");
			e.printStackTrace();
		}
	}

}
