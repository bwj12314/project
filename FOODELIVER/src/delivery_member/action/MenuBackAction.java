package delivery_member.action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery_member.svc.CompanyCategoryService;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Member;

public class MenuBackAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		String company_id=request.getParameter("company_id");
	
		CompanyCategoryService companycategoryService= new CompanyCategoryService();
		
		String category=companycategoryService.selectcategory(company_id);
		HttpSession session=request.getSession();
		Member address=(Member)session.getAttribute("address");

		ActionForward forward = new ActionForward("company.main?category="+URLEncoder.encode(category,"UTF-8")+"&member_address2="+URLEncoder.encode(address.getMember_address2(),"UTF-8"), true);
		return forward;
	}

}
