package rider.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.Action;
import rider.svc.DeliveryInfoService;
import rider.vo.ActionForward;
import rider.vo.OrderList;
import rider.vo.PageInfo;

public class DeliveryInfo implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward=null;
		HttpSession session=request.getSession();
		ArrayList<OrderList> orderArrayList=new ArrayList<>();
		
		if(session.getAttribute("riderid")==null) {
			
			response.setContentType("text/html;charset=utf-8");
	    	PrintWriter out=response.getWriter();
    		out.println("<script>");
    		out.println("alert('로그인을 하세요');");
	    	out.println("location.href='rider/loginForm.jsp';");
	    	out.println("</script>");
		}else {
			
			
			DeliveryInfoService deliveryinfosvc=new DeliveryInfoService();
			int page=1;
			int limit=9;
			int limitPage=5;
			String Option="Option";
			String Value="";
			if(request.getParameter("page")!=null)
				page=Integer.parseInt(request.getParameter("page"));
			if(request.getParameter("Option")!=null)
				Option=request.getParameter("Option");
			if(request.getParameter("Value")!=null)
				Value=request.getParameter("Value");
			
			int listCount=deliveryinfosvc.getListCount(Option,Value);
			orderArrayList=deliveryinfosvc.getOrderInfoList(page,limit,Option,Value);
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
			
			
			session.setAttribute("pageInfo", pageInfo);
			session.setAttribute("Value", Value);
			session.setAttribute("Option", Option);
			session.setAttribute("orderArrayList", orderArrayList);
			
			forward=new ActionForward("rider/deliveryInfo.jsp",false);
		}
		return forward;
	}

}
