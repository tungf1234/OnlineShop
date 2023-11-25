/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Util.Encryption;
import Dal.AccountDAO;
import Dal.CustomerDAO;
import Model.Account;
import Model.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Register.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fname = request.getParameter("first_name");
        String lname = request.getParameter("last_name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("re_pass");
        String contact = request.getParameter("contact");
        String error;

        AccountDAO accDAO = new AccountDAO();
        CustomerDAO cusDAO = new CustomerDAO();
        Account acc = new Account(username, 0, 0, 0, null, Encryption.toSHA1(pass));
        Customer cus = new Customer(username, fname, lname, 0, null, email, contact);
        //check format gmail 
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        //CHECK PASSWORD
        String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{6,}$";
        //1 chữ hoa, 1 chữ thường, 1 số, 1 kí tự đặc biệt, ít nhất 6 kí tự
        Pattern pattern1 = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher1 = pattern1.matcher(pass);
        //CHECK USERNAME 
        String USERNAME_REGEX = "^[a-zA-Z0-9_]{3,20}$";
        Pattern pattern2 = Pattern.compile(USERNAME_REGEX);
        Matcher matcher2 = pattern2.matcher(username);
        //CHECK PHONE
        String regex = "^(\\+84|0)\\d{9}$"; // bắt đầu bằng số 0 hoặc "+84" (mã quốc gia của Việt Nam)
        Pattern number = Pattern.compile(regex);
        Matcher matcher3 = number.matcher(contact);

        if (fname.isEmpty() || lname.isEmpty() || username.isEmpty()
                || email.isEmpty() || pass.isEmpty() || re_pass.isEmpty()
                || contact.isEmpty()) {
            error = "Some input is empty";

            request.setAttribute("fname", fname);
            request.setAttribute("lname", lname);
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("pass", pass);
            request.setAttribute("re_pass", re_pass);
            request.setAttribute("contact", contact);
            request.setAttribute("error", error);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else if (accDAO.checkIdExist(username)) {
            error = "Username already exists";

            request.setAttribute("fname", fname);
            request.setAttribute("lname", lname);
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("pass", pass);
            request.setAttribute("re_pass", re_pass);
            request.setAttribute("contact", contact);
            request.setAttribute("error", error);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        }else if (!matcher2.matches()) {
            error = "Invalid username format";

            request.setAttribute("fname", fname);
            request.setAttribute("lname", lname);
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("pass", pass);
            request.setAttribute("re_pass", re_pass);
            request.setAttribute("contact", contact);
            request.setAttribute("error", error);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else if (!matcher.matches()) {
            error = "Invalid email format";

            request.setAttribute("fname", fname);
            request.setAttribute("lname", lname);
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("pass", pass);
            request.setAttribute("re_pass", re_pass);
            request.setAttribute("contact", contact);
            request.setAttribute("error", error);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else if (cusDAO.checkEmailExist(email)) {
            error = "Email already exists";

            request.setAttribute("fname", fname);
            request.setAttribute("lname", lname);
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("pass", pass);
            request.setAttribute("re_pass", re_pass);
            request.setAttribute("contact", contact);
            request.setAttribute("error", error);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else if (!matcher1.matches()) {
            error = "Password must have uppercase, lowercase letters, special characters and be longer than 6 characters";

            request.setAttribute("fname", fname);
            request.setAttribute("lname", lname);
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("pass", pass);
            request.setAttribute("re_pass", re_pass);
            request.setAttribute("contact", contact);
            request.setAttribute("error", error);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else if (!re_pass.equals(pass)) {
            error = "Password and Confirm password aren't the same";

            request.setAttribute("fname", fname);
            request.setAttribute("lname", lname);
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("pass", pass);
            request.setAttribute("re_pass", re_pass);
            request.setAttribute("contact", contact);
            request.setAttribute("error", error);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else if (!matcher3.matches()) {
            error = "Phone number must be 10 digits start with '0' or '+84'";

            request.setAttribute("fname", fname);
            request.setAttribute("lname", lname);
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("pass", pass);
            request.setAttribute("re_pass", re_pass);
            request.setAttribute("contact", contact);
            request.setAttribute("error", error);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else {
            cusDAO.addCustomer(cus);
            accDAO.addAccount(acc);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
