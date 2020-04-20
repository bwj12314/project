package rider.svc;


import static rider.db.JdbcUtil.*;
import java.sql.Connection;

import rider.dao.RiderDAO;
import rider.vo.Rider;

public class RiderJoinService {
	
		public boolean riderJoin(Rider rider) {
			
			Connection con=getConnectionDelivery();
			
			RiderDAO riderDAO=RiderDAO.getInstance();
			riderDAO.setConnection(con);
			boolean joinResult=false;
			int insertCount=riderDAO.joinRider(rider);
			if(insertCount>0) {
				commit(con);
				joinResult=true;
			}
			else {
				rollback(con);
			}
			close(con);
			return joinResult;
		}
		public boolean riderDeleteKey(String licensekeyEX) {
			Connection con=getConnectionDelivery();
			
			RiderDAO riderDAO=RiderDAO.getInstance();
			riderDAO.setConnection(con);
			boolean deleteResult=false;
			int insertCount=riderDAO.deleteRiderKey(licensekeyEX);
			if(insertCount>0) {
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
