

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Checkout Page - Ustora Demo</title>

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
            .container{
                /*margin-top: 30px;*/
                margin-bottom: 40px;
            }
            .py-5{
                margin-bottom: 30px;
            }
            .mb-3{
                /*line-height: 30px;*/
                margin-bottom: 15px;
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
            <div class="container">
                <div class="py-5 text-center">

                    <h2>Your Checkout</h2>
                    <!--<p class="lead">Below is an example form built entirely with Bootstrap 5 form controls. Each required form group has a validation state that can be triggered by attempting to submit the form without completing it.</p>-->
                </div>

                <div class="row">
                    <div class="col-md-4 order-md-2 mb-4">
                        <h4 class="d-flex justify-content-between align-items-center mb-3">
                            <span class="text-muted">--------Order Total--------</span>
                            <span class="badge badge-secondary badge-pill"></span>
                        </h4>


                        <ul class="list-group mb-3">
                            <c:set var="o" value="${requestScope.cart}"/>
                            <c:forEach items="${cart.items}" var="i">
                                <li class="list-group-item d-flex justify-content-between lh-condensed" >
                                    <div>
                                        <p class="my-0">${i.product.productName}</p>
                                        <!--<img src="${i.product.imgUrl}" style="width: 120px; height: 120px;">-->
                                        <p class="text-muted">Quantity: ${i.quantity}</p>
                                    </div>
                                    <span class="text-muted">Price: <fmt:formatNumber pattern="##.##" value="${(i.product.productPrice*i.quantity)}"/>$</span>
                                </li>
                            </c:forEach>
                            <!--                            <li class="list-group-item d-flex justify-content-between lh-condensed">
                                                            <div>
                                                                <h6 class="my-0">Second product</h6>
                                                                <small class="text-muted">Brief description</small>
                                                            </div>
                                                            <span class="text-muted">$8</span>
                                                        </li>
                                                        <li class="list-group-item d-flex justify-content-between lh-condensed">
                                                            <div>
                                                                <h6 class="my-0">Third item</h6>
                                                                <small class="text-muted">Brief description</small>
                                                            </div>
                                                            <span class="text-muted">$5</span>
                                                        </li>-->

                            <li class="list-group-item d-flex justify-content-between">
                                <span>Total (USD) + Shipping: <br></span>
                                <strong><fmt:formatNumber pattern="##.##" value="${(o.totalMoney + 2)}"/>$</strong>
                            </li>
                        </ul>

                    </div>
                    <div class="col-md-8 order-md-1">
                        <h4 class="mb-3">Billing address</h4>
                        <form class="needs-validation" action="checkout" method="POST" onsubmit="return validateForm()">

                            <div class="mb-3">
                                <label for="username">Username</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">@</span>
                                    </div>
                                    <input type="text" class="form-control" id="username" placeholder="Username" name="username" >
                                    <div class="invalid-feedback" style="width: 100%;">
                                        Your username is required.
                                    </div>
                                </div>
                            </div>

                            <div class="mb-3">
                                <label for="email">Email <span class="text-muted">(Optional)</span></label>
                                <input type="email" class="form-control" id="email" placeholder="you@example.com" value="${user.email}" required>
                                <div class="invalid-feedback">
                                    Please enter a valid email address for shipping updates.
                                </div>
                            </div>

                            <div class="mb-3 ">
                                <label for="address">Address</label>
                                <input type="text" class="form-control" id="address" placeholder="1234 Main St" name="address" >
                                <div class="invalid-feedback">
                                    Please enter your shipping address.
                                </div>
<!--                                <div class="input-group-append">
                                    <button class="btn btn-secondary" type="button" id="refreshButton">
                                        <i class="fa fa-refresh"></i>
                                    </button> ( Update new address )
                                </div>-->
                            </div>
                            <div class="mb-3">
                                <label for="address">Phone Number</label>
                                <input type="text" class="form-control" id="phone-number" placeholder="0965******" name="phone" >
                                <div class="invalid-feedback">
                                    Please enter your phone number.
                                </div>
                            </div>

                            <hr class="mb-4">

                            <h4 class="mb-3">Payment</h4>

                            <div class="d-block my-3">

                                <div class="custom-control custom-radio">
                                    <i class="fa fa-gift" style="font-size: 20px;"></i>
                                    <label class="custom-control-label" for="debit">Payment in delivery</label>
                                    <input id="debit" name="paymentMethod" type="radio" class="custom-control-input" required>
                                    <!--<label class="custom-control-label" for="debit">Payment in cash</label>-->
                                </div>

                            </div>

                            <hr class="mb-4">
                            <div style="margin-top: 15px;color: red" id="error-messages"></div>

                            <input class="btn btn-primary btn-lg btn-block" type="submit" value="Checkout">
                        </form>
                    </div>
                </div>
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
        <script>
                            function validateForm() {
                                var name = document.getElementById("username").value;
                                var address = document.getElementById("address").value;
                                var phone = document.getElementById("phone-number").value;

                                var errorDiv = document.getElementById("error-messages");
                                errorDiv.innerHTML = ""; // Xóa các thông báo lỗi trước đó (nếu có)

                                if (name.trim() === "") {
                                    showError("Name is required");
                                    return false;
                                }

// Kiểm tra ký tự đặc biệt hoặc số trong tên
                                var nameRegex = /^[a-zA-Z\s]*$/;
                                if (!nameRegex.test(name)) {
                                    showError("Name should contain only letters and spaces");
                                    return false;
                                }

                                if (address.trim() === "") {
                                    showError("Address is required");
                                    return false;
                                }

// Kiểm tra ký tự đặc biệt trong địa chỉ
                                var addressRegex = /^[\p{L}\p{N}\s!@#$%^&*()-_=+{};:'",.<>?/\\|[\]`~]*$/u;
                                if (!addressRegex.test(address)) {
                                 showError("Address should contain only letters, numbers, spaces, and common special characters");
                                return false;
}


                                if (phone.trim() === "") {
                                    showError("Phone number is required");
                                    return false;
                                }

// Kiểm tra số điện thoại có 10 chữ số và không chứa ký tự đặc biệt
                                var phoneRegex = /^\d{10}$/;
                                if (!phoneRegex.test(phone)) {
                                    showError("Phone number should be 10 digits without special characters");
                                    return false;
                                }

// Nếu không có lỗi, có thể tiếp tục xử lý form và gửi yêu cầu POST
                                showSuccess("Order placed successfully!");
                                return true;
                            }

                            function showError(errorMessage) {
                                window.alert("Error: " + errorMessage);
                            }

                            function showSuccess(successMessage) {
                                window.alert(successMessage);
                            }

        </script>
    </body>
</html>