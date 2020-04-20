package delivery_member.svc;

import static delivery_member.db.JdbcUtil.close;
import static delivery_member.db.JdbcUtil.getConnection;

import java.sql.Connection;

import delivery_member.dao.DeliveryDAO;


public class CompanyCategoryService {

	public String selectcategory(String company_id) {
		Connection con = getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);	
		String category = deliveryDAO.selectCompany_category(company_id);
		close(con);
		
		return category;
	}

}
