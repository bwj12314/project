package delivery_member.vo;

public class CompanyReview {

	private String member_id;
	private String company_id;
	private int review_num;
	private String review_content;
	private String review_file;
	private String review_date;
	private Double review_score;
	private String review_menu;
	public CompanyReview() {}
	public CompanyReview(String member_id, String company_id, String review_content, String review_file,
			Double review_score, String review_menu) {
		super();
		this.member_id = member_id;
		this.company_id = company_id;
		this.review_content = review_content;
		this.review_file = review_file;
		this.review_score = review_score;
		this.review_menu = review_menu;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public int getReview_num() {
		return review_num;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public String getReview_file() {
		return review_file;
	}
	public void setReview_file(String review_file) {
		this.review_file = review_file;
	}
	public String getReview_date() {
		return review_date;
	}
	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}
	public Double getReview_score() {
		return review_score;
	}
	public void setReview_score(Double review_score) {
		this.review_score = review_score;
	}
	public String getReview_menu() {
		return review_menu;
	}
	public void setReview_menu(String review_menu) {
		this.review_menu = review_menu;
	}
	
	
	
}
