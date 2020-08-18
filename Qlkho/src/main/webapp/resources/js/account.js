//var roleApi = "/Elearning/role";

$(function() {
//	$.ajax({
//		url: $('#roleApi').val(),
//		type: 'GET',
//		dataType: 'JSON',
//		success: function(data){
//			console.log(data);
//			//Khai báo chuỗi chứa các option
//			var html= '';
//			data.forEach(function(role, index) {
//				html += `<option value="${role.id}">${role.description}></option>`;
//			});
//			// Thay thế option của thẻ select bằng option tạo ra từ javascript
//			$('#roleId').html(html);
//		},
//		error: function(err){
//			console.log(err);
//		}
//	}),
	
	$('#frmLogin').submit(function() {
		console.log($(this).serialize());
		$.ajax({
			url : $(this).attr('action'),
			type : $(this).attr('method'),
			data : $(this).serialize(),
			success : function(res) {
				if (res) {
					// Trả về true => load lại trang
					location.reload();
				} else {
					swal({
						title : "Thông báo!",
						text : "Sai tên đăng nhập hoặc mật khẩu!",
						icon : "error",
						button : "Đóng",
					});
				}
			},
			error : function(err) {
				console.log(err);
			}
		});

		return false;
	});
});

// Khi bàn phím được nhấn và thả ra 
//thì sẽ chạy phương thức này
$("#frmRegister").validate({
	rules : {
		fullname : {
			required: true,
			minlength: 4
		},
		email : {
			required : true,
			email : true
		},
		password : {
			required : true,
			minlength : 6
		},
		confirm : {
			equalTo : "#rgPassword"
		},
		roleType : "required"
	},
	messages : {
		fullname : {
			required : "Vui lòng nhập họ tên!",
			minlength : "Họ tên ít nhất 4 ký tự!"
		},
		email : {
			required : "Vui lòng nhập email!",
			email : "Email không đúng định dạng!"
		},
		address : {
			required : "Vui lòng nhập địa chỉ!"
		},
		phone : {
			required : "Vui lòng nhập số điện thoại!"
		},
		password : {
			required : 'Vui lòng nhập mật khẩu',
			minlength : 'Vui lòng nhập ít nhất 6 kí tự'
		},
		confirm : {
			equalTo : 'Mật khẩu nhập không khớp!'
		},
		roleType : "Vui lòng chọn lại tài khoản!"
	},
	// Nếu không có lỗi sẽ chạy hàm này
	submitHandler: function(form){
		$("#frmRegister").submit(function(e) {
			e.preventDefault();
			
			var obj = {
					fullname: $('#rgFullname').val(),
					email: $('#rgEmail').val(),
					password: $('#rgPassword').val(),
					confirm: $('#rgConfirm').val(),
					roleId: $('#rgRoleType').val(),
					address: $('#rgAddress').val(),
					phone: $('#rgPhone').val()
			}
			console.log(obj);
			
			$.ajax({
				url: $('#frmRegister').attr('action'),
				type: 'POST',
				data: JSON.stringify(data),
				contentType: 'application/json',
				dataType: 'json',
				success: function(data){
					if(data.status === 'true'){
						swal({
						  title: "Thành công!!",
						  text: data.message,
						  icon: "success",
						});
					}else{
						swal({
						  title: "Thất bại!",
						  text: data.message,
						  icon: "error",
						});
					}
				},
				error: function(err){
					console.log(err);
				}
			})
		})
	}
});
