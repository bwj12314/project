package companyadmin.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import companyadmin.dao.AdminDAO;
import delivery_member.vo.Company;

public class CompanyInService {

	public boolean setcompany(Company company) {
		// TODO Auto-generated method stub
				Connection con = getConnection();
				AdminDAO adminDao = AdminDAO.getInstance();
				adminDao.setConnection(con);
				
				int Count = adminDao.insertaddCompany(company);
				boolean success=false;
				if(Count > 0) {
					int sCount=adminDao.insertaddCompanyScore(company);
					
					if(sCount>0) {
						success=true;
						commit(con);
					}
					
					
				}else {
					rollback(con);
					
				}
				close(con);
				return success;
	}

	public boolean setcompanyaddress(String company_id, String lat, String lng) {
		Connection con = getConnection();
		AdminDAO adminDao = AdminDAO.getInstance();
		adminDao.setConnection(con);
		
		int Count = adminDao.insertaddCompanyAddress(company_id,lat,lng);
		boolean success=false;
		if(Count > 0) {
			commit(con);
			success=true;
		}else {
			rollback(con);
			
		}
		close(con);
		return success;
	}

}
