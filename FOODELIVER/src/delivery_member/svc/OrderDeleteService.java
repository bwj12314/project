package delivery_member.svc;

import static delivery_member.db.JdbcUtil.close;
import static delivery_member.db.JdbcUtil.commit;
import static delivery_member.db.JdbcUtil.getConnection;
import static delivery_member.db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import delivery_member.dao.DeliveryDAO;
import delivery_member.vo.MainOrder;
public class OrderDeleteService {

	public ArrayList<MainOrder> delorder(int order_num,String member_id) {
		Connection con=getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);		
		boolean success = false;		
		int dellist = deliveryDAO.DeleteOrder_list(order_num);
		ArrayList<MainOrder> mainorder=null;
		if(dellist>0){
			int deldetail = deliveryDAO.DeleteOrder_detail(order_num);
			if(deldetail>0) {
			commit(con);
			mainorder=deliveryDAO.selectMainOrder(member_id);
			
			}else {
				rollback(con);
			}
		}else{
			rollback(con);
		}
		
		close(con);
		return mainorder;
	}

}
