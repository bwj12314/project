package compmem.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import compmem.svc.MemberListSvc;
import comp.vo.*;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String company_id=request.getParameter("company_id");
		
		ActionForward forward = null;
				
			MemberListSvc memberlistsvc = new MemberListSvc();	
			ArrayList<Member> memberlist = memberlistsvc.getMemberList(company_id);		
			HttpSession session = request.getSession();
			session.setAttribute("memberlist", memberlist);
			forward = new ActionForward();
			forward.setPath("company_memberlist.jsp");
			forward.setRedirect(true);	
		
		return forward;
	}

}
