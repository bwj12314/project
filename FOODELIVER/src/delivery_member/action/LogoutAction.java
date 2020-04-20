package delivery_member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery_member.vo.ActionForward;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	HttpSession session=request.getSession();
	session.removeAttribute("member_id");
	session.removeAttribute("mainorder");
	ActionForward forward=new ActionForward("main.jsp", true);
		return forward;
	}

}
