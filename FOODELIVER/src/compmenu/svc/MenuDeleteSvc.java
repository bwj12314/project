package compmenu.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import compmenu.dao.MenuAddDAO;

public class MenuDeleteSvc {

	public boolean removeMenu(int company_menunum,String company_id) {
		// TODO Auto-generated method stub
		boolean isRemoveSuccess = false;
		Connection con = getConnection();
		MenuAddDAO menuDAO = MenuAddDAO.getInstance();
		menuDAO.setConnection(con);
		int deleteCount = menuDAO.deleteMenu(company_menunum,company_id);
		
		if(deleteCount > 0) {
			commit(con);
			isRemoveSuccess=true;
		}
		else {
			rollback(con);
		}
		close(con);
		return isRemoveSuccess;
	}

}
