package admin.svc;

import static rider.db.JdbcUtil.close;
import static rider.db.JdbcUtil.commit;
import static rider.db.JdbcUtil.getConnectionDelivery;
import static rider.db.JdbcUtil.rollback;

import java.sql.Connection;

import admin.dao.AdminDAO;
import rider.vo.Admin;

public class AdminModProSVC {
	

	public boolean updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Connection con=getConnectionDelivery();
		AdminDAO adminDAO=AdminDAO.getInstance();
		adminDAO.setConnection(con);
		boolean updateResult=false;
		int updateCount=adminDAO.updateAdmin(admin);
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
