package rider.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.action.Action;
import rider.svc.RiderJoinService;
import rider.vo.ActionForward;
import rider.vo.Rider;

public class RiderJoinPro implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Rider rider=new Rider();
		String checkfinalemail=request.getParameter("checkfinalemail").trim();
		String checkfinalkey=request.getParameter("checkfinalkey").trim();
		ActionForward forward=null;
		String telEX="";
		String tel="";
		String name=request.getParameter("name").trim();
		String licensekeyEX=request.getParameter("licensekeyEX").trim();
		if(checkfinalemail.equals("true")) {
			if(checkfinalkey.equals("true")) {
				rider.setRider_id(request.getParameter("id"));
				rider.setRider_name(name);
				rider.setRider_pass(request.getParameter("pass").trim());
				rider.setRider_email(request.getParameter("email").trim());
				rider.setRider_age(Integer.parseInt(!(request.getParameter("age").equals("")
		    		||request.getParameter("age")==null)?request.getParameter("age"):"0"));
				rider.setRider_gender(request.getParameter("gender"));
				telEX=request.getParameter("tel");
				tel=telEX.replace("-", "");
				tel=telEX.trim();
				rider.setRider_tel(tel);
				rider.setRider_address1(request.getParameter("address1"));
				rider.setRider_address2(request.getParameter("address2"));
				rider.setRider_address3(request.getParameter("address3"));
				rider.setRider_address4(request.getParameter("address4"));
				rider.setRider_count(0);
				rider.setRider_active("활성상태");
				rider.setRider_reason("");
				rider.setRider_state("배달안함");
				RiderJoinService riderjoinservice=new RiderJoinService();
				boolean result=riderjoinservice.riderJoin(rider);
				
				if(result) {
					boolean resultkey=riderjoinservice.riderDeleteKey(licensekeyEX);
					if(resultkey) {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out=response.getWriter();
					out.println("<script>");
					out.println("alert('회원가입이 완료되었습니다!');");
					out.println("location.href='loginForm.riderlog'");
					out.println("</script>");
					}
				}else {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out=response.getWriter();
					out.println("<script>");
					out.println("alert('다시 입력하세요.');");
					out.println("history.back();");
					out.println("</script>");
				}
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('회원 인증이 처리되지 않았습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('이메일 인증이 처리되지 않았습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
		
	}
}
