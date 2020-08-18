<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>

<h3 class="mb-4 text-center">Cập nhật quyền</h3>
<c:url value="/admin/quyen/edit" var="url"/>
<mvc:form method="post" action="${ url }" modelAttribute="role">
	<div class="row">
		<div class="col-md-6 m-auto">
		<mvc:hidden path="id"/>
			<div class="form-group">
				<label>Tên quyền</label> <mvc:input type="text" path="name"
					cssClass="form-control" placeholder="name" />
				<mvc:errors path="name" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<label>Mô tả</label> <mvc:input type="text" path="description"
					cssClass="form-control" placeholder="description" />
				<mvc:errors path="description" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-success">Lưu lại</button>
				<a class="btn btn-secondary" href='<c:url value="/admin/quyen"/>'>Quay lại</a>
			</div>
		</div>
	</div>
</mvc:form>