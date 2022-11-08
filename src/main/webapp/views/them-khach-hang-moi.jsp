<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Them khach hang moi</title>
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
					<h3>THEM KHACH HANG MOI</h3>
				</div>
				<div class="d-flex justify-content-center">
					<p>${empty addFail ? 'Nhap thong tin khach hang' : addFail}</p>
				</div>
				<form:form action="them-khach-hang-moi" modelAttribute="khachHang" method="POST">
					<div class="form-group form-row">
						<form:label path="maKh" class="col-3"><b>Ma khach hang</b></form:label> 
						<form:input path="maKh"
							class="form-control col-7"
							placeholder="Nhap ma khach hang"/>
						<p class="offset-3 mb-0"><form:errors path="maKh" cssClass="error"/></p>
						<p class="mb-0" id="exist-maKh"></p>
					</div>
					<div class="form-group form-row">
						<form:label path="tenKh" class="col-3"><b>Ten khach hang</b></form:label> 
						<form:input path="tenKh"
							class="form-control col-7"
							placeholder="Nhap ten khach hang"/>
						<p class="offset-3 mb-0"><form:errors path="tenKh" cssClass="error"/></p>
					</div>
					<div class="form-group form-row">
						<form:label path="diaChi" class="col-3"><b>Dia chi</b></form:label> 
						<form:input path="diaChi"
							class="form-control col-7"
							placeholder="Nhap dia chi" />
						<p class="offset-3 mb-0"><form:errors path="diaChi" cssClass="error"/></p>
					</div>
					<div class="form-group form-row">
						<form:label path="soDienThoai" class="col-3"><b>So dien thoai</b></form:label> 
						<form:input path="soDienThoai"
							class="form-control col-7"
							placeholder="Nhap so dien thoai" />
						<p class="offset-3 mb-0"><form:errors path="soDienThoai" cssClass="error"/></p>
					</div>
					<div class="form-group form-row">
						<form:label path="diaChiEmail" class="col-3"><b>Dia chi Email</b></form:label> 
						<form:input path="diaChiEmail" type="email"
							class="form-control col-7"
							placeholder="Nhap dia chi email" />
						<p class="offset-3 mb-0"><form:errors path="diaChiEmail" cssClass="error"/></p>
					</div>
					<div class="d-flex justify-content-center">
						<form:button type="submit" class="btn btn-success mb-3" id="add-khach-hang">Them khach hang</form:button>
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
		src="<%=request.getContextPath()%>/resources/js/them-khach-hang-moi.js"></script>
</body>
</html>