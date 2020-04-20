package rider.svc;

import static rider.db.JdbcUtil.*;

import java.sql.Connection;

import rider.dao.RiderDAO;

public class DeliveryOrdernumSVC {

	public int getOrder_num(String rider_id) {
		// TODO Auto-generated method stub
		Connection con=getConnectionDelivery();
		RiderDAO riderDAO=RiderDAO.getInstance();
		riderDAO.setConnection(con);
		
		int Order_num=riderDAO.getOrder_num(rider_id);
		if(Order_num>0) {
			commit(con);
			
		}
		else {
			rollback(con);
		}
		close(con);
		return Order_num;
	}

}
