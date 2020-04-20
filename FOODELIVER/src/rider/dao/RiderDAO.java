package rider.dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import rider.vo.OrderList;
import rider.vo.Rider;
import rider.vo.RiderKey;

public class RiderDAO {
	DataSource ds;
	private Connection con;
	private static RiderDAO riderDAO;
	private RiderDAO() {
		
	}
	public static RiderDAO getInstance() {
		if(riderDAO==null) {
			riderDAO=new RiderDAO();
		}
		
		return riderDAO;
	}
	
	public void setConnection(Connection con) {
		this.con=con;
	}
	
	public Rider selectRider(String id) {
		Rider rider=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=con.prepareStatement("select * from rider where rider_id=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				rider=new Rider();
				rider.setRider_id(rs.getString("rider_id"));
				rider.setRider_pass(rs.getString("rider_pass"));
				rider.setRider_email(rs.getString("rider_email"));
				rider.setRider_name(rs.getString("rider_name"));
				rider.setRider_state(rs.getString("rider_state"));
			}
		}catch(Exception e) {
			System.out.println("Riderselect 에러"+e);
		}finally {
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
		}
		return rider;
	}
	
	public Rider rideridCheck(String checkname) {
		// TODO Auto-generated method stub
		Rider rider=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=con.prepareStatement("select * from rider where rider_name=?");
			pstmt.setString(1, checkname);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				rider=new Rider();
				rider.setRider_name(rs.getString("rider_name"));
				rider.setRider_email(rs.getString("rider_email"));
				rider.setRider_id(rs.getString("rider_id"));
			}
		}catch(Exception e) {
			System.out.println("Riderselect 에러"+e);
		}finally {
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
		}
		
		
		return rider;
	}
	
	public Rider rideremailCheck(String checkemail) {
		// TODO Auto-generated method stub
		Rider rider=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=con.prepareStatement("select * from rider where rider_email=?");
			pstmt.setString(1, checkemail);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				rider=new Rider();
				rider.setRider_name(rs.getString("rider_name"));
				rider.setRider_email(rs.getString("rider_email"));
				rider.setRider_id(rs.getString("rider_id"));
			}
		}catch(Exception e) {
			System.out.println("Riderselect 에러"+e);
		}finally {
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
		}
		
		return rider;
	}
	public RiderKey riderKeyCheck(String licensekeyEX,String tel) {
		// TODO Auto-generated method stub
		RiderKey riderkey=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=con.prepareStatement("select * from rider_certify where rider_key=? and rider_tel=?");
			pstmt.setString(1, licensekeyEX);
			pstmt.setString(2, tel);
			rs=pstmt.executeQuery();
		
			if(rs.next()) {
				riderkey=new RiderKey();
				riderkey.setRiderkey(rs.getString("rider_key"));
				
			}
		}catch(Exception e) {
			System.out.println("RiderKeySelect 에러"+e);
		}finally {
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
		}
		return riderkey;
	}
	
	
	public int joinRider(Rider rider) {
		int result=0;
		PreparedStatement pstmt=null;
		
		try {
			pstmt=con.prepareStatement("insert into rider values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					// executeQeury와 executeUpdate 의 차이를 알아야한다.
			pstmt.setString(1, rider.getRider_id());
			pstmt.setString(2, rider.getRider_name());
			pstmt.setString(3, rider.getRider_pass());
			pstmt.setString(4, rider.getRider_email());
			pstmt.setInt(5, rider.getRider_age());
			pstmt.setString(6, rider.getRider_gender());
			pstmt.setString(7, rider.getRider_tel());
			pstmt.setString(8, rider.getRider_address1());
			pstmt.setString(9, rider.getRider_address2());
			pstmt.setString(10, rider.getRider_address3());
			pstmt.setString(11, rider.getRider_address4());
			pstmt.setInt(12, rider.getRider_count());
			pstmt.setString(13, rider.getRider_active());
			pstmt.setString(14, rider.getRider_reason());
			pstmt.setString(15, rider.getRider_state());
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(pstmt!=null) close(pstmt);
		}
		
		return result;
	}
	public int deleteRiderKey(String licensekeyEX) {
		// TODO Auto-generated method stub
		int result=0;
		PreparedStatement pstmt=null;
		try {
			
			pstmt=con.prepareStatement("delete from rider_certify where rider_key=?");
					// executeQeury와 executeUpdate 의 차이를 알아야한다.
			pstmt.setString(1, licensekeyEX);
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(pstmt!=null) close(pstmt);
		}
		
		
		return result;
	}
	
	public Rider getRiderInform(String id) {
		// TODO Auto-generated method stub
		Rider rider=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=con.prepareStatement("select * from rider where rider_id=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				rider=new Rider();
				rider.setRider_id(rs.getString("rider_id"));
				rider.setRider_name(rs.getString("rider_name"));
				rider.setRider_pass(rs.getString("rider_pass"));
				rider.setRider_email(rs.getString("rider_email"));
				rider.setRider_age(rs.getInt("rider_age"));
				rider.setRider_gender(rs.getString("rider_gender"));
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
			
			pstmt=con.prepareStatement("update rider set rider_email=?, rider_age=?"
					+ ", rider_gender=? , rider_tel=?,rider_address1=?,rider_address2=?,rider_address3=?,rider_address4=? where rider_id=?");
					// executeQeury와 executeUpdate 의 차이를 알아야한다.
			
			pstmt.setString(1, rider.getRider_email());
			pstmt.setInt(2, rider.getRider_age());
			pstmt.setString(3, rider.getRider_gender());
			pstmt.setString(4, rider.getRider_tel());
			pstmt.setString(5, rider.getRider_address1());
			pstmt.setString(6, rider.getRider_address2());
			pstmt.setString(7, rider.getRider_address3());
			pstmt.setString(8, rider.getRider_address4());
			pstmt.setString(9, rider.getRider_id());
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(pstmt!=null) close(pstmt);
		}
		
		return result;
	}
	public int updatePassword(String checkid, String password) {
		// TODO Auto-generated method stub
		int result=0;
		PreparedStatement pstmt=null;
		try {
			
			pstmt=con.prepareStatement("update rider set rider_pass=? where rider_id=?");
					// executeQeury와 executeUpdate 의 차이를 알아야한다.
			pstmt.setString(1, password);
			pstmt.setString(2, checkid);
			
			
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(pstmt!=null) close(pstmt);
		}
		return result;
		}
	
	public int selectListCount(String option, String value) {
		// TODO Auto-generated method stub
		int listCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(*) from order_list inner join company on order_list.company_id=company.company_id"
				+ " inner join member on order_list.member_id=member.member_id where order_list.order_state='주문 완료'";
		if(option.equals("Customer")) {
			sql="select count(*) from order_list inner join company on order_list.company_id=company.company_id"
					+ " inner join member on order_list.member_id=member.member_id where order_list.order_state='주문 완료' and member_address2 like ?";
		}else if(option.equals("Company")) {
			sql="select count(*) from order_list inner join company on order_list.company_id=company.company_id"
					+ " inner join member on order_list.member_id=member.member_id where order_list.order_state='주문 완료' and company_address2 like ?";
		}
		try {
			pstmt=con.prepareStatement(sql);
			if(option.equals("Customer"))
				pstmt.setString(1, "%"+value+"%");
			if(option.equals("Company"))
				pstmt.setString(1,"%"+value+"%");
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				listCount=rs.getInt(1);
				
			}
					
		}catch(Exception ex) {
			System.out.println("getListCount 에러 : "+ex);
		}finally{
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
		}
		return listCount;
	}
	public int selectListCount(String rider_id) {
		// TODO Auto-generated method stub
		int listCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(*) from order_list inner join company on order_list.company_id=company.company_id"
				+ " inner join member on order_list.member_id=member.member_id where order_list.order_state='배달 완료'"
				+ " and order_list.rider_id=? order by order_list.order_num";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, rider_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				listCount=rs.getInt(1);
			}
					
		}catch(Exception ex) {
			System.out.println("getListCount 에러 : "+ex);
		}finally{
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
		}
		return listCount;
	}
	public ArrayList<OrderList> getOrderInfoList(int page, int limit, String option, String value) {
		// TODO Auto-generated method stub
		ArrayList<OrderList> orderArrayList=new ArrayList<>();
		OrderList orderlist=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select order_list.*,company.*,member.* from order_list"
				+ " inner join company on order_list.company_id=company.company_id inner join member on order_list.member_id=member.member_id"
				+ " where order_list.order_state='주문 완료' order by order_list.order_num limit ?,?";
		if(option.equals("Customer")) {
			sql="select order_list.*,company.*,member.* from order_list"
					+ " inner join company on order_list.company_id=company.company_id inner join member on order_list.member_id=member.member_id"
					+ " where order_list.order_state='주문 완료' and member_address2 like ? order by order_list.order_num limit ?,?";
		}
		else if(option.equals("Company")) {
			sql="select order_list.*,company.*,member.* from order_list"
					+ " inner join company on order_list.company_id=company.company_id inner join member on order_list.member_id=member.member_id"
					+ " where order_list.order_state='주문 완료' and company_address2 like ? order by order_list.order_num limit ?,?";
		}
		int startrow=(page-1)*limit;
		
		try {
			pstmt=con.prepareStatement(sql);
			if(option.equals("Customer")) {
				pstmt.setString(1, "%"+value+"%");
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, limit);
			}else if(option.equals("Company")) {
				pstmt.setString(1, "%"+value+"%");
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, limit);
			}
			else {
				pstmt.setInt(1, startrow);
				pstmt.setInt(2, limit);
			}
			
			rs=pstmt.executeQuery();
			
				while(rs.next()) {
					
				orderlist=new OrderList();
				orderlist.setOrder_num(rs.getInt("order_num"));
				orderlist.setOrder_date(rs.getString("order_date"));
				orderlist.setMember_tel(rs.getString("member_tel"));
				orderlist.setMember_address1(rs.getString("order_member_address1"));
				orderlist.setMember_address2(rs.getString("order_member_address2"));
				orderlist.setMember_address_lat(rs.getString("member_address_lat"));
				orderlist.setMember_address_lng(rs.getString("member_address_lng"));
				orderlist.setCompany_name(rs.getString("company_name"));
				orderlist.setCompany_tel(rs.getString("company_tel"));
				orderlist.setCompany_address1(rs.getString("company_address1"));
				orderlist.setCompany_address2(rs.getString("company_address2"));
				orderlist.setCompany_address3(rs.getString("company_address3"));
				orderlist.setCompany_address4(rs.getString("company_address4"));
				orderlist.setCompany_address_lat(rs.getString("company_address_lat"));
				orderlist.setCompany_address_lng(rs.getString("company_address_lng"));
				orderlist.setOrder_state(rs.getString("order_state"));
				
				orderArrayList.add(orderlist);
				}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
		}
		return orderArrayList;
	}
	public ArrayList<OrderList> getSuccessInfoList(int page, int limit, String rider_id) {
		// TODO Auto-generated method stub
		ArrayList<OrderList> orderSuccessList=new ArrayList<>();
		OrderList orderlist=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select order_list.*,company.*,member.* from order_list inner join company on order_list.company_id=company.company_id"
				+ " inner join member on order_list.member_id=member.member_id where order_list.order_state='배달 완료'"
				+ " and order_list.rider_id=? order by order_list.order_num limit ?,?";
		
		int startrow=(page-1)*limit;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, rider_id);
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, limit);
			rs=pstmt.executeQuery();
			
				while(rs.next()) {
					
				orderlist=new OrderList();
				orderlist.setOrder_num(rs.getInt("order_num"));
				orderlist.setOrder_date(rs.getString("order_date"));
				orderlist.setMember_tel(rs.getString("member_tel"));
				orderlist.setMember_address1(rs.getString("order_member_address1"));
				orderlist.setMember_address2(rs.getString("order_member_address2"));
				orderlist.setCompany_name(rs.getString("company_name"));
				orderlist.setCompany_tel(rs.getString("company_tel"));
				orderlist.setCompany_address1(rs.getString("company_address1"));
				orderlist.setCompany_address2(rs.getString("company_address2"));
				orderlist.setCompany_address3(rs.getString("company_address3"));
				orderlist.setCompany_address4(rs.getString("company_address4"));
				orderlist.setOrder_state(rs.getString("order_state"));
				
				orderSuccessList.add(orderlist);
				}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
		}
		return orderSuccessList;
	}
	public ArrayList<OrderList> getDetailInfoList(int Order_num) {
		// TODO Auto-generated method stub
		ArrayList<OrderList> testlist=new ArrayList<>();
		OrderList orderlist=null;
		ArrayList<String> name=null;
		ArrayList<Integer> price=null;
		ArrayList<Integer> quantity=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select order_list.*, order_detail.*,company.*,member.* from order_list inner join order_detail"
				+ " on order_list.order_num=order_detail.order_num inner join company on order_list.company_id=company.company_id "
				+ "inner join member on order_list.member_id=member.member_id where order_list.order_state='주문 완료' and order_list.order_num=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,Order_num);
			rs=pstmt.executeQuery();
			
				if (rs.next()) {
					
				orderlist=new OrderList();
				price=new ArrayList<Integer>();
				name=new ArrayList<String>();
				quantity=new ArrayList<>(); 
				orderlist.setOrder_num(rs.getInt("order_num"));
				orderlist.setOrder_date(rs.getString("order_date"));
				orderlist.setMember_tel(rs.getString("member_tel"));
				orderlist.setMember_address1(rs.getString("order_member_address1"));
				orderlist.setMember_address2(rs.getString("order_member_address2"));
				orderlist.setMember_address_lat(rs.getString("member_address_lat"));
				orderlist.setMember_address_lng(rs.getString("member_address_lng"));
				orderlist.setCompany_id(rs.getString("company_id"));
				orderlist.setCompany_name(rs.getString("company_name"));
				orderlist.setCompany_tel(rs.getString("company_tel"));
				orderlist.setCompany_address1(rs.getString("company_address1"));
				orderlist.setCompany_address2(rs.getString("company_address2"));
				orderlist.setCompany_address3(rs.getString("company_address3"));
				orderlist.setCompany_address4(rs.getString("company_address4"));
				orderlist.setCompany_address_lat(rs.getString("company_address_lat"));
				orderlist.setCompany_address_lng(rs.getString("company_address_lng"));
				orderlist.setOrder_state(rs.getString("order_state"));
				name.add(rs.getString("order_name"));
				orderlist.setOrder_name(name);
				price.add(rs.getInt("order_price"));
				orderlist.setOrder_price(price);
				quantity.add(rs.getInt("order_quantity"));
				orderlist.setOrder_quantity(quantity);
				orderlist.setTotalmoney(rs.getInt("order_price")*rs.getInt("order_quantity"));
				testlist.add(orderlist);
				
				}
				while(rs.next()) {
					
					for (int i = 0; i < testlist.size(); i++) {
						if(testlist.get(i).getOrder_num()==rs.getInt("order_num")) {
							testlist.get(i).getOrder_name().add(rs.getString("order_name"));
							testlist.get(i).getOrder_price().add(rs.getInt("order_price"));
							testlist.get(i).getOrder_quantity().add(rs.getInt("order_quantity"));
							testlist.get(i).setTotalmoney(testlist.get(i).getTotalmoney()+(rs.getInt("order_price")*rs.getInt("order_quantity")));
							
						}
					}
				
				}
		
			
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
		}
		
		
		return testlist;
	}
	public ArrayList<OrderList> getDetailInfoList2(int Order_num) {
		// TODO Auto-generated method stub
		ArrayList<OrderList> testlist=new ArrayList<>();
		OrderList orderlist=null;
		ArrayList<String> name=null;
		ArrayList<Integer> price=null;
		ArrayList<Integer> quantity=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select order_list.*, order_detail.*,company.*,member.*,rider.* from order_list inner join order_detail"
				+ " on order_list.order_num=order_detail.order_num inner join company on order_list.company_id=company.company_id "
				+ "inner join member on order_list.member_id=member.member_id inner join rider on order_list.rider_id=rider.rider_id "
				+ "where order_list.order_state='배달중' and order_list.order_num=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,Order_num);
			rs=pstmt.executeQuery();
			
				if (rs.next()) {
					
				orderlist=new OrderList();
				price=new ArrayList<Integer>();
				name=new ArrayList<String>();
				quantity=new ArrayList<>(); 
				orderlist.setOrder_num(rs.getInt("order_num"));
				orderlist.setOrder_date(rs.getString("order_date"));
				orderlist.setMember_tel(rs.getString("member_tel"));
				orderlist.setMember_address1(rs.getString("order_member_address1"));
				orderlist.setMember_address2(rs.getString("order_member_address2"));
				orderlist.setMember_address_lat(rs.getString("member_address_lat"));
				orderlist.setMember_address_lng(rs.getString("member_address_lng"));
				orderlist.setCompany_id(rs.getString("company_id"));
				orderlist.setCompany_name(rs.getString("company_name"));
				orderlist.setCompany_tel(rs.getString("company_tel"));
				orderlist.setCompany_email(rs.getString("company_email"));
				orderlist.setCompany_address1(rs.getString("company_address1"));
				orderlist.setCompany_address2(rs.getString("company_address2"));
				orderlist.setCompany_address3(rs.getString("company_address3"));
				orderlist.setCompany_address4(rs.getString("company_address4"));
				orderlist.setCompany_address_lat(rs.getString("company_address_lat"));
				orderlist.setCompany_address_lng(rs.getString("company_address_lng"));
				orderlist.setOrder_state(rs.getString("order_state"));
				orderlist.setRider_name(rs.getString("rider_name"));
				orderlist.setRider_tel(rs.getString("rider_tel"));
				
				name.add(rs.getString("order_name"));
				orderlist.setOrder_name(name);
				price.add(rs.getInt("order_price"));
				orderlist.setOrder_price(price);
				quantity.add(rs.getInt("order_quantity"));
				orderlist.setOrder_quantity(quantity);
				orderlist.setTotalmoney(rs.getInt("order_price")*rs.getInt("order_quantity"));
				testlist.add(orderlist);
				
				}
				while(rs.next()) {
					
					for (int i = 0; i < testlist.size(); i++) {
						if(testlist.get(i).getOrder_num()==rs.getInt("order_num")) {
							testlist.get(i).getOrder_name().add(rs.getString("order_name"));
							testlist.get(i).getOrder_price().add(rs.getInt("order_price"));
							testlist.get(i).getOrder_quantity().add(rs.getInt("order_quantity"));
							testlist.get(i).setTotalmoney(testlist.get(i).getTotalmoney()+(rs.getInt("order_price")*rs.getInt("order_quantity")));
							
						}
					}
				
				}
			
			
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
		}
		
		
		return testlist;
	}
	public ArrayList<OrderList> getSuccessDetail(int order_num, String rider_id) {
		// TODO Auto-generated method stub
		ArrayList<OrderList> orderSuccessDetailList=new ArrayList<>();
		OrderList orderlist=null;
		ArrayList<String> name=null;
		ArrayList<Integer> price=null;
		ArrayList<Integer> quantity=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select order_list.*, order_detail.*,company.*,member.* from order_list"
				+ " inner join order_detail on order_list.order_num=order_detail.order_num "
				+ "inner join company on order_list.company_id=company.company_id "
				+ "inner join member on order_list.member_id=member.member_id"
				+ " where order_list.order_state='배달 완료' and order_list.order_num=? and order_list.rider_id=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,order_num);
			pstmt.setString(2, rider_id);
			rs=pstmt.executeQuery();
			
				if (rs.next()) {
					
				orderlist=new OrderList();
				price=new ArrayList<Integer>();
				name=new ArrayList<String>();
				quantity=new ArrayList<>(); 
				orderlist.setOrder_num(rs.getInt("order_num"));
				orderlist.setOrder_date(rs.getString("order_date"));
				orderlist.setMember_tel(rs.getString("member_tel"));
				orderlist.setMember_address1(rs.getString("member_address1"));
				orderlist.setMember_address2(rs.getString("member_address2"));
				orderlist.setMember_address3(rs.getString("member_address3"));
				orderlist.setMember_address4(rs.getString("member_address4"));
				orderlist.setCompany_name(rs.getString("company_name"));
				orderlist.setCompany_tel(rs.getString("company_tel"));
				orderlist.setCompany_email(rs.getString("company_email"));
				orderlist.setCompany_address1(rs.getString("company_address1"));
				orderlist.setCompany_address2(rs.getString("company_address2"));
				orderlist.setCompany_address3(rs.getString("company_address3"));
				orderlist.setCompany_address4(rs.getString("company_address4"));
				orderlist.setOrder_state(rs.getString("order_state"));
				
				
				name.add(rs.getString("order_name"));
				orderlist.setOrder_name(name);
				price.add(rs.getInt("order_price"));
				orderlist.setOrder_price(price);
				quantity.add(rs.getInt("order_quantity"));
				orderlist.setOrder_quantity(quantity);
				orderlist.setTotalmoney(rs.getInt("order_price")*rs.getInt("order_quantity"));
				orderSuccessDetailList.add(orderlist);
				
				}
				while(rs.next()) {
					
					for (int i = 0; i < orderSuccessDetailList.size(); i++) {
						if(orderSuccessDetailList.get(i).getOrder_num()==rs.getInt("order_num")) {
							orderSuccessDetailList.get(i).getOrder_name().add(rs.getString("order_name"));
							orderSuccessDetailList.get(i).getOrder_price().add(rs.getInt("order_price"));
							orderSuccessDetailList.get(i).getOrder_quantity().add(rs.getInt("order_quantity"));
							orderSuccessDetailList.get(i).setTotalmoney(orderSuccessDetailList.get(i).getTotalmoney()+(rs.getInt("order_price")*rs.getInt("order_quantity")));
							
						}
					}
				
				}
			
			
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
		}
		return orderSuccessDetailList;
	}
	public int updateRiderState(String rider_id) {
		// TODO Auto-generated method stub
		int result=0;
		PreparedStatement pstmt=null;
		
		try {
			
			pstmt=con.prepareStatement("update rider set rider_state='배달중' where rider_id=?");
					// executeQeury와 executeUpdate 의 차이를 알아야한다.
			
			pstmt.setString(1, rider_id);
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(pstmt!=null) close(pstmt);
		}
		
		return result;
		
	}
	public int updateOrderState(int order_num,String rider_id) {
		// TODO Auto-generated method stub
		int result=0;
		PreparedStatement pstmt=null;
		System.out.println("RiderDAO에서 rider_id값"+rider_id);
		System.out.println("RiderDAO애서 order_num값"+order_num);
		try {
			pstmt=con.prepareStatement("update order_list set order_state='배달중', rider_id=? where order_num=?");
			pstmt.setString(1, rider_id);
			pstmt.setInt(2, order_num);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) close(pstmt);
		}
		System.out.println("RiderDAO에서 result값"+result);
		return result;
	}
	public int getOrder_num(String rider_id) {
		// TODO Auto-generated method stub
		int Order_num=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=con.prepareStatement("select * from order_list where rider_id=? and order_state='배달중'");
			pstmt.setString(1, rider_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				Order_num=rs.getInt("order_num");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
		}
		
		return Order_num;
	}
	public int deliverySuccess(int order_num,String rider_id) {
		// TODO Auto-generated method stub
		int Order_num=0;
		PreparedStatement pstmt=null;
		
		try {
			pstmt=con.prepareStatement("update rider set rider_state='배달 안함',rider_count=rider_count+1 where rider_id=?");
			pstmt.setString(1, rider_id);
			Order_num=pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("update order_list set order_state='배달 완료' where order_num=?");
			pstmt.setInt(1, order_num);
			Order_num=pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt!=null) close(pstmt);
			if(pstmt!=null) close(pstmt);
		}
		
		return Order_num;
	}
	
	
	
	
	
	
}
