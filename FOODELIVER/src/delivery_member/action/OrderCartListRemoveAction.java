package delivery_member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_member.svc.OrderListRemoveService;
import delivery_member.vo.ActionForward;

public class OrderCartListRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String company_id=request.getParameter("company_id");
		String company_menuname = request.getParameter("company_menuname");
		OrderListRemoveService orderlistremoveService = new OrderListRemoveService();
		orderlistremoveService.orderlistRemove(request,company_menuname,company_id);
		

//		OrderCartListService ordercartlistService=new OrderCartListService();
//		ArrayList<Company_menu> orderlist= ordercartlistService.getcartlist(request);
//		
		
		

		
		ActionForward forward = new ActionForward("member/order_menu.jsp?company_id="+company_id, true);
		return forward;
	}

}
