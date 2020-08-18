<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="side-bar">
    <div class="logo">USER PAGE</div>
    <ul class="list-group rounded-0">
        <li class="dashboard">DASHBOARD</li>
        <li>
            <a href='<c:url value="/user/san-pham"></c:url>'>
                <i class="fa fa-car mr-2"></i> Quản lý sản phẩm
            </a>
        </li>
        <li>
            <a href='<c:url value="/user/khach-hang"></c:url>'>
                <i class="fa fa-child mr-2"></i> Khách hàng
            </a>
        </li>
        <li>
            <a href='<c:url value="/user/ncc"></c:url>'>
                <i class="fa fa-child mr-2"></i> Nhà cung cấp
            </a>
        </li>
        <li>
            <a href='<c:url value="/user/nhap-kho"></c:url>'>
                <i class="fa fa-arrow-right mr-2"></i> Nhập kho
            </a>
        </li>
        <li>
            <a href='<c:url value="/user/xuat-kho"></c:url>'>
                <i class="fa fa-arrow-left mr-2"></i> Xuất kho
            </a>
        </li>
        <li>
            <a href='<c:url value="/user/bao-cao"></c:url>'>
                <i class="fa fa-heartbeat mr-2"></i> Báo cáo
            </a>
        </li>
        <li>
            <a href="#">
                <i class="fa fa-slack mr-2"></i> Thông tin khác
            </a>
        </li>
    </ul>
</div>