<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Them dich vu moi</title>
<!-- Boostrap 4 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/them-dich-vu-moi.css" />
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-6 offset-3 mt-2">
				<div class="d-flex justify-content-center">
					<h3>THEM DICH VU MOI</h3>
				</div>
				<div class="d-flex justify-content-center">
					<p>${empty addFail ? 'Nhap thong tin dich vu' : addFail}</p>
				</div>
				<form:form action="them-dich-vu-moi" modelAttribute="dichVu" method="POST">
					<div class="form-group form-row">
						<form:label path="maDv" class="col-3"><b>Ma dich vu</b></form:label> 
						<form:input path="maDv"
							class="form-control col-7"
							placeholder="Nhap ma dich vu"/>
						<p class="offset-3 mb-0"><form:errors path="maDv" cssClass="error"/></p>
					</div>
					<div class="form-group form-row">
						<form:label path="tenDv" class="col-3"><b>Ten dich vu</b></form:label> 
						<form:input path="tenDv"
							class="form-control col-7"
							placeholder="Nhap ten dich vu"/>
						<p class="offset-3 mb-0"><form:errors path="tenDv" cssClass="error"/></p>
					</div>
					<div class="form-group form-row">
						<form:label path="donViTinh" class="col-3"><b>Don vi tinh</b></form:label> 
						<form:select path="donViTinh"
							class="form-control col-7">
							<form:option value="" label="---------"></form:option>
							<form:option value="Cai" label="Cai"></form:option>
							<form:option value="Dia" label="Dia"></form:option>
							<form:option value="Goi" label="Goi"></form:option>
							<form:option value="To" label="To"></form:option>
							<form:option value="Ly" label="Ly"></form:option>
						</form:select>
						<p class="offset-3 mb-0"><form:errors path="donViTinh" cssClass="error"/></p>
					</div>
					<div class="form-group form-row">
						<form:label path="donGia" class="col-3"><b>Don gia</b></form:label> 
						<form:input path="donGia" type="number"
							class="form-control col-7"
							placeholder="Nhap don gia"/>
						<p class="offset-3 mb-0"><form:errors path="donGia" cssClass="error"/></p>
					</div>
					<div class="d-flex justify-content-center">
						<form:button type="submit" class="btn btn-success mb-3">Chinh sua dich vu</form:button>
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
		src="<%=request.getContextPath()%>/resources/js/them-dich-vu-moi.js"></script>
</body>
</html>