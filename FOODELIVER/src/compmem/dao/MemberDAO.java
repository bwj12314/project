package compmem.dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import comp.vo.Company;
import comp.vo.Member;
import comp.vo.Order;

public class MemberDAO {
	
	DataSource ds;
	Connection con;
	private static MemberDAO memberDao;
	

	public static MemberDAO getInstance() {
		// TODO Auto-generated method stub
		if(memberDao==null) {
			memberDao=new MemberDAO();
		}
		return memberDao;
	}
	
	public Member selectMember(String id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			pstmt=con.prepareStatement("select * from company_member where company_memberid=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setCompany_id(rs.getString("company_id"));
				member.setCompany_memberid(rs.getString("company_memberid"));
				member.setCompany_memberpass(rs.getString("company_memberpass"));
				member.setCompany_membername(rs.getString("company_membername"));
				member.setCompany_memberemail(rs.getString("company_memberemail"));
				member.setCompany_membertel(rs.getString("company_membertel"));
				member.setCompany_membergrade(rs.getString("company_membergrade"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return member;
	}

	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
		
	}

	public int insertMember(Member member) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int insertCount=0;
		
		try {
			pstmt=con.prepareStatement("insert into company_member values (?,?,?,?,?,?,?)");
			pstmt.setString(1, member.getCompany_memberid());
			pstmt.setString(2, member.getCompany_id());
			pstmt.setString(3, member.getCompany_membername());
			pstmt.setString(4, member.getCompany_memberpass());
			pstmt.setString(5, "N");
			pstmt.setString(6, member.getCompany_memberemail());
			pstmt.setString(7, member.getCompany_membertel());
			
			insertCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(pstmt);
		}
		return insertCount;
	}

	public Company companyinfo(String company_id,String id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Company company = null;
		try {
			pstmt=con.prepareStatement("select c.*,cme.*,cmu.*,cs.*\r\n" + 
					"from company c\r\n" + 
					"left join company_member cme on c.company_id = cme.company_id \r\n" + 
					"left join company_menu cmu on c.company_id = cmu.company_id\r\n" + 
					"left join company_score cs on c.company_id = cs.company_id\r\n" + 
					"where cme.company_memberid = ?;");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			
			if(rs.next()) {
				company = new Company();
				company.setCompany_id(rs.getString("company_id"));
				company.setCompany_businum(rs.getString("company_businum"));
				company.setCompany_name(rs.getString("company_name"));
				company.setCompany_tel(rs.getString("company_tel"));
				company.setCompany_logo(rs.getString("company_logo"));
				company.setCompany_category(rs.getString("company_category"));
				company.setCompany_regdate(rs.getDate("company_regdate"));
				company.setCompany_address1(rs.getString("company_address1"));
				company.setCompany_address2(rs.getString("company_address2"));
				company.setCompany_address3(rs.getString("company_address3"));
				company.setCompany_active(rs.getString("company_active"));
				
				company.setCompany_menuname(rs.getString("company_menuname"));
				company.setCompany_menuprice(rs.getInt("company_menuprice"));
				company.setCompany_menupicture(rs.getString("company_menupicture"));
				company.setCompany_menuinfo(rs.getString("company_menuinfo"));
				
				company.setCompany_score(rs.getInt("company_score"));
				company.setCompany_count(rs.getInt("company_count"));
				
				company.setCompany_membername(rs.getString("company_membername"));
				company.setCompany_memberid(rs.getString("company_memberid"));
				company.setCompany_memberpass(rs.getString("company_memberpass"));
				company.setCompany_membergrade(rs.getString("company_membergrade"));
				company.setCompany_memberemail(rs.getString("company_memberemail"));
				company.setCompany_membertel(rs.getString("company_membertel"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return company;
	}

	public ArrayList<Company> companymenu(String company_id, String id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Company> menulist = null;
		try {
			pstmt=con.prepareStatement("select * from company_menu where company_id=?;");
			pstmt.setString(1, company_id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				menulist = new ArrayList<Company>();
				do {
					Company company = new Company();
					company.setCompany_menunum(rs.getInt("company_menunum"));
					company.setCompany_menuname(rs.getString("company_menuname"));
					company.setCompany_menuprice(rs.getInt("company_menuprice"));
					company.setCompany_menupicture(rs.getString("company_menupicture"));
					company.setCompany_menuinfo(rs.getString("company_menuinfo"));
					menulist.add(company);
	
				}while(rs.next());
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return menulist;
	}

	public ArrayList<Member> selectMemberList(String company_id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		ArrayList<Member> memlist = null;
		String sql = "select * from company_member where company_id =?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, company_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				memlist = new ArrayList<Member>();
				do {
					Member member = new Member();
					member.setCompany_id(rs.getString("company_id"));
					member.setCompany_memberid(rs.getString("company_memberid"));
					member.setCompany_membername(rs.getString("company_membername"));
					member.setCompany_membergrade(rs.getString("company_membergrade"));
					member.setCompany_memberemail(rs.getString("company_memberemail"));
					member.setCompany_membertel(rs.getString("company_membertel"));
					memlist.add(member);
				}while(rs.next());
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return memlist;
	}

	public int deleteMember(String company_memberid) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql="delete from company_member where company_memberid=?";
		int deleteCount=0;

		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, company_memberid);
			deleteCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("메뉴삭제 에러 : "+ex);
		}	finally{
			close(pstmt);
		}

		return deleteCount;
	}

	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		try {
		pstmt=con.prepareStatement("update company_member set company_id=?,company_memberpass=?,company_membername=?"
				+ ",company_memberemail=?,company_membertel=? where company_memberid=?");
		pstmt.setString(1, member.getCompany_id());
		pstmt.setString(2, member.getCompany_memberpass());
		pstmt.setString(3, member.getCompany_membername());
		pstmt.setString(4, member.getCompany_memberemail());
		pstmt.setString(5, member.getCompany_membertel());
		pstmt.setString(6, member.getCompany_memberid());
		result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int GradeModi(String selectgrade, String company_memberid) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql="update company_member set company_membergrade=? where company_memberid=?";
		int ModiCount=0;

		try{
			if(selectgrade.equals("modi")) {
				selectgrade = "M";
			}else {
				selectgrade = "N";
			}
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, selectgrade);
			pstmt.setString(2, company_memberid);
			ModiCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("맴버등급변경 에러 : "+ex);
		}	finally{
			close(pstmt);
		}

		return ModiCount;
	}

	public ArrayList<Order> selectOrderList(String company_id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		ArrayList<Order> orderlist = null;
		String sql = "select li.*,de.* from order_list li inner join order_detail de on li.order_num = de.order_num where li.company_id = ?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, company_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				orderlist = new ArrayList<Order>();
				do {
					Order order = new Order();
					order.setOrder_num(rs.getInt("order_num"));
					order.setOrder_date(rs.getString("order_date"));
					order.setMember_id(rs.getString("member_id"));
					order.setCompany_id(rs.getString("company_id"));
					order.setRider_id(rs.getString("rider_id"));
					order.setOrder_state(rs.getString("order_state"));
					order.setOrder_price(rs.getInt("order_price"));
					order.setOrder_name(rs.getString("order_name"));
					order.setOrder_quantity(rs.getInt("order_quantity"));
					
					orderlist.add(order);
				}while(rs.next());
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return orderlist;
	}
}
