package delivery_member.vo;

import java.util.ArrayList;

public class MainOrder {
	private int order_num;
	private String order_date;
	private String member_id;
	private String company_id;
	private String company_name;
	private String rider_id;
	private String order_state;
	private ArrayList<Integer> order_price;
	private ArrayList<String> order_name;
	private ArrayList<Integer> order_quantity;
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
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
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getRider_id() {
		return rider_id;
	}
	public void setRider_id(String rider_id) {
		this.rider_id = rider_id;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}

	public ArrayList<Integer> getOrder_price() {
		return order_price;
	}
	public void setOrder_price(ArrayList<Integer> order_price) {
		this.order_price = order_price;
	}
	public ArrayList<String> getOrder_name() {
		return order_name;
	}
	public void setOrder_name(ArrayList<String> order_name) {
		this.order_name = order_name;
	}
	public ArrayList<Integer> getOrder_quantity() {
		return order_quantity;
	}
	public void setOrder_quantity(ArrayList<Integer> order_quantity) {
		this.order_quantity = order_quantity;
	}
	
	
}
