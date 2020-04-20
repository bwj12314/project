package delivery_member.svc;

import static delivery_member.db.JdbcUtil.close;
import static delivery_member.db.JdbcUtil.commit;
import static delivery_member.db.JdbcUtil.getConnection;
import static delivery_member.db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import delivery_member.dao.DeliveryDAO;
import delivery_member.vo.CompanyReview;
import delivery_member.vo.CompanyScore;

public class CompanyReviewService {

	public ArrayList<CompanyReview> getreview(String company_id) {
		Connection con = getConnection();
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		deliveryDAO.setConnection(con);	
		ArrayList<CompanyReview> review = deliveryDAO.selectReview(company_id);
		close(con);
		return review;
	}

	public boolean insertreview(CompanyReview writereview, int review_num) {
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		Connection con = getConnection();
		deliveryDAO.setConnection(con);		
		boolean success = false;		
		int insertCount = deliveryDAO.InsertReview(writereview,review_num);
		
		if(insertCount>0){
			commit(con);
			success=true;
		}else{
			rollback(con);
		}
		
		close(con);
		return success;
	}

	public int maxreviewnum(String company_id) {
		Connection con = getConnection();
		DeliveryDAO companyDAO = DeliveryDAO.getInstance();
		companyDAO.setConnection(con);	
		int review_num= companyDAO.selectmaxreviewnum(company_id);
		close(con);
		return review_num;
	}

	public CompanyScore selectscore(String company_id) {
		Connection con = getConnection();
		DeliveryDAO companyDAO = DeliveryDAO.getInstance();
		companyDAO.setConnection(con);	
		CompanyScore comscore= companyDAO.slectScore(company_id);
		close(con);
		return comscore;
	}

	public boolean updatescore(CompanyReview writereview, CompanyScore comScore) {
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		Connection con = getConnection();
		deliveryDAO.setConnection(con);		
		boolean success = false;		
		int insertCount = deliveryDAO.UpdateScore(writereview,comScore);
		
		if(insertCount>0){
			commit(con);
			success=true;
		}else{
			rollback(con);
		}
		
		close(con);
		return success;
	}

	public boolean updatecomscore(CompanyScore comScore2) {
		DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
		Connection con = getConnection();
		deliveryDAO.setConnection(con);		
		boolean success = false;		
		int insertCount = deliveryDAO.UpdateComScore(comScore2);
		
		if(insertCount>0){
			commit(con);
			success=true;
		}else{
			rollback(con);
		}
		
		close(con);
		return success;
	}

}
