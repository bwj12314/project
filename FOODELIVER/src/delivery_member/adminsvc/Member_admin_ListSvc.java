package delivery_member.adminsvc;


import static delivery_member.db.JdbcUtil.close;
import static delivery_member.db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import delivery_member.dao.DeliveryDAO;
import delivery_member.vo.Member;

public class Member_admin_ListSvc {

	public ArrayList<Member> getmemlist(int page, int limit, String option, String value) {
		Connection con = getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);	
		ArrayList<Member> memberlist = deliveryDAO.selectMemberList(page,limit,option,value);
		close(con);
		return memberlist;
	}

	public int listCount(String option, String value) {
		int listCount=0;
		Connection con=getConnection();
		DeliveryDAO deliveryDAO=DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);
		listCount=deliveryDAO.selectListCount(option,value);
		close(con);
		return listCount;
	}

}
