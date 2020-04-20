package delivery_member.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery_member.svc.OrderDeleteService;
import delivery_member.vo.ActionForward;
import delivery_member.vo.MainOrder;

public class order_deleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		int order_num=Integer.parseInt(request.getParameter("order_num"));
		String member_id=request.getParameter("member_id");
		ActionForward forward=null;
		
		OrderDeleteService odsvc=new OrderDeleteService();
		ArrayList<MainOrder> mainorder=odsvc.delorder(order_num,member_id);
		HttpSession session=request.getSession();
		session.setAttribute("mainorder", mainorder);
		if(mainorder!=null) {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.println("<script>");
		out.println("alert('주문이 취소되었습니다.');");
		out.println("location.href='member/order_list.jsp';");
		out.println("</script>");
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out =response.getWriter();
			out.println("<script>");
			out.println("alert('오류');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		
		return forward;
	}

}
