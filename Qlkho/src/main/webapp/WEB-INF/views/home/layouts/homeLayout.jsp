<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href='<c:url value="/assets/css/bootstrap.min.css"/>'>
    <link rel="stylesheet" href='<c:url value="/assets/css/style.css"/> '>
    <link rel="stylesheet" href='<c:url value="/assets/css/home.css"/>'>
    <link rel="stylesheet" href='<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>'>
	<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
</head>

<body>
    <tiles:insertAttribute name="navbar"/>

	<tiles:insertAttribute name="body"/>

	<tiles:insertAttribute name="footer" />
    
    <script src="<c:url value="http://code.jquery.com/jquery-3.2.1.min.js"/>" ></script>
	<script src="<c:url value="/assets/js/popper.min.js"/>"></script>
	<script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/assets/js/sweetalert.min.js"/>"></script>
	<script src="<c:url value="/assets/js/jquery.validate.min.js"/>"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			//khi bàn phím được nhấn và thả ra sẽ chạy phương thức này
			$("#frmRegister").validate({
				rules : {
					email : {
						required : true,
						email : true
					},
					password : {
						required : true,
						minlength : 6
					},
					fullname : {
						required : true,
						minlength : 4
					},
					confirm : {
						required : true,
						equalTo : "#rgPassword"
					},
					roleType : "required"
				},
				messages : {
					email : {
						required : "Vui lòng nhập email!",
						email : "Email không đúng định dạng!"
					},
					password : {
						required : "Vui lòng nhập mật khẩu!",
						minlength : "Mật khẩu phải có ít nhất 6 ký tự!"
					},
					fullname : {
						required : "Vui lòng nhập họ tên!",
						minlength : "Họ tên có ít nhất 4 ký tự!"
					},
					confirm : {
						required : "Vui lòng nhập lại mật khẩu!",
						equalTo : "Mật khẩu không trùng khớp!"
					},
					roleType : "Vui lòng chọn loại tài khoản!"
				},
				submitHandler : function(form) {
					$("#frmRegister").submit(function(e) {
						e.preventDefault();
						var data = {
								fullname: $('#rgFullname').val(),
								email: $('#rgEmail').val(),
								password: $('#rgPassword').val(),
								address: $('#rgAddress').val(),
								phone: $('#rgPhone').val(),
								roleType: $('#rgRoleType').val()
						}
						$.ajax({
							url: $(this).attr('action'),
							type: 'POST',
							data: JSON.stringify(data),
							dataType: 'json',
							contentType: 'application/json',
							success: function(res) {
								if(res.status === 'true'){
									swal("Thành công!", res.message, "success");
								}
								else{
									swal("Thất bại!", res.message, "error");
								}
							},
							error: function(err) {
								console.log(err)
							}
						})
					})
				}
			});
		});
	</script>
</body>
</html>