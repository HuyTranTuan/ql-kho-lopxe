<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header class="container-fluid border-bottom">
	<nav class="navbar navbar-expand-sm navbar-light bg-light">
		<a class="navbar-brand" href='<c:url value=""/>'>QUAN LY KHO</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation"></button>
		<div class="collapse navbar-collapse row" id="collapsibleNavId">
			<div class="col-md-6">
				<ul
					class="navbar-nav mr-auto mt-2 mt-lg-0 d-flex align-items-center justify-content-between">
					<li class="nav-item mr-3">
						<div class="dropdown">
							<a class="btn btn-outline-light dropdown-toggle"
								data-toggle="dropdown"> <i class="fa fa-th"></i> <span
								class="ml-2">Categories</span>
							</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#"> <i
									class="fa fa-car"></i> <span>Development</span>
								</a> <a class="dropdown-item" href="#"> <i
									class="fa fa-car"></i> <span>Photography</span>
								</a> <a class="dropdown-item" href="#"> <i
									class="fa fa-car mr-1"></i> <span>Business</span>
								</a>
							</div>
						</div>
					</li>
					<li class="nav-item w-100">
						<form class="input-group nav-search">
							<input type="text" class="form-control"
								placeholder="Search brand">
							<div class="input-group-append">
								<button class="btn bg-white text-danger">
									<i class="fa fa-search"></i>
								</button>
							</div>
						</form>
					</li>
				</ul>
			</div>
			<div class="col-md-1 nav-cart">
				<i class="fa fa-shopping-basket"></i>
			</div>
			<div class="col-md-5 d-flex justify-content-end">
				<button class="btn btn-outline-secondary" data-toggle="modal" data-target="#loginModal">Login</button>
				<button class="btn btn-danger ml-2" data-toggle="modal" data-target="#registerModal">Sign up</button>
			</div>
		</div>
	</nav>
</header>
