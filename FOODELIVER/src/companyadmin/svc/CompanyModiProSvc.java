package companyadmin.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import comp.vo.Company;
import companyadmin.dao.AdminDAO;

public class CompanyModiProSvc {

	public boolean companymodipro(Company company) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		AdminDAO adminDao = AdminDAO.getInstance();
		adminDao.setConnection(con);
		
		int modifyCount = adminDao.updateCompany(company);
		boolean modResult=false;
		if(modifyCount > 0) {
			commit(con);
			modResult=true;
		}else {
			rollback(con);
			
		}
		close(con);
		return modResult;
	}

}
