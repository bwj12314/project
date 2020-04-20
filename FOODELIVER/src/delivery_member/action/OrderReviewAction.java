package delivery_member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_member.svc.CompanyReviewService;
import delivery_member.vo.ActionForward;
import delivery_member.vo.CompanyReview;

public class OrderReviewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String company_id=request.getParameter("company_id");
		
		//리뷰목록 뿌려주기
		CompanyReviewService comreviewService =new CompanyReviewService();
		ArrayList<CompanyReview> review=comreviewService.getreview(company_id);
		
		request.setAttribute("review", review);
		ActionForward forward = new ActionForward("member/company_review.jsp?company_id="+company_id, false);
		return forward;
	}

}
