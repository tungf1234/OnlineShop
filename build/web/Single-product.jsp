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
        <title>Product Page - Ustora Demo</title>

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

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script>
            document.addEventListener('DOMContentLoaded', function () {
                const minusButton = document.querySelector('.minus');
                const plusButton = document.querySelector('.plus');
                const quantityInput = document.querySelector('.qty');

                minusButton.addEventListener('click', function () {
                    if (quantityInput.value > 1) {
                        quantityInput.value = parseInt(quantityInput.value) - 1;
                    }
                });

                plusButton.addEventListener('click', function () {
                    quantityInput.value = parseInt(quantityInput.value) + 1;
                });
            });

            function buy(id, cateid) {
                var quantityElement = document.querySelector('.quantity input.qty');
                var m = quantityElement.value;
                document.querySelector('.f').action = "addtocart?id=" + id + "&cateid=" + cateid + "&num=" + m;
                document.querySelector('.f').submit();
                showSuccessAlert();
            }


            function showSuccessAlert() {
                alert("Product added successfully to the cart!");
            }
            function fb(customerId, productId) {
                document.querySelector('.fed').action ="feedback?cid" +customerId +"&pid"+productId;
                document.querySelector('.fed').submit();
                show();
            }
            
            function show(){
                alert("Feedback Successfully!");
            }
        </script>
    </head>
    <body>
        <%@include file="Header.jsp" %>
        <!-- End mainmenu area -->

        <c:set var="currentPage" value="Single-product.jsp"/>
        <%@include file="Menu.jsp" %>
        <!-- End mainmenu area -->

        <div class="product-big-title-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="product-bit-title text-center">
                            <h2>Shop</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="single-product-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">
                    <div class="product-content-right">
                        <!--                        <div class="product-breadcroumb">
                                                    <a href="home">Home</a>
                                                    <a href="">Category Name</a>
                                                    <a href="">Sony Smart TV - 2015</a>
                                                </div>-->

                        <div class="row">
                            <div class="col-sm-6">
                                <div class="product-images">
                                    <div class="product-main-img">
                                        <img src="${pro.imgUrl}" alt="${pro.productName}">
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <div class="product-inner">
                                    <h2 class="product-name">${pro.productName}</h2>
                                    <div class="product-inner-price">
                                        <ins style="color: red">${pro.productPrice}$</ins> 
                                    </div>    
                                    
                                    <form class="f" method="post">
                                        <div class="quantity">
                                            <input type="button" value="-" class="minus">
                                            <input type="number" size="4" class="input-text qty text" title="Qty" value="1" name="quantity" min="1" step="1">
                                            <input type="button" value="+" class="plus">
                                        </div>
                                        <button class="add_to_cart_button" onclick="buy('${pro.productId}', '${pro.cateId}')">Add to cart</button>
                                    </form>   

                                    <div class="product-inner-category">
                                        <p>Category: <a href="">Summer</a>. 
                                    </div> 

                                    <div role="tabpanel">
                                        <ul class="product-tab" role="tablist">
                                            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Description</a></li>
                                            <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Reviews</a></li>
                                        </ul>
                                        <div class="tab-content">
                                            <div role="tabpanel" class="tab-pane fade in active" id="home">
                                                <p>CPU: ${proDet.cpu}</p>  
                                                <p>RAM: ${proDet.ram}</p>
                                                <p>MONITOR: ${proDet.monitor}</p>
                                                <p>GPU: ${proDet.gpu}</p>
                                                <p>ROM: ${proDet.rom}</p>
                                                <p>WEIGHT: ${proDet.weight}</p>
                                                <p>SIZE: ${proDet.size}</p>
                                                <p>WEBCAM: ${proDet.webcam}</p>
                                            </div>
                                            <div role="tabpanel" class="tab-pane fade" id="profile">
                                                <c:if test="${not empty sessionScope.user}">
                                                    <h2>Reviews</h2>
                                                    <form action="" class="fed">
                                                        <div class="submit-review">
                                                            <p hidden><label for="name"></label> <input name="customerId" type="text" value="${sessionScope.user.customerId}"></p>
                                                            <p hidden><label for="email"></label> <input name="productId" type="text" value="${pro.productId}"></p>
                                                            <div class="rating-chooser">
                                                                <p>Lượt đánh giá: ${countVote}</p>
                                                                <p>Your rating</p>
                                                                <p><input type="number" name="vote" min="1" max="5"></p>
                                                            </div>
                                                            <p><label for="review">Your review</label> <textarea name="review" id="" cols="30" rows="10"></textarea></p>
                                                            <p><button onclick="fb('${sessionScope.user.customerId}', '${pro.productId}')">Submit</button></p>
                                                        </div>
                                                    </form>
                                                </c:if>

                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="related-products-wrapper">
                            <h2 class="related-products-title">Related Products</h2>
                            <div class="related-products-carousel">
                                <c:forEach items="${listProByCateId}" var="c" varStatus="loop">
                                    <c:if test="${loop.index <= 10}">
                                        <div class="single-product">
                                            <div class="product-f-image">
                                                <img src="${c.imgUrl}" alt="${c.productName}">
                                                <div class="product-hover">
                                                    <a href="#" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Add to cart</a>
                                                    <a href="productdetails?mod=${c.productId}&mod1=${c.cateId}" class="view-details-link"><i class="fa fa-link"></i> See details</a>
                                                </div>
                                            </div>

                                            <h2><a href="productdetails?mod=${c.productId}">${c.productName}</a></h2>

                                            <div class="product-carousel-price">
                                                <ins>${c.productPrice}$</ins>
                                            </div> 
                                        </div>
                                    </c:if>
                                </c:forEach>
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
