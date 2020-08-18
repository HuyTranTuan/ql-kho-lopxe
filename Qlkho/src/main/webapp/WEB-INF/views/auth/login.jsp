<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/admin/login" var="action"/>
<form action="${ action }" method="post" class="md-float-material form-material">
	<div class="auth-box card">
		<div class="card-block">
			<div class="row m-b-20">
				<div class="col-md-12">
					<h3 class="text-center txt-primary">Đăng nhập</h3>
					<h6 class="text-danger txt-center m-0">${ message }</h6>
				</div>
			</div>
			<div class="form-group form-primary">
				<label for="">Email</label>
				<input type="text" name="email" class="form-control">
			</div>
			<div class="form-group form-primary">
				<label for="">Mật khẩu</label>
				<input type="text" name="password" class="form-control">
			</div>
			<div class="row m-t-30">
				<div class="col-md-12">
					<button class="btn btn-primary btn-md btn-block wave-effect text-center m-b-20">LOGIN</button>
				</div>
			</div>
		</div>
	</div>
</form>