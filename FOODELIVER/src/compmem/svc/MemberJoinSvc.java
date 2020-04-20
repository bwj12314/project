package compmem.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import comp.vo.Member;
import compmem.dao.MemberDAO;

public class MemberJoinSvc {

	public boolean joinMember(Member member) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);
		
		int insertCount = memberDao.insertMember(member);
		
		boolean joinResult = false;
		if(insertCount > 0) {
			commit(con);
			joinResult=true;
		}else {
			rollback(con);
		}
		
		close(con);
		
		return joinResult;
	}


}

