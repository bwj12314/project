package rider.log.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import rider.log.svc.LoginSVC;
import rider.vo.ActionForward;
import rider.vo.Rider;

public class CheckidAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String checkname=request.getParameter("checkname");
		String checkemail=request.getParameter("checkemail");
		ActionForward forward=null;
		Rider rider=null;
		LoginSVC loginsvc=new LoginSVC();
		
		rider=loginsvc.RiderLoginidCheck(checkname);
		HttpSession session=request.getSession();
		
		if(checkname!=null&&!checkname.equals("")&&checkemail!=null&&!checkname.equals("")) {
			if(rider!=null) {
			if(checkname.equals(rider.getRider_name())&&checkemail.equals(rider.getRider_email())) {
			String certifykey="";
			
			for(int i=0;i<5;i++) {
				double dValue=Math.random();
				char cValueN=(char)((dValue*10)+48);
				certifykey+=cValueN;
			}
			
			session.setAttribute("certifykey", certifykey);
			session.setAttribute("checkemail", checkemail);
			session.setAttribute("checkname",checkname);
			forward=new ActionForward("rider/mailFormId.jsp?option=id",false);
		}}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('이름과 이메일을 다시 확인하세요.')");
			out.println("window.close();");
			out.println("</script>");
		}}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('이름과 이메일을 다시 확인하세요.')");
			out.println("window.close();");
			out.println("</script>");
		}
		return forward;
	}

}
