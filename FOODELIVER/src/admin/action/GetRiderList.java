package admin.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import admin.svc.GetRiderListSVC;
import admin.svc.LoginAdminSVC;
import rider.vo.ActionForward;
import rider.vo.Admin;
import rider.vo.PageInfo;
import rider.vo.Rider;

public class GetRiderList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
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
				
			try {
				GetRiderListSVC getriderlistsvc =new GetRiderListSVC();
				
				ArrayList<Rider> riderList=new ArrayList<Rider>();
				int page=1;
				int limit=5;
				int limitPage=3;
				String Option="Option";
				String Value="";
				if(request.getParameter("page")!=null)
					page=Integer.parseInt(request.getParameter("page"));
				if(request.getParameter("Option")!=null)
					Option=request.getParameter("Option");
				if(request.getParameter("Value")!=null)
					Value=request.getParameter("Value");
				
				
				int listCount=getriderlistsvc.getListCount(Option,Value);
				riderList=getriderlistsvc.getRiderList(page,limit,Option,Value);
				System.out.println("riderList : " + riderList.size());
				int maxPage=(int)((double)listCount/limit+0.95);
				int startPage=(((int) ((double)page/limitPage+0.9))-1)*limitPage+1;
				int endPage=startPage+limitPage-1;
				
				if(endPage>maxPage) endPage=maxPage;
				
				PageInfo pageInfo = new PageInfo();
				pageInfo.setEndPage(endPage);
				pageInfo.setListCount(listCount);
				pageInfo.setMaxPage(maxPage);
				pageInfo.setPage(page);
				pageInfo.setStartPage(startPage);
				request.setAttribute("pageInfo", pageInfo);
				request.setAttribute("riderList", riderList);
				request.setAttribute("Value", Value);
				request.setAttribute("Option", Option);
				
				forward=new ActionForward("admin/admin_rider_list.jsp",false);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return forward;
	}

}
