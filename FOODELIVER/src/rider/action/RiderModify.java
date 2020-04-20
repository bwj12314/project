package rider.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import rider.svc.RiderInfoService;
import rider.vo.ActionForward;
import rider.vo.Rider;

public class RiderModify implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward=null;
		String id=null;
	    String info_id=null;
	    HttpSession session=request.getSession();
	    if(session.getAttribute("riderid")==null){
	    	response.setContentType("text/html;charset=utf-8");
	    	PrintWriter out=response.getWriter();
	    	out.println("<script>");
	    	out.println("alert('로그인을 하세요')");
	    	out.println("location.href='loginForm.riderlog'");
	    	out.println("</script>");
	    }else{
	    	id=(String)session.getAttribute("riderid");
	    }
	    
	    //if(request.getParameter("id")!=null&&id!=null&&id.equals("admin")){
	    	//info_id=request.getParameter("id");
	    //}
	   	if(request.getParameter("id")!=null&&id!=null){
		info_id=request.getParameter("id");
	   	}
	   	if(info_id!=null&&!info_id.equals("")) {
	   		Rider rider=null;
		   	RiderInfoService riderinfosvc=new RiderInfoService();
			rider=riderinfosvc.getRiderInfo(info_id);
			 
			if(rider!=null) {
			    	session.setAttribute("rider", rider);
			    	forward=new ActionForward("rider/rider_realmod.jsp",false);
			    	
			}else {
			    	response.setContentType("text/html;charset=utf-8");
				    PrintWriter out=response.getWriter();
					out.println("<script>");
			    	out.println("alert('오류발생')");
			    	out.println("location.href='riderMain.jsp'");
			    	out.println("</script>");
			    }
	   	}else {
	   		response.setContentType("text/html;charset=utf-8");
	    	PrintWriter out=response.getWriter();
	    	out.println("<script>");
	    	out.println("alert('로그인을 하세요')");
	    	out.println("location.href='loginForm.log'");
	    	out.println("</script>");
	   	}
	   	
	   	
	   	
		return forward;
	}

}
