package edu.fa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import edu.fa.model.DichVu;
import edu.fa.repository.DichVuRepository;

@Controller
public class DichVuService {
	@Autowired
	DichVuRepository repository;
	
	public Page<DichVu> findAll(int pageNumber) {
    	Pageable pageable = PageRequest.of(pageNumber - 1, 5);
        return repository.findAll(pageable);
    }
	
	public void save(DichVu dichVu) {
		repository.save(dichVu);
	}
	
	public DichVu findById(String id) {
		return repository.findById(id).get();
	}
	
	public Page<DichVu> search(String keyword, int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        return repository.search("%" + keyword + "%", pageable);
    }
	
	public void delete(String id) {
		repository.deleteById(id);
	}
}
