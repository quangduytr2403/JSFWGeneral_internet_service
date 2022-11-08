<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Danh sach khach hang</title>
<!-- Boostrap 4 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/danh-sach-khach-hang.css" />
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container-fluid">
		<div class="row"> 
			<div class="col-6 offset-3 pt-3 d-flex justify-content-center"> 
				<div class="input-group mr-3">
    				<input type="text" class="form-control" placeholder="Search"/>
    				<div class="input-group-append" id="search">
      					<span class="input-group-text"><i class="fas fa-search"></i></span>
    				</div>
  				</div>
				<button class="btn btn-primary" id="them-khach-hang">
					<i class="fas fa-plus mr-3"></i>Them khach hang moi
				</button>
			</div>
		</div>
		<div class="row">
			<div class="col-7 mt-2">
				<h3>Danh sach khach hang</h3>
				<table class="table table-bordered table-hover table-sm mt-3">
					<thead>
						<tr>
							<th>STT</th>
							<th>Ma KH</th>
							<th>Ten KH</th>
							<th>Dia chi</th>
							<th>SDT</th>
							<th>Email</th>
							<th>Sua/Xoa</th>
						</tr>
					</thead>
	
					<tbody>
						<%
						int counter = (Integer)request.getAttribute("currentPage") * 5  - 4;
						%>
						<c:forEach items="${danhSachKhachHang}" var="khachHang">
							<tr>
								<td><%=counter++%></td>
								<td>${khachHang.maKh}</td>
								<td>${khachHang.tenKh}</td>
								<td>${khachHang.diaChi}</td>
								<td>${khachHang.soDienThoai}</td>
								<td>${khachHang.diaChiEmail}</td>
								<td>
									<button class='btn btn-primary khach-hang-edit'><i class='fas fa-pencil-alt'></i></button> 
									<button class='btn btn-danger khach-hang-delete'><i class='fas fa-trash'> </i></button>
									<div class="modal">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-body">Are you sure to delete this KhachHang?</div>
	
												<div class="modal-footer">
													<button type="button" class="btn btn-danger yes-confirm">Yes</button>
													<button type="button" class="btn btn-success no-confirm">No</button>
												</div>
											</div>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="d-flex justify-content-center"> 
					Tong so: ${totalItems} - Page ${currentPage} of ${totalPages} 
				</div>
				<div class="d-flex justify-content-center">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="../khach-hang/1">First</a></li>
						<c:choose>
							<c:when test="${currentPage != 1}">
								<li class="page-item"><a class="page-link" href="../khach-hang/${currentPage - 1}">Previous</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link">Previous</a></li>
							</c:otherwise>
						</c:choose>
						<c:forEach var="counter" begin="1" end="${totalPages}">
							<c:choose>
								<c:when test="${currentPage != counter}">
									<li class="page-item"><a class="page-link" href="../khach-hang/${counter}">${counter}</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link">${counter}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${currentPage != totalPages}">
								<li class="page-item"><a class="page-link" href="../khach-hang/${currentPage + 1}">Next</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link">Next</a></li>
							</c:otherwise>
						</c:choose>
						<li class="page-item"><a class="page-link" href="../khach-hang/${totalPages}">Last</a></li> 
					</ul>
				</div>
			</div>
			<div class="col-5 mt-2" id="edit-form">
				<h3>Chinh sua khach hang</h3>
				<p>${empty editFail ? 'Nhap thong tin khach hang' : editFail}</p>
				<form:form modelAttribute="khachHang" method="POST"> 
					<div class="form-group form-row">
						<form:label path="maKh" class="col-3"><b>Ma khach hang</b></form:label>
						<form:hidden path="maKh" /> 
						<p>${khachHang.maKh}</p>
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
						<form:button type="submit" class="btn btn-success mb-3">Chinh sua khach hang</form:button>
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
		src="<%=request.getContextPath()%>/resources/js/danh-sach-khach-hang.js"></script>
</body>
</html>