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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.fa.model.KhachHang;
import edu.fa.service.KhachHangService;

@Controller
public class KhachHangController {
	@Autowired
	KhachHangService service;
	
	@GetMapping("/khach-hang/{pageNumber}")
	public String showKhachHang(@PathVariable("pageNumber") int currentPage, Model model) {
		Page<KhachHang> page = service.findAll(currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<KhachHang> danhSachKhachHang = page.getContent();
		KhachHang khachHang = new KhachHang();
		
		model.addAttribute("currentPage", currentPage);
	    model.addAttribute("totalItems", totalItems);
	    model.addAttribute("totalPages", totalPages);
		model.addAttribute("danhSachKhachHang", danhSachKhachHang);
		model.addAttribute("khachHang", khachHang);
		return "danh-sach-khach-hang";
	}
	
	@GetMapping(value = "/tim-khach-hang/{pageNumber}", params = "keyword")
	public String showKhachHangWithSearch(@PathVariable("pageNumber") int currentPage, Model model, @RequestParam("keyword") String keyword) {
		Page<KhachHang> page = service.search(keyword, currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<KhachHang> danhSachKhachHang = page.getContent();
		
		model.addAttribute("keyword", keyword);
		model.addAttribute("currentPage", currentPage);
	    model.addAttribute("totalItems", totalItems);
	    model.addAttribute("totalPages", totalPages);
		model.addAttribute("danhSachKhachHang", danhSachKhachHang);
		return "tim-khach-hang";
	}
	
	@GetMapping(value = "/khach-hang/{pageNumber}", params = "edit-id")
	public String showKhachHangWithEdit(@PathVariable("pageNumber") int currentPage, Model model, @RequestParam("edit-id") String id) {
		Page<KhachHang> page = service.findAll(currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages(); 
		List<KhachHang> danhSachKhachHang = page.getContent();
		KhachHang khachHangEditing = service.findById(id);
		
		model.addAttribute("currentPage", currentPage);
	    model.addAttribute("totalItems", totalItems);
	    model.addAttribute("totalPages", totalPages);
		model.addAttribute("danhSachKhachHang", danhSachKhachHang);
		model.addAttribute("khachHang", khachHangEditing);
		return "danh-sach-khach-hang";
	}
	
	
	@PostMapping(value = "/khach-hang/{pageNumber}", params = "edit-id")
	public String editKhachHang(@PathVariable("pageNumber") int currentPage, Model model, 
								@Valid @ModelAttribute("khachHang") KhachHang khachHang , 
								BindingResult bindingResult, @RequestParam("edit-id") String id ) {
		if (bindingResult.hasErrors()) {
			Page<KhachHang> page = service.findAll(currentPage);
			long totalItems = page.getTotalElements();
			int totalPages = page.getTotalPages(); 
			List<KhachHang> danhSachKhachHang = page.getContent();
			
			model.addAttribute("currentPage", currentPage);
		    model.addAttribute("totalItems", totalItems);
		    model.addAttribute("totalPages", totalPages);
			model.addAttribute("danhSachKhachHang", danhSachKhachHang);
			model.addAttribute("editFail", "Chinh sua khach hang khong thanh cong");
			return "danh-sach-khach-hang";
		}
		
		//Add new May
		service.save(khachHang);
		return "redirect:/khach-hang/1";
	}
	
	@GetMapping("/them-khach-hang-moi")
	public String showAddKhachHang(Model model) {
		KhachHang khachHang = new KhachHang();
		model.addAttribute("khachHang", khachHang);
		return "them-khach-hang-moi";
	}
	
	@PostMapping("/them-khach-hang-moi")
	public String addKhachHang(@Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("addFail", "Them khach hang khong thanh cong");
			return "them-khach-hang-moi";
		}

		//Add new Khach hang
		service.save(khachHang);
		return "redirect:/khach-hang/1";
	}
	
	@GetMapping(value = "/xoa-khach-hang", params = "id")
	public String deleteKhachHang(Model model, @RequestParam("id") String id) {
		service.delete(id);
		return "redirect:/khach-hang/1";
	}
	
	@RequestMapping(value = "/check-id")
	public @ResponseBody String checkId(@RequestParam("id") String id) {
		String ajaxResponse = "false";
		
		if(service.checkId(id)) {
			ajaxResponse = "true";
		}

		return ajaxResponse;
	}
}
