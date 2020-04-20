package compmem.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import compmem.svc.MemberDeleteSvc;


public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		String company_memberid =request.getParameter("company_memberid");
		MemberDeleteSvc memberdeletesvc = new MemberDeleteSvc();
		boolean isDeleteSuccess = memberdeletesvc.deleteMember(company_memberid);
		
		if(!isDeleteSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('탈퇴실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('탈퇴 되었습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
