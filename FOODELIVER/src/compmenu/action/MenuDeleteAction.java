package compmenu.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import compmenu.svc.MenuDeleteSvc;

public class MenuDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward = null;
		int company_menunum = Integer.parseInt(request.getParameter("company_menunum"));
		String company_id =request.getParameter("company_id");
		MenuDeleteSvc menudeletesvc = new MenuDeleteSvc();
		boolean isDeleteSuccess = menudeletesvc.removeMenu(company_menunum,company_id);
		
		if(!isDeleteSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 되었습니다.');");
			out.println("location.href='menulist.menu'");
			out.println("</script>");
		}
		return forward;
	}

}
