package companyadmin.action;

import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import action.ActionForward;
import admin.svc.LoginAdminSVC;
import companyadmin.svc.CompanyInService;
import delivery_member.vo.Company;
import rider.vo.Admin;

public class CompanyAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(); 
		ActionForward forward=null;
		String id=(String)session.getAttribute("adminid");
		Admin admin=new Admin();
		
		LoginAdminSVC loginadminsvc=new LoginAdminSVC();
		admin=loginadminsvc.AdminLogin(id);
		if((session.getAttribute("adminid")==null)||
		    		(!id.equals(admin.getAdmin_id()))){
			
		    response.setContentType("text/html;charset=utf-8");
		    PrintWriter out=response.getWriter();
		    
				out.println("<script>");
		    	out.println("alert('관리자로 로그인하세요')");
		    	out.println("location.href='admin/loginForm.jsp'");
		    	out.println("</script>");
		    }
		else {
			
			//DB insert 기업 추가
			String realFolder = "";
			String saveFolder = "/company_img";
			String encType = "UTF-8";
			int maxSize = 5*1024*1024;
			
			ServletContext context = request.getServletContext();
			realFolder = context.getRealPath(saveFolder);
			MultipartRequest multi = new MultipartRequest(request,
						realFolder, maxSize, encType,
						new DefaultFileRenamePolicy());
			String company_id=multi.getParameter("company_id");
			String company_address2=multi.getParameter("company_address2");
			Company company=new Company();
			company.setCompany_id(multi.getParameter("company_id"));
			company.setCompany_businum(multi.getParameter("company_businum"));
			company.setCompany_name(multi.getParameter("company_name"));
			company.setCompany_tel(multi.getParameter("company_tel"));
			company.setCompany_logo(multi.getFilesystemName("company_logo"));
			company.setCompany_category(multi.getParameter("company_category"));
			company.setCompany_address1(multi.getParameter("company_address1"));
			
			company.setCompany_address2(multi.getParameter("company_address2"));
			company.setCompany_address3(multi.getParameter("company_address3"));
			company.setCompany_address4(multi.getParameter("company_address4"));
			company.setCompany_email(multi.getParameter("company_email"));
			CompanyInService cominsvc=new CompanyInService();
			boolean success=cominsvc.setcompany(company);
			if(success) {
				forward = new ActionForward();
				forward.setPath("company/company_getlocation.jsp?company_id="+company_id+"&address2="+URLEncoder.encode(company_address2,"UTF-8"));
				forward.setRedirect(true);	
			}else {
				PrintWriter out =response.getWriter();
				out.println("<script>");
		    	out.println("alert('기업 추가 실패')");
		    	out.println("history.back();");
		    	out.println("</script>");
			}
			
		
		}
		return forward;
	}

}
