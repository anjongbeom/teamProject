<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>KA주류교육원</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/resources/css/menu_styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="http://localhost">KA 주류교육원</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="http://localhost/#portfolio">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="http://localhost/board/list">Board</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#!">주류 종류</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="/product/brandyList">Brandy</a></li>
                                <li><a class="dropdown-item" href="/product/whiskyList">Scotch Whisky</a></li>
                                <li><a class="dropdown-item" href="/product/beerList">Beer</a></li>
                                <li><a class="dropdown-item" href="/product/traditionalList">Traditional liquor</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="d-flex">
                    	<!-- 수정중 -->
                    	<!-- 장바구니 -->
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                        </button>
                        <!-- 알림 기능 예약 메세지 -->
                        <button id="m" class="btn btn-outline-dark" type="submit" style="margin-left: 5px;">
                        	<i class="bi bi-clock"></i>
 							Alert
                        	<span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                        </button>
                        <!-- 로그인 -->
                        <button id="" class="btn btn-outline-dark" type="submit" style="margin-left: 5px;">
                        	<i class="bi bi-door-open"></i>
 							Login
                        	<span class="badge bg-dark text-white ms-1 rounded-pill"></span>
                        </button>
                        
                        <!-- 회원가입 -->
                         <button id="" class="btn btn-outline-dark" type="submit" style="margin-left: 5px;">
                        	<i class="bi bi-people-fill"></i>
 							Sign Up
                        	<span class="badge bg-dark text-white ms-1 rounded-pill"></span>
                        </button>
                    </form>
                </div>
            </div>
        </nav>
        
        <!-- Header-->
        <header class="bg-dark py-5"> 
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">깔끔한 한잔</h1>
                    <p class="lead fw-normal text-white-50 mb-0">우리 KA와 함께 찾아보시죠</p>
                </div>
            </div>
        </header>
        
        