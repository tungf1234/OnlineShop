/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.CustomerBill;
import java.sql.SQLException;

/**
 *
 * @author Acer Nitro5
 */
public class CustomerBillDAO extends DBContext {

    public List<CustomerBill> getAllCustomerBill() {
        String sql = "SELECT  [orderId]\n"
                + ",[productId]\n"
                + ",[productQuantity]\n"
                + ",[productPrice] FROM CustomerBill";
        List<CustomerBill> cusbill = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CustomerBill cu = new CustomerBill();
                cu.setOrderId(rs.getInt("OrderID"));
                cu.setProductId(rs.getString("ProductID"));

                cu.setQuantity(rs.getInt("Quantity"));
                cu.setPrice(rs.getDouble("UnitPrice"));
                cusbill.add(cu);
            }
        } catch (SQLException e) {
            System.out.println("Loi SQl: " + e.getMessage());
        }
        return cusbill;
    }

    public List<CustomerBill> getCustomerBillByID(int orderID) {
        String sql = "SELECT orderId, productId, productQuantity, productPrice FROM CustomerBill WHERE orderId = ?";
        List<CustomerBill> t = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, orderID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               CustomerBill orderDetail = new CustomerBill();
               
                orderDetail.setOrderId(rs.getInt("OrderID"));
                orderDetail.setProductId(rs.getString("ProductID"));
                orderDetail.setQuantity(rs.getInt("Quantity"));
                orderDetail.setPrice(rs.getDouble("UnitPrice"));
                t.add(orderDetail);
            }
        } catch (Exception e) {
           System.out.println("Loi SQl: " + e.getMessage());
        }
        return t; // Return null if the order detail with the specified ID is not found
    }

}
