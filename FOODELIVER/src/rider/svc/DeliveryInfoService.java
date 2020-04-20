package rider.svc;

import static rider.db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import rider.dao.RiderDAO;
import rider.vo.OrderList;

public class DeliveryInfoService {
	public ArrayList<OrderList> getOrderInfoList(int page, int limit, String option, String value) {
		ArrayList<OrderList> orderlist=null;
		Connection con=getConnectionDelivery();
		
		RiderDAO riderDAO=RiderDAO.getInstance();
		riderDAO.setConnection(con);
		
		orderlist=riderDAO.getOrderInfoList(page,limit,option,value);
		
		close(con);
		return orderlist;
		
	}

	public int getListCount(String option, String value) {
		// TODO Auto-generated method stub
		Connection con=getConnectionDelivery();
		int listCount=0;
		RiderDAO riderDAO=RiderDAO.getInstance();
		riderDAO.setConnection(con);
		try {
			
			listCount=riderDAO.selectListCount(option,value);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			close(con);
		}
		
		return listCount;
	}

	public ArrayList<OrderList> getSuccessInfoList(int page, int limit, String rider_id) {
		// TODO Auto-generated method stub
		ArrayList<OrderList> ordersuccesslist=null;
		Connection con=getConnectionDelivery();
		
		RiderDAO riderDAO=RiderDAO.getInstance();
		riderDAO.setConnection(con);
		
		ordersuccesslist=riderDAO.getSuccessInfoList(page,limit,rider_id);
		
		close(con);
		return ordersuccesslist;
	}

	public int getListCount(String rider_id) {
		// TODO Auto-generated method stub
		Connection con=getConnectionDelivery();
		int listCount=0;
		RiderDAO riderDAO=RiderDAO.getInstance();
		riderDAO.setConnection(con);
		try {
			
			listCount=riderDAO.selectListCount(rider_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			close(con);
		}
		return listCount;
	}

	

	
}
