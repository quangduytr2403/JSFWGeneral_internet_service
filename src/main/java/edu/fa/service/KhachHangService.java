package edu.fa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import edu.fa.model.KhachHang;
import edu.fa.repository.KhachHangRepository;

@Controller
public class KhachHangService {
	@Autowired
	KhachHangRepository repository;
	
	public Page<KhachHang> findAll(int pageNumber) {
    	Pageable pageable = PageRequest.of(pageNumber - 1, 5);
        return repository.findAll(pageable);
    }
	
	public void save(KhachHang khachHang) {
		repository.save(khachHang);
	}
	
	public KhachHang findById(String id) {
		return repository.findById(id).get();
	}
	
	public Page<KhachHang> search(String keyword, int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        return repository.search("%" + keyword + "%", pageable);
    }
	
	public void delete(String id) {
		repository.deleteById(id);
	}
	
	public boolean checkId(String id) {
		return repository.findById(id).isPresent();
	}
}
