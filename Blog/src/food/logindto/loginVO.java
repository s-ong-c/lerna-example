package food.logindto;

import java.sql.Timestamp;

public class loginVO {

	
	private String id;
	private String pass;
	private String name;
	private String email;
	private String nickname;
	private Timestamp writedate;
	private int admin;
	private String address;
	private String companyName;
	private String companyPhone;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	


	public loginVO(String id, String pass, String name, String email, String nickname, Timestamp writedate, int admin,
			String address, String companyName, String companyPhone) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.nickname = nickname;
		this.writedate = writedate;
		this.admin = admin;
		this.address = address;
		this.companyName = companyName;
		this.companyPhone = companyPhone;
	}
	public loginVO() {

	}
	
}
