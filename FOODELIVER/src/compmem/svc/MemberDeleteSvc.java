package compmem.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;
import java.sql.Connection;
import compmem.dao.MemberDAO;

public class MemberDeleteSvc {

	public boolean deleteMember(String company_memberid) {
		// TODO Auto-generated method stub
		boolean isRemoveSuccess = false;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		int deleteCount = memberDAO.deleteMember(company_memberid);
		
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
