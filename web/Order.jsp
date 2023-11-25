<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="Dal.*" %>
<%@page import="Model.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>

<!DOCTYPE html>
<!--
        ustora by freshdesignweb.com
        Twitter: https://twitter.com/freshdesignweb
        URL: https://www.freshdesignweb.com/ustora/
-->
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Your Order Page - Ustora Demo</title>

        <!-- Google Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

        <!-- Bootstrap -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Font Awesome -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="css/responsive.css">
        <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">-->

        <!-- Bootstrap 5 CSS -->
        <!--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">-->

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <style>
            /* Áp dụng margin cho container */
            * {
                margin: 0;
                padding: 0;

            }

            .container-fluid{
                margin-top: 30px;
                margin-bottom: 30px;
            }

            /* Áp dụng margin cho các card bên trong */
            .card {
                border: 1px solid #ccc; /* Màu viền và độ rộng */
                border-radius: 15px; /* Bo tròn viền */
                padding: 15px; /* Khoảng cách bên trong card */
                margin-bottom: 20px; /* Khoảng cách với các phần tử khác */
            }


            /* Chỉnh định dạng thẻ h2 và h3 */
            h2, h3 {
                color: #333; /* Màu chữ */
                margin-bottom: 15px; /* Khoảng cách dưới */
            }

            /* Chỉnh định dạng thẻ .btn-link */
            .btn-link {
                color: #007bff; /* Màu chữ */
                text-decoration: none; /* Bỏ gạch chân link */
            }

            /* Chỉnh định dạng thẻ table */
            table {
                width: 100%;
                margin-bottom: 1rem;
                color: #212529; /* Màu chữ chính */
            }

            /* Chỉnh màu nền và border của table */
            .table {
                background-color: #fff;
                border-collapse: collapse;
                /* Màu viền */
            }

            .table tr {
                border: none;
            }

            /* Chỉnh border của table head */
            .table thead th {
                border-bottom: 2px solid #dee2e6; /* Viền dưới */
            }

            /* Chỉnh kích thước ảnh trong table */
            .table img {
                width: 150px;
                height: auto;
            }

            /* Chỉnh định dạng thẻ address */
            address {
                margin-bottom: 1rem;
            }

            /* Chỉnh định dạng footer của table */
            tfoot {
                font-weight: bold;
            }

            /* Chỉnh định dạng cho span.badge */
            span.badge {
                font-size: 0.8em;
                margin-left: 5px;
                padding: 5px;
            }

            /* Chỉnh định dạng cho .badge.bg-success */
            .badge.bg-success {
                background-color: #28a745; /* Màu nền */
            }

            /* Chỉnh định dạng cho .badge.bg-info */
            .badge.bg-info {
                background-color: #17a2b8; /* Màu nền */
            .table td img {
                    width: 100px; /* Điều chỉnh kích thước ảnh */
                    height: auto; /* Giữ tỷ lệ chiều cao */
                    display: block; /* Ngăn cách với phần tử khác */
                    margin: 0 auto; /* Canh giữa ảnh */
            }

            .table td {
                    text-align: center; /* Căn giữa nội dung trong các ô */
                    vertical-align: middle; /* Căn giữa theo chiều dọc */
            }
            
        }

        </style>
    </head>
    <body>
        <%@include file="Header.jsp" %>
        <!-- End header area -->

        <c:set var="currentPage" value="Checkout.jsp"/>
        <%@include file="Menu.jsp" %>
        <!-- End mainmenu area -->

        <div class="product-big-title-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="product-bit-title text-center">
                            <h2>Shopping Cart</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <main>
            <div class="container-fluid">
                <c:forEach items="${order}" var="o">
                    <div class="container">
<!--                         Title 
                        <div class="d-flex justify-content-between align-items-center py-3">
                            <h2 class="h5 mb-0"><a href="#" class="text-muted"></a> Thanks for your Order <span style="color: #cf1863;">${o.name}</span>!</h2>
                        </div>-->

                        <!-- Main content -->
                        <form action="yourorder" method="post">
                            <div class="row">

                                <div class="col-lg-8">
                                    <!-- Details -->
                                    <div class="card mb-4">
                                        <div class="card-body">
                                            <div class="mb-3 d-flex justify-content-between">
                                                <div>
                                                    <span class="me-3">${o.date}</span>
                                                    <span class="me-3"></span>
                                                    <span class="me-3"></span>
                                                    <span class="badge rounded-pill bg-info">Order</span>
                                                </div>
                                                <div class="d-flex">
                                                    <!--<button class="btn btn-link p-0 me-3 d-none d-lg-block btn-icon-text"><i class="bi bi-download"></i> <span class="text">Invoice</span></button>-->
                                                    <div class="dropdown">
                                                        <button class="btn btn-link p-0 text-muted" type="button" data-bs-toggle="dropdown">
                                                            <i class="bi bi-three-dots-vertical"></i>
                                                        </button>
                                                        <ul class="dropdown-menu dropdown-menu-end">
                                                            <li><a class="dropdown-item" href="#"><i class="bi bi-pencil"></i> Edit</a></li>
                                                            <li><a class="dropdown-item" href="#"><i class="bi bi-printer"></i> Print</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                            <table class="table table-borderless">
                                                <tbody>
                                                    <tr>
                                                        <td>
                                                            <div class="d-flex mb-2">
                                                                <div class="flex-shrink-0">
                                                                    <img src="${o.productImage}" alt="" heigth="500px" width="500px" class="img-fluid" style="margin: 20px 0;">
                                                                </div>
                                                                <div class="flex-lg-grow-1 ms-3">
                                                                    <h6 class="small mb-0"><a href="#" class="text-reset">${o.productName}</a></h6>
                                                                    <!--<span class="small">Color: Black</span>-->
                                                                </div>
                                                            </div>
                                                        </td>
                                                        <td>${o.productQuantity}</td>
                                                        <td class="text-end">${o.productPrice} $</td>
                                                    </tr>

                                                </tbody>

                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <!-- Customer Notes -->
                                    <div class="card mb-4">
                                        <div class="card-body">
                                            <h3 class="h6" style="font-size: 13px"><b>Payment in delivery</b></h3>
                                            <p>
                                                Total: $ ${o.totalPrice} <span class="badge bg-success rounded-pill">PAID</span></p>
                                        </div>
                                    </div>
                                    <div class="card mb-4">
                                        <!-- Shipping information -->
                                        <div class="card-body">
                                            <h3 class="h6">Shipping Information</h3>
                                            <strong>FedEx</strong>
                                            <span><a href="#" class="text-decoration-underline" target="_blank">FF1234567890</a> <i class="bi bi-box-arrow-up-right"></i> </span>
                                            <hr>
                                            <h3 class="h6">Address</h3>
                                            <address>
                                                <strong>${o.name}</strong><br>
                                                ${o.address}<br>

                                                <p title="Phone">Phone: 0${o.phone}</p> 
                                            </address>
                                        </div>
                                    </div>
                                </div>
                               
                           
                        </div>
                                            <hr style="border-top: 1px solid #000">              
                    </form>
                </div>
                    </c:forEach>
            </div>
        </main>


        <%@include file="Footer.jsp" %>

        <!-- Latest jQuery form server -->
        <script src="https://code.jquery.com/jquery.min.js"></script>

        <!-- Bootstrap JS form CDN -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"></script>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

        <!-- jQuery sticky menu -->
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.sticky.js"></script>

        <!-- jQuery easing -->
        <script src="js/jquery.easing.1.3.min.js"></script>

        <!-- Main Script -->
        <script src="js/main.js"></script>

    </body>
</html>