package domain;

public class Join {

	private String uId;
	private String uPw;
	private String uName;
	private int uDate;
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPw() {
		return uPw;
	}
	public void setuPw(String uPw) {
		this.uPw = uPw;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public int getuDate() {
		return uDate;
	}
	public void setuDate(int uDate) {
		this.uDate = uDate;
	}
	public Join(String uId, String uPw, String uName, int uDate) {
		super();
		this.uId = uId;
		this.uPw = uPw;
		this.uName = uName;
		this.uDate = uDate;
	}
	@Override
	public String toString() {
		return "Join [uId=" + uId + ", uPw=" + uPw + ", uName=" + uName + ", uDate=" + uDate + "]";
	}
	
	
}
