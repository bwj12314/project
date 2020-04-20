package companyadmin.svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import comp.vo.Company;
import companyadmin.dao.AdminDAO;

public class CompanyModiSvc {

	public Company companyModi(String company_id) {
		// TODO Auto-generated method stub
		Company company = null;
		Connection con = getConnection();
		AdminDAO adminDao = AdminDAO.getInstance();
		adminDao.setConnection(con);
		
		company = adminDao.selectCompany(company_id);
		
		close(con);
		return company;
	}

}
