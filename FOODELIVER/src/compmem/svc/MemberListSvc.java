package compmem.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import comp.vo.Member;
import compmem.dao.MemberDAO;

public class MemberListSvc {

	public ArrayList<Member> getMemberList(String company_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);
		
		ArrayList<Member> list = memberDao.selectMemberList(company_id);
		close(con);
		return list;
	}

}
