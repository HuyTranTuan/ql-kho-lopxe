<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>

<h3 class="mb-4 text-center">Cập nhật thành viên</h3>
<c:url value="/admin/thanh-vien/edit" var="url"/>
<mvc:form method="post" action="${ url }" modelAttribute="account">
	<div class="row">
		<div class="col-md-6">
		<mvc:hidden path="id"/>
		<mvc:hidden path="password"/>
			<div class="form-group">
				<label>Email</label> <mvc:input type="text" path="email" cssClass="form-control" placeholder="email" />
				<mvc:errors path="email" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<label>Họ tên</label> <mvc:input type="text" path="fullname" cssClass="form-control" placeholder="fullname" />
				<mvc:errors path="fullname" cssClass="text-danger"/>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label>Số điện thoại</label> <mvc:input type="text" path="phone" cssClass="form-control" placeholder="phone" />
				<mvc:errors path="phone" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<label>Địa chỉ</label> <mvc:input type="text" path="address" cssClass="form-control" placeholder="address" />
				<mvc:errors path="address" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<label>Loại thành viên</label> <mvc:select path="roleId" cssClass="form-control" items="${ roles }"></mvc:select>
				<mvc:errors path="roleId" cssClass="text-danger"/>
			</div>
		</div>
		<div class="col-12 mt-3">
			<button type="submit" class="btn btn-success">Lưu lại</button>
			<a class="btn btn-secondary" href='<c:url value="/admin/thanh-vien"/>'>Quay lại</a>
		</div>
	</div>
</mvc:form>