package rider.svc;

import static rider.db.JdbcUtil.*;

import java.sql.Connection;

import rider.dao.RiderDAO;
import rider.vo.Rider;
public class RiderInfoService {
	public Rider getRiderInfo(String id) {
		Rider rider=null;
		Connection con=getConnectionDelivery();
		
		RiderDAO riderDAO=RiderDAO.getInstance();
		riderDAO.setConnection(con);
		
		rider=riderDAO.getRiderInform(id);
		
		close(con);
		return rider;
		
	}
}
