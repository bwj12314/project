package delivery_member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery_member.svc.MainOrderService;
import delivery_member.vo.ActionForward;
import delivery_member.vo.MainOrder;

public class OrderListComAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String member_id =(String)session.getAttribute("member_id");
		ArrayList<MainOrder> mainorder=null;
		ActionForward forward=null;
		
		if(member_id!=null) {
			MainOrderService mainorderService= new MainOrderService();
			mainorder=mainorderService.getmainorder(member_id);
		}
		
		request.setAttribute("mainorder", mainorder); 
		 forward=new ActionForward("member/order_list_completion.jsp", false);
		return forward;
	}

}
