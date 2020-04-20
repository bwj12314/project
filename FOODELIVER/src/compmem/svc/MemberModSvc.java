package compmem.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import comp.vo.Member;
import compmem.dao.MemberDAO;

public class MemberModSvc {

	public boolean memberModi(Member member) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);
		
		int modifyCount = memberDao.updateMember(member);
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
