package admin.svc;

import static db.JdbcUtil.close;
import static rider.db.JdbcUtil.getConnectionDelivery;

import java.sql.Connection;

import admin.dao.AdminDAO;
import rider.vo.Admin;

public class LoginAdminSVC {

	public Admin AdminLogin(String id) {
		// TODO Auto-generated method stub
		
			Admin admin=null;
			Connection con=getConnectionDelivery();
			
			AdminDAO adminDAO=AdminDAO.getInstance();
			adminDAO.setConnection(con);
			
			admin=adminDAO.selectAdmin(id);
			close(con);
			return admin;
		
	}
	

}
