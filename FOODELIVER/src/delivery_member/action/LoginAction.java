package delivery_member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery_member.svc.LoginSVC;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Member;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//값 처리, 서비스 객체 생성 메소드 사용(memberLogin) 매개 변수는 아이디 리턴값은 password나 member 객체 둘 중 하나 서비스에서는
		//맴버 객체 생성하고 
		//비밀번호 확인 session 생성 맞으면  main페이지로 틀리면 historyback
		
		String member_id=request.getParameter("member_id");
		String member_pass=request.getParameter("member_pass");
		System.out.println(member_id);
		System.out.println(member_pass);
		ActionForward forward=null;
		
		LoginSVC loginsvc=new LoginSVC();
		Member member=loginsvc.memberLogin(member_id);
		
		if(member==null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('아이디가 존재하지 않습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			if(!member_pass.equals(member.getMember_pass())) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('비밀번호가 일치하지 않습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}else {
				HttpSession session=request.getSession();
				session.setAttribute("member_id", member_id);
				
				
				forward = new ActionForward("main.jsp", true);
			}
		}
		return forward;
	}

}
