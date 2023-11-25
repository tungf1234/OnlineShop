/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Brand;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class BrandDAO extends DBContext{
    //list brand
        public List<Brand> getListBrand() {
        List<Brand> list = new ArrayList<>();
        try {
            String sql = "select * from Brand";
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Brand b = new Brand();
                b.setBrandId(rs.getInt(1));
                b.setBrandName(rs.getString(2));
                b.setBrandImgUrl(rs.getString(3));
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println("Error at getListBrand " + e.getMessage());;
        }
        return list;
    }
}
