/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Lớp CustomerDAO là một thành phần của lớp DataAccess Layer (DAL) và chịu trách nhiệm thực hiện các thao tác liên quan đến dữ liệu của đối tượng Customer trong cơ sở dữ liệu. Các thao tác bao gồm kiểm tra email tồn tại, thêm khách hàng mới, lấy thông tin khách hàng theo ID và cập nhật thông tin khách hàng.
 *
 * @author User
 */
public class CustomerDAO extends DBContext {

    /**
     * Kiểm tra sự tồn tại của một địa chỉ email trong cơ sở dữ liệu.
     *
     * @param email Địa chỉ email cần kiểm tra.
     * @return Trả về true nếu email đã tồn tại, ngược lại trả về false.
     */
    public boolean checkEmailExist(String email) {
        String sql = "Select * from Customer\n"
                + "where email = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, email);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error checkEmailExist " + e.getMessage());
        }
        return false;
    }

    /**
     * Thêm một khách hàng mới vào cơ sở dữ liệu.
     *
     * @param cus Đối tượng Customer chứa thông tin của khách hàng cần thêm.
     */
    public void addCustomer(Customer cus) {
        String sql = "insert into Customer values(\n"
                + "    ?,?,?,?,?,?,?\n"
                + ")";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, cus.getCustomerId());
            pre.setString(2, cus.getFirstName());
            pre.setString(3, cus.getLastName());
            pre.setInt(4, cus.getIsVerified());
            pre.setString(5, cus.getAddress());
            pre.setString(6, cus.getEmail());
            pre.setString(7, cus.getPhoneNumber());

            pre.execute();
        } catch (SQLException e) {
            System.out.println("Error addCustomer " + e.getMessage());
        }
    }

    /**
     * Lấy thông tin của một khách hàng dựa trên ID.
     *
     * @param id ID của khách hàng cần lấy thông tin.
     * @return Đối tượng Customer chứa thông tin của khách hàng hoặc null nếu không tìm thấy.
     */
    public Customer getCustomerById(String id) {
        Customer cus = new Customer();
        String sql = "select * from Customer\n"
                + "where customerId = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, id);
            ResultSet rs = pre.executeQuery();
            //get All Employee value
            while (rs.next()) {
                cus.setCustomerId(rs.getString(1));
                cus.setFirstName(rs.getString(2));
                cus.setLastName(rs.getString(3));
                cus.setIsVerified(rs.getInt(4));
                cus.setAddress(rs.getString(5));
                cus.setEmail(rs.getString(6));
                cus.setPhoneNumber(rs.getString(7));
            }
        } catch (SQLException e) {
            System.out.println("Error at getCustomerById " + e.getMessage());
        }
        return cus;
    }
    
        public Customer getCustomerByEmail(String email) {
        Customer cus = new Customer();
        String sql = "select * from Customer\n"
                + "where email = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, email);
            ResultSet rs = pre.executeQuery();
            //get All Employee value
            while (rs.next()) {
                cus.setCustomerId(rs.getString(1));
                cus.setFirstName(rs.getString(2));
                cus.setLastName(rs.getString(3));
                cus.setIsVerified(rs.getInt(4));
                cus.setAddress(rs.getString(5));
                cus.setEmail(rs.getString(6));
                cus.setPhoneNumber(rs.getString(7));
            }
        } catch (SQLException e) {
            System.out.println("Error at getCustomerById " + e.getMessage());
        }
        return cus;
    }

    /**
     * Cập nhật thông tin của một khách hàng trong cơ sở dữ liệu.
     *
     * @param customerId     ID của khách hàng cần cập nhật thông tin.
     * @param firstName      Tên khách hàng mới.
     * @param lastName       Họ và tên đệm khách hàng mới.
     * @param isVerified     Trạng thái xác thực khách hàng mới.
     * @param address        Địa chỉ mới của khách hàng.
     * @param email          Địa chỉ email mới của khách hàng.
     * @param phoneNumber    Số điện thoại mới của khách hàng.
     */
    public void updateCustomer(String customerId, String firstName, String lastName, int isVerified,
            String address, String email, String phoneNumber) {
        String sql = "  update Customer set firstName = ?,"
                + "lastName = ?,"
                + "isVerified = ?,"
                + "address = ?,email = ?,"
                + "phoneNumber = ? where customerId = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, firstName);
            pre.setString(2, lastName);
            pre.setInt(3, isVerified);
            pre.setString(4, address);
            pre.setString(5, email);
            pre.setString(6, phoneNumber);

            pre.setString(7, customerId);

            pre.execute();
        } catch (SQLException e) {
            System.out.println("Error at updateCustomer " + e.getMessage());
        }
    }
}
