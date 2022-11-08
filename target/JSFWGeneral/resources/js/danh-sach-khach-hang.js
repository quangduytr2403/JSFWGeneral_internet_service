$(document).ready(function() {
	var href = window.location.href;
	
	//Hien menu
	$(".nav-item:nth-child(2)").addClass("active");
	
	//Search
	$('#search').click(function() {
		var key = $(this).prev().val();
		$(location).prop('href', '../tim-khach-hang/1?keyword=' + key);
	})
	
	//Hien form
	if(href.indexOf("edit-id") == -1) {
		$("#edit-form").attr("style", "display: none"); 
	}
	
	//Them khach hang
	$("#them-khach-hang").click(function(){
		$(location).prop('href','../them-khach-hang-moi');
	});
	
	//Mo edit
	$(".khach-hang-edit").click(function() {
		var id = $(this).parent().prev().prev().prev().prev().prev().text();
		var hrefTmp = href;
		hrefTmp = hrefTmp.substring(0, hrefTmp.indexOf("?"));
		$(location).prop('href', hrefTmp + '?edit-id=' + id);
	});
	
	//Xoa khach hang
	$(".khach-hang-delete").click(function() {
		$(this).next().attr("style", "display: block");
	});

	$(".no-confirm").click(function() {
		$(".modal").attr("style", "display: none");
	});

	$(".yes-confirm").click(function() {
		$(".modal").attr("style", "display: none");
		var id = $(this).parent().parent().parent().parent().parent().prev().prev().prev().prev().prev().text();
		$(location).prop('href', "../xoa-khach-hang?id=" + id);
	});
});
