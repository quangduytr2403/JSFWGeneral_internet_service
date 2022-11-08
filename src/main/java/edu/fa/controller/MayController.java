package edu.fa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.fa.model.May;
import edu.fa.service.MayService;

@Controller
public class MayController {
	@Autowired
	MayService service;
	
	@GetMapping("/may/{pageNumber}")
	public String showMay(@PathVariable("pageNumber") int currentPage, Model model) {
		Page<May> page = service.findAll(currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<May> danhSachMay = page.getContent();
		May may = new May();
		
		model.addAttribute("currentPage", currentPage);
	    model.addAttribute("totalItems", totalItems);
	    model.addAttribute("totalPages", totalPages);
		model.addAttribute("danhSachMay", danhSachMay);
		model.addAttribute("may", may);
		return "danh-sach-may";
	}
	
	@GetMapping(value = "/tim-may/{pageNumber}", params = "keyword")
	public String showMayWithSearch(@PathVariable("pageNumber") int currentPage, Model model, @RequestParam("keyword") String keyword) {
		Page<May> page = service.search(keyword, currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<May> danhSachMay = page.getContent();
		
		model.addAttribute("keyword", keyword);
		model.addAttribute("currentPage", currentPage);
	    model.addAttribute("totalItems", totalItems);
	    model.addAttribute("totalPages", totalPages);
		model.addAttribute("danhSachMay", danhSachMay);
		return "tim-may";
	}
	
	@GetMapping(value = "/may/{pageNumber}", params = "edit-id")
	public String showMayWithEdit(@PathVariable("pageNumber") int currentPage, Model model, @RequestParam("edit-id") int id) {
		Page<May> page = service.findAll(currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages(); 
		List<May> danhSachMay = page.getContent();
		May mayEditing = service.findById(id);
		
		model.addAttribute("currentPage", currentPage);
	    model.addAttribute("totalItems", totalItems);
	    model.addAttribute("totalPages", totalPages);
		model.addAttribute("danhSachMay", danhSachMay);
		model.addAttribute("may", mayEditing);
		return "danh-sach-may";
	}
	
	@PostMapping(value = "/may/{pageNumber}", params = "edit-id")
	public String editMay(@PathVariable("pageNumber") int currentPage, Model model, @Valid @ModelAttribute("may") May may ,
						BindingResult bindingResult, @RequestParam("edit-id") int id) {
		// Validate form
		if (bindingResult.hasErrors()) {
			Page<May> page = service.findAll(currentPage);
			long totalItems = page.getTotalElements();
			int totalPages = page.getTotalPages(); 
			List<May> danhSachMay = page.getContent();
			
			model.addAttribute("currentPage", currentPage);
		    model.addAttribute("totalItems", totalItems);
		    model.addAttribute("totalPages", totalPages);
			model.addAttribute("danhSachMay", danhSachMay);
			model.addAttribute("editFail", "Chinh sua may khong thanh cong");
			return "danh-sach-may";
		}
		//Add new May
		service.save(may);
		return "redirect:/may/1";
	}
	
	@GetMapping("/them-may-moi")
	public String showAddMay(Model model) {
		May may = new May();
		model.addAttribute("may", may);
		return "them-may-moi";
	}
	
	@PostMapping("/them-may-moi")
	public String addMay(@Valid @ModelAttribute("may") May may, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("addFail", "Them may khong thanh cong");
			return "them-may-moi";
		} 
		
		//Add new May
		service.save(may);
		return "redirect:/may/1";
	}
	
	@GetMapping(value = "/xoa-may", params = "id")
	public String deleteMay(Model model, @RequestParam("id") int id) {
		service.delete(id);
		return "redirect:/may/1";
	}
}
