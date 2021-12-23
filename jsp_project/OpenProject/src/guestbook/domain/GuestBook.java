package guestbook.domain;

public class GuestBook {
	private int idx;
	private String subject;
	private String content;

	public GuestBook(int idx, String subject, String content) {
		this.idx = idx;
		this.subject = subject;
		this.content = content;
	}

	@Override
	public String toString() {
		return "GuestBook [idx=" + idx + ", subject=" + subject + ", content=" + content + "]";
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
	
	
}
