package companyadmin.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import admin.svc.LoginAdminSVC;
import comp.vo.Company;
import companyadmin.svc.CompanyListSvc;
import rider.vo.Admin;

public class CompanyListAction implements Action {

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
		String company_id=request.getParameter("company_id");
		String admin_grade = request.getParameter("admin_grade");
		
				
		CompanyListSvc companylistsvc = new CompanyListSvc(); 	
		ArrayList<Company> companylist = companylistsvc.getCompanyList(company_id,admin_grade);		
		
		session.setAttribute("companylist", companylist);
		forward = new ActionForward();
		forward.setPath("company/company_admin.jsp");
		forward.setRedirect(true);	
		}
		return forward;
	}

}
