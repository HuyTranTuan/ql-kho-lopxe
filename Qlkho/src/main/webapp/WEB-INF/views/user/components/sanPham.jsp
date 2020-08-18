<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h3 class="mb-3">Danh sách sản phẩm</h3>
<div class="row">
	<div class="col-md-8">
		<a href='<c:url value="/user/san-pham/add"/>' class="btn btn-primary">Thêm mới</a>
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
			<th>Tên</th>
			<th>Hãng</th>
			<th>Số lượng</th>
			<th>Loại</th>
			<th>Giá (VNĐ)</th>
			<th>#</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ tyres }" var="item" varStatus="status">
			<tr>
				<td>${ status.index + 1 }</td>
				<td>${ item.name }</td>
				<td>${ item.brand }</td>
				<td>${ item.quantity }</td>
				<td>${ item.type }</td>
				<td>${ item.price }</td>
				<td><a href='<c:url value="/user/san-pham/edit/"/>${ item.id }' class="btn btn-sm btn-info"> <i class="fa fa-pencil-square-o"></i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
