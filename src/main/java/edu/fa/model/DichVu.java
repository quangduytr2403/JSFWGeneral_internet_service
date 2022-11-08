package edu.fa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import edu.fa.utils.Constants;

@Entity
public class DichVu {
	@Id
	@NotBlank(message = "Ma Dv khong duoc de trong")
	@Pattern(regexp = Constants.MADV_REGEX, message = "Ma Dv sai mau")
	@Column(columnDefinition = "char(6)")
	private String maDv;
	
	@NotBlank(message = "Ten Dv khong duoc de trong")
	private String tenDv;
	
	@NotBlank(message = "Don vi tinh khong duoc de trong")
	private String donViTinh;
	
	@NotNull(message = "Don gia khong duoc de trong")
	@Min(value = 1, message = "Don gia phai lon hon 0")
	private Integer donGia;
	
	public DichVu() {
		super();
	}
	
	public DichVu(String tenDv, String donViTinh, Integer donGia) {
		super();
		this.tenDv = tenDv;
		this.donViTinh = donViTinh;
		this.donGia = donGia;
	}

	public String getMaDv() {
		return maDv;
	}
	
	public void setMaDv(String maDv) {
		this.maDv = maDv;
	}
	
	public String getTenDv() {
		return tenDv;
	}
	
	public void setTenDv(String tenDv) {
		this.tenDv = tenDv;
	}
	
	public String getDonViTinh() {
		return donViTinh;
	}
	
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	
	public Integer getDonGia() {
		return donGia;
	}
	
	public void setDonGia(Integer donGia) {
		this.donGia = donGia;
	}
}
