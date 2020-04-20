package delivery_member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_member.svc.ListChangeService;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Company;

public class changeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String option=request.getParameter("option");
	
		if(option.equals("company_score"))
		{
			option="company_score desc";
		}
		String search=request.getParameter("search");
		String category=request.getParameter("category");
		ArrayList<Company> companylist=null;
		
		ListChangeService lcsvc=new ListChangeService();
		if(search.equals("")||search==null) {
		companylist=lcsvc.getListsearch(option,category);
		
		}else {
			companylist=lcsvc.getListcategory(option,search);
		}
		request.setAttribute("companylist", companylist);
		request.setAttribute("pagefile", "member/company_list.jsp");
		ActionForward forward=null;
		if(option.equals("company_name")) {
		forward = new ActionForward("main.jsp?optv=1", false);
		}else {
			forward = new ActionForward("main.jsp?optv=2", false);
		}
		return forward;
	}

}
