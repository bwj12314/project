package complog.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import comp.vo.Company;
import compmem.dao.MemberDAO;

public class CompanyMenuSvc {

	public ArrayList<Company> companymenu(String company_id, String id) {
		// TODO Auto-generated method stub
		ArrayList<Company> menulist=null;
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);
		
		menulist=memberDao.companymenu(company_id,id);
		
		close(con);
		return menulist;
	}

}
