package rider.log.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import rider.log.svc.LoginSVC;
import rider.vo.ActionForward;
import rider.vo.Rider;

public class CheckEmailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String checkemail=request.getParameter("checkemail");
		
		ActionForward forward=null;
		Rider rider=null;
		LoginSVC loginsvc=new LoginSVC();
		
		rider=loginsvc.RiderLoginemailCheck(checkemail);
		HttpSession session=request.getSession();
		if(rider==null) {
			String certifykey="";
			for(int i=0;i<5;i++) {
				double dValue=Math.random();
				char cValueN=(char)((dValue*10)+48);
				certifykey+=cValueN;
			}
			
			session.setAttribute("certifykey", certifykey);
			session.setAttribute("checkemail", checkemail);
			forward=new ActionForward("rider/mailFormId.jsp?option=email",false);
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('이미 가입이 처리된 이메일입니다.')");
			out.println("window.close();");
			out.println("</script>");
		}
		
		return forward;
	}

}
