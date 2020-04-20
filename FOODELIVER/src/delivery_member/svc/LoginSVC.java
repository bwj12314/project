package delivery_member.svc;

import static delivery_member.db.JdbcUtil.close;
import static delivery_member.db.JdbcUtil.getConnection;

import java.sql.Connection;

import delivery_member.dao.DeliveryDAO;
import delivery_member.vo.Member;


public class LoginSVC {
	public Member memberLogin(String member_id) throws Exception {

		Member member = null;
		Connection con = getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);
		member = deliveryDAO.selectMember(member_id);
		close(con);
		return member;
	}
	
	public Member memberLoginnameCheck(String checkname) {
		Member member = null;
		Connection con = getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);
		member = deliveryDAO.selectMembername(checkname);
		close(con);
		return member;
	}

	public Member MemberLoginemailCheck(String checkemail) {
		Member member = null;
		Connection con = getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);
		member = deliveryDAO.memberemailCheck(checkemail);
		close(con);
		return member;
	}
	
}
