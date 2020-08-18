<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h3 class="mb-3">Danh sách xuất kho</h3>
<div class="row">
	<div class="col-md-8">
		<a href='<c:url value="/admin/xuat-kho/add"/>' class="btn btn-primary">Thêm mới</a>
	</div>
	<div class="col-md-4">
		<div class="input-group">
			<input type="text" class="form-control" placeholder="Tìm kiếm...">
			<div class="input-group-append">
				<span class="input-group-text" id="basic-addon2"><i
					class="fa fa-search"></i></span>
			</div>
		</div>
	</div>
</div>
<table class="table table-bordered table-hover mt-3">
	<thead>
		<tr>
			<th>STT</th>
			<th>Khách hàng</th>
			<th>Lốp xe</th>
			<th>Số lượng</th>
			<th>Ghi chú</th>
			<th>Ngày tạo</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ deliveries }" var="item" varStatus="status">
			<tr>
				<td>${ status.index + 1 }</td>
				<td>${ item.customer }</td>
				<td>${ item.tyre }</td>
				<td>${ item.quantity }</td>
				<td>${ item.note }</td>
				<td>${ item.create }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
