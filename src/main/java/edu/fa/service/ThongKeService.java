package edu.fa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.fa.model.ThongKe;
import edu.fa.repository.KhachHangRepository;

@Service
public class ThongKeService {
	@Autowired
	KhachHangRepository repository;
	
	public Page<ThongKe> join(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        return repository.join(pageable);
	} 
}
