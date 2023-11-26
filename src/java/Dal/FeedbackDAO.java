/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CaoTung
 */
public class FeedbackDAO extends DBContext {

    public void addFeedback(String custemerId, int vote, String commnent, String productId) {
        String sql = "insert into Feedback "
                + "values(?,?,?,?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, custemerId);
            pre.setInt(2, vote);
            pre.setString(3, commnent);
            pre.setString(4, productId);
            pre.execute();
        } catch (SQLException e) {
            System.out.println("Error at addFeedback " + e.getMessage());
        }
    }

    public int getQuantity(String productId) {
        try {
            String sql = "select count(feedbackId) from Feedback "
                    + "where productId =?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, productId);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error at getQuantity " + e.getMessage());
        }
        return 0;
    }
}
