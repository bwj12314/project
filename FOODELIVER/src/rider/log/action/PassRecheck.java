package rider.log.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import rider.log.svc.LoginSVC;
import rider.vo.ActionForward;
import rider.vo.Rider;

public class PassRecheck implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String pass=request.getParameter("pass");
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("riderid");
		ActionForward forward=null;
		LoginSVC loginSVC=new LoginSVC();
		
		Rider rider=null;
		rider=loginSVC.RiderLogin(id);
		if(rider.getRider_pass().equals(pass)) {
			forward=new ActionForward("rider/rider_realmod.jsp",false);
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		
		return forward;
	}

}
