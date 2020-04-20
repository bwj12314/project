package delivery_member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery_member.svc.LoginSVC;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Member;

public class CheckidSuccess implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String certifykey=(String)session.getAttribute("certifykey");
		String certifykeyEX=request.getParameter("certifykeyEX");
		String checkname=request.getParameter("checkname");
		ActionForward forward=null;
		if(certifykey!=null&&certifykey.equals(certifykeyEX)&&!checkname.equals("")) {
			Member member=null;
			LoginSVC loginsvc=new LoginSVC();
			member=loginsvc.memberLoginnameCheck(checkname);
			String member_id=member.getMember_id();
			
			forward=new ActionForward("login/checkidsuccess.jsp?member_id="+member_id,false);
			
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('인증 번호가 잘못되었거나 정보가 올바르지 않습니다.')");
			out.println("location.href='login/checkid.jsp'");
			out.println("</script>");
		}
		return forward;
	}

}
