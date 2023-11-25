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
        <title>Shop Page- Ustora Demo</title>

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
        <style>
            .single-shop-product {
                border: 2px solid #ccc;
                border-radius: 10px;
                margin-bottom: 20px;
                text-align: center;
                background-color: #e0f2f1;
                padding-bottom: 15px;
            }

            .single-shop-product img {
                max-height: 250px;
                width: 450px;
                object-fit: cover;
                border-radius: 10px;
                transition: transform 0.3s;
            }

            .single-shop-product img:hover {
                transform: scale(1.1);
                box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
            }

            .product-option-shop {
                margin-top: 10px;
                border-top: 1px solid #ccc;
                padding-top: 10px;
            }
        </style>
    </head>

</style>
</head>
<body>
    <%@include file="Header.jsp" %>
    <!-- End header area -->

    <c:set var="currentPage" value="shop"/>
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
                <div class="col-md-4">
                    <div class="single-sidebar">
                        <h2 class="sidebar-title">Search Products</h2>
                        <form action="search">
                            <input type="text" placeholder="Search products..." name="txtSearch" value="${txtSearch}">
                            <input type="submit" value="Search">
                        </form>
                    </div>
                </div>
            </div>

            <div class="single-sidebar" >
                <h2 class="sidebar-title">Filter Products</h2></br>
                <div style="display: flex;">
                <form id="sortpro" action="sort" style="margin-right: 10px">
                    <select name="sort" onchange="mySort()">
                        <option>Sort</option>
                        <option value="asc">Price Up</option>
                        <option value="desc">Price Down</option>
                        <option value="name_asc">Name (A-Z)</option>
                        <option value="name_desc">Name (Z-A)</option>
                    </select>
                </form>

                <script>
                    function mySort() {
                        document.getElementById("sortpro").submit();
                    }
                </script>

                <form id="sortCategory" action="category" style="margin-right: 10px">
                    <select name="categoryId" onchange=" myCategorySort()">
                        <option value="0">All Categories</option>
                        <option value="1">Laptop Office, Study</option>
                        <option value="2">Laptop Gaming</option>
                        <option value="3">Laptop Design</option>
                    </select>
                </form>

                <script>
                    function myCategorySort() {
                        document.getElementById("sortCategory").submit();
                    }
                </script>

                <form id="sortBrand" action="brand" style="margin-right: 10px">
                    <select id="brandId" name="brandId">
                        <option value="0">All Brands</option>
                        <option value="1">Dell</option>
                        <option value="2">Lenovo</option>
                        <option value="3">Microsoft</option>
                        <option value="4">Asus</option>
                        <option value="5">Acer</option>
                        <option value="6">HP</option>
                        <option value="7">Apple</option>
                        <option value="8">MSI</option>
                        <option value="9">GIGABYTE</option>
                    </select>
                </form>

                <script>
                    document.getElementById("brandId").addEventListener("change", function () {
                        document.getElementById("sortBrand").submit();
                    });
                </script>

                <form id="sortPrice" action="price" style="margin-right: 10px">
                    <select id="priceRange" name="priceRange">
                        <option>Price</option>
                        <option value="0-600">Under $600</option>
                        <option value="600-1000">$600 - $1000</option>
                        <option value="1000-2000">$1000 - $2000</option>
                        <option value="2000-10000">From $2000</option> <!-- Tùy chọn mới -->
                    </select>
                </form>

                <script>
                    document.getElementById("priceRange").addEventListener("change", function () {
                        document.getElementById("sortPrice").submit();
                    });
                </script>
                </div>
            </div>


            <div class="row">
                <c:forEach items="${listPro}" var="p" varStatus="loop">
                    <c:if test="${loop.index % 3 == 0}">
                        <div class="row">
                        </c:if>
                        <form action="addtocart" method="post">
                            <div class="col-md-4 col-sm-6">
                                <div class="single-shop-product">
                                    <div class="product-upper">
                                        <a href="productdetails?mod=${p.productId}&mod1=${p.cateId}"><img src="${p.imgUrl}" alt="${p.productName}" style="justify-content: center"></a>
                                    </div>
                                    <h2><a href="productdetails?mod=${p.productId}&mod1=${p.cateId}" style="display: flex; justify-content: center">${p.productName}</a></h2>
                                    <div class="product-carousel-price" style="text-align: center">
                                        <h4 style="color: red;">${p.productPrice} $</h4> 
                                    </div>  
                                    <div class="product-option-shop" style="text-align: center">
                                        <a href="productdetails?mod=${p.productId}&mod1=${p.cateId}" class="add_to_cart_button">Buy Now</a>
                                    </div>                       
                                </div>
                            </div>
                        </form>
                        <c:if test="${loop.index % 3 == 2 or loop.last}">
                        </div>
                    </c:if>
                </c:forEach>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="product-pagination text-center">
                        <nav>
                            <ul class="pagination">
                                <c:set var="currentPage" value="${page}" />
                                <c:set var="totalPages" value="${totalPage}" />

                                <!-- Previous Page -->
                                <c:if test="${currentPage > 1}">
                                    <li>
                                        <a href="?page=${currentPage - 1}" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                </c:if>

                                <!-- Page Numbers -->
                                <c:forEach begin="1" end="${totalPages}" var="pageNumber">
                                    <li class="<c:if test="${pageNumber == currentPage}">active</c:if>">
                                        <a href="?page=${pageNumber}">${pageNumber}</a>
                                    </li>
                                </c:forEach>

                                <!-- Next Page -->
                                <c:if test="${currentPage < totalPages}">
                                    <li>
                                        <a href="?page=${currentPage + 1}" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                </c:if>
                            </ul>
                        </nav>
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
