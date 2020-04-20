package delivery_member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery_member.svc.LoginSVC;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Member;

public class CheckidAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String checkname=request.getParameter("checkname");
		String checkemail=request.getParameter("checkemail");
		ActionForward forward=null;
		Member member=null;
		LoginSVC loginsvc=new LoginSVC();
		
		member=loginsvc.memberLoginnameCheck(checkname);
		HttpSession session=request.getSession();

		if(checkname!=null&&!checkname.equals("")&&checkemail!=null&&!checkname.equals("")) {
			if(checkname.equals(member.getMember_name())&&checkemail.equals(member.getMember_email())) {
				
			String certifykey="";
			
			for(int i=0;i<5;i++) {
				double dValue=Math.random();
				char cValueN=(char)((dValue*10)+48);
				certifykey+=cValueN;
			}
			
			session.setAttribute("certifykey", certifykey);
			session.setAttribute("checkemail", checkemail);
			session.setAttribute("checkname",checkname);
			
			forward=new ActionForward("mailSendId",true);
		}else{
			PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("alert('이름과 이메일을 다시 확인하세요.')");
		out.println("window.close();");
		out.println("</script>");}
			}else {
			
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('이름과 이메일을 다시 확인하세요.')");
			out.println("window.close();");
			out.println("</script>");
		}
		return forward;
	}

}
