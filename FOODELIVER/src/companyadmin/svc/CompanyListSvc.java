package companyadmin.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import comp.vo.Company;
import companyadmin.dao.AdminDAO;


public class CompanyListSvc {

	public ArrayList<Company> getCompanyList(String company_id,String admin_grade) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		AdminDAO adminDao = AdminDAO.getInstance();
		adminDao.setConnection(con);
		
		ArrayList<Company> companylist = adminDao.selectCompanyList(company_id,admin_grade);
		close(con);
		return companylist;
	}

	public ArrayList<Company> getCompanyAllList() {
		Connection con = getConnection();
		AdminDAO adminDao = AdminDAO.getInstance();
		adminDao.setConnection(con);
		
		ArrayList<Company> companylist = adminDao.selectAllCompanyList();
		close(con);
		return companylist;
	}

}
