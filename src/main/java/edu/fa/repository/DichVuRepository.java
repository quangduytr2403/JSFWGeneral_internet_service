package edu.fa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.fa.model.DichVu;

public interface DichVuRepository extends JpaRepository<DichVu, String>{
	@Query("SELECT d FROM DichVu d WHERE d.tenDv LIKE ?1")
    public Page<DichVu> search(String keyword, Pageable pageable);
}
