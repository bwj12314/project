package comp.vo;

public class Menu {

	private String company_id;
	private String company_menuname;
	private int company_menuprice;
	private String company_menupicture;
	private String company_menuinfo;
	private int company_menunum;
	
	public Menu(String company_id,String company_menuname, int company_menuprice, String company_menupicture,String company_menuinfo,int company_menunum) {
		super();
		this.company_id = company_id;
		this.company_menuname = company_menuname;
		this.company_menuprice = company_menuprice;
		this.company_menupicture = company_menupicture;
		this.company_menuinfo = company_menuinfo;
		this.company_menunum = company_menunum;
		
	}



	public int getCompany_menunum() {
		return company_menunum;
	}



	public void setCompany_menunum(int company_menunum) {
		this.company_menunum = company_menunum;
	}



	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	public String getCompany_menuname() {
		return company_menuname;
	}

	public void setCompany_menuname(String company_menuname) {
		this.company_menuname = company_menuname;
	}

	public int getCompany_menuprice() {
		return company_menuprice;
	}

	public void setCompany_menuprice(int company_menuprice) {
		this.company_menuprice = company_menuprice;
	}

	public String getCompany_menupicture() {
		return company_menupicture;
	}

	public void setCompany_menupicture(String company_menupicture) {
		this.company_menupicture = company_menupicture;
	}

	public String getCompany_menuinfo() {
		return company_menuinfo;
	}

	public void setCompany_menuinfo(String company_menuinfo) {
		this.company_menuinfo = company_menuinfo;
	}

	
}
