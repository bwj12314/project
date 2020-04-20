package companyadmin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import comp.vo.Company;
import companyadmin.svc.CompanyModiSvc;

public class CompanyModiAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String company_id = request.getParameter("company_id");
		ActionForward forward = null;
		Company company = new Company();
		company.setCompany_name(request.getParameter("company_name"));
		company.setCompany_businum(request.getParameter("company_businum"));
		company.setCompany_tel(request.getParameter("company_tel"));
		company.setCompany_category(request.getParameter("company_category"));
		company.setCompany_address1(request.getParameter("company_address1"));
		company.setCompany_address2(request.getParameter("company_address2"));
		company.setCompany_address3(request.getParameter("company_address3"));
		company.setCompany_address4(request.getParameter("company_address4"));
		company.setCompany_active(request.getParameter("company_active"));
		company.setCompany_logo(request.getParameter("company_logo"));
		System.out.println(request.getParameter("company_active"));
		CompanyModiSvc companymodisvc = new CompanyModiSvc();
		company = companymodisvc.companyModi(company_id);
		session.setAttribute("company", company);
		
		forward = new ActionForward();
		forward.setPath("company/company_adminMod.jsp");
		forward.setRedirect(true);	
		
		return forward;
	}

}
