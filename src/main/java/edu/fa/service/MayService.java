package edu.fa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.fa.model.May;
import edu.fa.repository.MayRepository;

@Service
public class MayService {
	@Autowired
	MayRepository repository;
	
	public Page<May> findAll(int pageNumber) {
    	Pageable pageable = PageRequest.of(pageNumber - 1, 5);
        return repository.findAll(pageable);
    }
	
	public void save(May may) {
		repository.save(may);
	}
	
	public May findById(int id) {
		return repository.findById(id).get();
	}
	
	public Page<May> search(String keyword, int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        return repository.search("%" + keyword + "%", pageable);
    }
	
	public void delete(int id) {
		repository.deleteById(id);
	}
}
