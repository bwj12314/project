package compmenu.dao;
import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import comp.vo.Menu;

public class MenuAddDAO {
	
	DataSource ds;
	Connection con;
	private static MenuAddDAO menuaddDAO;
	
	private MenuAddDAO() {
		
	}

	public static MenuAddDAO getInstance() {
		// TODO Auto-generated method stub
		if(menuaddDAO == null) {
			menuaddDAO = new MenuAddDAO();
		}
		return menuaddDAO;
	}

	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
		
	}

	public int AddMenu(Menu menu,int company_menunum) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		int insertCount=0;
		
		try {			
			pstmt = con.prepareStatement("insert into company_menu(\r\n" + 
					"		company_id,\r\n" + 
					"		company_menuname,\r\n" + 
					"		company_menuprice,\r\n" + 
					"		company_menupicture,\r\n" + 
					"		company_menuinfo,\r\n" + 
					"		company_menunum\r\n" + 
					"		)\r\n" + 
					"values (?,?,?,?,?,?);");
			
			pstmt.setString(1,menu.getCompany_id());
			pstmt.setString(2, menu.getCompany_menuname());
			pstmt.setInt(3, menu.getCompany_menuprice());
			pstmt.setString(4, menu.getCompany_menupicture()==null?"":menu.getCompany_menupicture());
			pstmt.setString(5, menu.getCompany_menuinfo());
			pstmt.setInt(6, company_menunum);
			insertCount=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("AddMenu 에러 : " + e);
			
		}finally {
			close(pstmt);
		}
		return insertCount;
	}

	public int Modimenu(Menu menu) {
		
		// TODO Auto-generated method stub
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql="update company_menu set "
				+ "company_menuname=?,company_menuprice=?,company_menupicture=?,company_menuinfo=? "
				+ "where company_menunum=? and company_id=?";

		try{
			System.out.println(menu.getCompany_menuname());
			System.out.println(menu.getCompany_menuprice());
			System.out.println(menu.getCompany_menupicture());
			System.out.println(menu.getCompany_menuinfo());
			System.out.println(menu.getCompany_menunum());
			System.out.println(menu.getCompany_id());
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, menu.getCompany_menuname());
			pstmt.setInt(2, menu.getCompany_menuprice());
			pstmt.setString(3, menu.getCompany_menupicture());
			pstmt.setString(4, menu.getCompany_menuinfo());
			pstmt.setInt(5,menu.getCompany_menunum());
			pstmt.setString(6, menu.getCompany_id());
			updateCount = pstmt.executeUpdate();
		
		}catch(Exception e){
			System.out.println("MenuModify 에러 : " + e);
		}finally{
			close(pstmt);
		}
		return updateCount;
	}

	public int MenuNumMax(String company_id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int company_menunum = 0;
		String sql = "select * from company_menu where company_menunum = (select max(company_menunum) from company_menu where company_id=?)";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, company_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("company_menunum")!=null) {
					company_menunum = rs.getInt("company_menunum");
				}
			}
			
		}catch(SQLException e){
			System.out.println("selectmaxcompany_menunum없을때:" + e);
		}finally {
			close(con);
			close(rs);
		}
		return company_menunum;
	}

	public int deleteMenu(int company_menunum,String company_id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql="delete from company_menu where company_menunum=? and company_id=?";
		int deleteCount=0;

		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, company_menunum);
			pstmt.setString(2, company_id);
			deleteCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("메뉴삭제 에러 : "+ex);
		}	finally{
			close(pstmt);
		}

		return deleteCount;
	}

	public int totalMoney(String companyid, int totalmoney) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		String sql="update company set company_totalsales=company_totalsales+? where company_id=?";
		int count=0;
		System.out.println(companyid);
		System.out.println(totalmoney);
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, totalmoney);
			pstmt.setString(2, companyid);
			count=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return count;
	}
	

}
