package com.bitcamp.mvc.domain;

import org.springframework.web.multipart.MultipartFile;

public class ReqReport {

	private String sno;
	private String sname;
	private MultipartFile report;
	
	public ReqReport() {};
	
	public ReqReport(String sno, String sname, MultipartFile report) {
		this.sno = sno;
		this.sname = sname;
		this.report = report;
	}

	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public MultipartFile getReport() {
		return report;
	}
	public void setReport(MultipartFile report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return "ReqReport [sno=" + sno + ", sname=" + sname + ", report=" + report + "]";
	}
	
	
	
	
}
