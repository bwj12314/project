package delivery_member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_member.svc.MemberJoinService;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Member;


public class MemberJoinPro implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member member=new Member();
		String checkfinalemail=request.getParameter("checkfinalemail");
	
		ActionForward forward=null;
		String telEX="";
		String tel="";
		String name=request.getParameter("name");
		
		if(checkfinalemail.equals("true")) {
			
			member.setMember_id(request.getParameter("id"));
			member.setMember_name(name);
			member.setMember_pass(request.getParameter("pass"));
				member.setMember_email(request.getParameter("email"));
				
				member.setMember_gender(request.getParameter("gender"));
				telEX=request.getParameter("tel");
				tel=telEX.replace("-", "");
				String birth2=request.getParameter("birth2");
				if(birth2.length()==1) {
					birth2="0"+birth2;
				}
				String birth3=request.getParameter("birth3");
				if(birth3.length()==1) {
					birth3="0"+birth3;
				}
				member.setMember_birth(request.getParameter("birth1")+birth2+birth3);
				member.setMember_tel(tel);
				member.setMember_address1(request.getParameter("address1"));
				member.setMember_address2(request.getParameter("address2"));
				member.setMember_address3(request.getParameter("address3"));
				member.setMember_address4(request.getParameter("address4"));
				member.setMember_grade(request.getParameter("grade"));
				
				MemberJoinService memberjoinservice=new MemberJoinService();
				boolean result=memberjoinservice.memberJoin(member);
				
				if(result) {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out=response.getWriter();
					out.println("<script>");
					out.println("alert('회원가입이 완료되었습니다!');");
					out.println("location.href='loginform.mlog'");
					out.println("</script>");
					
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
			out.println("alert('인증이 처리되지 않았습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
		
		
	}
}
