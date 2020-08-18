<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h3 class="mb-3">Danh sách khách hàng</h3>
<div class="row">
	<div class="col-md-8">
		<a href='<c:url value="/user/khach-hang/add"/>' class="btn btn-primary">Thêm mới</a>
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
			<th>SĐT</th>
			<th>Địa chỉ</th>
			<th>#</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ customers }" var="item" varStatus="status">
			<tr>
				<td>${ status.index + 1 }</td>
				<td>${ item.name }</td>
				<td>${ item.phone }</td>
				<td>${ item.address }</td>
				<td><a href='<c:url value="/user/khach-hang/edit/"/>${ item.id }' class="btn btn-sm btn-info"> <i class="fa fa-pencil-square-o"></i></a> 
				<a href='<c:url value="/user/khach-hang/delete/"/>${ item.id }' class="btn btn-sm btn-danger"> <i class="fa fa-trash-o"></i> </a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
