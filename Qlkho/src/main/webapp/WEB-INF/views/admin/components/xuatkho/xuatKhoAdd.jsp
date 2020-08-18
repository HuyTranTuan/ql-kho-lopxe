<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>

<h3 class="mb-4 text-center">Thêm mới xuất kho</h3>

<c:url value="/admin/xuat-kho/add" var="url"/>
<mvc:form method="post" action="${ url }" modelAttribute="delivery">
	<div class="row">
		<div class="col-md-6 m-auto">
			<div class="form-group">
				<label>Khách hàng</label> <mvc:input type="text" path="customer"
					cssClass="form-control" placeholder="customer" />
				<mvc:errors path="customer" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<label>Lốp</label> <mvc:input type="text" path="tyre"
					cssClass="form-control" placeholder="tyre" />
				<mvc:errors path="tyre" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<label>Số lượng</label> <mvc:input type="text" path="quantity"
					cssClass="form-control" placeholder="quantity" />
				<mvc:errors path="quantity" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<label>Ghi chú</label> <mvc:input type="text" path="note"
					cssClass="form-control" placeholder="note" />
				<mvc:errors path="note" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-success">Lưu lại</button>
				<a class="btn btn-secondary" href='<c:url value="/admin/xuat-kho"/>'>Quay lại</a>
			</div>
		</div>
	</div>
</mvc:form>