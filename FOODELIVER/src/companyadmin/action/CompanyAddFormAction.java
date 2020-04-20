package companyadmin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import admin.svc.LoginAdminSVC;
import rider.vo.Admin;

public class CompanyAddFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(); 
		ActionForward forward=null;
		String id=(String)session.getAttribute("adminid");
		Admin admin=new Admin();
		
		LoginAdminSVC loginadminsvc=new LoginAdminSVC();
		admin=loginadminsvc.AdminLogin(id);
		if((session.getAttribute("adminid")==null)||
		    		(!id.equals(admin.getAdmin_id()))){
			
		    response.setContentType("text/html;charset=utf-8");
		    PrintWriter out=response.getWriter();
		    
				out.println("<script>");
		    	out.println("alert('관리자로 로그인하세요')");
		    	out.println("location.href='admin/loginForm.jsp'");
		    	out.println("</script>");
		    }
		else {
		forward = new ActionForward();
		forward.setPath("company/CompanyAdd.jsp");
		forward.setRedirect(true);	
		}
		return forward;
	}

}
