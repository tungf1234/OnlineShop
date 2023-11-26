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
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class LoginController extends HttpServlet {

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
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        //check if user already login or not
        if (session.getAttribute("user") != null) {
            response.sendRedirect("home");
            return;
        }
        request.getRequestDispatcher("Login.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        String rem = request.getParameter("remember-me");

        HttpSession session = request.getSession();
        AccountDAO accDAO = new AccountDAO();
        CustomerDAO cusDAO = new CustomerDAO();

        //Create 3 cookies
        Cookie cu = new Cookie("cuser", username);
        Cookie cp = new Cookie("cpass", pass);
        Cookie cr = new Cookie("crem", rem);

        if (username.isEmpty() || pass.isEmpty()) {
            String error = "Username or password is empty!";

            request.setAttribute("username", username);
            request.setAttribute("pass", pass);
            request.setAttribute("error", error);

            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            try {
                if (accDAO.checkLogin(username, Encryption.toSHA1(pass))) {
//                    Account accNew = accDAO.getAccountById(username);
                    Customer cusNew = cusDAO.getCustomerById(username);
                    session.setAttribute("user", cusNew);
                    if (rem != null) {
                        //choose
                        cu.setMaxAge(60*60*24);//1d
                        cp.setMaxAge(60*60*24);
                        cr.setMaxAge(60*60*24);
                    }else{ 
                        //not choose
                        cu.setMaxAge(0);
                        cp.setMaxAge(0);
                        cr.setMaxAge(0);
                    }
                    response.addCookie(cu);
                    response.addCookie(cp);
                    response.addCookie(cr);
                    response.sendRedirect("home");
                } else {
                    String error = "Login failed, username or password are incorrect!";

                    request.setAttribute("username", username);
                    request.setAttribute("pass", pass);
                    request.setAttribute("error", error);
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
