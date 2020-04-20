package delivery_member.adminaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.svc.LoginAdminSVC;
import delivery_member.adminsvc.Member_admin_InfoSvc;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Member;
import rider.vo.Admin;

public class Member_admin_infoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("adminid");
	    LoginAdminSVC loginadminsvc=new LoginAdminSVC();
	    Admin admin=null;
	    admin=loginadminsvc.AdminLogin(id);
		
		
	    if((id!=null && id.equals(admin.getAdmin_id()))){
	    	String member_id=request.getParameter("id");
	    	Member_admin_InfoSvc infoSvc=new Member_admin_InfoSvc();
			Member member=infoSvc.getinfo(member_id);
		    
		   
		    if(member!=null) {
		    	request.setAttribute("member", member);
		    	forward=new ActionForward("member_admin/member_admin_info.jsp",false);
		    	
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
