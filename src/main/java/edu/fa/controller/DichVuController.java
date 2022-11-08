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

import edu.fa.model.DichVu;
import edu.fa.service.DichVuService;

@Controller
public class DichVuController {
	@Autowired
	DichVuService service;
	
	@GetMapping("/dich-vu/{pageNumber}")
	public String showDichVu(@PathVariable("pageNumber") int currentPage, Model model) {
		Page<DichVu> page = service.findAll(currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<DichVu> danhSachDichVu = page.getContent();
		DichVu dichVu = new DichVu();
		
		model.addAttribute("currentPage", currentPage);
	    model.addAttribute("totalItems", totalItems);
	    model.addAttribute("totalPages", totalPages);
		model.addAttribute("danhSachDichVu", danhSachDichVu);
		model.addAttribute("dichVu", dichVu);
		return "danh-sach-dich-vu";
	}
	
	@GetMapping(value = "/tim-dich-vu/{pageNumber}", params = "keyword")
	public String showDichVuWithSearch(@PathVariable("pageNumber") int currentPage, Model model, @RequestParam("keyword") String keyword) {
		Page<DichVu> page = service.search(keyword, currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<DichVu> danhSachDichVu = page.getContent();
		
		model.addAttribute("keyword", keyword);
		model.addAttribute("currentPage", currentPage);
	    model.addAttribute("totalItems", totalItems);
	    model.addAttribute("totalPages", totalPages);
		model.addAttribute("danhSachDichVu", danhSachDichVu);
		return "tim-dich-vu";
	}
	
	@GetMapping(value = "/dich-vu/{pageNumber}", params = "edit-id")
	public String showDichVuWithEdit(@PathVariable("pageNumber") int currentPage, Model model, @RequestParam("edit-id") String id) {
		Page<DichVu> page = service.findAll(currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages(); 
		List<DichVu> danhSachDichVu = page.getContent();
		DichVu dichVuEditing = service.findById(id);
		
		model.addAttribute("currentPage", currentPage);
	    model.addAttribute("totalItems", totalItems);
	    model.addAttribute("totalPages", totalPages);
		model.addAttribute("danhSachDichVu", danhSachDichVu);
		model.addAttribute("dichVu", dichVuEditing);
		return "danh-sach-dich-vu";
	}
	
	@PostMapping(value = "/dich-vu/{pageNumber}", params = "edit-id")
	public String editDichVu(@PathVariable("pageNumber") int currentPage, Model model,
							@Valid @ModelAttribute("dichVu") DichVu dichVu , BindingResult bindingResult, 
							@RequestParam("edit-id") String id) {
		if (bindingResult.hasErrors()) {
			Page<DichVu> page = service.findAll(currentPage);
			long totalItems = page.getTotalElements();
			int totalPages = page.getTotalPages(); 
			List<DichVu> danhSachDichVu = page.getContent();
			
			model.addAttribute("currentPage", currentPage);
		    model.addAttribute("totalItems", totalItems);
		    model.addAttribute("totalPages", totalPages);
			model.addAttribute("danhSachDichVu", danhSachDichVu);
			model.addAttribute("editFail", "Chinh sua dich vu khong thanh cong");
			return "danh-sach-dich-vu";
		}
		
		//Add new DichVu
		service.save(dichVu);
		return "redirect:/dich-vu/1";
	}
	
	@GetMapping("/them-dich-vu-moi")
	public String showAddDichVu(Model model) {
		DichVu dichVu = new DichVu();
		model.addAttribute("dichVu", dichVu);
		return "them-dich-vu-moi";
	}
	
	@PostMapping("/them-dich-vu-moi")
	public String addDichVu(@Valid @ModelAttribute("dichVu") DichVu dichVu, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("addFail", "Them dich vu khong thanh cong");
			return "them-dich-vu-moi";
		}
		
		//Add new DichVu
		service.save(dichVu);
		return "redirect:/dich-vu/1";
	}
	
	@GetMapping(value = "/xoa-dich-vu", params = "id")
	public String deleteDichVu(Model model, @RequestParam("id") String id) {
		service.delete(id);
		return "redirect:/dich-vu/1";
	}
}
