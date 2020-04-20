package admin.svc;

import static rider.db.JdbcUtil.*;
import java.sql.Connection;

import admin.dao.AdminDAO;
import rider.vo.Rider;

public class RiderInfoSVC {

	public Rider getRiderInfo(String rider_id) {
		// TODO Auto-generated method stub
		Rider rider=null;
		Connection con=getConnectionDelivery();
		
		AdminDAO adminDAO=AdminDAO.getInstance();
		adminDAO.setConnection(con);
		
		rider=adminDAO.getRiderInform(rider_id);
		
		close(con);
		return rider;
	}

}
