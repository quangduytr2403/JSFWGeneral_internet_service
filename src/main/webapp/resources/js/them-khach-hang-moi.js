$(document).ready(function() {
	$(".nav-item:nth-child(2)").addClass("active");
	
	if(id !== ''){
		var id = $("#maKh").val();

		$.get({
			url: "/JSFWGeneral/check-id",
			data: {
				id: id
			},
			success: function(response) {
				if(response === "true") {
					$("#exist-maKh").html("<span style='color:red'>Ma khach hang bi trung</span>");
				} else {
					$("#exist-maKh").html("");
				}
			}
		});
	}
	
	$("#maKh").on('input', function() {
		var id = $("#maKh").val();
		console.log(id);

		$.get({
			url: "/JSFWGeneral/check-id",
			data: {
				id: id
			},
			success: function(response) {
				if(response === "true") {
					$("#exist-maKh").html("<span style='color:red'>Ma khach hang bi trung</span>");
				} else {
					$("#exist-maKh").html("");
				}
			}
		});
	});
	
	$("#khachHang").on('submit', function (e){
		if($("#exist-maKh").html() === '<span style="color:red">Ma khach hang bi trung</span>') {
			e.preventDefault();	
		}
	});
});
