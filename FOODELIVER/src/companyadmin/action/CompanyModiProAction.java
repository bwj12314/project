package companyadmin.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import comp.vo.Company;
import companyadmin.svc.CompanyListSvc;
import companyadmin.svc.CompanyModiProSvc;

public class CompanyModiProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		ActionForward forward = null;
		
		Company company = new Company();
		company.setCompany_id(request.getParameter("company_id"));
		company.setCompany_name(request.getParameter("company_name"));
		company.setCompany_businum(request.getParameter("company_businum"));
		company.setCompany_tel(request.getParameter("company_tel"));
		company.setCompany_category(request.getParameter("company_category"));
		company.setCompany_address1(request.getParameter("company_address1"));
		company.setCompany_address2(request.getParameter("company_address2"));
		company.setCompany_address3(request.getParameter("company_address3"));
		company.setCompany_address4(request.getParameter("company_address4"));
		company.setCompany_active(request.getParameter("company_active"));
		String company_logo=request.getParameter("company_logo");
		if(company_logo==null||company_logo.equals("")) {
			company_logo=request.getParameter("company_logo_orig");
		}
		
		company.setCompany_logo(company_logo);
		
		CompanyModiProSvc companyModiprosvc = new CompanyModiProSvc();
		boolean result = companyModiprosvc.companymodipro(company);
		
		HttpSession session = request.getSession();
		
		CompanyListSvc companylistsvc = new CompanyListSvc(); 	
		ArrayList<Company> companylist = companylistsvc.getCompanyAllList();		
		
		session.setAttribute("companylist", companylist);
		if(!result) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정에 실패하였습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정이 완료되었습니다.');");
			out.println("location.href='company_admin.jsp';");
			out.println("</script>");
		}
		return forward;
	}

}
