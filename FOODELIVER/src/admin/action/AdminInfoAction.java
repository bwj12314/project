package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import admin.svc.LoginAdminSVC;
import rider.vo.ActionForward;
import rider.vo.Admin;


public class AdminInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String Option=request.getParameter("Option");
	    if(session.getAttribute("adminid")==null){
	    	
	    	response.setContentType("text/html;charset=utf-8");
	    	PrintWriter out=response.getWriter();
    		out.println("<script>");
    		out.println("alert('로그인을 하세요');");
	    	out.println("location.href='admin/loginForm.jsp';");
	    	out.println("</script>");
	    }else {
	    	
	    	String info_id=(String)session.getAttribute("adminid");
		    LoginAdminSVC loginadminsvc=new LoginAdminSVC();
		    Admin admin=null;
		    admin=loginadminsvc.AdminLogin(info_id);
		    
		    if(admin!=null) {
		    	session.setAttribute("admin", admin);
		    	if(Option.equals("see"))
		    		forward=new ActionForward("admin/admin_info.jsp",false);
		    	if(Option.equals("mod"))
		    		forward=new ActionForward("admin/admin_mod.jsp",false);
		    }else {
		    	response.setContentType("text/html;charset=utf-8");
		    	PrintWriter out=response.getWriter();
				out.println("<script>");
			    	out.println("alert('오류발생')");
			    	out.println("location.href='adminMain.jsp'");
			    	out.println("</script>");
		    }
	    }
		return forward;
	}

}
