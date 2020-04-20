package companyadmin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import companyadmin.svc.CompanyInService;

public class CompanyAddAddressAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward=null;
		String company_id=request.getParameter("company_id");
		String lat=request.getParameter("lat");
		String lng=request.getParameter("lng");
		System.out.println(company_id);
		System.out.println(lat);
		System.out.println(lng);
		CompanyInService cominsvc=new CompanyInService();
		boolean success=cominsvc.setcompanyaddress(company_id,lat,lng);
		if(success) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out =response.getWriter();
			out.println("<script>");
	    	out.println("alert('가입 완료')");
	    	out.println("location.href='companylist.comadm';");
	    	out.println("</script>");
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out =response.getWriter();
			out.println("<script>");
	    	out.println("alert('기업 추가 실패')");
	    	out.println("history.back();");
	    	out.println("</script>");
		}
		return forward;
	}

}
