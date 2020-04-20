package rider.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.action.Action;
import rider.log.svc.LoginSVC;
import rider.vo.ActionForward;
import rider.vo.Rider;

public class RiderCheckId implements Action {

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
	    	out.println("history.back();");
	    	out.println("</script>");
	    }else {
	    	Rider rider=null;
			LoginSVC checksvc=new LoginSVC();
			rider=checksvc.RiderLogin(id);
			
			if(rider!=null) {
				
				request.setAttribute("usable", "no");
				
			}else {
				request.setAttribute("usable", "yes");
				
			}
			request.setAttribute("chk_id", id);
			forward=new ActionForward("rider/idCheck.jsp",false);
			
	    }
		return forward;
	}

}
