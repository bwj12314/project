package complog.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import comp.vo.*;
import complog.svc.*;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("company_memberid");  //기업 맴버의 아이디
		String pass=request.getParameter("company_memberpass"); //기업 맴버의 비밀번호
		Company company = null;
		Member member = null;
		
		ActionForward forward = null;
		
		LoginSvc loginsvc = new LoginSvc(); 					//기업맴버 로그인 서비스
		member = loginsvc.memberLogin(id);
		
		if(member == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디가 존재 하지 않습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			
			if(!pass.equals(member.getCompany_memberpass())) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('비밀번호 일치하지 않습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}else {
				String company_id=member.getCompany_id();
				CompanyInfoSvc companyinfosvc = new CompanyInfoSvc();	// 기업 정보 서비스
				company = companyinfosvc.companyinfo(company_id,id);
				
				CompanyMenuSvc companymenusvc = new CompanyMenuSvc();	//기업 메뉴 서비스 
				ArrayList<Company> menulist = companymenusvc.companymenu(company_id, id);	//메뉴정보를 arraylist로 만들어서 jsp에서 foreach로 뿌려줌		
				HttpSession session = request.getSession();
				session.setAttribute("company_memberid", id);
				session.setAttribute("company",company);
				session.setAttribute("menulist", menulist);
				forward = new ActionForward();
				forward.setPath("company/company_info.jsp");
				forward.setRedirect(true);
			}
		}
		return forward;
	}

}
