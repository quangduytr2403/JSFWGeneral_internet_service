package edu.fa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.model.KhachHangMay;
import edu.fa.model.May;
import edu.fa.repository.KhachHangMayRepository;
import edu.fa.repository.KhachHangRepository;
import edu.fa.repository.MayRepository;

@Service
public class KhachHangMayService {
	@Autowired
	KhachHangMayRepository khachHangMayRepository;
	
	@Autowired
	MayRepository mayRepository;
	
	@Autowired
	KhachHangRepository khachHangRepository;
	
	public List<May> findAllAvailableMay() {
		return mayRepository.findByTrangThai("Dung duoc");
	}
	
	public boolean checkKhachHangByMaKh(String maKh) {
		return khachHangRepository.findById(maKh).isPresent();
	}
	
	public void save(KhachHangMay khachHangMay) {
		khachHangMayRepository.save(khachHangMay);
	}
}
