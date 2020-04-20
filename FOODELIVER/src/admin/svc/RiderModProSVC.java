package admin.svc;

import static rider.db.JdbcUtil.*;

import java.sql.Connection;

import admin.dao.AdminDAO;
import rider.vo.Rider;

public class RiderModProSVC {

	public boolean updateRider(Rider rider) {
		// TODO Auto-generated method stub
		Connection con=getConnectionDelivery();
		AdminDAO adminDAO=AdminDAO.getInstance();
		adminDAO.setConnection(con);
		boolean updateResult=false;
		int updateCount=adminDAO.updateRider(rider);
		if(updateCount>0) {
			commit(con);
			updateResult=true;
		}
		else {
			rollback(con);
		}
		close(con);
		return updateResult;
	}
	
}
