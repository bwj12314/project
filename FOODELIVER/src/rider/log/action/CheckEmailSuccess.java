package rider.log.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import admin.action.Action;
import rider.vo.ActionForward;

public class CheckEmailSuccess implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String certifykeyEX=request.getParameter("certifykeyEX");
		HttpSession session=request.getSession();
		String certifykey=(String)session.getAttribute("certifykey");
		System.out.println("checkemailsuccess 클래스에서 certifykey의 값은"+certifykey);
		System.out.println("checkemailsuccess 클래스에서 certifykeyEX의 값은"+certifykeyEX);
		if(certifykeyEX.equals(certifykey)) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('이메일 인증이 완료되었습니다.')");
			out.println("opener.document.getElementById('checkfinalemail').value=true");
			out.println("window.close()");
			out.println("</script>");
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('이메일 인증번호가 다릅니다 메일을 다시 보내시거나 번호를 확인하세요.')");
			out.println("window.close()");
			out.println("</script>");
		}
		
		return null;
	}

}
