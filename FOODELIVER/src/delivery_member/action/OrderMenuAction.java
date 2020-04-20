package delivery_member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery_member.svc.CompanyMenuListService;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Company_menu;

public class OrderMenuAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String company_id= request.getParameter("company_id");
		CompanyMenuListService companymenulistservice = new CompanyMenuListService();
		ArrayList<Company_menu> menu_list=companymenulistservice.ComMenu(company_id);//회사 전체메뉴
		
//		OrderCartListService ordercartlistService=new OrderCartListService();
//		ArrayList<Company_menu> orderlist= ordercartlistService.getcartlist(request); //주문메뉴
		
	
		
		HttpSession session = request.getSession();
		session.setAttribute("menu_list", menu_list);//회사전체메뉴 세션에담기
	
		ActionForward forward = new ActionForward("member/order_menu.jsp?company_id="+company_id, true);
		return forward;
	}

}
