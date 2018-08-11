package food.logindto;

public class OutStaticsVo {

	
	
	private int num;
	private int outNum;
	private String Content;
	private int admin;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getOutNum() {
		return outNum;
	}
	public void setOutNum(int outNum) {
		this.outNum = outNum;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public OutStaticsVo() {

	}
	public OutStaticsVo(int num, int outNum, String content, int admin) {
		super();
		this.num = num;
		this.outNum = outNum;
		Content = content;
		this.admin = admin;
	}
	
	
}
