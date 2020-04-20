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

import delivery_member.vo.GoogleAuthentication;



/**
 * Servlet implementation class ailSendServlet
 */
@WebServlet("*.mail")
public class mailSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mailSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	doPost(request, response);
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		String subject="";
		String content="";
		System.out.println(command);
		if(command.equals("/company_app.mail")) {
			System.out.println(1);
			subject="기업 신청서";
			String company_name=request.getParameter("company_name");
			String company_ceo=request.getParameter("company_ceo");
			String company_tel=request.getParameter("company_tel");
			String company_businum=request.getParameter("company_businum");
			String company_address1=request.getParameter("company_address1");
			String company_address2=request.getParameter("company_address2");
			String company_address3=request.getParameter("company_address3");
			String company_address4=request.getParameter("company_address4");
			content="회사이름 : "+company_name+"<br>"
					+"CEO : "+company_ceo+"<br>"
					+"회사 전화번호 : "+company_tel+"<br>"
					+"사업자 등록번호 : "+company_businum+"<br>"
					+"회사 우편번호 : "+company_address1+"<br>"
					+"회사 주소 : "+company_address2+"<br>"
					+"회사 상세주소 : "+company_address3+"<br>"
					+"참고 항목 : "+company_address4;
		}else if(command.equals("/rider_app.mail")) {
			System.out.println(2);
			subject="라이더 신청서";
			String rider_name=request.getParameter("rider_name");
			String rider_tel=request.getParameter("rider_tel");
			String rider_email=request.getParameter("rider_email");
			String rider_address1=request.getParameter("rider_address1");
			String rider_address2=request.getParameter("rider_address2");
			String rider_address3=request.getParameter("rider_address3");
			String rider_address4=request.getParameter("rider_address4");
			String rider_license=request.getParameter("rider_license").equals("t")?"있음":"없음";
			content="이름 : "+rider_name+"<br>"
					+"전화번호 : "+rider_tel+"<br>"
					+"이메일 : "+rider_email+"<br>"
					+"우편번호 : "+rider_address1+"<br>"
					+"주소 : "+rider_address2+"<br>"
					+"상세주소 : "+rider_address3+"<br>"
					+"참고항목 : "+rider_address4+"<br>"
					+"면허 여부 : "+rider_license;
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		try {
			Properties properties=System.getProperties();
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.port", "587");
			Authenticator auth=new GoogleAuthentication();
			Session s=Session.getDefaultInstance(properties,auth);
			Message message=new MimeMessage(s);
			Address sender_addres=new InternetAddress("bwj12313@gmail.com");
			Address receiver_addres=new InternetAddress("bwj12313@gmail.com");
			message.setHeader("content-type", "text/html;charset=UTF-8");
			message.setFrom(sender_addres);
			message.addRecipient(Message.RecipientType.TO, receiver_addres);
			message.setSubject(subject);
			message.setContent(content,"text/html;charset=UTF-8");
			message.setSentDate(new java.util.Date());
			Transport.send(message);

			out.println("<script>");
			out.println("alert('정상적으로 발송되었습니다.')");
			out.println("location.href='main.jsp'");
			out.println("</script>");
			
		} catch (Exception e) {
			out.println("SMTP 서버가 잘못 설정되었거나, 서비스에 문제가 있습니다");
			e.printStackTrace();
		}
	}

}
