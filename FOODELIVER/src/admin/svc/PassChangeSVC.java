package admin.svc;

import static rider.db.JdbcUtil.*;

import java.sql.Connection;

import admin.dao.AdminDAO;

public class PassChangeSVC {
	public boolean updatepassword(String id, String password) {
		// TODO Auto-generated method stub
		
		Connection con=getConnectionDelivery();
		AdminDAO adminDAO=AdminDAO.getInstance();
		adminDAO.setConnection(con);
		
		boolean updateResult=false;
		int updateCount=adminDAO.updatePassword(id,password);
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
