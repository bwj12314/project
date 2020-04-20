package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import admin.svc.LoginAdminSVC;
import admin.svc.RiderInfoSVC;
import rider.vo.ActionForward;
import rider.vo.Admin;
import rider.vo.Rider;


public class RiderInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("adminid");
	    LoginAdminSVC loginadminsvc=new LoginAdminSVC();
	    Admin admin=null;
	    admin=loginadminsvc.AdminLogin(id);
		
		
	    if((id!=null && id.equals(admin.getAdmin_id()))){
	    	String rider_id=request.getParameter("id");
		    RiderInfoSVC riderinfosvc=new RiderInfoSVC();
		    Rider rider=null;
		    rider=riderinfosvc.getRiderInfo(rider_id);
		    if(rider!=null) {
		    	request.setAttribute("rider", rider);
		    	forward=new ActionForward("admin/admin_rider_info.jsp",false);
		    	
		    }else {
		    	response.setContentType("text/html;charset=utf-8");
			    PrintWriter out=response.getWriter();
				out.println("<script>");
			    out.println("alert('오류발생')");
			    out.println("location.href='adminMain.jsp'");
			    out.println("</script>");
		    }
	    }else {
	    	PrintWriter out=response.getWriter();
    		out.println("<script>");
    		out.println("alert('관리자 아이디로 로그인하세요'");
    		out.println("loaction.href='admin/loginForm.jsp'");
    		out.println("</script>");
	    }
		return forward;
	}

}
