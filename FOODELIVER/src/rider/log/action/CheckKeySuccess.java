package rider.log.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.action.Action;
import rider.log.svc.LoginSVC;
import rider.vo.ActionForward;
import rider.vo.RiderKey;

public class CheckKeySuccess implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String licensekeyEX=request.getParameter("licensekeyEX");
		String tel=request.getParameter("tel");
		ActionForward forward=null;
		RiderKey riderkey=new RiderKey();
		LoginSVC loginsvc=new LoginSVC();
		riderkey=loginsvc.RiderKeyCheck(licensekeyEX,tel);
		if(riderkey!=null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('인증되었습니다.');");
			out.println("opener.document.getElementById('checkfinalkey').value=true");
			out.println("window.close();");
			out.println("</script>");
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('인증키가 다릅니다 관리자에게 연락해보세요.')");
			out.println("window.close()");
			out.println("</script>");
		}
		
		return forward;
	}

}
