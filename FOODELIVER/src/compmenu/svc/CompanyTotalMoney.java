package compmenu.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import compmenu.dao.MenuAddDAO;
public class CompanyTotalMoney {

	public boolean getTotalMoney(String companyid, int totalmoney) {
		// TODO Auto-generated method stub
		boolean updateResult=false;
		MenuAddDAO menuaddDAO = MenuAddDAO.getInstance();
		Connection con = getConnection();
		menuaddDAO.setConnection(con);	
		
		int result=menuaddDAO.totalMoney(companyid,totalmoney);
		if(result>0) {
			commit(con);
			updateResult=true;
		}else {
			rollback(con);
		}
		close(con);
		return updateResult;
	}

}
