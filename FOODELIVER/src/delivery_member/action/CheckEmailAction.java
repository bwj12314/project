package delivery_member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery_member.svc.LoginSVC;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Member;

public class CheckEmailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String checkemail=request.getParameter("checkemail");
		
		ActionForward forward=null;
		Member member=null;
		if(!checkemail.trim().equals("")) {
		LoginSVC loginsvc=new LoginSVC();
		
		member=loginsvc.MemberLoginemailCheck(checkemail);
		HttpSession session=request.getSession();
		if(member==null) {
			String certifykey="";
			for(int i=0;i<5;i++) {
				double dValue=Math.random();
				char cValueN=(char)((dValue*10)+48);
				certifykey+=cValueN;
			}
			
			session.setAttribute("certifykey", certifykey);
			session.setAttribute("checkemail", checkemail);
			forward=new ActionForward("mailSendCertify",false);
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('이미 가입이 처리된 이메일입니다.')");
			out.println("window.close();");
			out.println("</script>");
		}
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('이메일 주소가 비어있습니다.')");
			out.println("window.close();");
			out.println("</script>");
		}
		return forward;
	}

}
