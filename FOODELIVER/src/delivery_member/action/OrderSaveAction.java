package delivery_member.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery_member.svc.OrderSaveService;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Company_menu;
import delivery_member.vo.OrderSave;

public class OrderSaveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		ActionForward forward=null;
		String company_id=request.getParameter("company_id");
		String company_name=request.getParameter("company_name");
		String member_address1=request.getParameter("member_address1");
		String member_address2=request.getParameter("member_address2");
		String lat=request.getParameter("lat");
		String lng=request.getParameter("lng");
		HttpSession session=request.getSession();
		String member_id=(String)session.getAttribute("member_id");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		OrderSaveService ordersaveService=new OrderSaveService();
		
		//max order_num찾기
		int order_num=ordersaveService.maxordernum();
		order_num=order_num+1;
		
		boolean savelistSuccess=ordersaveService.ordersave(company_id,order_num,member_id,company_name,member_address1,member_address2,lat,lng);
		if(savelistSuccess==true) {
			boolean orderdetailSuccess=false;
			ArrayList<Company_menu> order_list=(ArrayList<Company_menu>)session.getAttribute("order_list");
			for (int i = 0; i < order_list.size(); i++) {
				if(order_list.get(i).getCompany_id().equals(company_id)) {
				orderdetailSuccess=false;
				orderdetailSuccess=ordersaveService.orderdetail(order_num,order_list.get(i).getCompany_menuname(),order_list.get(i).getCompany_menuprice(),order_list.get(i).getCompany_quantity());
				
				}
			}
			if(orderdetailSuccess==true) {
			
					ArrayList<OrderSave> ordersave=ordersaveService.selectordersave(order_num);
					session.setAttribute("ordersave", ordersave);
						
					forward = new ActionForward("order_list.main", true);
					
			}else {
				
				out.println("<script>");
				out.println("alert('오류');");
				out.println("history.back();");
				out.println("</script>");
				}
			
			
		}else{
			
		out.println("<script>");
		out.println("alert('오류');");
		out.println("history.back();");
		out.println("</script>");
		}
		
		
		
	
		return forward;
	}

}
