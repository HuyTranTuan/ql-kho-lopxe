<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>

<h3 class="mb-4 text-center">Cập nhật sản phẩm</h3>
<c:url value="/user/khach-hang/edit" var="url"/>
<mvc:form method="post" action="${ url }" modelAttribute="customer">
	<div class="row">
		<div class="col-md-6 m-auto">
		<mvc:hidden path="id"/>
			<div class="form-group">
				<label>Tên khách hàng</label> <mvc:input type="text" path="name"
					cssClass="form-control" placeholder="name" />
				<mvc:errors path="name" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<label>Số điện thoại</label> <mvc:input type="text" path="phone"
					cssClass="form-control" placeholder="brand" />
				<mvc:errors path="phone" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<label>Địa chỉ</label> <mvc:input type="text" path="address"
					cssClass="form-control" placeholder="type" />
				<mvc:errors path="address" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-success">Lưu lại</button>
				<a class="btn btn-secondary" href='<c:url value="/user/khach-hang"/>'>Quay lại</a>
			</div>
		</div>
	</div>
</mvc:form>