package rider.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import rider.svc.DeliveryInfoDetailSVC;
import rider.vo.ActionForward;
import rider.vo.OrderList;

public class DeliverySuccessDetail implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward=null;
		ArrayList<OrderList> detailSuccessList=new ArrayList<>();
		int Order_num;
		HttpSession session=request.getSession();
		
		if(session.getAttribute("riderid")==null) {
			response.setContentType("text/html;charset=utf8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('로그인을 하세요');");
			out.println("location.href='riderMain.jsp';");
			out.println("</script>");
		}else {
			String rider_id=(String)session.getAttribute("riderid");			
			DeliveryInfoDetailSVC infosuccessdetail=new DeliveryInfoDetailSVC();

			if(request.getParameter("Order_num")!=null) {
				Order_num=Integer.parseInt(request.getParameter("Order_num"));
				detailSuccessList=infosuccessdetail.getSuccessDetail(Order_num,rider_id);
			}else {
				response.setContentType("text/html;charset=utf8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('에러가 발생헀습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}
			
			forward=new ActionForward("rider/deliverySuccessDetail.jsp",false);
			
		
			session.setAttribute("detailSuccessList", detailSuccessList);
			
		}
		return forward;
	}

}
