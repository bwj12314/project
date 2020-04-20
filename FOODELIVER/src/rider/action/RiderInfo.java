package rider.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import rider.svc.RiderInfoService;
import rider.vo.ActionForward;
import rider.vo.Rider;

public class RiderInfo implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String Option=request.getParameter("Option");
	    if(session.getAttribute("riderid")==null){
	    	
	    	response.setContentType("text/html;charset=utf-8");
	    	PrintWriter out=response.getWriter();
    		out.println("<script>");
    		out.println("alert('로그인을 하세요');");
	    	out.println("location.href='loginForm.riderlog';");
	    	out.println("</script>");
	    }else {
	    	
	    	String info_id=(String)session.getAttribute("riderid");
		    RiderInfoService riderinfoservice=new RiderInfoService();
		    Rider rider=null;
		    rider=riderinfoservice.getRiderInfo(info_id);
		    
		    if(rider!=null) {
		    	session.setAttribute("rider", rider);
		    	if(Option.equals("see"))
		    		forward=new ActionForward("rider/rider_info.jsp",false);
		    	if(Option.equals("mod"))
		    		forward=new ActionForward("rider/rider_mod.jsp",false);
		    }else {
		    	response.setContentType("text/html;charset=utf-8");
		    	PrintWriter out=response.getWriter();
				out.println("<script>");
			    	out.println("alert('오류발생')");
			    	out.println("location.href='rider/main.jsp'");
			    	out.println("</script>");
		    }
	    }
		return forward;
		
	}
}
