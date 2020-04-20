package compmenu.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import comp.vo.Order;
import compmenu.svc.OrderListSvc;

public class OrderListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String company_id=request.getParameter("company_id");
		
		ActionForward forward = null;
		
			OrderListSvc orderlistsvc = new OrderListSvc();
			ArrayList<Order> orderlist = orderlistsvc.getOrderList(company_id);
			HttpSession session = request.getSession();
			session.setAttribute("orderlist", orderlist);
			if(orderlist==null) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('아직 거래내역이 없습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}else {
			forward = new ActionForward();
			forward.setPath("company_orderlist.jsp");
			forward.setRedirect(true);
			}
		return forward;
	}

}
