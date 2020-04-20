package delivery_member.svc;

import static delivery_member.db.JdbcUtil.close;
import static delivery_member.db.JdbcUtil.commit;
import static delivery_member.db.JdbcUtil.getConnection;
import static delivery_member.db.JdbcUtil.rollback;

import java.sql.Connection;

import delivery_member.dao.DeliveryDAO;

public class CheckActionSVC {

	public boolean updatepassword(String checkid, String password) {
		// TODO Auto-generated method stub
		
		Connection con=getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);
		
		boolean updateResult=false;
		int updateCount=deliveryDAO.updatePassword(checkid,password);
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
