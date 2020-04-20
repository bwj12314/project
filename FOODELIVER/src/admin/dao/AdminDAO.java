package admin.dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import rider.vo.Admin;
import rider.vo.Rider;


public class AdminDAO {
	DataSource ds;
	Connection con;
	private static AdminDAO adminDAO;
	private AdminDAO() {
		
	}
	public static AdminDAO getInstance() {
		if(adminDAO==null) {
			adminDAO=new AdminDAO();
		}
		
		return adminDAO;
	}
	
	public void setConnection(Connection con) {
		this.con=con;
	}
	public Admin selectAdmin(String id) {
		// TODO Auto-generated method stub
		Admin admin=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=con.prepareStatement("select * from admin where admin_id=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				admin=new Admin();
				admin.setAdmin_id(rs.getString("admin_id"));
				admin.setAdmin_pass(rs.getString("admin_pass"));
				admin.setAdmin_email(rs.getString("admin_email"));
				admin.setAdmin_tel(rs.getString("admin_tel"));
			}
		}catch(Exception e) {
			System.out.println("Adminselect 에러"+e);
		}finally {
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
		}
		return admin;
	}

	public int updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		int result=0;
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement("update admin set admin_email=?"
					+ ",admin_tel=? where admin_id=?");
					// executeQeury와 executeUpdate 의 차이를 알아야한다.
			
			pstmt.setString(1, admin.getAdmin_email());
			pstmt.setString(2, admin.getAdmin_tel());
			pstmt.setString(3, admin.getAdmin_id());
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(pstmt!=null) close(pstmt);
		}
		
		return result;
	}
	
	public int getListCount(String option, String value) {
		// TODO Auto-generated method stub
		int listCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(*) from rider";
		if(option.equals("id")) {
			sql="select count(*) from rider where rider_id like ?";
		}else if(option.equals("tel")) {
			sql="select count(*) from rider where rider_tel like ?";
		}
		try {
			pstmt=con.prepareStatement(sql);
			if(option.equals("id"))
				pstmt.setString(1, "%"+value+"%");
			if(option.equals("tel"))
				pstmt.setString(1,"%"+value+"%");
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				listCount=rs.getInt(1);
				System.out.println("AdminDAO에서 listCount의 크기는"+listCount);
			}
					
		}catch(Exception ex) {
			System.out.println("getListCount 에러 : "+ex);
		}finally{
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
		}
		return listCount;
	}
	public ArrayList<Rider> getRiderList(int page, int limit, String option, String value) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String rider_list_sql="select * from rider limit ?,?";
		if(option.equals("id")) {
			rider_list_sql="select * from rider where rider_id like ? limit ?,?";
			System.out.println("아이디로 검색했을 때 MemberDAO에서 이게 떠야한다.");
		}
		else if(option.equals("tel")) {
			rider_list_sql="select * from rider where rider_tel like ? limit ?,?";
			System.out.println("이름으로 검색했을 때 MemberDAO에서 이게 떠야한다.");
		}
		
		System.out.println("AdminDAO 에서 getRiderList에서 value의 값은 "+value);
		System.out.println("AdminDAO 에서 getRiderList에서 option의 값은 "+option);
		ArrayList<Rider> riderList=new ArrayList<Rider>();
		Rider rider=null;
		int startrow=(page-1)*limit;
		
		
		
		try {
			
			pstmt=con.prepareStatement(rider_list_sql);
			if(option.equals("id")) {
				pstmt.setString(1, "%"+value+"%");
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, limit);
			}else if(option.equals("tel")) {
				pstmt.setString(1, value+"%");
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, limit);
			}
			else {
				pstmt.setInt(1, startrow);
				pstmt.setInt(2, limit);
			}
			rs=pstmt.executeQuery();
			//if(rs.next()) list 생성 do member 생성 while 
			while(rs.next()) {
				
				rider=new Rider();
				rider.setRider_id(rs.getString("rider_id"));
				rider.setRider_pass(rs.getString("rider_pass"));
				rider.setRider_name(rs.getString("rider_name"));				
				rider.setRider_age(rs.getInt("rider_age"));
				rider.setRider_gender(rs.getString("rider_gender"));
				rider.setRider_email(rs.getString("rider_email"));
				rider.setRider_tel(rs.getString("rider_tel"));
				rider.setRider_address1(rs.getString("rider_address1"));
				rider.setRider_address2(rs.getString("rider_address2"));
				rider.setRider_address3(rs.getString("rider_address3"));
				rider.setRider_address4(rs.getString("rider_address4"));
				rider.setRider_count(rs.getInt("rider_count"));
				rider.setRider_active(rs.getString("rider_active"));
				rider.setRider_reason(rs.getString("rider_reason"));
				rider.setRider_state(rs.getString("rider_state"));
				System.out.println("AdminDAO에서 getRiderList에서 rider의 값"+rider.getRider_id());
				riderList.add(rider);
			}
			
		}catch(Exception ex) {
			System.out.println("getRiderList 에러 : "+ex);
		}finally{
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
		}
		return riderList;
	}
	
	public Rider getRiderInform(String rider_id) {
		// TODO Auto-generated method stub
		Rider rider=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=con.prepareStatement("select * from rider where rider_id=?");
			pstmt.setString(1, rider_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				rider=new Rider();
				rider.setRider_id(rs.getString("rider_id"));
				rider.setRider_pass(rs.getString("rider_pass"));
				rider.setRider_name(rs.getString("rider_name"));				
				rider.setRider_age(rs.getInt("rider_age"));
				rider.setRider_gender(rs.getString("rider_gender"));
				rider.setRider_email(rs.getString("rider_email"));
				rider.setRider_tel(rs.getString("rider_tel"));
				rider.setRider_address1(rs.getString("rider_address1"));
				rider.setRider_address2(rs.getString("rider_address2"));
				rider.setRider_address3(rs.getString("rider_address3"));
				rider.setRider_address4(rs.getString("rider_address4"));
				rider.setRider_count(rs.getInt("rider_count"));
				rider.setRider_active(rs.getString("rider_active"));
				rider.setRider_reason(rs.getString("rider_reason"));
				rider.setRider_state(rs.getString("rider_state"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
		}
		
		return rider;
	}
	public int updateRider(Rider rider) {
		// TODO Auto-generated method stub
		int result=0;
		PreparedStatement pstmt=null;
		
		try {
			
			pstmt=con.prepareStatement("update rider set rider_name=?, rider_pass=?, rider_email=?, rider_age=?"
					+ ", rider_gender=? , rider_tel=?,rider_address1=?,rider_address2=?,rider_address3=?,rider_address4=?"
					+ ", rider_count=?, rider_active=?, rider_reason=? where rider_id=?");
					// executeQeury와 executeUpdate 의 차이를 알아야한다.
			
			pstmt.setString(1, rider.getRider_name());
			pstmt.setString(2, rider.getRider_pass());
			pstmt.setString(3, rider.getRider_email());
			pstmt.setInt(4, rider.getRider_age());
			pstmt.setString(5, rider.getRider_gender());
			pstmt.setString(6, rider.getRider_tel());
			pstmt.setString(7, rider.getRider_address1());
			pstmt.setString(8, rider.getRider_address2());
			pstmt.setString(9, rider.getRider_address3());
			pstmt.setString(10, rider.getRider_address4());
			pstmt.setInt(11, rider.getRider_count());
			pstmt.setString(12, rider.getRider_active());
			pstmt.setString(13, rider.getRider_reason());
			pstmt.setString(14, rider.getRider_id());
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(pstmt!=null) close(pstmt);
		}
		
		return result;
	}
	public int removeRider(String id) {
		// TODO Auto-generated method stub
		int result=0;
		PreparedStatement pstmt=null;
		
		try {
			pstmt=con.prepareStatement("delete from rider where rider_id=?");
					// executeQeury와 executeUpdate 의 차이를 알아야한다.
			pstmt.setString(1, id);
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(pstmt!=null) close(pstmt);
		}
		
		return result;
	}
	public int updatePassword(String id, String password) {
		// TODO Auto-generated method stub
		int result=0;
		PreparedStatement pstmt=null;
		try {
			
			pstmt=con.prepareStatement("update admin set admin_pass=? where admin_id=?");
					// executeQeury와 executeUpdate 의 차이를 알아야한다.
			pstmt.setString(1, password);
			pstmt.setString(2, id);
			
			
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(pstmt!=null) close(pstmt);
		}
		return result;
		
	}
	public int insertkey(String[] values, String[] certifykey) {
		// TODO Auto-generated method stub
		int result=0;
		PreparedStatement pstmt=null;
		try {
			for(int i=0;i<values.length;i++) {
			pstmt=con.prepareStatement("insert into rider_certify values(?,?)");
					// executeQeury와 executeUpdate 의 차이를 알아야한다.
			pstmt.setString(1, certifykey[i]);
			pstmt.setString(2, values[i]);
			result=pstmt.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			for(int i=0;i<values.length;i++) {
			if(pstmt!=null) close(pstmt);
			}
		}
		return result;
	}
}
