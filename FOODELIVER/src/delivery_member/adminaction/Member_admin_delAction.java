package delivery_member.adminaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.svc.LoginAdminSVC;
import delivery_member.adminsvc.Member_admin_DelSvc;
import delivery_member.vo.ActionForward;
import rider.vo.Admin;

public class Member_admin_delAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		ActionForward forward=null;
		String id=(String)session.getAttribute("adminid");
		LoginAdminSVC loginadminsvc=new LoginAdminSVC();
		Admin admin=null;
		admin=loginadminsvc.AdminLogin(id);
		
		if(id==null||(!(id.equals(admin.getAdmin_id())))){
	    	PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('관리자로 로그인하세요')");
	    	out.println("location.href='adminMain.jsp'");
	    	out.println("</script>");
	    }else {
	    	String member_id=request.getParameter("id");
	    	Member_admin_DelSvc deletesvc = new Member_admin_DelSvc();
	    	boolean result=deletesvc.memberdelete(member_id);
	    	if(result) {
	    		System.out.println("삭제완료");
	    		response.setContentType("text/html;charset=utf-8");
	    		PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('"+member_id+"회원 삭제가 완료되었습니다.');");
				out.println("location.href='member_admin_list.mem_admin'");
				out.println("</script>");
	    	}else {
	    		response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('회원 정보가 삭제 되지 않았습니다.');");
				out.println("history.back();");
				out.println("</script>");
	    	}
	    }
	
		return forward;
	}

}
