package edu.fa.id;

import java.io.Serializable;
import java.time.LocalDate;

public class KhachHangDichVuId implements Serializable {
	private static final long serialVersionUID = 1L;

	private String maKhachHang;
	private String maDichVu;
	private LocalDate ngaySuDung;
	private String gioSuDung;
	
	public KhachHangDichVuId() {
		super();
	}

	public KhachHangDichVuId(String maKhachHang, String maDichVu, LocalDate ngaySuDung, String gioSuDung) {
		super();
		this.maKhachHang = maKhachHang;
		this.maDichVu = maDichVu;
		this.ngaySuDung = ngaySuDung;
		this.gioSuDung = gioSuDung;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}
	
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	
	public String getMaDichVu() {
		return maDichVu;
	}
	
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
