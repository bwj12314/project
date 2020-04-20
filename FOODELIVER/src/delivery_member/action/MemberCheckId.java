package delivery_member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_member.svc.LoginSVC;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Member;

public class MemberCheckId implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	    ActionForward forward=null;
	    
	    String id=request.getParameter("id");
	    if(id.equals("")||id==null){
	    	response.setContentType("text/html;charset=utf-8");
	    	PrintWriter out=response.getWriter();
	    	out.println("<script>");
	    	out.println("alert('아이디를 채우세요')");
	    	out.println("history.back()");
	    	out.println("</script>");
	    }else {
	    	Member member=null;
			LoginSVC checksvc=new LoginSVC();
			member=checksvc.memberLogin(id);
			
			if(member!=null) {
				
				request.setAttribute("usable", "no");
				
			}else {
				request.setAttribute("usable", "yes");
				
			}
			request.setAttribute("chk_id", id);
			forward=new ActionForward("login/idCheck.jsp",false);
			
	    }
	    
	    
		
		return forward;
	}

}
