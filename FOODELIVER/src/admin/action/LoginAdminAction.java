package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import admin.svc.LoginAdminSVC;
import rider.vo.ActionForward;
import rider.vo.Admin;

public class LoginAdminAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		ActionForward forward=null;
		Admin admin=null;
		LoginAdminSVC loginadminsvc=new LoginAdminSVC();
		admin=loginadminsvc.AdminLogin(id);
		
		if(admin==null||!pass.equals(admin.getAdmin_pass())) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('아이디가 없거나 비밀번호가 일치하지 않습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}else {
				HttpSession session=request.getSession();
				session.setAttribute("adminid", id);
				forward = new ActionForward("adminMain.jsp", true);
		}
		
		return forward;
	}

}
