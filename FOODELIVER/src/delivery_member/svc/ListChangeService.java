package delivery_member.svc;

import static delivery_member.db.JdbcUtil.close;
import static delivery_member.db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import delivery_member.dao.DeliveryDAO;
import delivery_member.vo.Company;

public class ListChangeService {


	public ArrayList<Company> getListsearch(String option, String category) {
		Connection con = getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);	
		ArrayList<Company> companylist = deliveryDAO.changelistsearch(option,category);
		close(con);
		
		return companylist;
	}

	public ArrayList<Company> getListcategory(String option, String search) {
		Connection con = getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);	
		ArrayList<Company> companylist = deliveryDAO.changelistcategory(option,search);
		close(con);
		
		return companylist;
	}

}
