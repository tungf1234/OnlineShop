<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Login Form</title>

        <!-- Font Icon -->
        <link rel="stylesheet"
              href="login_form/fonts_login/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="login_form/css_login/style.css">
    </head>
    <body>

        <div class="main">

            <!-- Sing in  Form -->
            <section class="sign-in">
                <div class="container">
                    <div class="signin-content">
                        <div class="signin-image">
                            <figure>
                                <img src="login_form/images_login/signin-image.jpg" alt="sing up image">
                            </figure>
                            <a href="register" class="signup-image-link">Create an account</a>
                        </div>

                        <div class="signin-form">
                            <h2 class="form-title">Login</h2>
                            <c:set var="cookie" value="${pageContext.request.cookies}"/>
                            <form method="post" action="login" class="register-form" id="login-form">
                                <div class="form-group">
                                    <label for="username">
                                        <i class="zmdi zmdi-account material-icons-name"></i>
                                    </label> 
                                    <input type="text" name="username" id="username" placeholder="Username" 
                                           value="${not empty requestScope.error ? requestScope.username : cookie.cuser.value}"/> 
                                </div>
                                <div class="form-group">
                                    <label for="password">
                                        <i class="zmdi zmdi-lock"></i>
                                    </label> 
                                    <input type="password" name="pass" id="password" placeholder="Password" 
                                           value="${not empty requestScope.error ? requestScope.pass : cookie.cpass.value}"/>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" ${(cookie.crem!=null?'checked':'')} name="remember-me" id="remember-me" class="agree-term" value="ON"/> 
                                    <label for="remember-me" class="label-agree-term">
                                        <span><span></span></span>Remember me
                                    </label>
                                </div>
                                <c:if test="${not empty requestScope.error}">
                                    <div class="error">
                                        <a style="color: red">${requestScope.error}</a> 
                                    </div>
                                </c:if>
                                <div>
                                    Forgot <a href="forgotpassword">password?</a>
                                </div>
                                <div class="form-group form-button">
                                    <input type="submit" name="signin" id="signin" class="form-submit" value="Log in" />
                                </div>
                            </form>
                            <div class="social-login">
                                <span class="social-label">Or login with</span>
                                <ul class="socials">
                                    <li><a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile&redirect_uri=http://localhost:9999/laptop_online_shop/loginemail&response_type=code&client_id=780232171487-l3i8u7rg7s73qp009p3t775n065ghvp9.apps.googleusercontent.com&approval_prompt=force"><i
                                                class="display-flex-center zmdi zmdi-google"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="form-group form-button" style="text-align: center;padding-bottom:50px">
                        <input style="background: red;" type="submit" name="cancel" id="cancel" 
                               class="form-submit" value="Cancel" onclick="cancelAction()"/>
                    </div>
                </div>
            </section>
        </div>

        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="login_form/js_login/main.js"></script>
    </body>
    <!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>