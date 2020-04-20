package rider.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import rider.svc.DeliveryInfoDetailSVC;
import rider.svc.DeliveryOrdernumSVC;
import rider.vo.ActionForward;
import rider.vo.OrderList;

public class DeliveryInfoDetail implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward=null;
		ArrayList<OrderList> detailarraylist=new ArrayList<>();
		int Order_num;
		int mapmylocation=0;
		DeliveryOrdernumSVC deliveryordernumsvc=new DeliveryOrdernumSVC();
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
			DeliveryInfoDetailSVC infodetail=new DeliveryInfoDetailSVC();

			if(request.getParameter("Order_num")!=null) {
				Order_num=Integer.parseInt(request.getParameter("Order_num"));
				detailarraylist=infodetail.getDetailInfo(Order_num);
			}else {
				Order_num=deliveryordernumsvc.getOrder_num(rider_id);
				detailarraylist=infodetail.getDetailInfo2(Order_num);
			}
			if((Integer)session.getAttribute("riderstate")==1) {
				mapmylocation=1;
			}
			forward=new ActionForward("rider/deliveryInfoFirstDetail.jsp",false);
			
			session.setAttribute("mapmylocation", mapmylocation);
			session.setAttribute("detailarraylist", detailarraylist);
			
		}
		return forward;
	}

}
