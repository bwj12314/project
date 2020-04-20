package compmenu.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;
import comp.vo.Order;
import compmem.dao.MemberDAO;

public class OrderListSvc {

	public ArrayList<Order> getOrderList(String company_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);
		
		ArrayList<Order> orderlist = memberDao.selectOrderList(company_id);
		close(con);
		return orderlist;
	}

}
