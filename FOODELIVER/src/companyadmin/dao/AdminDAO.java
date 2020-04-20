package companyadmin.dao;
import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import comp.vo.Company;
public class AdminDAO {
	
	DataSource ds;
	Connection con;
	private static AdminDAO adminDao;
	
	
	public static AdminDAO getInstance() {
		// TODO Auto-generated method stub
		if(adminDao==null) {
			adminDao=new AdminDAO();
		}
		return adminDao;
	}


	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
	}


	public ArrayList<Company> selectCompanyList(String company_id, String admin_grade) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Company> companylist = null;
		try {
			pstmt=con.prepareStatement("select * from company");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				companylist = new ArrayList<Company>();
				do {
					Company companyadmin = new Company();
					companyadmin.setCompany_logo(rs.getString("company_logo"));
					companyadmin.setCompany_name(rs.getString("company_name"));
					companyadmin.setCompany_id(rs.getString("company_id"));
					companyadmin.setCompany_businum(rs.getString("company_businum"));
					companyadmin.setCompany_active(rs.getString("company_active"));
					companyadmin.setCompany_tel(rs.getString("company_tel"));
					companyadmin.setCompany_category(rs.getString("company_category"));
					companyadmin.setCompany_address1(rs.getString("company_address1"));
					companyadmin.setCompany_address2(rs.getString("company_address2"));
					companyadmin.setCompany_address3(rs.getString("company_address3"));
					companyadmin.setCompany_address4(rs.getString("company_address4"));
					companyadmin.setCompany_score(rs.getInt("company_score"));
					
					companylist.add(companyadmin);
				}while(rs.next());
			}
		}catch(SQLException e) {
				e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return companylist;
	}


	public Company selectCompany(String company_id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Company company = null;
		
		try {
			pstmt=con.prepareStatement("select * from company where company_id = ?");
			pstmt.setString(1, company_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				company = new Company();
				company.setCompany_id(rs.getString("company_id"));
				company.setCompany_name(rs.getString("company_name"));
				company.setCompany_businum(rs.getString("company_businum"));
				company.setCompany_tel(rs.getString("company_tel"));
				company.setCompany_category(rs.getString("company_category"));
				company.setCompany_address1(rs.getString("company_address1"));
				company.setCompany_address2(rs.getString("company_address2"));
				company.setCompany_address3(rs.getString("company_address3"));
				company.setCompany_address4(rs.getString("company_address4"));
				company.setCompany_active(rs.getString("company_active"));
				company.setCompany_logo(rs.getString("company_logo"));				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return company;
	}


	public int updateCompany(Company company) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=con.prepareStatement("update company set company_name =? , company_businum=?,company_tel=?,company_category=?,\r\n" + 
					"company_address1=?,company_address2=?,company_address3=?,company_address4=?,company_active=?,company_logo=? where company_id = ?;");
			pstmt.setString(1, company.getCompany_name());
			pstmt.setString(2, company.getCompany_businum());
			pstmt.setString(3, company.getCompany_tel());
			pstmt.setString(4, company.getCompany_category());
			pstmt.setString(5, company.getCompany_address1());
			pstmt.setString(6, company.getCompany_address2());
			pstmt.setString(7, company.getCompany_address3());
			pstmt.setString(8, company.getCompany_address4());
			pstmt.setString(9, company.getCompany_active());
			pstmt.setString(10, company.getCompany_logo());
			pstmt.setString(11, company.getCompany_id());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public ArrayList<Company> selectAllCompanyList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Company> companylist = null;
		try {
			pstmt=con.prepareStatement("select * from company");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				companylist = new ArrayList<Company>();
				do {
					Company companyadmin = new Company();
					companyadmin.setCompany_logo(rs.getString("company_logo"));
					companyadmin.setCompany_name(rs.getString("company_name"));
					companyadmin.setCompany_id(rs.getString("company_id"));
					companyadmin.setCompany_businum(rs.getString("company_businum"));
					companyadmin.setCompany_active(rs.getString("company_active"));
					companyadmin.setCompany_tel(rs.getString("company_tel"));
					companyadmin.setCompany_category(rs.getString("company_category"));
					companyadmin.setCompany_address1(rs.getString("company_address1"));
					companyadmin.setCompany_address2(rs.getString("company_address2"));
					companyadmin.setCompany_address3(rs.getString("company_address3"));
					companyadmin.setCompany_address4(rs.getString("company_address4"));
					companyadmin.setCompany_score(rs.getInt("company_score"));
					
					companylist.add(companyadmin);
				}while(rs.next());
			}
		}catch(SQLException e) {
				e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return companylist;
	}


	public int insertaddCompany(delivery_member.vo.Company company) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=con.prepareStatement("insert into company (company_id,company_businum,company_name,company_tel,company_logo,company_category,company_regdate,company_address1,company_address2,company_address3,company_address4,company_active,company_score,company_email,company_totalsales) values (?,?,?,?,?,?,current_timestamp,?,?,?,?,'활성상태',0,?,0 )");
			pstmt.setString(1, company.getCompany_id());
			pstmt.setString(2, company.getCompany_businum());
			pstmt.setString(3, company.getCompany_name());
			pstmt.setString(4, company.getCompany_tel());
			pstmt.setString(5, company.getCompany_logo());
			pstmt.setString(6, company.getCompany_category());
			//current_timestamp
			pstmt.setString(7, company.getCompany_address1());
			pstmt.setString(8, company.getCompany_address2());
			pstmt.setString(9, company.getCompany_address3());
			pstmt.setString(10, company.getCompany_address4());
			//lat
			//lng
		
			pstmt.setString(11, company.getCompany_email());
			
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int insertaddCompanyAddress(String company_id, String lat, String lng) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=con.prepareStatement("update company set company_address_lat=?,company_address_lng=? where company_id=?");
			pstmt.setString(1, lat);
			pstmt.setString(2, lng);
			pstmt.setString(3, company_id);
			
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int insertaddCompanyScore(delivery_member.vo.Company company) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=con.prepareStatement("insert into company_score values (?,0,0)");
			pstmt.setString(1, company.getCompany_id());
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}	
