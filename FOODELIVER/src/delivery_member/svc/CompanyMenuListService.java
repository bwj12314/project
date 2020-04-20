package delivery_member.svc;

import static delivery_member.db.JdbcUtil.close;
import static delivery_member.db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import delivery_member.dao.DeliveryDAO;
import delivery_member.vo.Company_menu;

public class CompanyMenuListService {
	public ArrayList<Company_menu> ComMenu(String company_id) {
		Connection con = getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);	
		ArrayList<Company_menu> menulist = deliveryDAO.selectCompany_menulist(company_id);
		close(con);
		return menulist;
	}
}
