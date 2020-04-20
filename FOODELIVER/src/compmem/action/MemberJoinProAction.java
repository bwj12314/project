package compmem.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import compmem.svc.MemberJoinSvc;
import comp.vo.Member;

public class MemberJoinProAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		Member member = new Member();
		member.setCompany_id(request.getParameter("company_id"));
		member.setCompany_memberid(request.getParameter("company_memberid"));
		member.setCompany_memberpass(request.getParameter("company_memberpass"));
		member.setCompany_membername(request.getParameter("company_membername"));
		member.setCompany_memberemail(request.getParameter("company_memberemail"));
		member.setCompany_membertel(request.getParameter("company_membertel"));
		
		MemberJoinSvc memberJoinsvc = new MemberJoinSvc();
		boolean joinResult = memberJoinsvc.joinMember(member);
		
		ActionForward forward = null;
		if(!joinResult) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입 오류가 발생했습니다. 다시작성하세요.');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입이 완료되었습니다 로그인해주세요.');");
			out.println("location.href='../company_main.jsp'");
			out.println("</script>");
		
		}
		return forward;
	}

}
