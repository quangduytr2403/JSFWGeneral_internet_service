<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Them may moi</title>
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
					<h3>THEM MAY MOI</h3>
				</div>
				<div class="d-flex justify-content-center">
					<p>${empty addFail ? 'Nhap thong tin may' : addFail}</p>
				</div>
				<form:form action="them-may-moi" modelAttribute="may" method="POST">
					<div class="form-group form-row">
						<form:label path="viTri" class="col-3"><b>Vi tri</b></form:label> 
						<form:input path="viTri"
							class="form-control col-7"
							placeholder="Nhap vi tri"/>
						<p class="offset-3 mb-0"><form:errors path="viTri" cssClass="error"/></p>
					</div>
					<div class="form-group form-row">
						<form:label path="trangThai" class="col-3"><b>Trang thai</b></form:label>
						<div class="col-7"> 
							<form:radiobutton path="trangThai" value="Dung duoc" label="Dung duoc" class="mr-2" checked="checked" />
							<form:radiobutton path="trangThai" value="Dang sua chua" label="Dang sua chua" class="mx-2"/>
						</div>
					</div>
					<div class="d-flex justify-content-center">
						<form:button type="submit" class="btn btn-success mb-3">Them may</form:button>
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
		src="<%=request.getContextPath()%>/resources/js/them-may-moi.js"></script>
</body>
</html>