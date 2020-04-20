package delivery_member.svc;

import static delivery_member.db.JdbcUtil.close;
import static delivery_member.db.JdbcUtil.getConnection;

import java.sql.Connection;

import delivery_member.dao.DeliveryDAO;
import delivery_member.vo.Member;

public class OrderService {

	public Member memselect(String member_id) {
		Connection con = getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);	
		Member member = deliveryDAO.selectMember(member_id);
		close(con);
		return member;
	}

}
