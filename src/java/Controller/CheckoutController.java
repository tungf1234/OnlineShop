package Controller;

import Dal.CustomerDAO;
import Dal.OrderDAO;
import Dal.ProductDAO;
import Model.Account;
import Model.Cart;
import Model.Customer;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author Acer Nitro5
 */
public class CheckoutController extends HttpServlet {

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
            out.println("<title>Servlet CheckoutController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckoutController at " + request.getContextPath() + "</h1>");
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
      
        
        
        ProductDAO d = new ProductDAO();
        List<Product> list = d.getListProducts();
        Cookie[] arr = request.getCookies();

        String txt = "";
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                }
            }
        }
        
        Cart cart = new Cart(txt, list);
       
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("Checkout.jsp").forward(request, response);
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
 
        String nameacount = request.getParameter("username");
        System.out.println("a " + nameacount);
        String phone = request.getParameter("phone");
        System.out.println(phone);
        String address = request.getParameter("address");
        System.out.println(address);
        
        ProductDAO prod = new ProductDAO();
        List<Product> list = prod.getListProducts();
        Cookie[] arr = request.getCookies();
        String txt = "";
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                }
            }
        }
        Cart cart = new Cart(txt, list);
        HttpSession session = request.getSession();
        Customer account = (Customer) session.getAttribute("user");
        if(account==null){
            response.sendRedirect("shop");
        }else{
            
            OrderDAO ord = new OrderDAO();
            ord.addOrder(cart, account, address, phone, nameacount);
            ord.addCustomerBill(cart, ord.getLastOrderID());
            ord.updateQuantity(cart);
            Cookie c = new Cookie("cart", "");
            c.setMaxAge(0);
            response.addCookie(c);
            request.setAttribute("mess", "Order Successfully!!!");
            response.sendRedirect("Thanks.jsp");
            
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
