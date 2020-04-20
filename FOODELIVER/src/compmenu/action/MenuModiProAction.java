package compmenu.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import compmenu.svc.*;
import comp.vo.Menu;

public class MenuModiProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		boolean isModiSuccess = false;
		Menu menu=new Menu(
				request.getParameter("company_id"),
				request.getParameter("company_menuname"),
				Integer.parseInt(request.getParameter("company_menuprice")),
				request.getParameter("company_menupicture"),
				request.getParameter("company_menuinfo"),
				Integer.parseInt(request.getParameter("company_menunum")));
		MenuModiProSvc menumodiprosvc = new MenuModiProSvc();
			isModiSuccess = menumodiprosvc.modimenu(menu);
			if(!isModiSuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패');");
				out.println("history.back()");
				out.println("</script>");
			}
			else{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('수정이 완료되었습니다.');");
				out.println("location.href='company_info.jsp'");
				out.println("</script>");
			}
		return forward;
	}
}
