package delivery_member.adminaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery_member.adminsvc.Member_admin_InfoSvc;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Member;

public class Member_admin_modformAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		String id=null;
	    String info_id=null;
	    HttpSession session=request.getSession();
	    if(session.getAttribute("adminid")==null){
	    	response.setContentType("text/html;charset=utf-8");
	    	PrintWriter out=response.getWriter();
	    	out.println("<script>");
	    	out.println("alert('관리자 로그인을 하세요')");
	    	out.println("location.href='adminMain.jsp'");
	    	out.println("</script>");
	    }else{
	    	id=(String)session.getAttribute("adminid");
	    }
	    
	    //if(request.getParameter("id")!=null&&id!=null&&id.equals("admin")){
	    	//info_id=request.getParameter("id");
	    //}
	   	if(request.getParameter("id")!=null&&id!=null){
		info_id=request.getParameter("id");
	   	}
	   	if(info_id!=null&&!info_id.equals("")) {
	   		Member_admin_InfoSvc infoSvc=new Member_admin_InfoSvc();
			Member member=infoSvc.getinfo(info_id);
			if(member!=null) {
			    	session.setAttribute("member", member);
			    	forward=new ActionForward("member_admin/member_admin_modform.jsp",false);
			    	
			}else {
			    	response.setContentType("text/html;charset=utf-8");
				    PrintWriter out=response.getWriter();
					out.println("<script>");
			    	out.println("alert('오류발생')");
			    	out.println("location.href='adminMain.jsp'");
			    	out.println("</script>");
			    }
	   	}else {
	   		response.setContentType("text/html;charset=utf-8");
	    	PrintWriter out=response.getWriter();
	    	out.println("<script>");
	    	out.println("alert('로그인을 하세요')");
	    	out.println("location.href='adminMain.jsp'");
	    	out.println("</script>");
	   	}
	   	
		return forward;
		
		
	}

}
