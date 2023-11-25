/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import java.util.List;
import Model.Product;
import Model.ProductDetails;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Lớp ProductDAO cung cấp các phương thức để thao tác với cơ sở dữ liệu liên
 * quan đến sản phẩm (Product) và thông tin chi tiết sản phẩm (ProductDetails).
 * Bao gồm việc lấy danh sách sản phẩm, lấy sản phẩm theo ID, tìm kiếm sản phẩm
 * theo tên, lấy thông tin chi tiết sản phẩm theo ID, và lấy sản phẩm phân
 * trang.
 *
 * @author User
 */
public class ProductDAO extends DBContext {

    /**
     * Lấy danh sách tất cả sản phẩm từ cơ sở dữ liệu.
     *
     * @return Danh sách các sản phẩm.
     */
    public List<Product> getListProducts() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select * from Product";
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getString(1));
                p.setProductName(rs.getString(2));
                p.setProductPrice(rs.getFloat(3));
                p.setBrandId(rs.getInt(4));
                p.setCateId(rs.getInt(5));
                p.setImgUrl(rs.getString(6));
                p.setQuantity(rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error at getListProducts " + e.getMessage());;
        }
        return list;
    }

    /**
     * Lấy danh sách sản phẩm theo ID danh mục và loại trừ sản phẩm có ID cụ
     * thể.
     *
     * @param cateId ID danh mục sản phẩm.
     * @param productId ID sản phẩm cần loại trừ.
     * @return Danh sách sản phẩm thuộc danh mục và loại trừ sản phẩm cụ thể.
     */
    public List<Product> getListProductByCateId(int cateId, String productId) {
        List<Product> list = new ArrayList<>();

        try {
            String sql = "select * from Product\n"
                    + "where cateId = ? and productId != ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, cateId);
            pre.setString(2, productId);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getString(1));
                p.setProductName(rs.getString(2));
                p.setProductPrice(rs.getFloat(3));
                p.setBrandId(rs.getInt(4));
                p.setCateId(rs.getInt(5));
                p.setImgUrl(rs.getString(6));
                p.setQuantity(rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error at getListProductByCateId " + e.getMessage());
        }
        return list;
    }

    /**
     * Lấy thông tin sản phẩm dựa trên ID sản phẩm.
     *
     * @param productId ID của sản phẩm cần lấy thông tin.
     * @return Trả về đối tượng Product chứa thông tin sản phẩm hoặc null nếu
     * không tìm thấy.
     */
    public Product getProductById(String productId) {
        String sql = "select * from Product\n"
                + "where productId = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, productId);
            ResultSet rs = pre.executeQuery();
            //Access every values of Product founded
            while (rs.next()) {
                return new Product(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4),
                        rs.getInt(5), rs.getString(6), rs.getInt(7));
            }
        } catch (SQLException e) {
            System.out.println("Error at getProductById " + e.getMessage());
        }
        return null;
    }

    /**
     * Tìm kiếm sản phẩm theo tên.
     *
     * @param txtSearch Tên sản phẩm hoặc một phần của tên sản phẩm cần tìm
     * kiếm.
     * @return Danh sách các sản phẩm tìm thấy.
     */
    public ArrayList<Product> searchProductByName(String txtSearch) {
        ArrayList<Product> list = new ArrayList();
        String sql = "select * from Product where productName like ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, "%" + txtSearch + "%");
            ResultSet rs = pre.executeQuery();
            //access all product table data
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println("Error at searchProductByName " + e.getMessage());
        }
        return list;
    }

    /**
     * Lấy thông tin chi tiết sản phẩm dựa trên ID sản phẩm.
     *
     * @param productId ID của sản phẩm cần lấy thông tin chi tiết.
     * @return Trả về đối tượng ProductDetails chứa thông tin chi tiết sản phẩm
     * hoặc null nếu không tìm thấy.
     */
    public ProductDetails getProductDetailById(String productId) {
        String sql = "select * from ProductDetails where productId = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, productId);
            ResultSet rs = pre.executeQuery();
            //Access every values of Product founded
            while (rs.next()) {
                return new ProductDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getFloat(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12));
            }
        } catch (SQLException e) {
            System.out.println("Error at getProductDetailById " + e.getMessage());
        }
        return null;
    }

    /**
     * Lấy danh sách sản phẩm phân trang.
     *
     * @param page Số trang cần lấy.
     * @param PAGE_SIZE Kích thước trang.
     * @return Danh sách sản phẩm trang cần lấy.
     */
    public List<Product> getProductsWithPagging(int page, int PAGE_SIZE) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select *  from Product order by productId\n"
                    + "offset (?-1)*? row fetch next ? rows only";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, page);
            stm.setInt(2, PAGE_SIZE);
            stm.setInt(3, PAGE_SIZE);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getString(1));
                p.setProductName(rs.getString(2));
                p.setProductPrice(rs.getFloat(3));
                p.setBrandId(rs.getInt(4));
                p.setCateId(rs.getInt(5));
                p.setImgUrl(rs.getString(6));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error at getProductsWithPagging " + e.getMessage());
        }
        return list;
    }

    /**
     * Lấy tổng số sản phẩm có trong cơ sở dữ liệu.
     *
     * @return Số lượng sản phẩm.
     */
    public int getTotalProducts() {
        try {
            String sql = "select count(productId)  from Product ";

            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error at getTotalProducts " + e.getMessage());
        }
        return 0;
    }

    /**
     * Sắp xếp danh sách sản phẩm theo giá tăng dần.
     *
     * @return Danh sách các sản phẩm đã được sắp xếp theo giá tăng dần.
     */
    public List<Product> sortProductUp() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select * from Product order by productPrice ASC";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString(1));
                product.setProductName(rs.getString(2));
                product.setProductPrice(rs.getFloat(3));
                product.setBrandId(rs.getInt(4));
                product.setCateId(rs.getInt(5));
                product.setImgUrl(rs.getString(6));
                list.add(product);
            }
        } catch (SQLException ex) {
            System.out.println("Error at sortProductUp " + ex.getMessage());
        }
        return list;
    }
    /**
     * Sắp xếp danh sách sản phẩm theo giá giảm dần.
     *
     * @return Danh sách các sản phẩm đã được sắp xếp theo giá giảm dần.
     */
    public List<Product> sortProductDown() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select * from Product order by productPrice DESC";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString(1));
                product.setProductName(rs.getString(2));
                product.setProductPrice(rs.getFloat(3));
                product.setBrandId(rs.getInt(4));
                product.setCateId(rs.getInt(5));
                product.setImgUrl(rs.getString(6));
                list.add(product);
            }
        } catch (SQLException ex) {
            System.out.println("Error at ssortProductDown " + ex.getMessage());
        }
        return list;
    }
    /**
     * Sắp xếp danh sách sản phẩm theo tên sản phẩm tăng dần.
     *
     * @return Danh sách các sản phẩm đã được sắp xếp theo tên tăng dần.
     */
    public List<Product> sortProductByNameAscending() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select * from Product order by productName ASC";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString(1));
                product.setProductName(rs.getString(2));
                product.setProductPrice(rs.getFloat(3));
                product.setBrandId(rs.getInt(4));
                product.setCateId(rs.getInt(5));
                product.setImgUrl(rs.getString(6));
                list.add(product);
            }
        } catch (SQLException ex) {
            System.out.println("Error at sortProductByNameAscending " + ex.getMessage());

        }
        return list;
    }
    /**
     * Sắp xếp danh sách sản phẩm theo tên sản phẩm giảm dần.
     *
     * @return Danh sách các sản phẩm đã được sắp xếp theo tên giảm dần.
     */
    public List<Product> sortProductByNameDescending() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select * from Product order by productName DESC";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString(1));
                product.setProductName(rs.getString(2));
                product.setProductPrice(rs.getFloat(3));
                product.setBrandId(rs.getInt(4));
                product.setCateId(rs.getInt(5));
                product.setImgUrl(rs.getString(6));
                list.add(product);
            }
        } catch (SQLException ex) {
            System.out.println("Error at sortProductByNameDescending " + ex.getMessage());

        }
        return list;
    }
    /**
     * Lấy danh sách sản phẩm thuộc một danh mục cụ thể.
     *
     * @param categoryId ID danh mục cần lấy sản phẩm.
     * @return Danh sách sản phẩm thuộc danh mục cụ thể.
     */
    public List<Product> sortProductsByCategory(int categoryId) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE cateId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, categoryId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString(1));
                product.setProductName(rs.getString(2));
                product.setProductPrice(rs.getFloat(3));
                product.setBrandId(rs.getInt(4));
                product.setCateId(rs.getInt(5));
                product.setImgUrl(rs.getString(6));
                list.add(product);
            }
        } catch (SQLException ex) {
            System.out.println("Error at sortProductsByBrandId " + ex.getMessage());
        }
        return list;
    }
    /**
     * Lấy danh sách sản phẩm thuộc một thương hiệu cụ thể.
     *
     * @param brandId ID thương hiệu cần lấy sản phẩm.
     * @return Danh sách sản phẩm thuộc thương hiệu cụ thể.
     */
    public List<Product> sortProductsByBrandId(int brandId) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE brandId = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, brandId);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString(1));
                product.setProductName(rs.getString(2));
                product.setProductPrice(rs.getFloat(3));
                product.setBrandId(rs.getInt(4));
                product.setCateId(rs.getInt(5));
                product.setImgUrl(rs.getString(6));
                list.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Error at sortProductsByBrandId " + e.getMessage());
        }
        return list;
    }
    /**
     * Lấy danh sách sản phẩm theo khoảng giá cụ thể.
     *
     * @param priceRange Khoảng giá cần lọc sản phẩm (dưới dạng "minPrice-maxPrice").
     * @return Danh sách sản phẩm thuộc khoảng giá cụ thể.
     */
    public List<Product> sortProductsByPrice(String priceRange) {
        List<Product> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Product WHERE productPrice >= ? AND productPrice <= ?";
            PreparedStatement stm = connection.prepareStatement(sql);

            String[] priceBounds = priceRange.split("-");
            double minPrice = Double.parseDouble(priceBounds[0]);
            double maxPrice = Double.parseDouble(priceBounds[1]);

            stm.setDouble(1, minPrice);
            stm.setDouble(2, maxPrice);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString(1));
                product.setProductName(rs.getString(2));
                product.setProductPrice(rs.getFloat(3));
                product.setBrandId(rs.getInt(4));
                product.setCateId(rs.getInt(5));
                product.setImgUrl(rs.getString(6));
                list.add(product);
            }
        } catch (SQLException ex) {
            System.out.println("Error at sortProductsByPrice " + ex.getMessage());
        }
        return list;
    }
}
