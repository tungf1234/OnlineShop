package Dal;

import Model.Account;
import Model.Cart;
import Model.Customer;
import Model.CustomerBill;
import Model.Product;
import Model.Item;
import Model.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer Nitro5
 */
public class OrderDAO extends DBContext{
    public void addOrder(Cart cart,Customer c, String address, String phone, String name) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try {
            // Thực hiện câu lệnh INSERT INTO ORDERS
            String sql = "INSERT INTO [ORDER] VALUES (?,?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);                     
            st.setString(1, date);
            st.setDouble(2, cart.getTotalMoney()+2); 
            st.setString(3, c.getCustomerId());
            st.setString(4, address);
            st.setString(5, phone);
            st.setString(6, name);
            st.executeUpdate();

        } catch (SQLException e) {
            // Xử lý ngoại lệ khi thực hiện INSERT INTO ORDERS
            System.out.println("Error at addOrder " + e.getMessage());
        }
    }
    
    public void cancelOrder(String oid) {
        String sql = "delete from Order\n"
                + "where OrderID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, oid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cancel order: " + e.getMessage());
        }
    }
    
    public int getLastOrderID() {
        String sql = "select top 1 orderId from [Order] order by orderId desc";
        int id = 0;
        try {
            PreparedStatement st1 = connection.prepareStatement(sql);
            ResultSet rs = st1.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("GetLastOrderId: " + e.getMessage());
        }
        return id;
    }
    
    public void addCustomerBill(Cart cart, int oid) {
    String sql = "INSERT INTO CustomerBill (orderId, productId, productQuantity, productPrice) VALUES (?,?,?,?)";
    try {
        for (Item i : cart.getItems()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, oid);
            st.setString(2, i.getProduct().getProductId());
            st.setInt(3, i.getQuantity());
            st.setDouble(4, i.getProduct().getProductPrice() /* trừ đi tiền discount */);

            st.executeUpdate();
        }
    } catch (SQLException e) {
        // Xử lý exception ở đây
        System.out.println("addCustomerBill: " + e.getMessage());
    }
}

    
     public void updateQuantity(Cart cart) {
        String sql_3 = "UPDATE Product SET quantity = quantity - ? WHERE productId = ?";
        try {
            PreparedStatement st3 = connection.prepareStatement(sql_3);
            for (Item i : cart.getItems()) {
                st3.setInt(1, i.getQuantity());
                st3.setString(2, i.getProduct().getProductId());
                st3.executeUpdate();
            }
        } catch (SQLException e) {
        }
    }
     
     
     
//     public List<CustomerBill> orderDetail(int oid) {
//        String sql = "SELECT od.OrderDetailID, od.OrderID,p.Name,od.Quantity,od.UnitPrice FROM OrderDetail od\n"
//                + "JOIN Product p \n"
//                + "ON p.ProductID = od.ProductID WHERE od.OrderID = ?";
//        List<CustomerBill> lod = new ArrayList<>();
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, oid);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                CustomerBill o = new CustomerBill();
//                o.setBillId(rs.getInt(1));
//                o.setOrderId(rs.getInt(2));
////                o.(rs.getString(3));
//                o.setQuantity(rs.getInt(4));
//                o.setPrice(rs.getDouble(5));
//                
//                lod.add(o);
//            }
//        } catch (Exception e) {
//        }
//        return lod;
//    }
    public List<Order> myOrder() {
        String sql = "SELECT o.orderId, o.orderDate, o.totalPrice, o.customerId, o.address, o.phoneNumber, o.name,\n"
                + "p.productName, p.productPrice, p.imgUrl, cb.productQuantity\n"
                + "FROM [Order] o\n"
                + "JOIN CustomerBill cb ON o.orderId = cb.orderId\n"
                + "JOIN Product p ON cb.productId = p.productId\n"
                + "ORDER BY o.orderId DESC";
        List<Order> lo = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrderId(rs.getInt("orderId"));
                o.setDate(rs.getDate("orderDate"));
                o.setTotalPrice((float) rs.getDouble("totalPrice"));
                o.setName(rs.getString("name"));
                o.setPhone(rs.getInt("phoneNumber"));// Chắc chắn customerId là tên khách hàng, bạn có thể cần cột khác
                o.setAddress(rs.getString("address"));
                o.setProductName(rs.getString("productName")); // Set product name
                o.setProductPrice((float) rs.getDouble("productPrice")); // Set product price
                o.setProductImage(rs.getString("imgUrl")); // Set product image URL
                o.setProductQuantity(rs.getInt("productQuantity")); // Set product quantity

                lo.add(o);
            }
        } catch (Exception e) {
            System.out.println("mypur:  " + e.getMessage());
        }
        return lo;
    }
}