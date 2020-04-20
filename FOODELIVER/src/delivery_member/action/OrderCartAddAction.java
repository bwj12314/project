package delivery_member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_member.svc.OrderCartAddService;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Company_menu;


public class OrderCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		OrderCartAddService ordercartaddService=new OrderCartAddService();
		
		String company_id = request.getParameter("company_id");
		String company_menuname=request.getParameter("company_menuname");
		
		Company_menu menu = ordercartaddService.OrderMenu(company_id,company_menuname);
		ordercartaddService.addCart(request,menu);//세션저장
		
//		OrderCartListService ordercartlistService=new OrderCartListService();
//		ArrayList<Company_menu> orderlist= ordercartlistService.getcartlist(request);
		
		
		
	
		ActionForward forward = new ActionForward("member/order_menu.jsp?company_id="+company_id, true);
		return forward;
	}

}
