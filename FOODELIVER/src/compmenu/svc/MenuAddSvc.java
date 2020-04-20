package compmenu.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import comp.vo.*;
import compmenu.dao.MenuAddDAO;

public class MenuAddSvc {

	public boolean AddMenu(Menu menu,int company_menunum) throws Exception {
		// TODO Auto-generated method stub
		boolean isAddSuccess = false;	
		MenuAddDAO menuaddDAO = MenuAddDAO.getInstance();
		Connection con = getConnection();
		menuaddDAO.setConnection(con);		
			
		int insertCount = menuaddDAO.AddMenu(menu,company_menunum);
		
		if(insertCount>0){
			commit(con);
			isAddSuccess=true;
		}else{
			rollback(con);
		}
		
		close(con);
		return isAddSuccess;
	}

	public int Menunum(String company_id) {
		// TODO Auto-generated method stub
	
		Connection con = getConnection();
		MenuAddDAO menuadddao = MenuAddDAO.getInstance();
		menuadddao.setConnection(con);
		int company_menunum = menuadddao.MenuNumMax(company_id);
		
		close(con);
		
		return company_menunum;
	}

}
