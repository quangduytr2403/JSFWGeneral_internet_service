<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dang ky su dung may</title>
<!-- Boostrap 4 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-6 offset-3 mt-2">
				<div class="d-flex justify-content-center">
					<h3>DANG KY SU DUNG MAY</h3>
				</div>
				<div class="d-flex justify-content-center">
					<p>${empty addFail ? (empty addSuccess ? 'Nhap thong tin dang ky' : addSuccess) : addFail}</p>
				</div>
				<form:form action="dang-ky-may" modelAttribute="khachHangMay" method="POST">
					<div class="form-group form-row">
						<form:label path="maKhachHang" class="col-3"><b>Ma khach hang</b></form:label> 
						<form:input path="maKhachHang"
							class="form-control col-7"
							placeholder="Nhap ma khach hang"/>
						<p class="offset-3 mb-0"><form:errors path="maKhachHang" cssClass="error"/></p>
						<p class="mb-0"><span class="error">${maKhNotExist}</span></p>
					</div>
					<div class="form-group form-row">
						<form:label path="maMayTinh" class="col-3"><b>Ma may</b></form:label>
						<form:select path="maMayTinh" class="form-control col-7">
							<form:option value="" label="----Chon may----" ></form:option>
							<form:options items="${danhSachMay}" itemLabel="maMay" itemValue="maMay"></form:options>
						</form:select>
						<p class="offset-3 mb-0"><form:errors path="maMayTinh" cssClass="error"/></p>
					</div>
					<div class="form-group form-row">
						<form:label path="ngayBatDauSuDung" class="col-3"><b>Ngay bat dau SD</b></form:label> 
						<form:input path="ngayBatDauSuDung" type="date"
							class="form-control col-7" />
						<p class="offset-3 mb-0"><form:errors path="ngayBatDauSuDung" cssClass="error"/></p>
					</div>
					<div class="form-group form-row">
						<form:label path="gioBatDauSuDung" class="col-3"><b>Gio bat dau SD</b></form:label> 
						<form:input path="gioBatDauSuDung" type="time"
							class="form-control col-7"/>
						<p class="offset-3 mb-0"><form:errors path="gioBatDauSuDung" cssClass="error"/></p>
					</div>
					<div class="form-group form-row">
						<form:label path="thoiGianSuDung" class="col-3"><b>Thoi gian SD</b></form:label> 
						<form:input path="thoiGianSuDung" type="number"
							class="form-control col-7"
							placeholder="Nhap thoi gian su dung"/>
						<p class="offset-3 mb-0"><form:errors path="thoiGianSuDung" cssClass="error"/></p>
					</div>
					<div class="d-flex justify-content-center">
						<form:button type="submit" class="btn btn-success mb-3">Dang ky</form:button>
					</div>
				</form:form>
			</div>
		</div>
	</div>

	<!-- Bootstrap 4 -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<!-- Fontwesome 5 -->
	<script src="https://kit.fontawesome.com/a12342cbee.js"
		crossorigin="anonymous"></script>

	<script
		src="<%=request.getContextPath()%>/resources/js/dang-ky-may.js"></script>
</body>
</html>