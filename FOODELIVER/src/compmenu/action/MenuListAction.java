package compmenu.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import comp.vo.Company;
import comp.vo.Member;
import complog.svc.CompanyMenuSvc;
import complog.svc.LoginSvc;

public class MenuListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("company_memberid");
		LoginSvc loginsvc = new LoginSvc(); 			
		Member member = null;
		member = loginsvc.memberLogin(id);
		String company_id=member.getCompany_id();
		
		CompanyMenuSvc companymenusvc = new CompanyMenuSvc();	//기업 메뉴 서비스 
		ArrayList<Company> menulist = companymenusvc.companymenu(company_id, id);
		session.setAttribute("menulist", menulist);
		forward = new ActionForward();
		forward.setPath("MenuList.jsp");
		forward.setRedirect(true);
		
		return forward;
	}

}
