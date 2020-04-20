package delivery_member.svc;


import static delivery_member.db.JdbcUtil.close;
import static delivery_member.db.JdbcUtil.commit;
import static delivery_member.db.JdbcUtil.getConnection;
import static delivery_member.db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import delivery_member.dao.DeliveryDAO;
import delivery_member.vo.OrderSave;

public class OrderSaveService {

	public boolean ordersave(String company_id, int order_num,String member_id, String company_name,String member_address1,String member_address2,String lat,String lng) {
		boolean savelistSuccess=false;
		Connection con = getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);	
		int result = deliveryDAO.insertsavelist(company_id,order_num,member_id,company_name,member_address1,member_address2,lat,lng);
		
		if(result>0) {
			commit(con);
			savelistSuccess=true;
		}else {
			rollback(con);	
		}
		close(con);
		return savelistSuccess;
	}

	public int maxordernum() {
		Connection con = getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);	
		int order_num= deliveryDAO.selectmaxordernum();
		close(con);
		return order_num;
	}

	public boolean orderdetail(int order_num, String company_menuname, int company_menuprice, int company_quantity) {
		boolean orderdetailSuccess=false;
		Connection con = getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);	
		int result = deliveryDAO.insertorderdetail(order_num,company_menuname,company_menuprice,company_quantity);
		
		if(result>0) {
			commit(con);
			orderdetailSuccess=true;
		}else {
			rollback(con);	
		}
		close(con);
		return orderdetailSuccess;
	}

	public ArrayList<OrderSave> selectordersave(int order_num) {
		Connection con = getConnection();
		DeliveryDAO companyDAO = DeliveryDAO.getInstance();
		companyDAO.setConnection(con);	
		ArrayList<OrderSave> ordersave= companyDAO.selectordersave(order_num);
		close(con);
		return ordersave;
	}





}
