package edu.fa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.model.DichVu;
import edu.fa.model.KhachHangDichVu;
import edu.fa.repository.DichVuRepository;
import edu.fa.repository.KhachHangDichVuRepository;
import edu.fa.repository.KhachHangRepository;

@Service
public class KhachHangDichVuService {
	@Autowired
	KhachHangDichVuRepository khachHangDichVuRepository;
	
	@Autowired
	DichVuRepository dichVuRepository;
	
	@Autowired
	KhachHangRepository khachHangRepository;
	
	public List<DichVu> findAllDichVu() {
		return dichVuRepository.findAll();
	}
	
	public boolean checkKhachHangByMaKh(String maKh) {
		return khachHangRepository.findById(maKh).isPresent();
	}
	
	public void save(KhachHangDichVu khachHangDichVu) {
		khachHangDichVuRepository.save(khachHangDichVu);
	}
}
