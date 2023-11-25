package Dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author FPT University - PRJ301
 */
public class DBContext {

    protected Connection connection;

    /**
     * Khởi tạo một đối tượng DBContext và thiết lập kết nối cơ sở dữ liệu.
     *
     * @param user Tên người dùng để kết nối đến cơ sở dữ liệu.
     * @param pass Mật khẩu để kết nối đến cơ sở dữ liệu.
     * @param url URL cơ sở dữ liệu.
     */
    public DBContext() {
        //@Students: You are allowed to edit user, pass, url variables to fit 
        //your system configuration
        //You can also add more methods for Database Interaction tasks. 
        //But we recommend you to do it in another class
        // For example : StudentDBContext extends DBContext , 
        //where StudentDBContext is located in dal package, 
        try {
            String user = "sa";
            String pass = "123";
            String url = "jdbc:sqlserver://localhost:1433;databaseName =Online_shopping";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lấy kết nối đến cơ sở dữ liệu.
     *
     * @return Kết nối cơ sở dữ liệu.
     */
    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        try {
            System.out.println(new DBContext().connection);
        } catch (Exception e) {
        }
    }
}
