package compmem.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import complog.svc.LoginSvc;
import comp.vo.Member;

public class MemberModFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");
			ActionForward forward = null;
			String company_memberid= null;
			HttpSession session = request.getSession();
			if (session.getAttribute("company_memberid") == null) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인해야합니다.');");
				out.println("location.href='compMain.login';");
				out.println("</script>");
			} else {
				company_memberid = (String) session.getAttribute("company_memberid");	
			}
			if (request.getParameter("company_memberid") != null && company_memberid != null) {
				company_memberid = request.getParameter("company_memberid");
			}
			if (company_memberid != null && !company_memberid.equals("")) {
				LoginSvc memberModForm = new LoginSvc();
				Member member = new Member();
				member = memberModForm.memberLogin(company_memberid);
				request.setAttribute("member", member);
				forward = new ActionForward();
				forward.setPath("company_membermodForm.jsp");
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인해야합니다.');");
				out.println("location.href='loginForm.login';");
				out.println("</script>");
			}
			return forward;
	}

}
