package compmem.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import compmem.dao.MemberDAO;

public class MemberGradeModiSvc {

	public boolean GradeModi(String selectgrade, String company_memberid) {
		// TODO Auto-generated method stub
		boolean isGradeModiSuccess = false;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		int ModiCount = memberDAO.GradeModi(selectgrade,company_memberid);
		
		if(ModiCount > 0) {
			commit(con);
			isGradeModiSuccess=true;
		}
		else {
			rollback(con);
		}
		close(con);
		return isGradeModiSuccess;
	}
}
