package compmenu.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import comp.vo.Menu;
import compmenu.dao.*;

public class MenuModiProSvc {

	public boolean modimenu(Menu menu) throws Exception{
		// TODO Auto-generated method stub
		boolean isModiSuccess = false;
		Connection con = getConnection();
		MenuAddDAO menuadddao = MenuAddDAO.getInstance();
		menuadddao.setConnection(con);
		int updateCount = menuadddao.Modimenu(menu);

		if(updateCount > 0){
			commit(con);
			isModiSuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isModiSuccess;
	}


}
