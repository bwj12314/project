package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import admin.svc.AdminModProSVC;
import rider.vo.ActionForward;
import rider.vo.Admin;

public class AdminModProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	    
	    ActionForward forward=null;
	    Admin admin=new Admin();
	   
	    HttpSession session=request.getSession();
	    if(session.getAttribute("adminid")!=null){
	    		admin.setAdmin_id(request.getParameter("id"));
				admin.setAdmin_email(request.getParameter("email"));
				admin.setAdmin_tel(request.getParameter("tel"));
				
		  		
		  		AdminModProSVC adminmodprosvc=new AdminModProSVC();
		  		boolean result=adminmodprosvc.updateAdmin(admin);
		  		if(result) {
		  			response.setContentType("text/html;charset=utf-8");
		  			PrintWriter out=response.getWriter();
		  			out.println("<script>");
		      		out.println("alert('정보수정이 완료되었습니다.');");
		      		out.println("location.href='adminInfo.adm?Option=see"+"'");
		      		out.println("</script>");
		  		}else {
		  			response.setContentType("text/html;charset=utf-8");
		  			PrintWriter out=response.getWriter();
		  			out.println("<script>");
		      		out.println("alert('수정 오류가 발생했습니다.');");
		      		out.println("location.href='admin/admin_mod.jsp';");
		      		out.println("</script>");
		  		}
			    
		  
		}else {
			response.setContentType("text/html;charset=utf-8");
	    	PrintWriter out=response.getWriter();
	    	out.println("<script>");
	    	out.println("alert('로그인을 하세요.')");
	    	out.println("location.href='adminMain.jsp'");
	    	out.println("</script>");
		}
	    return forward;  
	}

}
