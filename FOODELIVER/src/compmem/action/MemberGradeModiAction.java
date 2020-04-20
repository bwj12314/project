package compmem.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import compmem.svc.MemberGradeModiSvc;

public class MemberGradeModiAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		String selectgrade = request.getParameter("selectgrade");
		System.out.println(selectgrade);
		String company_memberid =request.getParameter("company_memberid");
		MemberGradeModiSvc membergradmodisvc = new MemberGradeModiSvc();
		boolean isGradeModiSuccess = membergradmodisvc.GradeModi(selectgrade,company_memberid);
		
		if(!isGradeModiSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('변경실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('변경 되었습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
