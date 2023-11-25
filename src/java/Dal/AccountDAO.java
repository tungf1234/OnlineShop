/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Lớp AccountDAO cung cấp các phương thức để thao tác với cơ sở dữ liệu liên
 * quan đến tài khoản (Account). Bao gồm việc kiểm tra đăng nhập, kiểm tra sự
 * tồn tại của ID, tạo mới tài khoản và lấy tài khoản theo ID.
 *
 * @author User
 */
public class AccountDAO extends DBContext {

    /**
     * Kiểm tra đăng nhập cho một tài khoản sử dụng tên tài khoản và mật khẩu.
     *
     * @param account Tên tài khoản
     * @param password Mật khẩu
     * @return Trả về true nếu đăng nhập thành công, ngược lại trả về false.
     * @throws SQLException
     */
    public boolean checkLogin(String account, String password) throws SQLException {
        String sql = "Select password from Account\n"
                + "where accountId = ?;";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, account);
            ResultSet rs = pre.executeQuery();
            //check if the password is valid or not
            while (rs.next()) {
                if (rs.getString(1).equals(password)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error at checkLogin " + e.getMessage());
        }
        return false;
    }

    /**
     * Kiểm tra xem một ID tài khoản đã tồn tại trong cơ sở dữ liệu hay chưa.
     *
     * @param accountId ID của tài khoản cần kiểm tra
     * @return Trả về true nếu ID đã tồn tại, ngược lại trả về false.
     */
    public boolean checkIdExist(String accountId) {
        String sql = "Select * from Account\n"
                + "where accountId = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, accountId);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error at checkIdExist " + e.getMessage());
        }
        return false;
    }

    /**
     * Tạo một tài khoản mới trong cơ sở dữ liệu.
     *
     * @param acc Thông tin tài khoản cần tạo.
     */
    public void addAccount(Account acc) {
        String sql = "insert into Account values(\n"
                + "	?,?,?,?,?,?\n"
                + ")";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, acc.getAccountId());
            pre.setInt(2, acc.getIsActive());
            pre.setInt(3, acc.getIsAccountNonLock());
            pre.setInt(4, acc.getFailAttemp());
            pre.setDate(5, acc.getLockTime());
            pre.setString(6, acc.getPassword());

            pre.execute();
        } catch (SQLException e) {
            System.out.println("Error at addAccount " + e.getMessage());
        }
    }

    /**
     * Lấy thông tin tài khoản dựa trên ID tài khoản.
     *
     * @param id ID của tài khoản cần lấy thông tin.
     * @return Trả về đối tượng Account chứa thông tin tài khoản, hoặc trả về
     * một đối tượng Account rỗng nếu không tìm thấy.
     */
    public Account getAccountById(String id) {
        Account acc = new Account();
        String sql = "select * from Account\n"
                + "where accountId = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, id);
            ResultSet rs = pre.executeQuery();
            //get All Employee value
            while (rs.next()) {
                acc.setAccountId(rs.getString(1));
                acc.setIsActive(rs.getInt(2));
                acc.setIsAccountNonLock(rs.getInt(3));
                acc.setFailAttemp(rs.getInt(4));
                acc.setLockTime(rs.getDate(5));
                acc.setPassword(rs.getString(6));
            }
        } catch (SQLException e) {
            System.out.println("Error at getAccountById " + e.getMessage());
        }
        return acc;
    }

    public void updateAccountPassword(String accountId, String password) {
        String sql = "  update Account set password = ? where accountId = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, password);

            pre.setString(2, accountId);

            pre.execute();
        } catch (SQLException e) {
            System.out.println("Error at updateAccountPassword" + e.getMessage());
        }
    }

    public int resetPassWord(String accountId, String newPassword) {
        try {
            String sql = "update Account set password=? where accountId=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, newPassword);
            stm.setString(2, accountId);
            return stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error at resetPassWord " + e.getMessage());
        }
        return -1;
    }

    public String getMailAccount(String accountId) {
        String sql = "select * from Account,Customer where accountId=customerId and accountId=?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, accountId);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return rs.getString(12);
            }
        } catch (SQLException e) {
            System.out.println("Error at getMailAccount " + e.getMessage());
        }
        return null;
    }
}
