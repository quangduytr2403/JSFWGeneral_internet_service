package edu.fa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import edu.fa.utils.Constants;

@Entity
public class KhachHang {
	@Id
	@NotBlank(message = "Ma Kh khong duoc de trong")
	@Pattern(regexp = Constants.MAKH_REGEX, message = "Ma Kh sai mau")
	@Column(columnDefinition = "char(8)")
	private String maKh;
	
	@NotBlank(message = "Ten Kh khong duoc de trong")
	private String tenKh;
	
	@NotBlank(message = "Dia chi khong duoc de trong")
	private String diaChi;
	
	@NotBlank(message = "So dien thoai khong duoc de trong")
	@Pattern(regexp = Constants.SODIENTHOAI_REGEX, message = "So dien thoai sai mau")
	private String soDienThoai;
	
	@NotBlank(message = "Dia chi email khong duoc de trong")
	@Pattern(regexp = Constants.EMAIL_REGEX, message = "Dia chi email sai mau")
	private String diaChiEmail;
	
	public KhachHang() {
		super();
	}

	public KhachHang(String maKh, String tenKh, String diaChi, String soDienThoai, String diaChiEmail) {
		super();
		this.maKh = maKh;
		this.tenKh = tenKh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.diaChiEmail = diaChiEmail;
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
	
	public String getDiaChi() {
		return diaChi;
	}
	
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public String getSoDienThoai() {
		return soDienThoai;
	}
	
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	
	public String getDiaChiEmail() {
		return diaChiEmail;
	}
	
	public void setDiaChiEmail(String diaChiEmail) {
		this.diaChiEmail = diaChiEmail;
	}
}
