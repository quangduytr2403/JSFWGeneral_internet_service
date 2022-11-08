package edu.fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fa.id.KhachHangDichVuId;
import edu.fa.model.KhachHangDichVu;

public interface KhachHangDichVuRepository extends JpaRepository<KhachHangDichVu, KhachHangDichVuId>{

}
