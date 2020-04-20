package delivery_member.svc;


import static delivery_member.db.JdbcUtil.close;
import static delivery_member.db.JdbcUtil.commit;
import static delivery_member.db.JdbcUtil.getConnection;
import static delivery_member.db.JdbcUtil.rollback;

import java.sql.Connection;

import delivery_member.dao.DeliveryDAO;
import delivery_member.vo.Member;

public class MemberJoinService{
	public boolean memberJoin(Member member) {
		
		Connection con = getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);
		boolean joinResult=false;
		int insertCount = deliveryDAO.joinMember(member);

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
}