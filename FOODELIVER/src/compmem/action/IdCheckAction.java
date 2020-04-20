package compmem.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import complog.svc.LoginSvc;
import comp.vo.Member;

public class IdCheckAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		String check_id = request.getParameter("company_memberid");
		
		LoginSvc idCheckSvc = new LoginSvc();
		
		Member member = idCheckSvc.memberLogin(check_id);
		
		if(member==null) {
			request.setAttribute("passibleId", true);
		}else {
			request.setAttribute("passibleId", false);
		}
		request.setAttribute("company_memberid", check_id);
		
		ActionForward forward = new ActionForward();
		forward.setPath("company/idCheck.jsp");
		return forward;
	}
}
