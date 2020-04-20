package delivery_member.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import delivery_member.svc.CompanyMenuListService;
import delivery_member.svc.CompanyReviewService;
import delivery_member.vo.ActionForward;
import delivery_member.vo.CompanyReview;
import delivery_member.vo.CompanyScore;
import delivery_member.vo.Company_menu;

public class reviewwriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//받아온값 DB에 insert 시키고 리뷰페이지로 (멀티파트) 
		ActionForward forward=null;
		
		String realFolder = "";
		String saveFolder = "/review_img";
		String encType = "UTF-8";
		int maxSize = 5*1024*1024;
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request,
					realFolder, maxSize, encType,
					new DefaultFileRenamePolicy());
	
		
	
		CompanyReview writereview = new CompanyReview(
				multi.getParameter("member_id"), 
				multi.getParameter("company_id"), 
				multi.getParameter("review_content"),
				multi.getFilesystemName("review_file"), 
				Double.parseDouble(multi.getParameter("review_score")), 
				multi.getParameter("review_menu")
				);
		
		CompanyReviewService comreviewService =new CompanyReviewService();
		int review_num=comreviewService.maxreviewnum(multi.getParameter("company_id"));
		review_num=review_num+1;
		boolean reviewsuccess=false;
		reviewsuccess=comreviewService.insertreview(writereview,review_num);
		if(reviewsuccess==true) {
			CompanyScore comScore=comreviewService.selectscore(multi.getParameter("company_id"));       //회사평점 셀렉트
			boolean reviewscoresuccess=false;
			boolean companyscoresuccess=false;
			reviewscoresuccess=comreviewService.updatescore(writereview,comScore);// 리뷰스코어,카운트 업데이트
		
			CompanyScore comScore2=comreviewService.selectscore(multi.getParameter("company_id")); //회사평점셀렉트
			companyscoresuccess=comreviewService.updatecomscore(comScore2);//회사평점업데이트
			if(reviewscoresuccess==true&&companyscoresuccess==true) {
				HttpSession session = request.getSession();
				ArrayList<CompanyReview> review=comreviewService.getreview(multi.getParameter("company_id")); //회사전체리뷰담는다
				session.setAttribute("review", review);
				CompanyMenuListService companymenulistservice = new CompanyMenuListService();
				ArrayList<Company_menu> menu_list=companymenulistservice.ComMenu(multi.getParameter("company_id"));//회사 전체메뉴
				
				
				session.setAttribute("menu_list", menu_list);//회사전체메뉴 세션에담기
				forward = new ActionForward("member/company_review.jsp?company_id="+multi.getParameter("company_id"), true);
			}else {
				response.setContentType("text/html;charset=UTF8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('등록실패')");
				out.println("history.back();");
				out.println("</script>");
			}
		}else {
			response.setContentType("text/html;charset=UTF8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("</script>");
			
		}
				
		
		
		return forward;
	}

}
