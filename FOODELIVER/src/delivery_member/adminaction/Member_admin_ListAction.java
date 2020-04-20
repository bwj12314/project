package delivery_member.adminaction;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.svc.LoginAdminSVC;
import delivery_member.adminsvc.Member_admin_ListSvc;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Member;
import delivery_member.vo.PageInfo;
import rider.vo.Admin;

public class Member_admin_ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession(); 
		ActionForward forward=null;
		String id=(String)session.getAttribute("adminid");
		Admin admin=new Admin();
		
		LoginAdminSVC loginadminsvc=new LoginAdminSVC();
		admin=loginadminsvc.AdminLogin(id);
		if((session.getAttribute("adminid")==null)||
		    		(!id.equals(admin.getAdmin_id()))){
			
		    response.setContentType("text/html;charset=utf-8");
		    PrintWriter out=response.getWriter();
		    
				out.println("<script>");
		    	out.println("alert('관리자로 로그인하세요')");
		    	out.println("location.href='admin/loginForm.jsp'");
		    	out.println("</script>");
		    }
		else {
		
		request.setCharacterEncoding("UTF-8");
		int page=1;
		int limit=5;
		int limitpage=3;
		String Option="Option";
		String Value="";
		if(request.getParameter("page")!=null)
			page=Integer.parseInt(request.getParameter("page"));
		if(request.getParameter("Option")!=null)
			Option=request.getParameter("Option");
		if(request.getParameter("Value")!=null)
			Value=request.getParameter("Value");
		
		Member_admin_ListSvc malSvc = new Member_admin_ListSvc();
		int listCount = malSvc.listCount(Option, Value);
		

		ArrayList<Member> memberlist = malSvc.getmemlist(page, limit,Option,Value);

		int maxPage = (int) ((double) listCount / limit + 0.95);

		int startPage = (((int) ((double) page / limitpage + 0.9)) - 1) * limitpage + 1;

		int endPage = startPage + limitpage - 1;

		if (endPage > maxPage)
			endPage = maxPage;

		PageInfo pageinfo = new PageInfo();
		pageinfo.setEndPage(endPage);
		pageinfo.setListCount(listCount);
		pageinfo.setMaxPage(maxPage);
		pageinfo.setPage(page);
		pageinfo.setStartPage(startPage);
		request.setAttribute("pageInfo", pageinfo);

		request.setAttribute("memberlist", memberlist);
		request.setAttribute("Value", Value);
		request.setAttribute("Option", Option);
		forward = new ActionForward("member_admin/member_admin_list.jsp", false);
	
		}
		return forward;
		}

}
