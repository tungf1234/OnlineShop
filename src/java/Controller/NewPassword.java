/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.AccountDAO;
import Model.Account;
import Util.Encryption;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author thinh
 */
public class NewPassword extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String newPassword = request.getParameter("newPwd");
        String username = request.getParameter("username");
        Encryption encode = new Encryption();
        newPassword = encode.toSHA1(newPassword);
        
        AccountDAO accDao = new AccountDAO();
        accDao.updateAccountPassword(username ,newPassword);
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

}
