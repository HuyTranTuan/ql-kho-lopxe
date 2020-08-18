<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- LOGIN MODAL -->
<div class="modal fade" id="loginModal" role="dialog" tabindex="-1" aria-labelledby="modelTitleId" aria-hidden="true">
	<div class="modal-dialog modal-md" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Đăng nhập</h4>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			</div>
			<div class="modal-body">
				<c:url value="/account/login" var="login"/>
				<form action="${ login }" id="frmLogin" method="post">
					<div class="form-group">
						<label for="email">Email</label> <input type="email" class="form-control" id="dnEmail" placeholder="Email">
					</div>
					<div class="form-group">
						<label for="password">Mật khẩu</label> <input type="password" class="form-control" id="dnPassword" placeholder="Mật khẩu">
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary" id="btnDangNhapSubmit">Đăng nhập</button>
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>


<!-- REGISTER MODAL -->
<div class="modal fade" id="registerModal" role="dialog" tabindex="-1" aria-labelledby="modelTitleId" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Đăng ký</h4>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			</div>
			<div class="modal-body">
				<form action='<c:url value="/account/register" />' id="frmRegister" method="post">
					<div class="form-group">
						<label for="fullname">Họ tên</label> 
						<input type="text" class="form-control" name="fullname" id="rgFullname" placeholder="Họ tên">
					</div>
					<div class="form-group">
						<label for="email">Email</label> 
						<input type="email" class="form-control" name="email" id="rgEmail" placeholder="Email">
					</div>
					<div class="form-group">
						<label for="phone">Số điện thoại</label> 
						<input type="text" class="form-control" name="phone" id="rgPhone" placeholder="Số điện thoại">
					</div>
					<div class="form-group">
						<label for="address">địa chỉ</label> 
						<input type="text" class="form-control" name="address" id="rgAddress" placeholder="Địa chỉ">
					</div>
					<div class="form-group">
						<label for="password">Mật khẩu</label> 
						<input type="password" class="form-control" id="rgPassword" name="password" placeholder="Mật khẩu">
					</div>
					<div class="form-group">
						<label for="confirm">Nhập lại mật khẩu</label> 
						<input type="password" class="form-control" name="confirm" id="rgConfirm" placeholder="Nhập lại mật khẩu">
					</div> 
					<div class="form-group">
						<label for="roleType">Loại thành viên</label> 
						<select class="form-control" name="roleType" id="rgRoleType">
							<option value="">-- Chọn loại tài khoản --</option>
							<option value="USER">Nhân viên</option>
							<option value="USER2">Nhân viên cấp cao</option>
						</select>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary" id="btnDangKySubmit">Đăng ký</button>
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>