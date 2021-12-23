package guestbook.domain;

public class GuestBook {
	private int idx;
	private String subject;
	private String content;
	private String regdate;
	private int memberidx;
	private String writer; 	// 작성자 == memberidx
	
	public GuestBook(String subject, String content, int memberidx) {
		this.subject = subject;
		this.content = content;
		this.memberidx = memberidx;
	}
	
	public GuestBook(int idx, String subject, String content, String regdate, int memberidx) {
		this(subject,content,memberidx);
		this.idx = idx;
		this.regdate = regdate;
	}

	public GuestBook(int idx, String subject, String content, String regdate, int memberidx, String writer) {
		this(idx, subject, content, regdate, memberidx);
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
				+ ", memberidx=" + memberidx + "]";
	}

	
	
	
}
