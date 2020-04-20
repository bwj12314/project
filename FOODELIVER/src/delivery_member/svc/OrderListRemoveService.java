package delivery_member.svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import delivery_member.vo.Company_menu;

public class OrderListRemoveService {

	public void orderlistRemove(HttpServletRequest request, String company_menuname,String company_id) {
		HttpSession session = request.getSession();
		ArrayList<Company_menu> order_list = (ArrayList<Company_menu>)session.getAttribute("order_list");
		
		
			
			for (int j = 0; j < order_list.size(); j++) {
				
				if(order_list.get(j).getCompany_menuname().equals(company_menuname)&&order_list.get(j).getCompany_id().equals(company_id)){
					order_list.remove(order_list.get(j));
					
				}
				
			}
			
		
		
	}

}
