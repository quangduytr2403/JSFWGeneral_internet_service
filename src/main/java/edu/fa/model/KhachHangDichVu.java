package edu.fa.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import edu.fa.id.KhachHangDichVuId;

@Entity
@IdClass(KhachHangDichVuId.class)
public class KhachHangDichVu {
	@Id
	@Column(name = "maKh", columnDefinition = "char(8)")
	@NotBlank(message = "Ma khach hang khong duoc de trong")
	private String maKhachHang;
	
	@ManyToOne
	@JoinColumn(name = "maKh", insertable = false, updatable = false)
	private KhachHang khachHang;
	
	@Id
	@Column(name = "maDv", columnDefinition = "char(6)")
	@NotBlank(message = "Ma dich vu khong duoc de trong")
	private String maDichVu;
	
	@ManyToOne
	@JoinColumn(name = "maDv", insertable = false, updatable = false)
	private DichVu dichVu;
	
	@Id
	@NotNull(message = "Ngay su dung khong de trong")
	@FutureOrPresent(message = "Ngay su dung khong o qua khu")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngaySuDung;
	
	@Id
	@NotBlank(message = "Gio su dung khong de trong")
	@Column(columnDefinition = "time")
	private String gioSuDung;
	
	@NotNull(message = "So luong khong de trong")
	@Min(value = 1, message = "So luong phai la so duong")
	private Integer soLuong;

	public KhachHangDichVu() {
		super();
	}

	public KhachHangDichVu(@NotBlank(message = "Ma khach hang khong duoc de trong") String maKhachHang,
			KhachHang khachHang, @NotBlank(message = "Ma dich vu khong duoc de trong") String maDichVu, DichVu dichVu,
			@NotNull(message = "Ngay su dung khong de trong") @FutureOrPresent(message = "Ngay su dung khong o qua khu") LocalDate ngaySuDung,
			@NotNull(message = "Gio su dung khong de trong") String gioSuDung,
			@NotNull(message = "So luong khong de trong") @Min(value = 1, message = "So luong phai la so duong") Integer soLuong) {
		super();
		this.maKhachHang = maKhachHang;
		this.khachHang = khachHang;
		this.maDichVu = maDichVu;
		this.dichVu = dichVu;
		this.ngaySuDung = ngaySuDung;
		this.gioSuDung = gioSuDung;
		this.soLuong = soLuong;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public String getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public LocalDate getNgaySuDung() {
		return ngaySuDung;
	}

	public void setNgaySuDung(LocalDate ngaySuDung) {
		this.ngaySuDung = ngaySuDung;
	}

	public String getGioSuDung() {
		return gioSuDung;
	}

	public void setGioSuDung(String gioSuDung) {
		this.gioSuDung = gioSuDung;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}
}
