package delivery_member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_member.svc.OrderCartQuantityDownService;
import delivery_member.vo.ActionForward;

public class OrderCartQuantityDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String company_id=request.getParameter("company_id");
		String company_menuname = request.getParameter("company_menuname");
		
		OrderCartQuantityDownService ordercartquantityupService = new OrderCartQuantityDownService();
		ordercartquantityupService.downCartQty(company_menuname,request);
		
		
	
//		OrderCartListService ordercartlistService=new OrderCartListService();
//		ArrayList<Company_menu> orderlist= ordercartlistService.getcartlist(request);

		
		ActionForward forward = new ActionForward("member/order_menu.jsp?company_id="+company_id, true);
		return forward;
	}

}
