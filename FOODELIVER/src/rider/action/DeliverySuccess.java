package rider.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import compmenu.svc.CompanyTotalMoney;
import rider.svc.DeliverySuccessSVC;
import rider.vo.ActionForward;
import rider.vo.OrderList;

public class DeliverySuccess implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int Order_num=Integer.parseInt(!(request.getParameter("Order_num")==null)?request.getParameter("Order_num"):"0");
		HttpSession session=request.getSession();
		ArrayList<OrderList> detailarraylist=(ArrayList<OrderList>)session.getAttribute("deliveryfinallist");
		int totalmoney=detailarraylist.get(0).getTotalmoney();
		String companyid=detailarraylist.get(0).getCompany_id();
		String rider_id="";
		if(session.getAttribute("riderid")==null) {
			response.setContentType("text/html;charset=utf8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('로그인을 하세요!!');");
			out.println("location.href='riderMain.jsp';");
			out.println("</script>");
		}else {
			if(Order_num!=0) {
				rider_id=(String)session.getAttribute("riderid");
				DeliverySuccessSVC deliverysuccessSVC=new DeliverySuccessSVC();
				CompanyTotalMoney companytotalmoney=new CompanyTotalMoney();
				boolean result=deliverysuccessSVC.deliverySuccess(Order_num,rider_id);
				boolean result2=companytotalmoney.getTotalMoney(companyid,totalmoney);
				if(result2) {
				if(result) {
					session.setAttribute("riderstate", 0);
					response.setContentType("text/html;charset=utf8");
					PrintWriter out=response.getWriter();
					out.println("<script>");
					out.println("alert('배달이 완료되었습니다.');");
					out.println("location.href='deliverySuccessInfo.ridermem';");
					out.println("</script>");
				}}else {
					response.setContentType("text/html;charset=utf8");
					PrintWriter out=response.getWriter();
					out.println("<script>");
					out.println("alert('배달이 완료되지 않았습니다(오류발생)');");
					out.println("location.href='riderMain.jsp';");
					out.println("</script>");
				}
			}
			else {
				response.setContentType("text/html;charset=utf8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('오류가 발생하였습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}
		}
		return null;
	}

}
