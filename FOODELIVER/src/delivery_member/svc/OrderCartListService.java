package delivery_member.svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import delivery_member.vo.Company_menu;


public class OrderCartListService {

	public ArrayList<Company_menu> getcartlist(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Company_menu> order_list = (ArrayList<Company_menu>)session.getAttribute("order_list");
		return order_list;
	}
	
}
