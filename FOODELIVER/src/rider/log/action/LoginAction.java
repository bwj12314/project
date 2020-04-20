package rider.log.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import rider.svc.RiderInfoService;
import rider.vo.ActionForward;
import rider.vo.Rider;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//값 처리, 서비스 객체 생성 메소드 사용(memberLogin) 매개 변수는 아이디 리턴값은 password나 member 객체 둘 중 하나 서비스에서는
		//맴버 객체 생성하고 
		//비밀번호 확인 session 생성 맞으면  main페이지로 틀리면 historyback
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		ActionForward forward=null;
		Rider rider=null;
		int riderstate=0;
		RiderInfoService riderinfoservice=new RiderInfoService();
		rider=riderinfoservice.getRiderInfo(id);
		
		
		
		if(rider==null||!pass.equals(rider.getRider_pass())) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('아이디가 없거나 비밀번호가 일치하지 않습니다.');");
			out.println("location.href='rider/loginForm.jsp'");
			out.println("</script>");
		}else {
			String rider_active=rider.getRider_active();
			if(rider.getRider_state().equals("배달중")) {
				riderstate=1;
			}
			
				HttpSession session=request.getSession();
				String ridername=rider.getRider_name();
				session.setAttribute("riderid", id);
				session.setAttribute("ridername", ridername);
				session.setAttribute("riderstate",riderstate);
				session.setAttribute("rider_active", rider_active);
				forward = new ActionForward("riderMain.jsp", true);
			}
		
		return forward;
	}

}
