package delivery_member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery_member.svc.CompanyListService;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Company;
import delivery_member.vo.Member;


public class CompanyListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
	CompanyListService companylistservice = new CompanyListService();
	String category= request.getParameter("category");
	
	
	System.out.println(category);
	ArrayList<Company> companylist=companylistservice.ComList(category);
	HttpSession session=request.getSession();
	Member address=null;
	if(session.getAttribute("address")==null) {
		
		address=new Member();
	address.setMember_address1(request.getParameter("member_address1"));//우편번호
	address.setMember_address2(request.getParameter("member_address2"));//주소
	address.setMember_address4(request.getParameter("member_address4"));//명동
	}
	else {
		
		address=(Member) session.getAttribute("address");
		
		if(!request.getParameter("member_address2").equals(address.getMember_address2())) {
			
			address.setMember_address1(request.getParameter("member_address1"));//우편번호
			address.setMember_address2(request.getParameter("member_address2"));//주소
			address.setMember_address4(request.getParameter("member_address4"));//명동
		}
	}
	
	
	session.setAttribute("address", address);
	request.setAttribute("companylist", companylist);
	request.setAttribute("pagefile", "member/company_list.jsp");
	ActionForward forward = new ActionForward("main.jsp", false);
	return forward;
	}
}
