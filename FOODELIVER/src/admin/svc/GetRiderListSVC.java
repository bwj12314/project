package admin.svc;

import static rider.db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import admin.dao.AdminDAO;
import rider.vo.Rider;

public class GetRiderListSVC {

	public int getListCount(String option, String value) {
		// TODO Auto-generated method stub
		int listCount=0;
		Connection con=getConnectionDelivery();
		
		AdminDAO adminDAO=AdminDAO.getInstance();
		
		adminDAO.setConnection(con);
		
		try {
			
			listCount=adminDAO.getListCount(option,value);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			close(con);
		}
		System.out.println(listCount);
		return listCount;
	}

	public ArrayList<Rider> getRiderList(int page, int limit, String option, String value) {
		// TODO Auto-generated method stub
		ArrayList<Rider> riderList=null;
		Connection con=getConnectionDelivery();
		AdminDAO adminDAO=AdminDAO.getInstance();
		adminDAO.setConnection(con);
		try {
			riderList=adminDAO.getRiderList(page,limit,option,value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			close(con);
		}
		
		return riderList;
	}

}
