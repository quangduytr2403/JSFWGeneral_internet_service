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

import edu.fa.model.DichVu;
import edu.fa.model.KhachHangDichVu;
import edu.fa.service.KhachHangDichVuService;

@Controller
public class KhachHangDichVuController {
	@Autowired
	KhachHangDichVuService khachHangDichVuService;

	@GetMapping("/dang-ky-dich-vu")
	public String showDangKyDichVu(Model model) {
		KhachHangDichVu khachHangDichVu = new KhachHangDichVu();
		List<DichVu> danhSachDichVu = khachHangDichVuService.findAllDichVu();
		
		model.addAttribute("danhSachDichVu", danhSachDichVu);
		model.addAttribute("khachHangDichVu", khachHangDichVu);
		return "dang-ky-dich-vu";
	}

	@PostMapping("/dang-ky-dich-vu")
	public String dangKyDichVu(@Valid @ModelAttribute("khachHangDichVu") KhachHangDichVu khachHangDichVu,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			List<DichVu> danhSachDichVu = khachHangDichVuService.findAllDichVu();
			
			model.addAttribute("danhSachDichVu", danhSachDichVu);
			model.addAttribute("addFail", "Dang ky khong thanh cong");
	
			return "dang-ky-dich-vu";
		} else if (!khachHangDichVuService.checkKhachHangByMaKh(khachHangDichVu.getMaKhachHang())) {
			List<DichVu> danhSachDichVu = khachHangDichVuService.findAllDichVu();
			model.addAttribute("addFail", "Dang ky khong thanh cong");
			model.addAttribute("maKhNotExist", "Ma Kh khong ton tai");
			model.addAttribute("danhSachDichVu", danhSachDichVu);
			return "dang-ky-dich-vu";
		} 
		
		//Dang ky dich vu
		khachHangDichVuService.save(khachHangDichVu);
		List<DichVu> danhSachDichVu = khachHangDichVuService.findAllDichVu();
		model.addAttribute("danhSachDichVu", danhSachDichVu);
		model.addAttribute("addSuccess", "Dang ky thanh cong");
		return "dang-ky-dich-vu";
	}
}
