package guestbook.domain;

import java.util.List;


public class GuestBookListView {
	private int pageTotalCount; 	// 페이지 갯수
	private int totalCount; 		// 전체 행의 갯수
	private int countPerPage;		// 한 페이지에 출력할 행의 갯수
	private int currentPage;		// 현재 페이지 번호
	private List<GuestBook> list;	// 출력할 데이터 항목 리스트
	

	public GuestBookListView(int totalCount, int countPerPage, int currentPage, List<GuestBook> list) {
		this.totalCount = totalCount;
		this.countPerPage = countPerPage;
		this.currentPage = currentPage;
		this.list = list;
		calTotalPageCount();
	}


	private void calTotalPageCount() {
		this.pageTotalCount = this.totalCount / this.countPerPage;
		if(this.totalCount % this.countPerPage > 0) {
			this.pageTotalCount++;
		}
	}


	public int getPageTotalCount() {
		return pageTotalCount;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public int getCountPerPage() {
		return countPerPage;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public List<GuestBook> getList() {
		return list;
	}


	
	
	@Override
	public String toString() {
		return "MemberListView [pageTotalCount=" + pageTotalCount + ", totalCount=" + totalCount + ", countPerPage="
				+ countPerPage + ", currentPage=" + currentPage + ", list=" + list + "]";
	}
	
	
}
