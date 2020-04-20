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

public class DeliverySuccessInfo implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		ActionForward forward=null;
		String rider_id="";
		ArrayList<OrderList> successOrderList=new ArrayList<>();
		if(session.getAttribute("riderid")==null) {
			response.setContentType("text/html;charset=utf8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('로그인을 하세요!!');");
			out.println("location.href='riderMain.jsp';");
			out.println("</script>");
		}else {
			DeliveryInfoService deliveryinfosvc=new DeliveryInfoService();
			rider_id=(String)session.getAttribute("riderid");
			int page=1;
			int limit=9;
			int limitPage=5;
			if(request.getParameter("page")!=null)
				page=Integer.parseInt(request.getParameter("page"));
			
			int listCount=deliveryinfosvc.getListCount(rider_id);
			successOrderList=deliveryinfosvc.getSuccessInfoList(page,limit,rider_id);
			
			
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
			session.setAttribute("successOrderList", successOrderList);
			forward=new ActionForward("rider/deliverySuccessInfo.jsp",false);
		}
		return forward;
	}

}
