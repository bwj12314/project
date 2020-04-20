package rider.log.svc;


import java.sql.Connection;
import static rider.db.JdbcUtil.*;

import rider.dao.RiderDAO;
import rider.vo.Rider;
import rider.vo.RiderKey;
public class LoginSVC {
	public Rider RiderLogin(String id) {
		Rider rider=null;
		
		Connection con=getConnectionDelivery();
		RiderDAO riderDAO=RiderDAO.getInstance();
		riderDAO.setConnection(con);
		
		rider=riderDAO.selectRider(id);
		close(con);
		return rider;
	}
	
	public Rider RiderLoginidCheck(String checkname) {
		Rider rider=null;
		Connection con=getConnectionDelivery();
		
		RiderDAO riderDAO=RiderDAO.getInstance();
		riderDAO.setConnection(con);
		
		rider=riderDAO.rideridCheck(checkname);
		close(con);
		return rider;
	}
	public Rider RiderLoginemailCheck(String checkemail) {
		Rider rider=null;
		Connection con=getConnectionDelivery();
		
		RiderDAO riderDAO=RiderDAO.getInstance();
		riderDAO.setConnection(con);
		
		rider=riderDAO.rideremailCheck(checkemail);
		close(con);
		return rider;
	}

	public RiderKey RiderKeyCheck(String licensekeyEX,String tel) {
		// TODO Auto-generated method stub
		RiderKey riderkey=null;
		Connection con=getConnectionDelivery();
		
		RiderDAO riderDAO=RiderDAO.getInstance();
		riderDAO.setConnection(con);
		
		riderkey=riderDAO.riderKeyCheck(licensekeyEX,tel);
		close(con);
		return riderkey;
	}
	
}
