package edu.fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fa.id.KhachHangMayId;
import edu.fa.model.KhachHangMay;

public interface KhachHangMayRepository extends JpaRepository<KhachHangMay, KhachHangMayId>{

}
