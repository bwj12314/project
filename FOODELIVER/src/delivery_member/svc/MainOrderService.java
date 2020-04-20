package delivery_member.svc;

import static delivery_member.db.JdbcUtil.close;
import static delivery_member.db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import delivery_member.dao.DeliveryDAO;
import delivery_member.vo.MainOrder;

public class MainOrderService {

	public ArrayList<MainOrder> getmainorder(String member_id) {
		Connection con = getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);	
		ArrayList<MainOrder> mainorder = deliveryDAO.selectMainOrder(member_id);
		close(con);
		
		return mainorder;
	}

}
