package delivery_member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery_member.svc.OrderService;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Member;

public class OrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		ActionForward forward=null;
	
		if(session.getAttribute("member_id")==null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 하세요.');");
			out.println("location.href='loginform.mlog'");
			out.println("</script>");
		}
		else {
		String company_id=request.getParameter("company_id"); //회사아이디
		
		
		String member_id=(String)session.getAttribute("member_id");
		
		OrderService orderService=new OrderService();
		Member member=orderService.memselect(member_id);
		
		
		session.setAttribute("member", member);
		
		forward = new ActionForward("member/order.jsp?company_id="+company_id, true);
		}
		return forward;
	}

}
