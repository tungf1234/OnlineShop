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
        <title>Cart Page - Ustora Demo</title>

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
    </head>
    <body>
        <%@include file="Header.jsp" %>
        <!-- End header area -->

        <c:set var="currentPage" value="cart"/>
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
        </div> <!-- End Page title area -->


        <div class="single-product-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="product-content-right">
                            <div class="woocommerce">
                                <table cellspacing="0" class="shop_table cart">
                                    <thead>
                                        <tr>
                                            <th class="product-stt">No</th>
                                            <th class="product-img">Image</th>
                                            <th class="product-name">Product Name</th>
                                            <th class="product-price">Price</th>
                                            <th class="product-quantity">Quantity</th>
                                            <th class="product-subtotal">Total</th>
                                            <th class="product-action">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:set var="o" value="${requestScope.cart}"/>
                                        <c:set var="tt" value="0"/>
                                        <c:forEach var="i" items="${cart.items}">
                                            <c:set var="tt" value="${tt+1}"/>
                                            <tr class="cart_item" id="product-${i.product.productId}">
                                                <td>${loop.index + 1}</td>
                                                <td class="product-thumbnail">
                                                    <img width="50px" height="50px" alt="poster_1_up" class="shop_thumbnail" src="${i.product.imgUrl}">
                                                </td>
                                                <td class="product-name">${i.product.productName}
                                                </td>
                                                <td class="product-price">
                                                    <span class="amount">${i.product.productPrice}$</span> 
                                                </td>
                                                <td class="product-quantity" style="display: flex;justify-content: center;padding-bottom: 0px;flex-direction: row;flex-wrap: wrap;align-items: baseline;">       
                                                    <a href="process?num=-1&id=${i.product.productId}"><input type="button" value="-" class="minus"></a>
                                                    <input type="text" class="form-control form-control-sm bg-secondary border-0 text-center" value="${i.quantity}" style="width: 70px;">
                                                    <a href="process?num=1&id=${i.product.productId}"><input type="button" value="+" class="plus"></a>
                                                </td>
                                                <td class="product-subtotal">
                                                    <fmt:formatNumber pattern="##.##" value="${(i.product.productPrice*i.quantity)}"/>$
                                                </td>
                                                <td class="product-remove">
                                                    <form action="process" method="post">
                                                        <input type="hidden" name="id" value="${i.product.productId}"/>
                                                        <!--<input type="submit" value="Return item"/>-->   
                                                        <button class="btn btn-sm btn-danger">REMOVE</button>
                                                    </form>                                                     
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        <tr>
                                            <td class="actions" colspan="6">
                                                <div class="coupon">
                                                    <label for="coupon_code">Coupon:</label>
                                                    <input type="text" placeholder="Coupon code" value="" id="coupon_code" class="input-text" name="coupon_code">
                                                    <input type="submit" value="Apply Coupon" name="apply_coupon" class="button">
                                                </div>
                                                <form action="checkout" method="">
                                                    <input type="submit" value="Checkout" name="proceed" class="checkout-button button alt wc-forward">
                                                </form>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <div class="cart-collaterals">
                            <div class="cross-sells">
                                <h2>You may be interested in...</h2>
                                <ul class="products">
                                    <c:forEach items="${listPro}" var="p" varStatus="loop">
                                        <c:if test="${loop.index <= 1}">
                                            <li class="product">
                                                <a href="productdetails?mod=${p.productId}&&mod1=${p.cateId}">
                                                    <img width="325" height="325" alt="T_4_front" class="attachment-shop_catalog wp-post-image" src="${p.imgUrl}">
                                                    <h3>Ship Your Idea</h3>
                                                    <span class="price"><span class="amount">${p.productPrice}$</span></span>
                                                </a>

                                                <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="22" rel="nofollow" href="productdetails?mod=${p.productId}&&mod1=${p.cateId}">Select options</a>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </div>
                            <div class="cart_totals ">
                                <h2>Cart Totals</h2>

                                <table cellspacing="0">
                                    <tbody>
                                        <tr class="cart-subtotal">
                                            <th>Cart Subtotal</th>
                                            <td><span class="amount"><fmt:formatNumber pattern="##.##" value="${(o.totalMoney)}"/>$</span></td>
                                        </tr>

                                        <tr class="shipping">
                                            <th>Shipping and Handling</th>
                                            <td>2$</td>
                                        </tr>

                                        <tr class="order-total">
                                            <th>Order Total</th>
                                            <td><strong><span class="amount"></span><fmt:formatNumber pattern="##.##" value="${(o.totalMoney) + 2}"/>$</strong> </td>
                                        </tr>
                                    </tbody>
                                </table>
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
    </body>
</html>