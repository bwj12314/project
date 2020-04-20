package rider.svc;

import static rider.db.JdbcUtil.*;

import java.sql.Connection;

import rider.dao.RiderDAO;
import rider.vo.Rider;

public class RiderModProService {

	public boolean updateRider(Rider rider) {
		// TODO Auto-generated method stub
		Connection con=getConnectionDelivery();
		RiderDAO riderDAO=RiderDAO.getInstance();
		riderDAO.setConnection(con);
		boolean updateResult=false;
		int updateCount=riderDAO.updateRider(rider);
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

	public boolean updateRiderState(String rider_id) {
		// TODO Auto-generated method stub
		Connection con=getConnectionDelivery();
		RiderDAO riderDAO=RiderDAO.getInstance();
		riderDAO.setConnection(con);
		boolean updateResult=false;
		int updateCount=riderDAO.updateRiderState(rider_id);
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
