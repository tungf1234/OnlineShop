<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <title>Ustora Demo</title>

        <!-- Google Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

        <!-- Bootstrap -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Font Awesome -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="css/responsive.css">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <style>
            .product-offer {
                position: relative;
                overflow: hidden;
            }

            .product-offer img {
                width: 100%;
                height: auto;
                transition: transform 0.3s ease;
            }

            .product-offer:hover img {
                transform: scale(1.05);
            }

            .offer-text {
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                text-align: center;
            }

            .offer-text h6,
            .offer-text h3 {
                color: white;
                text-shadow: 2px 2px 4px rgba(0,0,0,0.8);
            }

            .offer-text h6 {
                font-size: 20px;
                margin-bottom: 5px;
            }

            .offer-text h3 {
                font-size: 30px;
                margin-bottom: 15px;
            }

            .offer-text a {
                display: inline-block;
                padding: 10px 20px;
                background-color: #007bff;
                color: white;
                text-decoration: none;
                border-radius: 5px;
                font-size: 16px;
                transition: background-color 0.3s ease;
            }

            .offer-text a:hover {
                background-color: #0056b3;
            }
            .single-product {
                border: 1px solid #000; /* Đường viền đen 1 pixel */
                box-shadow: 0px 0px 10px rgba(0,0,0,0.1); /* Hiệu ứng lồi lên */
            }
        </style>

    </head>
    <body>
        <%@include file="Header.jsp" %>
        <!-- End header area -->
        <c:set var="currentPage" value="home"/>
        <%@include file="Menu.jsp" %>
        <!-- End mainmenu area -->
        <div class="slider-area">
            <!-- Slider -->
            <div class="block-slider block-slider4">
                <ul class="" id="bxslider-home4">
                    <div>
                        <li style="display: flex; justify-content: center;">
                            <img style="height: 80% ;width: 90%;padding-top:8px" 
                                 img src="https://storage-asset.msi.com/global/picture/banner/banner_167238717118f8b0304cb96763a323a8a7724621b2.jpeg" alt="Slide">                        
                        </li>
                        <div class="caption-group" style="transform: translate(-133%, 200%);">
                            <a class="caption button-radius" href="shop"><span class="icon"></span>Shop Now</a>
                        </div>
                    </div>
                    <li style="display: flex; justify-content: center;">
                        <img style="height: 80% ;width: 90%;padding-top:8px" src="https://dlcdnwebimgs.asus.com/gain/89BDEFEE-CC57-4AE1-8DA3-9C12369716CE/fwebp" alt="Slide">
                        <div class="caption-group" style="transform: translate(-281%, 370%)">
                            <a class="caption button-radius" href="shop"><span class="icon"></span>Shop now</a>
                        </div>
                    </li>
                </ul>
            </div>
            <!-- ./Slider -->
        </div> <!-- End slider area -->

        <div class="promo-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-6">
                        <div class="single-promo promo1">
                            <i class="fa fa-refresh"></i>
                            <p>30 Days return</p>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="single-promo promo2">
                            <i class="fa fa-truck"></i>
                            <p>Free shipping</p>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="single-promo promo3">
                            <i class="fa fa-lock"></i>
                            <p>Secure payments</p>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="single-promo promo4">
                            <i class="fa fa-gift"></i>
                            <p>New products</p>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- End promo area -->

        <div class="maincontent-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="latest-product">
                            <h2 class="section-title">Latest Products</h2>
                            <div class="product-carousel">
                                <c:forEach items="${listPro}" var="p" varStatus="loop">
                                    <c:if test="${loop.index >= fn:length(listPro) - 7}">                                        
                                        <div class="single-product">
                                            <div class="product-f-image">
                                                <img src="${p.imgUrl}" alt="${p.productName}">
                                                <div class="product-hover">
                                                    <a href="productdetails?mod=${p.productId}&mod1=${p.cateId}" class="view-details-link"><i class="fa fa-link"></i> See details</a>
                                                </div>
                                            </div>
                                            <h5 style="display: block;text-align: center; padding-top: 5px">${p.productName}</h5>
                                            <div class="product-carousel-price">
                                                <ins style="display: block;text-align: center; color: red">$${p.productPrice}</ins>
                                            </div> 
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- End main content area -->


        <div class="product-widget-area">
            <div class="zigzag-bottom"></div>
            <h2 class="section-title">Special Offer</h2>
            <div class="container">
                <div class="row">
                    <div class="container-fluid pt-5 pb-3">
                        <div class="row px-xl-5">
                            <div class="col-md-6">
                                <div class="product-offer mb-30" style="height: 300px;">
                                    <img class="img-fluid" src="img/sale3.jpg" alt="" style="height: 300px ; width: 550px">
                                    <div class="offer-text">
                                        <h6 class="text-white text-uppercase">Save 20%</h6>
                                        <h3 class="text-white mb-3">Special Offer</h3>
                                        <a href="shop" class="btn btn-primary">Shop Now</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="product-offer mb-30" style="height: 300px;">
                                    <img class="img-fluid" src="img/sale2.jpg" alt="" style="height: 300px ; width: 550px">
                                    <div class="offer-text">
                                        <h6 class="text-white text-uppercase">Save 20%</h6>
                                        <h3 class="text-white mb-3">Special Offer</h3>
                                        <a href="shop" class="btn btn-primary">Shop Now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="Footer.jsp" %>
        <!-- Latest jQuery form server -->
        <script src="https://code.jquery.com/jquery.min.js"></script>

        <!-- Bootstrap JS form CDN -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

        <!-- jQuery sticky menu -->
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.sticky.js"></script>

        <!-- jQuery easing -->
        <script src="js/jquery.easing.1.3.min.js"></script>

        <!-- Main Script -->
        <script src="js/main.js"></script>

        <!-- Slider -->
        <script type="text/javascript" src="js/bxslider.min.js"></script>
        <script type="text/javascript" src="js/script.slider.js"></script>
    </body>
</html>
