<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 태그넣는 JSTL문법법 -->
<html lang="ko">
<head>
<title>seoha &mdash; tiffany web Project</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link
	href="https://fonts.googleapis.com/css?family=DM+Sans:300,400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="/fonts/icomoon/style.css">

<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/animate.min.css">
<link rel="stylesheet" href="/css/jquery.fancybox.min.css">
<link rel="stylesheet" href="/css/owl.carousel.min.css">
<link rel="stylesheet" href="/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/fonts/flaticon/font/flaticon.css">
<link rel="stylesheet" href="/css/aos.css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="/css/style.css">


<!--  썸머노트 테스트 -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
<!--  썸머노트 테스트 끝 -->


</head>

<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">


	<div class="site-wrap" id="home-section">

		<div class="site-mobile-menu site-navbar-target">
			<div class="site-mobile-menu-header">
				<div class="site-mobile-menu-close mt-3">
					<span class="icon-close2 js-menu-toggle"></span>
				</div>
			</div>
			<div class="site-mobile-menu-body"></div>
		</div>



		<header class="site-navbar site-navbar-target" role="banner">

			<div class="container">
				<div class="row align-items-center position-relative">

					<div class="col-lg-4">
						<nav class="site-navigation text-right ml-auto " role="navigation">
							<ul
								class="site-menu main-menu js-clone-nav ml-auto d-none d-lg-block">
								<li class="active"><a href="/product?cmd=list&type=ring"
									class="nav-link">ring</a></li>
								<li><a href="/product?cmd=list&type=watch" class="nav-link">watch</a></li>
								<li><a href="/product?cmd=list&type=perfuem" class="nav-link">perfuem</a></li>
							</ul>
						</nav>
					</div>
					<div class="col-lg-4 text-center">
						<div class="site-logo">
							<a href="/">tiffany</a>
						</div>


						<div class="ml-auto toggle-button d-inline-block d-lg-none">
							<a href="/"
								class="site-menu-toggle py-5 js-menu-toggle text-white"><span
								class="icon-menu h3 text-white"></span></a>
						</div>
					</div>
					<div class="col-lg-4">
						<nav class="site-navigation text-left mr-auto " role="navigation">
							<ul
								class="site-menu main-menu js-clone-nav ml-auto d-none d-lg-block">

								<c:choose>
									<c:when test="${not empty sessionScope.user}">
										<li><a href="/notice?cmd=list&pageno=1" class="nav-link">notice</a></li>
										<li><a href="/user?cmd=modify" class="nav-link">modify</a></li>
										<li><a href="/user?cmd=logout" class="nav-link">logout</a></li>

									</c:when>
									<c:otherwise>
										<li><a href="/user?cmd=login" class="nav-link">login</a></li>
										<li><a href="/user?cmd=join" class="nav-link">join</a></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</header>
	</div>