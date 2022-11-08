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

import edu.fa.id.KhachHangMayId;

@Entity
@IdClass(KhachHangMayId.class)
public class KhachHangMay {
	@Id
	@Column(name = "maKh", columnDefinition = "char(8)")
	@NotBlank(message = "Ma khach hang khong duoc de trong")
	private String maKhachHang;
	
	@ManyToOne
	@JoinColumn(name = "maKh", insertable = false, updatable = false)
	private KhachHang khachHang;
	
	@Id
	@Column(name = "maMay")
	@NotNull(message = "Ma may khong duoc de trong")
	private Integer maMayTinh;
	
	@ManyToOne 
	@JoinColumn(name = "maMay", insertable = false, updatable = false)
	private May may;
	
	@Id
	@NotNull(message = "Ngay bat dau su dung khong de trong")
	@FutureOrPresent(message = "Ngay bat dau su dung khong o qua khu")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngayBatDauSuDung;
	
	@Id
	@NotBlank(message = "Gio bat dau su dung khong de trong")
	@Column(columnDefinition = "time")
	private String gioBatDauSuDung;
	
	@NotNull(message = "Thoi gian su dung khong de trong")
	@Min(value = 1, message = "Thoi gian su dung phai la so duong")
	private Integer thoiGianSuDung;
	
	public KhachHangMay() {
		super();
	}

	public KhachHangMay(@NotNull(message = "Ma khach hang khong duoc de trong") String maKhachHang, KhachHang khachHang,
			@NotNull(message = "Ma may khong duoc de trong") Integer maMayTinh, May may,
			@NotNull(message = "Ngay bat dau su dung khong de trong") LocalDate ngayBatDauSuDung,
			@NotNull(message = "Gio bat dau su dung khong de trong") String gioBatDauSuDung,
			@NotNull(message = "Thoi gian su dung khong de trong") @Min(value = 1, message = "Thoi gian su dung phai la so duong") Integer thoiGianSuDung) {
		super();
		this.maKhachHang = maKhachHang;
		this.khachHang = khachHang;
		this.maMayTinh = maMayTinh;
		this.may = may;
		this.ngayBatDauSuDung = ngayBatDauSuDung;
		this.gioBatDauSuDung = gioBatDauSuDung;
		this.thoiGianSuDung = thoiGianSuDung;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKh) {
		this.maKhachHang = maKh;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public May getMay() {
		return may;
	}

	public void setMay(May may) {
		this.may = may;
	}

	public LocalDate getNgayBatDauSuDung() {
		return ngayBatDauSuDung;
	}

	public void setNgayBatDauSuDung(LocalDate ngayBatDauSuDung) {
		this.ngayBatDauSuDung = ngayBatDauSuDung;
	}

	public String getGioBatDauSuDung() {
		return gioBatDauSuDung;
	}

	public void setGioBatDauSuDung(String gioBatDauSuDung) {
		this.gioBatDauSuDung = gioBatDauSuDung;
	}

	public Integer getThoiGianSuDung() {
		return thoiGianSuDung;
	}

	public void setThoiGianSuDung(Integer thoiGianSuDung) {
		this.thoiGianSuDung = thoiGianSuDung;
	}

	public Integer getMaMayTinh() {
		return maMayTinh;
	}

	public void setMaMayTinh(Integer maMay) {
		this.maMayTinh = maMay;
	}
}
