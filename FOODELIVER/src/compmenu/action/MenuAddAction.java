package compmenu.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import action.ActionForward;
import comp.vo.*;
import compmenu.svc.MenuAddSvc;



public class MenuAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		ActionForward forward = null;
		Menu menu = null;
		String realFolder = "";
		String saveFolder = "/menu";
		String encType = "UTF-8";
		int maxSize = 5*1024*1024;
		int company_menunum = 0;
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder,maxSize,encType,new DefaultFileRenamePolicy());

		MenuAddSvc menuaddsvc = new MenuAddSvc();
		String company_id = multi.getParameter("company_id");
		company_menunum = menuaddsvc.Menunum(company_id);
		company_menunum = company_menunum+1;
		menu = new Menu(
				multi.getParameter("company_id"),
				multi.getParameter("company_menuname"),
				Integer.parseInt(multi.getParameter("company_menuprice")),
				multi.getOriginalFileName((String)multi.getFileNames().nextElement()),
				multi.getParameter("company_menuinfo"),
				company_menunum
				);
		
		
		boolean isAddSuccess = menuaddsvc.AddMenu(menu,company_menunum);
		
		
		if(isAddSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록되었습니다.');");
			out.println("location.href='company_info.jsp'");
			out.println("</script>");
			
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
