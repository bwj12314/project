package delivery_member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery_member.svc.CheckActionSVC;
import delivery_member.svc.LoginSVC;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Member;

public class CheckpassAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String checkid=request.getParameter("checkid");
		String checkemail=request.getParameter("checkemail");
		ActionForward forward=null;
		Member member=null;
		LoginSVC loginsvc=new LoginSVC();
		member=loginsvc.memberLogin(checkid);
		
		HttpSession session=request.getSession();
		if(member!=null) {
		if(checkid.equals(member.getMember_id())&&checkemail.equals(member.getMember_email())) {
			System.out.println("zz");
			String password="";
			int lotate=0;
			while(lotate<10) {
				double dValue=Math.random();
				char cValue=(char)((dValue*70)+40);
				password=password+cValue+"";
				lotate++;
			}
			
			session.setAttribute("email", member.getMember_email());
			session.setAttribute("password", password);
			
			CheckActionSVC checkactionsvc=new CheckActionSVC();
			boolean result=checkactionsvc.updatepassword(checkid,password);
			if(result) {
				forward=new ActionForward("mailSendPass",true);
				
			}else {
				
				out.println("<script>");
				out.println("alert('비밀번호 변경이 되지 않았습니다.')");
				out.println("location.href='loginform.mlog'");
				out.println("</script>");
			}
			
			
		}else{
			
			out.println("<script>");
			out.println("alert('이메일이 일치하지 않습니다.');");
			out.println("location.href='login/checkpass.jsp'");
			out.println("</script>");
		}}else {
			
			out.println("<script>");
			out.println("alert('아이디가 존재하지 않습니다.');");
			out.println("location.href='login/checkpass.jsp'");
			out.println("</script>");
		}
		return forward;
	}

}
