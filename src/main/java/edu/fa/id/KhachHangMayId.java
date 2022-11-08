package edu.fa.id;

import java.io.Serializable;
import java.time.LocalDate;

public class KhachHangMayId implements Serializable {
	private static final long serialVersionUID = 1L;

	private String maKhachHang;
	private Integer maMayTinh;
	private LocalDate ngayBatDauSuDung;
	private String gioBatDauSuDung;

	public KhachHangMayId() {
		super();
	}

	public KhachHangMayId(String maKhachHang, Integer maMayTinh, LocalDate ngayBatDauSuDung,
			String gioBatDauSuDung) {
		super();
		this.maKhachHang = maKhachHang;
		this.maMayTinh = maMayTinh;
		this.ngayBatDauSuDung = ngayBatDauSuDung;
		this.gioBatDauSuDung = gioBatDauSuDung;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public Integer getMaMayTinh() {
		return maMayTinh;
	}

	public void setMaMay(Integer maMay) {
		this.maMayTinh = maMay;
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
}
