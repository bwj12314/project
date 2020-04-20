package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import rider.vo.ActionForward;

public class LogoutAdminAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward=null;
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("adminid");
		if(id!=null) {
		session.removeAttribute("adminid");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("alert('로그아웃되었습니다.');");
		out.println("location.href='adminMain.jsp'");
		out.println("</script>");
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('로그인하지 않았습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
