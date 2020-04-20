package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import admin.svc.RiderInfoSVC;
import admin.svc.RiderModProSVC;
import rider.vo.ActionForward;
import rider.vo.Rider;

public class RiderModProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	    
	    ActionForward forward=null;
	    Rider rider=new Rider();
	    String telEX="";
	    String tel="";
	    String checkid=request.getParameter("id");
	    String email=request.getParameter("email");
	    String checkfinalemail=request.getParameter("checkfinalemail");
	    RiderInfoSVC riderinfosvc=new RiderInfoSVC();
	    rider=riderinfosvc.getRiderInfo(checkid);
	    if(email.equals(rider.getRider_email())) {
	    	checkfinalemail="true";
	    }
	    
	    HttpSession session=request.getSession();
	    if(session.getAttribute("adminid")!=null){
	    	if(checkfinalemail.equals("true")) {
	    		System.out.println("RiderModProAction에서 id의 값"+request.getParameter("id"));
	    		rider.setRider_id(request.getParameter("id"));
				rider.setRider_name(request.getParameter("name"));
				rider.setRider_pass(request.getParameter("pass"));
				rider.setRider_email(request.getParameter("email"));
				rider.setRider_age(Integer.parseInt(!(request.getParameter("age").equals("")
		    		||request.getParameter("age")==null)?request.getParameter("age"):"0"));
				rider.setRider_gender(request.getParameter("gender"));
				telEX=request.getParameter("tel");
				tel=telEX.replace("-", "");
				rider.setRider_tel(tel);
				rider.setRider_address1(request.getParameter("address1"));
				rider.setRider_address2(request.getParameter("address2"));
				rider.setRider_address3(request.getParameter("address3"));
				rider.setRider_address4(request.getParameter("address4"));
				rider.setRider_count(Integer.parseInt(!(request.getParameter("count").equals("")
			    		||request.getParameter("count")==null)?request.getParameter("count"):"0"));
				rider.setRider_active(request.getParameter("action"));
				rider.setRider_reason(request.getParameter("reason"));
		  		rider.setRider_state(request.getParameter("state"));
		  		RiderModProSVC ridermodprosvc=new RiderModProSVC();
		  		boolean result=ridermodprosvc.updateRider(rider);
		  		if(result) {
		  			response.setContentType("text/html;charset=utf-8");
		  			PrintWriter out=response.getWriter();
		  			out.println("<script>");
		      		out.println("alert('정보수정이 완료되었습니다.');");
		      		out.println("location.href='riderInfo.adm?Option=see&id="+checkid+"'");
		      		out.println("</script>");
		  		}else {
		  			response.setContentType("text/html;charset=utf-8");
		  			PrintWriter out=response.getWriter();
		  			out.println("<script>");
		      		out.println("alert('수정 오류가 발생했습니다.');");
		      		out.println("location.href='riderMod.adm?id="+checkid+"'");
		      		out.println("</script>");
		  		}
			    }else {
			    	response.setContentType("text/html;charset=utf-8");
			    	PrintWriter out=response.getWriter();
			    	out.println("<script>");
			    	out.println("alert('인증을 완료하세요.')");
			    	out.println("location.href='riderMod.adm?id="+checkid+"'");
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
