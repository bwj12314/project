package rider.log.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import rider.log.svc.LoginSVC;
import rider.vo.ActionForward;
import rider.vo.Rider;

public class CheckidSuccess implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String certifykey=(String)session.getAttribute("certifykey");
		String certifykeyEX=request.getParameter("certifykeyEX").trim();
		String checkname=request.getParameter("checkname").trim();
		String checkemail=request.getParameter("checkemail").trim();
		ActionForward forward=null;
		if(certifykey!=null&&certifykey.equals(certifykeyEX)) {
			System.out.println("this");
			Rider rider=null;
			LoginSVC loginsvc=new LoginSVC();
			rider=loginsvc.RiderLoginidCheck(checkname);
			String rider_id=rider.getRider_id();
			forward=new ActionForward("rider/checkidsuccess.jsp?rider_id="+rider_id,false);
			
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			System.out.println("this2");
			out.println("<script>");
			out.println("alert('인증 번호가 잘못되었거나 정보가 올바르지 않습니다.');");
			out.println("location.href='rider/checkid.jsp?checkname="+checkname+"&checkemail="+checkemail+"'");
			out.println("</script>");
		}
		return forward;
	}

}
