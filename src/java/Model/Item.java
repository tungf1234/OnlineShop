/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author msi
 */
/**
 * Lớp Item đại diện cho một mặt hàng trong giỏ hàng. Mỗi mặt hàng bao gồm một sản phẩm, số lượng và tổng giá trị.
 * 
 * @author msi
 */
public class Item {

    private Product product; // Sản phẩm trong mặt hàng
    private int quantity;    // Số lượng sản phẩm trong mặt hàng
    private double total;    // Tổng giá trị của mặt hàng

    /**
     * Constructor mặc định của lớp Item.
     */
    public Item() {
    }

    /**
     * Constructor để tạo một đối tượng Item với thông tin sản phẩm, số lượng và tổng giá trị.
     *
     * @param product   Sản phẩm trong mặt hàng.
     * @param quantity  Số lượng sản phẩm trong mặt hàng.
     * @param total     Tổng giá trị của mặt hàng.
     */
    public Item(Product product, int quantity, double total) {
        this.product = product;
        this.quantity = quantity;
        this.total = total;
    }

    /**
     * Lấy thông tin sản phẩm trong mặt hàng.
     *
     * @return Sản phẩm trong mặt hàng.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Đặt thông tin sản phẩm trong mặt hàng.
     *
     * @param product Sản phẩm trong mặt hàng.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Lấy số lượng sản phẩm trong mặt hàng.
     *
     * @return Số lượng sản phẩm trong mặt hàng.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Đặt số lượng sản phẩm trong mặt hàng.
     *
     * @param quantity Số lượng sản phẩm trong mặt hàng.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Lấy tổng giá trị của mặt hàng.
     *
     * @return Tổng giá trị của mặt hàng.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Đặt tổng giá trị của mặt hàng.
     *
     * @param total Tổng giá trị của mặt hàng.
     */
    public void setTotal(double total) {
        this.total = total;
    }
}
