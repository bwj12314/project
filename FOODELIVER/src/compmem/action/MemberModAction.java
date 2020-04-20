package compmem.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import comp.vo.Member;
import compmem.svc.MemberModSvc;


public class MemberModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		ActionForward forward = null;
		if(session.getAttribute("company_memberid") == null){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인을 하세요')");
			out.println("location.href='loginForm.jsp'");
			out.println("</script>");
			
		}else{
			request.setCharacterEncoding("utf-8");
			Member member = new Member();
			member.setCompany_id(request.getParameter("company_id"));
			member.setCompany_memberid(request.getParameter("company_memberid"));
			member.setCompany_memberpass(request.getParameter("company_memberpass"));
			member.setCompany_membername(request.getParameter("company_membername"));
			member.setCompany_memberemail(request.getParameter("company_memberemail"));
			member.setCompany_membertel(request.getParameter("company_membertel"));
			MemberModSvc memberModsvc = new MemberModSvc();
			boolean result = memberModsvc.memberModi(member);
			if(!result) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정에 실패하였습니다.');");
				out.println("location.href='login.login';");
				out.println("</script>");	
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정성공.');");
				out.println("location.href='company_info.jsp';");
				out.println("</script>");
			}
		}
		return forward;
	}

}
