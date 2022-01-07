package com.bitcamp.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitcamp.mvc.domain.ReqReport;

@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private FileUploadService service;
	
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String getReportForm() {
		return "/report/form";
	}
	
	@RequestMapping(value="/submit1", method = RequestMethod.POST)
	public String submit1(
			@RequestParam("sno") String sno,
			@RequestParam("sname") String sname,
			@RequestParam("report") MultipartFile report,
			Model model,
			HttpServletRequest req
	){
		System.out.println(sno);
		model.addAttribute("sno", sno);
		model.addAttribute("sname", sname);
		model.addAttribute("report", report.getOriginalFilename());
		
		// 중복된 파일을 방지하기위해
		String newFileName = sno +"_"+report.getOriginalFilename();
		
		System.out.println(sno);
		System.out.println(sname);
		System.out.println();
		System.out.println(report);
		System.out.println(report.getOriginalFilename());
		System.out.println(report.getContentType());
		System.out.println(report.getName());
		System.out.println(report.getSize());
		System.out.println(report.isEmpty());
		
		try {
			String fileName = service.saveFile("/uploadfile", report, req);
			System.out.println("파일 저장완료  :"+ fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/report/submit";
	}
	
	//mvc/report/submit2
	//mvc/report/submit2
	@PostMapping("/submit2")
	public String submit2(
			MultipartHttpServletRequest req,
			Model model
			) {

		MultipartFile report = req.getFile("report");
		
		System.out.println(req.getParameter("sno"));
		System.out.println(req.getParameter("sname"));
		System.out.println();
		System.out.println(report);
		System.out.println(report.getOriginalFilename());
		System.out.println(report.getContentType());
		System.out.println(report.getName());
		System.out.println(report.getSize());
		System.out.println(report.isEmpty());
		
		model.addAttribute("sno", req.getParameter("sno"));
		model.addAttribute("sname", req.getParameter("sname"));
		model.addAttribute("report", report.getOriginalFilename());
		
		try {
			String fileName = service.saveFile("/uploadfile", report, req);
			System.out.println("파일 저장완료  :"+ fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "/report/submit";
	}
	
	//mvc/report/submit3
	public String submit3(
			@ModelAttribute("report") ReqReport report,
			HttpServletRequest req	// 커맨드 객체라고 한다.
			) {

		try {
			String fileName = service.saveFile("/uploadfile", report.getReport(), req);
			System.out.println("파일 저장완료  :"+ fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "report/submit";
	}
}
