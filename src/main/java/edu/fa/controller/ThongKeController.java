package edu.fa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.fa.model.ThongKe;
import edu.fa.service.ThongKeService;

@Controller
public class ThongKeController {
	@Autowired
	ThongKeService service;
	
	@RequestMapping("/thong-ke/{pageNumber}")
	public String thongKe(Model model, @PathVariable("pageNumber") int currentPage) {
		Page<ThongKe> page = service.join(currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<ThongKe> danhSachThongKe = page.getContent();
		
		model.addAttribute("currentPage", currentPage);
	    model.addAttribute("totalItems", totalItems);
	    model.addAttribute("totalPages", totalPages);
		model.addAttribute("danhSachThongKe", danhSachThongKe);
		return "thong-ke";
	}
}
