<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ket qua tim kiem</title>
<!-- Boostrap 4 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/tim-dich-vu.css" />
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-8 offset-1 mt-2">
				<div class="d-flex justify-content-center">
					<h3 class="mb-0">Ket qua tim kiem Dich vu</h3>
				</div>
				<table class="table table-bordered table-hover table-sm mt-3">
					<thead>
						<tr>
							<th>STT</th>
							<th>Ma DV</th>
							<th>Ten DV</th>
							<th>Don vi tinh</th>
							<th>Don gia</th>
						</tr>
					</thead>
	
					<tbody>
						<%
						int counter = (Integer)request.getAttribute("currentPage") * 10  - 9;
						%>
						<c:forEach items="${danhSachDichVu}" var="dichVu">
							<tr>
								<td><%=counter++%></td>
								<td>${dichVu.maDv}</td>
								<td>${dichVu.tenDv}</td>
								<td>${dichVu.donViTinh}</td>
								<td>${dichVu.donGia}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="d-flex justify-content-center"> 
					Tong so: ${totalItems} - Page ${currentPage} of ${totalPages} 
				</div>
				<div class="d-flex justify-content-center">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="../dich-vu/1">First</a></li>
						<c:choose>
							<c:when test="${currentPage != 1}">
								<li class="page-item"><a class="page-link" href="../dich-vu/${currentPage - 1}">Previous</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link">Previous</a></li>
							</c:otherwise>
						</c:choose>
						<c:forEach var="counter" begin="1" end="${totalPages}">
							<c:choose>
								<c:when test="${currentPage != counter}">
									<li class="page-item"><a class="page-link" href="../dich-vu/${counter}">${counter}</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link">${counter}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${currentPage != totalPages}">
								<li class="page-item"><a class="page-link" href="../dich-vu/${currentPage + 1}">Next</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link">Next</a></li>
							</c:otherwise>
						</c:choose>
						<li class="page-item"><a class="page-link" href="../dich-vu/${totalPages}">Last</a></li> 
					</ul>
				</div>
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
	
	<!-- Change menu -->
	<script
		src="<%=request.getContextPath()%>/resources/js/them-dich-vu-moi.js"></script>
</body>
</html>