package edu.fa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.fa.model.KhachHang;
import edu.fa.model.ThongKe;

public interface KhachHangRepository extends JpaRepository<KhachHang, String>{
	@Query("SELECT k FROM KhachHang k WHERE k.tenKh LIKE ?1"
            + " OR k.diaChi LIKE ?1 OR k.soDienThoai LIKE ?1 OR k.diaChiEmail LIKE ?1")
    public Page<KhachHang> search(String keyword, Pageable pageable);
	
	
	@Query("SELECT new edu.fa.model.ThongKe(k.maKh, k.tenKh, km.maMayTinh, m.viTri, m.trangThai, "
			+ "km.ngayBatDauSuDung, km.gioBatDauSuDung, km.thoiGianSuDung, "
			+ "kd.maDichVu, kd.ngaySuDung, kd.gioSuDung, kd.soLuong, d.donGia) "
			+"FROM KhachHangMay km JOIN km.khachHang k JOIN km.may m LEFT JOIN KhachHangDichVu kd ON kd.maKhachHang = k.maKh "
			+ "LEFT JOIN kd.dichVu d")
	public Page<ThongKe> join(Pageable pageable);
}
