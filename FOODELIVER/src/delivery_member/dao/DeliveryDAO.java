package delivery_member.dao;


import static delivery_member.db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import delivery_member.vo.Company;
import delivery_member.vo.CompanyReview;
import delivery_member.vo.CompanyScore;
import delivery_member.vo.Company_menu;
import delivery_member.vo.MainOrder;
import delivery_member.vo.Member;
import delivery_member.vo.OrderSave;

public class DeliveryDAO {

	DataSource ds;
	Connection con;
	private static DeliveryDAO deliveryDAO;
	
	private DeliveryDAO() {
		
	}
	public static DeliveryDAO getInstance() {
		if(deliveryDAO==null) {
			deliveryDAO=new DeliveryDAO();
		}
		return deliveryDAO;
	}
	
	public void setConnection(Connection con) {
		this.con=con;
	}
	public ArrayList<Company> selectCompany(String category) {
		ArrayList<Company> companylist = new ArrayList<Company>();
		PreparedStatement pstmt=null;
		
		ResultSet rs=null;
		String sql="select * from company where company_active='활성상태' order by company_name";
		if(!category.equals("all")&&category!=null)
		{
			sql="select * from company where company_active='활성상태' and company_category='"+category+"' order by company_name";
		}
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
					do {
					Company company=new Company();
					company.setCompany_id(rs.getString("company_id"));
					company.setCompany_businum(rs.getString("company_businum"));
					company.setCompany_name(rs.getString("company_name"));
					company.setCompany_tel(rs.getString("company_tel"));
					company.setCompany_logo(rs.getString("company_logo"));
					company.setCompany_category(rs.getString("company_category"));
					company.setCompany_regdate(rs.getString("company_regdate"));
					company.setCompany_address1(rs.getString("company_address1"));
					company.setCompany_address2(rs.getString("company_address2"));
					company.setCompany_address3(rs.getString("company_address3"));
					company.setCompany_address4(rs.getString("company_address4"));
					company.setCompany_active(rs.getString("company_active"));
					company.setCompany_score(rs.getDouble("company_score"));
					companylist.add(company);
			} while (rs.next());
			}
		} catch (SQLException ex) {
			System.out.println("selectCompany 에러: "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return companylist;
	}
	///
	public ArrayList<Company_menu> selectCompany_menulist(String company_id) {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Company_menu> menulist=new ArrayList<Company_menu>();
		String sql="select company.*,company_menu.* from company inner join company_menu on company.company_id=company_menu.company_id where company.company_id=?";
		
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, company_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
				do{

					Company_menu commenu=new Company_menu();
					commenu=new Company_menu();
					commenu.setCompany_id(rs.getString("company_id"));
					commenu.setCompany_menuname(rs.getString("company_menuname"));
					commenu.setCompany_menuprice(rs.getInt("company_menuprice"));
					commenu.setCompany_menupicture(rs.getString("company_menupicture"));
					commenu.setCompany_menuinfo(rs.getString("company_menuinfo"));
					
					commenu.setCompany_businum(rs.getString("company_businum"));
					commenu.setCompany_name(rs.getString("company_name"));
					commenu.setCompany_tel(rs.getString("company_tel"));
					commenu.setCompany_logo(rs.getString("company_logo"));
					commenu.setCompany_category(rs.getString("company_category"));
					commenu.setCompany_address1(rs.getString("company_address1"));
					commenu.setCompany_address2(rs.getString("company_address2"));
					commenu.setCompany_address3(rs.getString("company_address3"));
					commenu.setCompany_address4(rs.getString("company_address4"));
					commenu.setCompany_active(rs.getString("company_active"));
					commenu.setCompany_score(rs.getDouble("company_score"));
					menulist.add(commenu);
				} while (rs.next());
			}
		} catch (SQLException ex) {
			System.out.println("selectCompany_menulist 에러: "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return menulist;
	}
	public Company_menu selectCompany_menu(String company_id,String company_menuname) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Company_menu menu=new Company_menu();
		
		String sql="select * from company_menu where company_id=? and company_menuname=?";
		
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, company_id);
			pstmt.setString(2, company_menuname);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
					
					menu=new Company_menu();
					menu.setCompany_id(rs.getString("company_id"));
					menu.setCompany_menuname(rs.getString("company_menuname"));
					menu.setCompany_menuprice(rs.getInt("company_menuprice"));
					menu.setCompany_menupicture(rs.getString("company_menupicture"));
					menu.setCompany_menuinfo(rs.getString("company_menuinfo"));
					
				
			}
		} catch (SQLException ex) {
			System.out.println("selectCompany_menu 에러: "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return menu;
	}
	public String selectCompany_category(String company_id) {
		String category=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from company where company_id='"+company_id+"'";
		
			
		
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				category=rs.getString("company_category");
					
			}
		} catch (SQLException ex) {
			System.out.println("selectCompany_category 에러: "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return category;
	}
	public ArrayList<Company> searchlist(String search) {
		ArrayList<Company> companylist = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select company.*, company_menu.* from company inner join company_menu on company.company_id=company_menu.company_id where company_active='활성상태' and (company_name like '%"+search+"%' or company_menuname like '%"+search+"%') group by company.company_id order by company_name";
			
		
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				companylist=new ArrayList<Company>();
					do {
					Company company=new Company();
					company.setCompany_id(rs.getString("company_id"));
					company.setCompany_businum(rs.getString("company_businum"));
					company.setCompany_name(rs.getString("company_name"));
					company.setCompany_tel(rs.getString("company_tel"));
					company.setCompany_logo(rs.getString("company_logo"));
					company.setCompany_category(rs.getString("company_category"));
					company.setCompany_score(rs.getDouble("company_score"));
					company.setCompany_regdate(rs.getString("company_regdate"));
					company.setCompany_address1(rs.getString("company_address1"));
					company.setCompany_address2(rs.getString("company_address2"));
					company.setCompany_address3(rs.getString("company_address3"));
					company.setCompany_address4(rs.getString("company_address4"));
					company.setCompany_active(rs.getString("company_active"));
					companylist.add(company);
			} while (rs.next());
			}
		} catch (SQLException ex) {
			System.out.println("searchlist 에러: "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return companylist;
	}
	public int insertsavelist(String company_id, int order_num,String member_id,String company_name,String member_address1,String member_address2,String lat,String lng) {
		
		PreparedStatement pstmt=null;
		int result=0;
		String sql="insert into order_list (order_num,company_id,order_state,order_date,member_id,company_name,order_member_address1,order_member_address2,member_address_lat,member_address_lng) values("+order_num+",'"+company_id+"','주문',current_timestamp,'"+member_id+"','"+company_name+"','"+member_address1+"','"+member_address2+"','"+lat+"','"+lng+"')";
		try {
			pstmt=con.prepareStatement(sql);
			result=pstmt.executeUpdate();
			
			
		} catch (SQLException ex) {
			System.out.println("insertsavelist 에러: "+ex);
		}finally {
			
			close(pstmt);
		}
		return result;
	}
	public int selectmaxordernum() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int order_num=0;
		String sql="select * from order_list where order_num=(select max(order_num) from order_list)";
			
		
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
			
				order_num=rs.getInt("order_num");
				}else {
					order_num=0;
			}
		} catch (SQLException ex) {
			System.out.println("selectmaxordernum : "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return order_num;
	}
	public int insertorderdetail(int order_num, String company_menuname, int company_menuprice, int company_quantity) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql="insert into order_detail (order_num,order_name,order_price,order_quantity) values("+order_num+",'"+company_menuname+"',"+company_menuprice+","+company_quantity+")";
		try {
			pstmt=con.prepareStatement(sql);
			result=pstmt.executeUpdate();
			
			
		} catch (SQLException ex) {
			System.out.println("insertorderdetail 에러: "+ex);
		}finally {
			
			close(pstmt);
		}
		return result;
	}
	public ArrayList<OrderSave> selectordersave(int order_num) {
		ArrayList<OrderSave> ordersave = new ArrayList<OrderSave>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select order_list.*, order_detail.* from order_list inner join order_detail on order_list.order_num=order_detail.order_num where order_list.order_num="+order_num;
			
		
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
					do {
						OrderSave save=new OrderSave();
					save.setOrder_num(rs.getInt("order_num"));
					save.setOrder_date(rs.getString("order_date"));
					save.setMember_id(rs.getString("member_id"));
					save.setCompany_name(rs.getString("company_name"));
					save.setCompany_id(rs.getString("company_id"));
					save.setOrder_state(rs.getString("order_state"));
					save.setOrder_price(rs.getInt("order_price"));
					save.setOrder_name(rs.getString("order_name"));
					save.setOrder_quantity(rs.getInt("order_quantity"));
					ordersave.add(save);
			} while (rs.next());
			}
		} catch (SQLException ex) {
			System.out.println("selectordersave 에러: "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return ordersave;
	}
	public ArrayList<String> selectrideremail() {
		ArrayList<String> rider_email=new ArrayList<String>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select rider_email from rider";
			
		
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
					do {
					rider_email.add(rs.getString("rider_email"));
			} while (rs.next());
			}
		} catch (SQLException ex) {
			System.out.println("selectordersave 에러: "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return rider_email;
	}
	public Member selectMember(String member_id) {
		Member member = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=con.prepareStatement("select * from member where member_id=?");
			pstmt.setString(1, member_id);
			rs=pstmt.executeQuery();
			
			
			if(rs.next()){
				if(member_id.equals(rs.getString("member_id"))){
					member=new Member();
					member.setMember_id(rs.getString("member_id"));
					member.setMember_name(rs.getString("member_name"));
					member.setMember_pass(rs.getString("member_pass"));
					member.setMember_email(rs.getString("member_email"));
					member.setMember_birth(rs.getString("member_birth"));
					member.setMember_gender(rs.getString("member_gender"));
					member.setMember_tel(rs.getString("member_tel"));
					member.setMember_address1(rs.getString("member_address1"));
					member.setMember_address2(rs.getString("member_address2"));
					member.setMember_address3(rs.getString("member_address3"));
					member.setMember_address4(rs.getString("member_address4"));
					member.setMember_grade(rs.getString("member_grade"));
					
				}
			}
		} catch (SQLException ex) {
			System.out.println("selectMember 에러: "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return member;
	}
	
	
	public ArrayList<MainOrder> selectMainOrder(String member_id) {
		ArrayList<MainOrder> mainorder = new ArrayList<MainOrder>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Integer> price=null;
		ArrayList<String> name=null;
		ArrayList<Integer> quantity=null;
		String sql="select order_list.*, order_detail.* from order_list inner join order_detail on order_list.order_num=order_detail.order_num where member_id='"+member_id+"' order by order_date desc";
			
		
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
					
						MainOrder save=new MainOrder();
						price=new ArrayList<Integer>();
						name=new ArrayList<String>();
						quantity=new ArrayList<Integer>();
					save.setOrder_num(rs.getInt("order_num"));
					save.setOrder_date(rs.getString("order_date"));
					save.setRider_id(rs.getString("rider_id"));
					save.setMember_id(rs.getString("member_id"));
					save.setCompany_name(rs.getString("company_name"));
					save.setCompany_id(rs.getString("company_id"));
					save.setOrder_state(rs.getString("order_state"));
					price.add(rs.getInt("order_price"));
					save.setOrder_price(price);
					name.add(rs.getString("order_name"));
					save.setOrder_name(name);
					quantity.add(rs.getInt("order_quantity"));
					save.setOrder_quantity(quantity);
					mainorder.add(save);
			 
			}
			int i=0;
			while(rs.next()) {
				
				
					if(mainorder.get(i).getOrder_num()==rs.getInt("order_num")) {
						mainorder.get(i).getOrder_name().add(rs.getString("order_name"));
						mainorder.get(i).getOrder_price().add(rs.getInt("order_price"));
						mainorder.get(i).getOrder_quantity().add(rs.getInt("order_quantity"));
					}else {
						i++;
						MainOrder save=new MainOrder();
						price=new ArrayList<Integer>();
						name=new ArrayList<String>();
						quantity=new ArrayList<Integer>();
					save.setOrder_num(rs.getInt("order_num"));
					save.setOrder_date(rs.getString("order_date"));
					save.setRider_id(rs.getString("rider_id"));
					save.setMember_id(rs.getString("member_id"));
					save.setCompany_name(rs.getString("company_name"));
					save.setCompany_id(rs.getString("company_id"));
					save.setOrder_state(rs.getString("order_state"));
					price.add(rs.getInt("order_price"));
					save.setOrder_price(price);
					name.add(rs.getString("order_name"));
					save.setOrder_name(name);
					quantity.add(rs.getInt("order_quantity"));
					save.setOrder_quantity(quantity);
					mainorder.add(save);
				}
			
			}
			
		} catch (SQLException ex) {
			System.out.println("selectordersave 에러: "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return mainorder;
	}
	public ArrayList<CompanyReview> selectReview(String company_id) {
		ArrayList<CompanyReview> review=new ArrayList<CompanyReview>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from review where company_id='"+company_id+"' order by review_num desc";
			
		
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
			do {
				CompanyReview comreview=new CompanyReview();
				comreview.setMember_id(rs.getString("member_id"));
				comreview.setCompany_id(rs.getString("company_id"));
				comreview.setReview_num(rs.getInt("review_num"));
				comreview.setReview_content(rs.getString("review_content"));
				comreview.setReview_file(rs.getString("review_file"));
				comreview.setReview_date(rs.getString("review_date"));
				comreview.setReview_score(rs.getDouble("review_score"));
				comreview.setReview_menu(rs.getString("review_menu"));
				
				review.add(comreview);
				
			} while (rs.next());
			}
		} catch (SQLException ex) {
			System.out.println("selectReview 에러: "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return review;
	}
	public int InsertReview(CompanyReview writereview, int review_num) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql="insert into review values(?,?,?,?,?,current_timestamp,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, writereview.getMember_id());
			pstmt.setString(2, writereview.getCompany_id());
			pstmt.setInt(3,review_num );
			pstmt.setString(4, writereview.getReview_content());
			pstmt.setString(5, writereview.getReview_file());
			pstmt.setDouble(6, writereview.getReview_score());
			pstmt.setString(7, writereview.getReview_menu());
			result=pstmt.executeUpdate();
			
			
		} catch (SQLException ex) {
			System.out.println("InsertReview 에러: "+ex);
		}finally {
			
			close(pstmt);
		}
		return result;
	}
	public int selectmaxreviewnum(String company_id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int review_num=0;
		String sql="select * from review where review_num=(select max(review_num) from review where company_id=?)";
			
		
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, company_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
				review_num=rs.getInt("review_num");
				}else {
					review_num=0;
				}
			
		} catch (SQLException ex) {
			System.out.println("selectmaxreviewnum : "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return review_num;
	}
	public int UpdateScore(CompanyReview writereview, CompanyScore comScore) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql="update company_score set company_score=?,company_count=? where company_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1,(int) (comScore.getCompany_score()+writereview.getReview_score()) );
			pstmt.setInt(2, comScore.getCompany_count()+1);
			pstmt.setString(3, writereview.getCompany_id());
			result=pstmt.executeUpdate();
			
			
		} catch (SQLException ex) {
			System.out.println("UpdateScore 에러: "+ex);
		}finally {
			
			close(pstmt);
		}
		return result;
	}
	public CompanyScore slectScore(String company_id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		CompanyScore comscore=null;
		String sql="select * from company_score where company_id=?";
			
		
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, company_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
				comscore= new CompanyScore();
				comscore.setCompany_id(rs.getString("company_id"));
				comscore.setCompany_score(rs.getInt("company_score"));
				comscore.setCompany_count(rs.getInt("company_count"));
			}
			
		} catch (SQLException ex) {
			System.out.println("slectScore : "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return comscore;
	}
	public int UpdateComScore(CompanyScore comScore2) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql="update company set company_score=? where company_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			int a=(int) ((double)comScore2.getCompany_score()/comScore2.getCompany_count()*10);
			double b= a/10.0;
			
			System.out.println(comScore2.getCompany_score());
			System.out.println(comScore2.getCompany_count());
			System.out.println(b);
			if(comScore2.getCompany_count()!=0.0||comScore2.getCompany_count()!=0) {
				
			pstmt.setDouble(1,b);
			}else {
			
				pstmt.setDouble(1, 0.0);
			}
		
			pstmt.setString(2, comScore2.getCompany_id());
		
			result=pstmt.executeUpdate();
			
			
		} catch (SQLException ex) {
			System.out.println("UpdateComScore 에러: "+ex);
		}finally {
			
			close(pstmt);
		}
		return result;
	}
	public ArrayList<Member> selectMemberList(int page, int limit, String option, String value) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Member>  memberlist=new ArrayList<Member>();
		String sql="select * from member limit ?,?";
			
		if(option.equals("id")) {
			sql="select * from member where member_id like ? limit ?,?";
			
		}
		else if(option.equals("tel")) {
			sql="select * from member where member_tel like ? limit ?,?";
			
		}
		int startrow=(page-1)*limit;
		try {
			pstmt=con.prepareStatement(sql);
			if(option.equals("id")) {
				pstmt.setString(1, "%"+value+"%");
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, limit);
			}else if(option.equals("tel")) {
				pstmt.setString(1, "%"+value+"%");
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, limit);
			}
			else {
				pstmt.setInt(1, startrow);
				pstmt.setInt(2, limit);
			}
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				do {
				Member member=new Member(); 
				member.setMember_id(rs.getString("member_id"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_pass(rs.getString("member_pass"));
				member.setMember_grade(rs.getString("member_grade"));
				member.setMember_email(rs.getString("member_email"));
				member.setMember_birth(rs.getString("member_birth"));
				member.setMember_gender(rs.getString("member_gender"));
				member.setMember_tel(rs.getString("member_tel"));
				member.setMember_address1(rs.getString("member_address1"));
				member.setMember_address2(rs.getString("member_address2"));
				member.setMember_address3(rs.getString("member_address3"));
				member.setMember_address4(rs.getString("member_address4"));
				memberlist.add(member);
				
				
				}while(rs.next());
			}
			
		} catch (SQLException ex) {
			System.out.println("selectMemberList : "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return memberlist;
	}
	public int selectListCount(String option, String value) {
		int listCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(*) from member";
		if(option.equals("id")) {
			sql="select count(*) from member where member_id like ?";
		}else if(option.equals("tel")) {
			sql="select count(*) from member where member_tel like ?";
		}
		try {
			pstmt=con.prepareStatement(sql);
			if(option.equals("id"))
				pstmt.setString(1, "%"+value+"%");
			if(option.equals("tel"))
				pstmt.setString(1,"%"+value+"%");
			rs=pstmt.executeQuery();
		
			if(rs.next()) {
				listCount=rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("selectListCount 에러: "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	public int UpdateMember(Member member) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql="update member set member_name=?,member_pass=?,member_email=?,member_birth=?,member_gender=?"
				+ ",member_tel=?,member_address1=?,member_address2=?,member_address3=?,member_address4=? where member_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			
			
			pstmt.setString(1, member.getMember_name());
			pstmt.setString(2, member.getMember_pass());
			pstmt.setString(3, member.getMember_email());
			pstmt.setString(4, member.getMember_birth()+"");
			pstmt.setString(5, member.getMember_gender());
			pstmt.setString(6, member.getMember_tel());
			pstmt.setString(7, member.getMember_address1());
			pstmt.setString(8, member.getMember_address2());
			pstmt.setString(9, member.getMember_address3());
			pstmt.setString(10, member.getMember_address4());
			pstmt.setString(11, member.getMember_id());
			result=pstmt.executeUpdate();
			
			
		} catch (SQLException ex) {
			System.out.println("UpdateMember 에러: "+ex);
		}finally {
			
			close(pstmt);
		}
		return result;
	}
	public int Deletemember(String member_id) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql="delete from member where member_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			
			
			pstmt.setString(1, member_id);
			
			result=pstmt.executeUpdate();
			
			
		} catch (SQLException ex) {
			System.out.println("Deletemember 에러: "+ex);
		}finally {
			
			close(pstmt);
		}
		return result;
	}
	public Member selectMembername(String checkname) {
		Member member = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=con.prepareStatement("select * from member where member_name=?");
			pstmt.setString(1, checkname);
			rs=pstmt.executeQuery();
			
			
			if(rs.next()){
				if(checkname.equals(rs.getString("member_name"))){
					member=new Member();
					member.setMember_id(rs.getString("member_id"));
					member.setMember_name(rs.getString("member_name"));
					member.setMember_pass(rs.getString("member_pass"));
					member.setMember_email(rs.getString("member_email"));
					member.setMember_birth(rs.getString("member_birth"));
					member.setMember_gender(rs.getString("member_gender"));
					member.setMember_tel(rs.getString("member_tel"));
					member.setMember_address1(rs.getString("member_address1"));
					member.setMember_address2(rs.getString("member_address2"));
					member.setMember_address3(rs.getString("member_address3"));
					member.setMember_address4(rs.getString("member_address4"));
					member.setMember_grade(rs.getString("member_grade"));
					
				}
			}
		} catch (SQLException ex) {
			System.out.println("selectMembername 에러: "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return member;
	}
	public int updatePassword(String checkid, String password) {
		// TODO Auto-generated method stub
				int result=0;
				PreparedStatement pstmt=null;
				try {
					
					pstmt=con.prepareStatement("update member set member_pass=? where member_id=?");
						
					pstmt.setString(1, password);
					pstmt.setString(2, checkid);
					
					
					result=pstmt.executeUpdate();
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					
					if(pstmt!=null) close(pstmt);
				}
				return result;
	}
	public Member memberemailCheck(String checkemail) {
		Member member=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=con.prepareStatement("select * from member where member_email=?");
			pstmt.setString(1, checkemail);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				member=new Member();
				member.setMember_name(rs.getString("member_name"));
				member.setMember_email(rs.getString("member_email"));
				member.setMember_id(rs.getString("member_id"));
			}
		}catch(Exception e) {
			System.out.println("memberemailCheck 에러"+e);
		}finally {
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
		}
		
		return member;
	}
	public int joinMember(Member member) {
		int result=0;
		PreparedStatement pstmt=null;
		
		try {
			pstmt=con.prepareStatement("insert into member values(?,?,?,?,?,?,?,?,?,?,?,?)");
					// executeQeury와 executeUpdate 의 차이를 알아야한다.
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_name());
			pstmt.setString(3, member.getMember_pass());
			pstmt.setString(4, member.getMember_grade());
			pstmt.setString(5, member.getMember_email());
			pstmt.setString(6, member.getMember_birth());
			pstmt.setString(7, member.getMember_gender());
			pstmt.setString(8, member.getMember_tel());
			pstmt.setString(9, member.getMember_address1());
			pstmt.setString(10, member.getMember_address2());
			pstmt.setString(11, member.getMember_address3());
			pstmt.setString(12, member.getMember_address4());
			
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(pstmt!=null) close(pstmt);
		}
		
		return result;
	}
	public int DeleteOrder_list(int order_num) {
		int result=0;
		PreparedStatement pstmt=null;
		
		try {
			pstmt=con.prepareStatement("delete from order_list where order_num=?");
					// executeQeury와 executeUpdate 의 차이를 알아야한다.
			pstmt.setInt(1, order_num);
		
			
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(pstmt!=null) close(pstmt);
		}
		
		return result;
	}
	public int DeleteOrder_detail(int order_num) {
		int result=0;
		PreparedStatement pstmt=null;
		
		try {
			pstmt=con.prepareStatement("delete from order_detail where order_num=?");
					// executeQeury와 executeUpdate 의 차이를 알아야한다.
			pstmt.setInt(1, order_num);
		
			
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(pstmt!=null) close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<Company> changelistsearch(String option, String category) {
		ArrayList<Company> companylist = new ArrayList<Company>();
		PreparedStatement pstmt=null;
		
		ResultSet rs=null;
		String sql="select * from company where company_active='활성상태' order by "+option;
		if(!category.equals("all")&&category!=null)
		{
			sql="select * from company where company_active='활성상태' and company_category='"+category+"' order by "+option;
		}
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				
					do {
					Company company=new Company();
					company.setCompany_id(rs.getString("company_id"));
					company.setCompany_businum(rs.getString("company_businum"));
					company.setCompany_name(rs.getString("company_name"));
					company.setCompany_tel(rs.getString("company_tel"));
					company.setCompany_logo(rs.getString("company_logo"));
					company.setCompany_category(rs.getString("company_category"));
					company.setCompany_regdate(rs.getString("company_regdate"));
					company.setCompany_address1(rs.getString("company_address1"));
					company.setCompany_address2(rs.getString("company_address2"));
					company.setCompany_address3(rs.getString("company_address3"));
					company.setCompany_address4(rs.getString("company_address4"));
					company.setCompany_active(rs.getString("company_active"));
					company.setCompany_score(rs.getDouble("company_score"));
					companylist.add(company);
			} while (rs.next());
			}
		} catch (SQLException ex) {
			System.out.println("selectCompany 에러: "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return companylist;
	}
	public ArrayList<Company> changelistcategory(String option, String search) {
		ArrayList<Company> companylist = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select company.*, company_menu.* from company inner join company_menu on company.company_id=company_menu.company_id where company_active='활성상태' and (company_name like '%"+search+"%' or company_menuname like '%"+search+"%') group by company.company_id order by "+option;
			
		
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				companylist=new ArrayList<Company>();
					do {
					Company company=new Company();
					company.setCompany_id(rs.getString("company_id"));
					company.setCompany_businum(rs.getString("company_businum"));
					company.setCompany_name(rs.getString("company_name"));
					company.setCompany_tel(rs.getString("company_tel"));
					company.setCompany_logo(rs.getString("company_logo"));
					company.setCompany_category(rs.getString("company_category"));
					company.setCompany_score(rs.getDouble("company_score"));
					company.setCompany_regdate(rs.getString("company_regdate"));
					company.setCompany_address1(rs.getString("company_address1"));
					company.setCompany_address2(rs.getString("company_address2"));
					company.setCompany_address3(rs.getString("company_address3"));
					company.setCompany_address4(rs.getString("company_address4"));
					company.setCompany_active(rs.getString("company_active"));
					companylist.add(company);
			} while (rs.next());
			}
		} catch (SQLException ex) {
			System.out.println("searchlist 에러: "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return companylist;
	}

	
	
}