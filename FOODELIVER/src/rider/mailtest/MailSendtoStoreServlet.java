package rider.mailtest;

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


/**
 * Servlet implementation class MailSendtoStoreServlet
 */
@WebServlet("/mailSendtoStore")
public class MailSendtoStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailSendtoStoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String sender=request.getParameter("sender");
		String receiver=request.getParameter("receiver");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
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
			out.println("alert('가게로 메일 전송이 완료되었습니다');");
			out.println("location.href='rider/deliveryInfoDetail.jsp';");
			out.println("</script>");
			
			
		}catch(Exception e) {
			out.println("오류가 발생하였습니다.");
			
			e.printStackTrace();
		}
	}

}
