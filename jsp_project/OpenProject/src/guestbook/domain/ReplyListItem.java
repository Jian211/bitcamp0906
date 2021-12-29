package guestbook.domain;

public class ReplyListItem {
	
	private int idx;			 // 댓글 idx
	private String content;		 // 댓글 내용
	private String regDate;		 // 댓글 작성 시간
	private int guestBookIdx;    // 부모 게시물의 idx
	private int memberIdx; 	 	 // 작성자의 idx
	private String userName;  	 // 작성자의 이름
	private String photo;	  	 // 작성자의 사진

	public ReplyListItem() {};
	public ReplyListItem(int idx, String content, String regDate, int guestBookIdx, int memberIdx, String userName,
			String photo) {
		this.idx = idx;
		this.content = content;
		this.regDate = regDate;
		this.guestBookIdx = guestBookIdx;
		this.memberIdx = memberIdx;
		this.userName = userName;
		this.photo = photo;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getGuestBookIdx() {
		return guestBookIdx;
	}

	public void setGuestBookIdx(int guestBookIdx) {
		this.guestBookIdx = guestBookIdx;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "ReplyListItem [idx=" + idx + ", content=" + content + ", regDate=" + regDate + ", guestBookIdx="
				+ guestBookIdx + ", memberIdx=" + memberIdx + ", userName=" + userName + ", photo=" + photo + "]";
	};
	
	
}
