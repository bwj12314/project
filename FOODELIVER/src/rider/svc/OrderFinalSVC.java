package rider.svc;

import static rider.db.JdbcUtil.*;

import java.sql.Connection;

import rider.dao.RiderDAO;

public class OrderFinalSVC {

	public boolean updateOrderState(int order_num,String rider_id) {
		// TODO Auto-generated method stub
		Connection con=getConnectionDelivery();
		RiderDAO riderDAO=RiderDAO.getInstance();
		riderDAO.setConnection(con);
		boolean updateResult=false;
		int updateCount=riderDAO.updateOrderState(order_num,rider_id);
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
