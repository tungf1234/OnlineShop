/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.AccountDAO;
import Dal.CustomerDAO;
import Model.Customer;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author thinh
 */
public class ForgotPassword extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ForgotPassword.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String username = request.getParameter("username");
        RequestDispatcher dispatcher = null;
        int otpvalue = 0;
        HttpSession mySession = request.getSession();
        
        if (email != null && !email.equals("")) {
            AccountDAO accDao = new AccountDAO();
            CustomerDAO cusDAO = new CustomerDAO();
            Customer cus = cusDAO.getCustomerById(username);
            boolean isMailExist = cusDAO.checkEmailExist(email);
            if (isMailExist) {
                // sending otp
                Random rand = new Random();
                otpvalue = rand.nextInt(1255650);
                
                String to = cus.getEmail();// change accordingly
                // Get the session object
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");
                Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("homieshop.website@gmail.com", "qsxnvihkzmnbakrt");// Put your email
                        // id and
                        // password here
                    }
                });
                // compose message
                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(email));// change accordingly
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    message.setSubject("Forgot Password");
                    message.setText("Your OTP is: " + otpvalue + "\nThe OTP will expire in 30 minutes! Enter this OTP to reset password!\nRegrad!");
                    // send message
                    Transport.send(message);
                    System.out.println("message sent successfully");
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
                request.setAttribute("username", username);
                dispatcher = request.getRequestDispatcher("/EnterOtp.jsp");
                request.setAttribute("message", "OTP is sent to your email");
                //request.setAttribute("connection", con);
                mySession.setAttribute("otp", otpvalue);
                mySession.setAttribute("email", email);
                dispatcher.forward(request, response);
                //request.setAttribute("status", "success");
            }else{
                request.setAttribute("msg", "Thông tin email không tồn tại vui lòng thử lại!");
                request.getRequestDispatcher("/ForgotPassword.jsp").forward(request, response);
            }
        }

    }
}
