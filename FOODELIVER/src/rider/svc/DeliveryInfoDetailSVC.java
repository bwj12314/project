package rider.svc;

import static rider.db.JdbcUtil.*;


import java.sql.Connection;
import java.util.ArrayList;

import rider.dao.RiderDAO;
import rider.vo.OrderList;

public class DeliveryInfoDetailSVC {

	public ArrayList<OrderList> getDetailInfo(int Order_num) {
		// TODO Auto-generated method stub
		ArrayList<OrderList> orderlist=null;
		Connection con=getConnectionDelivery();
		
		RiderDAO riderDAO=RiderDAO.getInstance();
		riderDAO.setConnection(con);
		
		orderlist=riderDAO.getDetailInfoList(Order_num);
		
		close(con);
		return orderlist;
	}

	public ArrayList<OrderList> getDetailInfo2(int Order_num) {
		// TODO Auto-generated method stub
		ArrayList<OrderList> orderlist=null;
		Connection con=getConnectionDelivery();
		
		RiderDAO riderDAO=RiderDAO.getInstance();
		riderDAO.setConnection(con);
		
		orderlist=riderDAO.getDetailInfoList2(Order_num);
		
		close(con);
		return orderlist;
	}

	public ArrayList<OrderList> getSuccessDetail(int order_num, String rider_id) {
		// TODO Auto-generated method stub
		ArrayList<OrderList> orderSuccessDetailList=null;
		Connection con=getConnectionDelivery();
		
		RiderDAO riderDAO=RiderDAO.getInstance();
		riderDAO.setConnection(con);
		
		orderSuccessDetailList=riderDAO.getSuccessDetail(order_num,rider_id);
		
		close(con);
		return orderSuccessDetailList;
	}

	

}
