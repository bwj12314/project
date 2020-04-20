package rider.log.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import rider.log.svc.CheckActionSVC;
import rider.log.svc.LoginSVC;
import rider.vo.ActionForward;
import rider.vo.Rider;

public class CheckpassAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String checkid=request.getParameter("checkid");
		String checkemail=request.getParameter("checkemail");
		ActionForward forward=null;
		Rider rider=null;
		LoginSVC loginsvc=new LoginSVC();
		rider=loginsvc.RiderLogin(checkid);
		HttpSession session=request.getSession();
		if(checkid!=null && !checkid.equals("") && !checkemail.equals("")&& checkemail!=null) {
			
		
		if(rider!=null) {
		if(checkid.equals(rider.getRider_id()) && checkemail.equals(rider.getRider_email())) {
			String password="";
			int lotate=0;
			while(lotate<10) {
				double dValue=Math.random();
				char cValue=(char)((dValue*70)+40);
				password=password+cValue+"";
				lotate++;
			}
			
			session.setAttribute("email", rider.getRider_email());
			session.setAttribute("password", password);
			
			CheckActionSVC checkactionsvc=new CheckActionSVC();
			boolean result=checkactionsvc.updatepassword(checkid,password);
			if(result) {
				forward=new ActionForward("rider/mailFormPass.jsp",false);
				
			}else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('임시비밀번호 발송에 실패하였습니다.')");
				out.println("location.href='loginForm.riderlog'");
				out.println("</script>");
			}
			
			
		}}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('아이디와 이메일을 확인하세요.');");
			out.println("history.back();");
			out.println("</script>");
		}}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('아이디와 이메일을 확인하세요.');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
