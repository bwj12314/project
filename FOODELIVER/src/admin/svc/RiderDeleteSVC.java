package admin.svc;

import static rider.db.JdbcUtil.*;

import java.sql.Connection;

import admin.dao.AdminDAO;



public class RiderDeleteSVC {

	public boolean removeRider(String id) {
		// TODO Auto-generated method stub
		Connection con=getConnectionDelivery();
		
		AdminDAO adminDAO=AdminDAO.getInstance();
		adminDAO.setConnection(con);
		boolean deleteResult=false;
		int deleteCount=adminDAO.removeRider(id);
		if(deleteCount>0) {
			commit(con);
			deleteResult=true;
		}
		else {
			rollback(con);
		}
		close(con);
		return deleteResult;
	}
	
}
