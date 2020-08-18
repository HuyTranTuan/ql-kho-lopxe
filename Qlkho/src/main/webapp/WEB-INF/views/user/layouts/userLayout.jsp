<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href='<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></c:url>'>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href='<c:url value="/assets/css/bootstrap.min.css"></c:url>'>
    <link rel="stylesheet" href='<c:url value="/assets/css/style.css"></c:url>'>
</head>

<body>
    <div class="d-flex justify-content-between">
        <!-- SIDE BAR -->
        <tiles:insertAttribute name="sidebar" />
        
        <div id="admin-wrapper">
            <!-- NAVBAR -->
            <tiles:insertAttribute name="navbar" />
            
            <!-- CONTENT -->
            <section id="admin-content" class="p-3">
                <tiles:insertAttribute name="body" />
            </section>
        </div>
    </div>
    <script src='<c:url value="/assets/js/jquery.slim.min.js"></c:url>'></script>
    <script src='<c:url value="/assets/js/popper.min.js"></c:url>'></script>
    <script src='<c:url value="/assets/js/bootstrap.min.js"></c:url>'></script>
    <script src="<c:url value="/assets/js/sweetalert.min.js"/>"></script>
    <script type="text/javascript">
    	var msgSuccess = '${ msgSuccess }';
    	var msgError = '${ msgError }';
    	if(msgSuccess){
    		swal("Thành công!", msgSuccess, "success");
    	}
    	else if(msgError){
    		swal("Thất bại!", msgError, "error");
    	}
    </script>
</body>
</html>