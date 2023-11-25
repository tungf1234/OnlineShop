<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Ustora Demo</title>

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
            .user-menu ul {
                position: relative;
                list-style-type: none;
                padding: 0;
            }

            .user-menu ul li {
                display: inline-block;
                margin-right: 10px;
                position: relative;
            }

            .submenu {
                position: absolute;
                top: 100%;
                left: 0;
                display: none;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0,0,0,0.1);
                min-width: 150px;
                z-index: 1;
            }

            .submenu ul {
                list-style-type: none;
                padding: 0;
            }

            .submenu ul li {
                padding: 10px;
            }

            .submenu ul li a {
                text-decoration: none;
            }

            .hello-trigger:hover .submenu {
                display: block;
            }
        </style>
    </head>
    <script>
        function login() {
            window.location.href = "login";
        }
        function logout() {
            window.location.href = "logoutemail";
        }
    </script>
    <body>
        <div class="header-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <div class="user-menu">
                            <ul>
                                <c:if test="${empty sessionScope.user && empty sessionScope.usergg}">
                                    <li><a href="login"><i class="fa fa-user"></i> Login</a></li>
                                    </c:if>
                                <c:if test="${not empty sessionScope.user}">
                                    <li class="hello-trigger">
                                        <a><i class="fa fa-user"></i> Hello ${sessionScope.user.firstName} ${sessionScope.user.lastName}</a>
                                        <div class="submenu">
                                            <ul>
                                                <li><a href="profile"><i class="fa fa-user"></i> Profile</a></li>
                                                <li><a href="logout"><i class="fa fa-user"></i> Logout</a></li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li><a href="cart"><i class="fa fa-user"></i> My Cart</a></li>
                                </c:if>
                                <c:if test="${not empty sessionScope.usergg}">
                                    <li class="hello-trigger">
                                        <a><i class="fa fa-user"></i> Hello ${sessionScope.usergg.name}</a>
                                        <div class="submenu">
                                            <ul>
                                                <li><a href="profile"><i class="fa fa-user"></i> Profile</a></li>
                                                <li><a href="logout"><i class="fa fa-user"></i> Logout</a></li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li><a href="cart"><i class="fa fa-user"></i> My Cart</a></li>
                                </c:if>

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- End header area -->
        <div class="site-branding-area">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="logo">
                            <h1><a href="home"><img src="img/logo.png"></a></h1>
                        </div>
                    </div>

                    <div class="col-sm-6">
                        <div class="shopping-item">
                            <a href="cart">Cart<i class="fa fa-shopping-cart"></i></a>
                            <span class="badge text-secondary border border-secondary rounded-circle">
                                <%
                                Cookie[] arr = request.getCookies();
                                int counter = 0;
                                if (arr != null) {
                                    for (Cookie o : arr) {
                                        if (o.getName().equals("cart")) {
                                            String[] splitedValue = o.getValue().split("/");
                                            counter += splitedValue.length;                                                    
                                            for (String s : splitedValue) {
                                                if (s.equals("")) {
                                                counter -= 1;
                                                }
                                            }
                                        }
                                    }
                                }
                                out.println(counter);
                                %>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End site branding area -->
    </body>