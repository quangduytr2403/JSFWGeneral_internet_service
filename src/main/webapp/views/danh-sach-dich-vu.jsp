<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Danh sach dich-vu</title>
<!-- Boostrap 4 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/danh-sach-dich-vu.css" />
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
				<button class="btn btn-primary" id="them-dich-vu">
					<i class="fas fa-plus mr-3"></i>Them dich vu moi
				</button>
			</div>
		</div>
		<div class="row">
			<div class="col-7 mt-2">
				<h3>Danh sach dich vu</h3>
				<table class="table table-bordered table-hover table-sm mt-3">
					<thead>
						<tr>
							<th>STT</th>
							<th>Ma DV</th>
							<th>Ten DV</th>
							<th>Don vi tinh</th>
							<th>Don gia</th>
							<th>Sua/Xoa</th>
						</tr>
					</thead>
	
					<tbody>
						<%
						int counter = (Integer)request.getAttribute("currentPage") * 5  - 4;
						%>
						<c:forEach items="${danhSachDichVu}" var="dichVu">
							<tr>
								<td><%=counter++%></td>
								<td>${dichVu.maDv}</td>
								<td>${dichVu.tenDv}</td>
								<td>${dichVu.donViTinh}</td>
								<td>${dichVu.donGia}</td>
								<td>
									<button class='btn btn-primary dich-vu-edit'><i class='fas fa-pencil-alt'></i></button> 
									<button class='btn btn-danger dich-vu-delete'><i class='fas fa-trash'> </i></button>
									<div class="modal">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-body">Are you sure to delete this DichVu?</div>
	
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
			<div class="col-5 mt-2" id="edit-form">
				<h3>Chinh sua dich vu</h3>
				<p>${empty editFail ? 'Nhap thong tin dich vu' : editFail}</p>
				<form:form modelAttribute="dichVu" method="POST"> 
					<div class="form-group form-row">
						<form:label path="maDv" class="col-3"><b>Ma dich vu</b></form:label>
						<form:hidden path="maDv" /> 
						<p>${dichVu.maDv}</p>
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
		src="<%=request.getContextPath()%>/resources/js/danh-sach-dich-vu.js"></script>
</body>
</html>