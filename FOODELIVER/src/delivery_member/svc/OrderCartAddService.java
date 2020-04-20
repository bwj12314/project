package delivery_member.svc;

import static delivery_member.db.JdbcUtil.close;
import static delivery_member.db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import delivery_member.dao.DeliveryDAO;
import delivery_member.vo.Company_menu;


public class OrderCartAddService {

	public void addCart(HttpServletRequest request,Company_menu menu) {
		HttpSession session = request.getSession();
		ArrayList<Company_menu> order_list = (ArrayList<Company_menu>)session.getAttribute("order_list");
		
		if(order_list == null){
			order_list = new ArrayList<Company_menu>();
			session.setAttribute("order_list", order_list);
		}
		
		boolean isNewCart = true;
		
		
		for (int i = 0; i < order_list.size(); i++) {
			if(menu.getCompany_menuname().equals(order_list.get(i).getCompany_menuname())&&menu.getCompany_id().equals(order_list.get(i).getCompany_id())){
				isNewCart = false;
				break;
			}
		}
		
		if(isNewCart){
			Company_menu cart = new Company_menu();
			cart.setCompany_id(menu.getCompany_id());
			cart.setCompany_menuname(menu.getCompany_menuname());
			cart.setCompany_menuprice(menu.getCompany_menuprice());
			cart.setCompany_quantity(1);
			
			
			order_list.add(cart);
		}
		
	}

	public Company_menu OrderMenu(String company_id, String company_menuname) {
		Connection con = getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);	
		Company_menu menu = deliveryDAO.selectCompany_menu(company_id,company_menuname);
		close(con);
		return menu;
	}

}
