package edu.fa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class May implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer maMay;
	
	@NotBlank(message = "Vi tri khong duoc de trong")
	private String viTri;
	
	private String trangThai;
	
	public May() {
		super();
	}
	
	public May(String viTri, String trangThai) {
		super();
		this.viTri = viTri;
		this.trangThai = trangThai;
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
}
