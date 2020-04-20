package rider.log.svc;

import static rider.db.JdbcUtil.*;

import java.sql.Connection;

import rider.dao.RiderDAO;

public class CheckActionSVC {

	public boolean updatepassword(String checkid, String password) {
		// TODO Auto-generated method stub
		
		Connection con=getConnectionDelivery();
		RiderDAO riderDAO=RiderDAO.getInstance();
		riderDAO.setConnection(con);
		
		boolean updateResult=false;
		int updateCount=riderDAO.updatePassword(checkid,password);
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
