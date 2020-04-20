package rider.vo;


import java.util.ArrayList;

public class OrderList {

	private int order_num;
	
	private String order_date;
	private String member_tel;
	private String member_address1;
	private String member_address2;
	private String member_address3;
	private String member_address4;
	private String member_address_lat;
	private String member_address_lng;
	private String company_name;
	private String company_tel;
	private String company_email;
	private String company_address1;
	private String company_address2;
	private String company_address3;
	private String company_address4;
	private String company_address_lat;
	private String company_address_lng;
	private String order_state;
	private String rider_tel;
	private String rider_name;
	private String rider_active;
	private String company_id;
	
	private ArrayList<String> order_name;
	private ArrayList<Integer> order_price;
	private ArrayList<Integer> order_quantity;
	private int totalmoney;
	
	
	
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getMember_address_lat() {
		return member_address_lat;
	}
	public void setMember_address_lat(String member_address_lat) {
		this.member_address_lat = member_address_lat;
	}
	public String getMember_address_lng() {
		return member_address_lng;
	}
	public void setMember_address_lng(String member_address_lng) {
		this.member_address_lng = member_address_lng;
	}
	public String getCompany_address_lat() {
		return company_address_lat;
	}
	public void setCompany_address_lat(String company_address_lat) {
		this.company_address_lat = company_address_lat;
	}
	public String getCompany_address_lng() {
		return company_address_lng;
	}
	public void setCompany_address_lng(String company_address_lng) {
		this.company_address_lng = company_address_lng;
	}
	public String getRider_active() {
		return rider_active;
	}
	public void setRider_active(String rider_active) {
		this.rider_active = rider_active;
	}
	public String getRider_tel() {
		return rider_tel;
	}
	public void setRider_tel(String rider_tel) {
		this.rider_tel = rider_tel;
	}
	public String getRider_name() {
		return rider_name;
	}
	public void setRider_name(String rider_name) {
		this.rider_name = rider_name;
	}
	public String getCompany_email() {
		return company_email;
	}
	public void setCompany_email(String company_email) {
		this.company_email = company_email;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getTotalmoney() {
		return totalmoney;
	}
	public void setTotalmoney(int totalmoney) {
		this.totalmoney = totalmoney;
	}
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	
	public String getMember_tel() {
		return member_tel;
	}
	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}
	public String getMember_address1() {
		return member_address1;
	}
	public void setMember_address1(String member_address1) {
		this.member_address1 = member_address1;
	}
	public String getMember_address2() {
		return member_address2;
	}
	public void setMember_address2(String member_address2) {
		this.member_address2 = member_address2;
	}
	public String getMember_address3() {
		return member_address3;
	}
	public void setMember_address3(String member_address3) {
		this.member_address3 = member_address3;
	}
	public String getMember_address4() {
		return member_address4;
	}
	public void setMember_address4(String member_address4) {
		this.member_address4 = member_address4;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_tel() {
		return company_tel;
	}
	public void setCompany_tel(String company_tel) {
		this.company_tel = company_tel;
	}
	public String getCompany_address1() {
		return company_address1;
	}
	public void setCompany_address1(String company_address1) {
		this.company_address1 = company_address1;
	}
	public String getCompany_address2() {
		return company_address2;
	}
	public void setCompany_address2(String company_address2) {
		this.company_address2 = company_address2;
	}
	public String getCompany_address3() {
		return company_address3;
	}
	public void setCompany_address3(String company_address3) {
		this.company_address3 = company_address3;
	}
	public String getCompany_address4() {
		return company_address4;
	}
	public void setCompany_address4(String company_address4) {
		this.company_address4 = company_address4;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public ArrayList<String> getOrder_name() {
		return order_name;
	}
	public void setOrder_name(ArrayList<String> order_name) {
		this.order_name=order_name;
	}
	public ArrayList<Integer> getOrder_price() {
		return order_price;
	}
	public void setOrder_price(ArrayList<Integer> order_price) {
		this.order_price=order_price;
	}
	public ArrayList<Integer> getOrder_quantity() {
		return order_quantity;
	}
	public void setOrder_quantity(ArrayList<Integer> order_quantity) {
		this.order_quantity=order_quantity;
	}
	
	
	
}
