<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Register Form</title>

        <!-- Font Icon -->
        <link rel="stylesheet"
              href="login_form/fonts_login/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="login_form/css_login/style.css">
    </head>
    <body>

        <div class="main">

            <!-- Sign up form -->
            <section class="signup">
                <div class="container">
                    <div class="signup-content">
                        <div class="signup-form">
                            <h2 class="form-title">Register</h2>

                            <form method="post" action="register" class="register-form" id="register-form">
                                <div class="form-group">
                                    <label for="fname">
                                        <i class="zmdi zmdi-account material-icons-name"></i>
                                    </label> 
                                    <input type="text" name="first_name" id="name" placeholder="First name" value="${fname}"/>
                                </div>
                                <div class="form-group">
                                    <label for="lname">
                                        <i class="zmdi zmdi-account material-icons-name"></i>
                                    </label> 
                                    <input type="text" name="last_name" id="name" placeholder="Last name" value="${lname}"/>
                                </div>
                                <div class="form-group">
                                    <label for="name">
                                        <i class="zmdi zmdi-account material-icons-name"></i>
                                    </label> 
                                    <input type="text" name="username" id="name" placeholder="Username" value="${username}"/>
                                </div>
                                <div class="form-group">
                                    <label for="email">
                                        <i class="zmdi zmdi-email"></i>
                                    </label> 
                                    <input type="email" name="email" id="email" placeholder="Your Email" value="${email}"/>
                                </div>
                                <div class="form-group">
                                    <label for="pass">
                                        <i class="zmdi zmdi-lock"></i>
                                    </label> 
                                    <input type="password" name="pass" id="pass" placeholder="Password" value="${pass}"/>
                                </div>
                                <div class="form-group">
                                    <label for="re-pass">
                                        <i class="zmdi zmdi-lock-outline"></i>
                                    </label>
                                    <input type="password" name="re_pass" id="re_pass" placeholder="Repeat your password" value="${re_pass}"/>
                                </div>
                                <div class="form-group">
                                    <label for="contact">
                                        <i class="zmdi zmdi-lock-outline"></i>
                                    </label>
                                    <input type="text" name="contact" id="contact" placeholder="Contact no" value="${contact}"/>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" /> 
                                    <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in 
                                        <a href="#" class="term-service">Terms of service</a>
                                    </label>
                                </div>
                                <c:if test="${not empty requestScope.error}">
                                    <div class="error">
                                        <a style="color: red">${requestScope.error}</a> 
                                    </div>
                                </c:if>
                                <div class="form-group form-button">
                                    <input type="submit" name="signup" id="signup" class="form-submit" value="Register" />
                                </div>
                            </form>
                        </div>
                        <div class="signup-image">
                            <figure>
                                <img src="login_form/images_login/signup-image.jpg" alt="sign up image">
                            </figure>
                            <a href="login" class="signup-image-link">I am already
                                member</a>
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