package rider.vo;
import java.util.ArrayList;
public class OrderDetailList {
	private ArrayList<String> order_name;
	private ArrayList<Integer> order_price;
	private ArrayList<Integer> order_quantity;
	private int totalmoney;
	
	public int getTotalmoney() {
		return totalmoney;
	}
	public void setTotalmoney(int totalmoney) {
		this.totalmoney = totalmoney;
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
