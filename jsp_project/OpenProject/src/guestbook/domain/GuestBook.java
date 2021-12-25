package guestbook.domain;

public class GuestBook {
	private int idx;
	private String subject;
	private String content;
	private String regdate;
	private String writer; 	// join으로  memberidx 값을  writer로 가지고 왔다
	private int memberidx;
	
	// jsp쪽에서 파라미터로 넘어온 String 형식으로 나열된 배열을 분해하여 생성하는 생성자 
	public GuestBook(String listView) {
		int fir = listView.indexOf("[")+1;
		int sec = listView.indexOf("]");
		listView = listView.substring(fir, sec);
		String [] list = listView.split(", ");
		
		for (int i = 0; i < list.length; i++) {
			list[i] = list[i].substring(list[i].indexOf("=")+1);
		}
		
		this.idx = Integer.parseInt(list[0]);
		this.subject = list[1];
		this.content = list[2];
		this.regdate = list[3];
		this.writer = list[4];
	};
	
	//글 등록 전용 생성자
	public GuestBook(String subject, String content, int memberidx) {
		this.subject = subject;
		this.content = content;
		this.memberidx = memberidx;
	}
	
	// List전용 생성자
	public GuestBook(int idx, String subject, String content, String regdate, String writer) {
		this.idx = idx;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.writer = writer;
	}

	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getMemberidx() {
		return memberidx;
	}
	
	public void setMemberidx(int memberidx) {
		this.memberidx = memberidx;
	}

	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "GuestBook [idx=" + idx + ", subject=" + subject + ", content=" + content + ", regdate=" + regdate
				+ ", writer=" + writer + "]";
	}

	
	
	
	
	
}
