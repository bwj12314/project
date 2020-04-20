package complog.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import compmem.dao.MemberDAO;
import comp.vo.Member;

public class LoginSvc {
	public Member memberLogin(String id) {
		Member member=null;
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);
		
		member=memberDao.selectMember(id);
		
		close(con);
		return member;
	}
}
