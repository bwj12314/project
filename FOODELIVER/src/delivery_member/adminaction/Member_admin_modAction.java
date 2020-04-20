package delivery_member.adminaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery_member.adminsvc.Member_admin_ModSvc;
import delivery_member.svc.LoginSVC;
import delivery_member.vo.ActionForward;
import delivery_member.vo.Member;


public class Member_admin_modAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
	    
	    ActionForward forward=null;
	    Member member=new Member();
	    String telEX="";
	    String tel="";
	    String checkid=request.getParameter("id");
	    String email=request.getParameter("email");
	    String checkfinalemail=request.getParameter("checkfinalemail");
	    LoginSVC meminfosvc=new LoginSVC();
	    member=meminfosvc.memberLogin(checkid);
	    
	    if(email.equals(member.getMember_email())) {
	    	checkfinalemail="true";
	    }
	    HttpSession session=request.getSession();
	    if(session.getAttribute("adminid")!=null){
	    	if(checkfinalemail.equals("true")) {
		member.setMember_id(request.getParameter("id"));
		member.setMember_name(request.getParameter("name"));
		member.setMember_pass(request.getParameter("pass"));
		member.setMember_email(request.getParameter("email"));
		member.setMember_birth(request.getParameter("birth"));
		member.setMember_gender(request.getParameter("gender"));
		member.setMember_tel(request.getParameter("tel"));
		member.setMember_address1(request.getParameter("address1"));
		member.setMember_address2(request.getParameter("address2"));
		member.setMember_address3(request.getParameter("address3"));
		member.setMember_address4(request.getParameter("address4"));
		member.setMember_grade(request.getParameter("grade"));
		
		boolean modSuccess=false;
		Member_admin_ModSvc modsvc= new Member_admin_ModSvc();
		modSuccess=modsvc.membermod(member);
	
		
		
		
		if(modSuccess==true) {
			response.setContentType("text/html;charset=utf-8");
  			PrintWriter out=response.getWriter();
  			out.println("<script>");
      		out.println("alert('정보수정이 완료되었습니다.');");
      		out.println("location.href='member_admin_info.mem_admin?Option=see&id="+checkid+"'");
      		out.println("</script>");
		
		}else {
			PrintWriter out= response.getWriter();
			out.println("<script>");
			out.println("alert('수정오류 다시작성하세요.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
	    	}else {
	    	response.setContentType("text/html;charset=utf-8");
	    	PrintWriter out=response.getWriter();
	    	out.println("<script>");
	    	out.println("alert('인증을 완료하세요.')");
	    	out.println("location.href='member_admin_modform.mem_admin?id="+checkid+"'");
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
