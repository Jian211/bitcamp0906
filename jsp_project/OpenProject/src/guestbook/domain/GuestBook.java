package guestbook.domain;

public class GuestBook {
	private int idx;
	private String subject;
	private String content;
	private String regdate;
	private String writer; 	// join으로  memberidx 값을  writer로 가지고 왔다
	private int memberidx;
	private String photo;

	// jsp쪽에서 파라미터로 넘어온 String 형식으로 나열된 배열을 분해하여 생성하는 생성자 
	public GuestBook(String listView) {
		System.out.println("listView : "+listView);
		System.out.println("여기서 오루냐냐");
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
		this.memberidx = Integer.parseInt(list[5]);
		this.photo = list[6];
	};
	
	

	//글 등록 전용 생성자 1
	public GuestBook(String subject, String content, int memberidx) {
		this.subject = subject;
		this.content = content;
		this.memberidx = memberidx;
	}
	
	// 유저가 게시글 선택시 사용되는 생성자
	public GuestBook(int idx, String subject, String content,String regdate, int memberidx) {
		this.subject = subject;
		this.content = content;
		this.memberidx = memberidx;
		this.idx = idx;
		this.regdate = regdate;
	}
	
	//글 수정 전용 생성자
	public GuestBook(String[] editedGuestBook) {
		this.subject = editedGuestBook[0];
		this.idx = Integer.parseInt(editedGuestBook[1]);
		this.content = editedGuestBook[2];
	}
	
	// List전용 생성자
	public GuestBook(int idx, String subject, String content, String regdate, String writer,String photo) {
		this.idx = idx;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.writer = writer;
		this.photo = photo;
	}
	
	// ListView 생성자
	public GuestBook(int idx, String subject, String content, String regdate, String writer, int memberidx,
			String photo) {
		this(memberidx, subject, content, regdate, writer, photo);
		this.idx = idx;
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
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "GuestBook [idx=" + idx + ", subject=" + subject + ", content=" + content + ", regdate=" + regdate
				+ ", writer=" + writer + ", memberidx=" + memberidx + ", photo=" + photo + "]";
	}



	
	
	
	
	
}
