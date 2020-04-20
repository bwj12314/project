package delivery_member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_member.svc.CompanySearchService;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Company;

public class SearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		String search=request.getParameter("search");
		CompanySearchService companysearchService=new CompanySearchService();
		ArrayList<Company> companylist=companysearchService.searchlist(search);
		System.out.println(search);
		
		
		
		request.setAttribute("companylist", companylist);
		request.setAttribute("pagefile", "member/company_list.jsp");
		ActionForward forward = new ActionForward("main.jsp?search="+search, false);
		return forward;
	}

}
