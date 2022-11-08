package edu.fa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.fa.model.KhachHangMay;
import edu.fa.model.May;
import edu.fa.service.KhachHangMayService;

@Controller
public class KhachHangMayController {
	@Autowired
	KhachHangMayService khachHangMayService;

	@GetMapping("/dang-ky-may")
	public String showDangKyMay(Model model) {
		KhachHangMay khachHangMay = new KhachHangMay();
		List<May> danhSachMay = khachHangMayService.findAllAvailableMay();
		
		model.addAttribute("danhSachMay", danhSachMay);
		model.addAttribute("khachHangMay", khachHangMay);
		return "dang-ky-may";
	}

	@PostMapping("/dang-ky-may")
	public String dangKyMay(@Valid @ModelAttribute("khachHangMay") KhachHangMay khachHangMay,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			List<May> danhSachMay = khachHangMayService.findAllAvailableMay();
			
			model.addAttribute("danhSachMay", danhSachMay);
			model.addAttribute("addFail", "Dang ky khong thanh cong");
	
			return "dang-ky-may";
		} else if (!khachHangMayService.checkKhachHangByMaKh(khachHangMay.getMaKhachHang())) {
			List<May> danhSachMay = khachHangMayService.findAllAvailableMay();
			model.addAttribute("addFail", "Dang ky khong thanh cong");
			model.addAttribute("maKhNotExist", "Ma Kh khong ton tai");
			model.addAttribute("danhSachMay", danhSachMay);
			return "dang-ky-may";
		} 
		
		//Dang ky dich vu
		khachHangMayService.save(khachHangMay);
		List<May> danhSachMay = khachHangMayService.findAllAvailableMay();
		model.addAttribute("danhSachMay", danhSachMay);
		model.addAttribute("addSuccess", "Dang ky thanh cong");
		return "dang-ky-may";
	}
}
