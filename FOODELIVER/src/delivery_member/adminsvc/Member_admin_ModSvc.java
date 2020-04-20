package delivery_member.adminsvc;

import static delivery_member.db.JdbcUtil.close;
import static delivery_member.db.JdbcUtil.commit;
import static delivery_member.db.JdbcUtil.getConnection;
import static delivery_member.db.JdbcUtil.rollback;

import java.sql.Connection;

import delivery_member.dao.DeliveryDAO;
import delivery_member.vo.Member;

public class Member_admin_ModSvc {

	public boolean membermod(Member member) {
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		Connection con = getConnection();
		deliveryDAO.setConnection(con);		
		boolean success = false;		
		int insertCount = deliveryDAO.UpdateMember(member);
		
		if(insertCount>0){
			commit(con);
			success=true;
		}else{
			rollback(con);
		}
		
		close(con);
		return success;
	}

}
