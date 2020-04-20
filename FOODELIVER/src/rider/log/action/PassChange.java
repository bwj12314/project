package rider.log.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import rider.log.svc.CheckActionSVC;
import rider.log.svc.LoginSVC;
import rider.vo.ActionForward;
import rider.vo.Rider;

public class PassChange implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String nowpass=request.getParameter("nowpass");
		String newpass=request.getParameter("newpass");
		String newpass2=request.getParameter("newpass2");
		HttpSession session=request.getSession();
		Rider rider=null;
		
		
		if((String)session.getAttribute("riderid")!=null) {
			LoginSVC loginSVC=new LoginSVC();
			String riderid=(String)session.getAttribute("riderid");
			rider=loginSVC.RiderLogin(riderid);
			if(rider.getRider_pass().equals(nowpass)) {
				if(!(newpass.length()<6 || newpass.length()>12 || newpass2.length()<6 ||newpass2.length()>12)) {
				if(newpass.equals(newpass2)) {
					CheckActionSVC checkactionSVC=new CheckActionSVC();	
					boolean result=checkactionSVC.updatepassword(riderid, newpass);
					if(result) {
						response.setContentType("text/html;charset=utf8");
						PrintWriter out=response.getWriter();
						out.println("<script>");
						out.println("alert('비밀번호가 수정되었습니다');");
						out.println("location.href='rider/rider_realmod.jsp';");
						out.println("</script>");
					}else {
						response.setContentType("text/html;charset=utf8");
						PrintWriter out=response.getWriter();
						out.println("<script>");
						out.println("alert('오류가 발생하였습니다')");
						out.println("history.back();");
						out.println("</script>");
					}
					
				}else {
					response.setContentType("text/html;charset=utf8");
					PrintWriter out=response.getWriter();
					out.println("<script>");
					out.println("alert('새 비밀번호가 일치하지 않습니다');");
					out.println("history.back();");
					out.println("</script>");
				}}else {
					response.setContentType("text/html;charset=utf8");
					PrintWriter out=response.getWriter();
					out.println("<script>");
					out.println("alert('비밀번호는 6~12자로 해야 합니다');");
					out.println("history.back();");
					out.println("</script>");
				}}else {
					response.setContentType("text/html;charset=utf8");
					PrintWriter out=response.getWriter();
					out.println("<script>");
					out.println("alert('기존 비밀번호가 일치하지 않습니다');");
					out.println("history.back();");
					out.println("</script>");
				}}else {
					response.setContentType("text/html;charset=utf8");
					PrintWriter out=response.getWriter();
					out.println("<script>");
					out.println("alert('로그인을 하세요');");
					out.println("history.back();");
					out.println("</script>");
				}
		
		
		
		
		
		return null;
	}

}
