package edu.fa.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class ThongKe implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String maKh;
	private String tenKh;
	private Integer maMay;
	private String viTri;
	private String trangThai;
	private LocalDate ngayBatDauSuDung;
	private String gioBatDauSuDung;
	private Integer thoiGianSuDung;
	private String maDv;
	private LocalDate ngaySuDung;
	private String gioSuDung;
	private Integer donGia;
	private Integer soLuong;
	private String tongTien;
	
	public ThongKe() {
		super();
	}

	public ThongKe(String maKh, String tenKh, Integer maMay, String viTri, String trangThai, LocalDate ngayBatDauSuDung,
			String gioBatDauSuDung, Integer thoiGianSuDung, String maDv, LocalDate ngaySuDung, String gioSuDung,
			Integer soLuong, Integer donGia) {
		super();
		this.maKh = maKh;
		this.tenKh = tenKh;
		this.maMay = maMay;
		this.viTri = viTri;
		this.trangThai = trangThai;
		this.ngayBatDauSuDung = ngayBatDauSuDung;
		this.gioBatDauSuDung = gioBatDauSuDung.substring(0,5);
		this.thoiGianSuDung = thoiGianSuDung;
		this.maDv = maDv;
		this.ngaySuDung = ngaySuDung;
		this.gioSuDung = gioSuDung == null ? "" : gioSuDung.substring(0,5);
		this.soLuong = soLuong;
		this.tongTien = soLuong == null ? "0" : NumberFormat.getInstance(new Locale("en", "US")).format(soLuong * donGia) + " d";
	}

	public String getMaKh() {
		return maKh;
	}
	
	public void setMaKh(String maKh) {
		this.maKh = maKh;
	}
	
	public String getTenKh() {
		return tenKh;
	}
	
	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}
	
	public Integer getMaMay() {
		return maMay;
	}
	
	public void setMaMay(Integer maMay) {
		this.maMay = maMay;
	}
	
	public String getViTri() {
		return viTri;
	}
	
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	
	public String getTrangThai() {
		return trangThai;
	}
	
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
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
	
	public String getMaDv() {
		return maDv;
	}
	
	public void setMaDv(String maDv) {
		this.maDv = maDv;
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
	
	public String getTongTien() {
		return tongTien;
	}
	
	public void setTongTien(String tongTien) {
		this.tongTien = tongTien;
	}

	public Integer getDonGia() {
		return donGia;
	}

	public void setDonGia(Integer donGia) {
		this.donGia = donGia;
	}
}
