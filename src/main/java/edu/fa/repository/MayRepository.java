package edu.fa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.fa.model.May;

public interface MayRepository extends JpaRepository<May, Integer>{
	@Query("SELECT m FROM May m WHERE m.viTri LIKE ?1"
            + " OR m.trangThai LIKE ?1")
    public Page<May> search(String keyword, Pageable pageable);
	
	public List<May> findByTrangThai(String trangThai);
}
