package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import admin.svc.LoginAdminSVC;
import admin.svc.RiderDeleteSVC;
import rider.vo.ActionForward;
import rider.vo.Admin;

public class RiderDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
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
	    	String rider_id=request.getParameter("id");
	    	RiderDeleteSVC riderdeletesvc=new RiderDeleteSVC();
	    	boolean result=riderdeletesvc.removeRider(rider_id);
	    	if(result) {
	    		System.out.println("삭제완료");
	    		response.setContentType("text/html;charset=utf-8");
	    		PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('"+rider_id+"회원 삭제가 완료되었습니다.');");
				out.println("location.href='getRiderList.adm'");
				out.println("</script>");
	    	}else {
	    		response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('다시 입력하세요.');");
				out.println("history.back();");
				out.println("</script>");
	    	}
	    }
		return forward;
	}

}
