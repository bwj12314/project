package delivery_member.svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import delivery_member.vo.Company_menu;


public class OrderCartQuantityUpService {

	public void upCartQty(String company_menuname, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Company_menu> order_list = (ArrayList<Company_menu>)session.getAttribute("order_list");
		
		for (int i = 0; i < order_list.size(); i++) {
			
			if(order_list.get(i).getCompany_menuname().equals(company_menuname)){
				order_list.get(i).setCompany_quantity(order_list.get(i).getCompany_quantity()+1);
			}
			
		}
		
	}

}
