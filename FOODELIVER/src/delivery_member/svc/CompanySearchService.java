package delivery_member.svc;


import static delivery_member.db.JdbcUtil.close;
import static delivery_member.db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import delivery_member.dao.DeliveryDAO;
import delivery_member.vo.Company;

public class CompanySearchService {

	public ArrayList<Company> searchlist(String search) {
		Connection con = getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);	
		ArrayList<Company> companylist = deliveryDAO.searchlist(search);
		close(con);
		
		return companylist;
	}

}
