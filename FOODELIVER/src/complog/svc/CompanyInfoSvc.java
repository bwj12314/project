package complog.svc;

import static db.JdbcUtil.*;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import comp.vo.Company;
import compmem.dao.MemberDAO;

public class CompanyInfoSvc {
	public Company companyinfo(String company_id,String id) {
		Company company=null;
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);
		
		company=memberDao.companyinfo(company_id,id);
		
		close(con);
		return company;
	}
}
