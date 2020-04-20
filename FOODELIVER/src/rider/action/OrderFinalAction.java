package rider.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import admin.action.Action;
import rider.svc.DeliveryInfoDetailSVC;
import rider.svc.OrderFinalSVC;
import rider.svc.RiderModProService;
import rider.vo.ActionForward;
import rider.vo.OrderList;

public class OrderFinalAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int Order_num=Integer.parseInt(!(request.getParameter("Order_num")==null)?request.getParameter("Order_num"):"0");
		String rider_id=request.getParameter("rider_id");
		ArrayList<OrderList> deliveryfinallist=new ArrayList<>();
		ActionForward forward=null;
		int riderstate=0;
		HttpSession session=request.getSession();
		if(session.getAttribute("riderid")==null) {
			response.setContentType("text/html;charset=utf8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('로그인을 하세요');");
			out.println("location.href='riderMain.jsp';");
			out.println("</script>");
			
		}else {
			if(Order_num==0) {
				response.setContentType("text/html;charset=utf8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('이미 배달 중인 주문입니다');");
				out.println("location.href='deliveryInfo.ridermem';");
				out.println("</script>");
			}else {
				RiderModProService ridermodsvc=new RiderModProService();
				boolean riderstateresult=ridermodsvc.updateRiderState(rider_id);
				
				if(riderstateresult) {
					riderstate=1;
					OrderFinalSVC orderfinalsvc=new OrderFinalSVC();
					orderfinalsvc.updateOrderState(Order_num,rider_id);
					DeliveryInfoDetailSVC deliveryinfodetailsvc=new DeliveryInfoDetailSVC();
					deliveryfinallist=deliveryinfodetailsvc.getDetailInfo2(Order_num);
					
					session.setAttribute("deliveryfinallist",deliveryfinallist);
					session.setAttribute("riderstate", riderstate);
					forward=new ActionForward("rider/mailSendtoStore.jsp",false);
				}else {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out=response.getWriter();
					out.println("<script>");
					out.println("alert('오류가 발생하였습니다.');");
					out.println("history.back();");
					out.println("</script>");
				}
			}
		}
		
		return forward;
	}

}
