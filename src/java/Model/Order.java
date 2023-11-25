/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author User
 */
/**
 * Lớp Order đại diện cho một đơn hàng trong hệ thống. Mỗi đơn hàng bao gồm thông tin về đơn hàng, khách hàng,
 * sản phẩm và các thuộc tính khác.
 * 
 * @author User
 */
public class Order {
    private int orderId;          // ID của đơn hàng
    private String name;          // Tên khách hàng
    private Date date;            // Ngày đặt hàng
    private float totalPrice;     // Tổng giá trị của đơn hàng
    private String customerId;    // ID của khách hàng
    private String address;       // Địa chỉ giao hàng
    private int phone;            // Số điện thoại liên hệ
    private String productName;   // Tên sản phẩm trong đơn hàng
    private float productPrice;   // Giá của sản phẩm
    private String productImage;  // Hình ảnh sản phẩm
    private int productQuantity;  // Số lượng sản phẩm

    /**
     * Constructor mặc định của lớp Order.
     */
    public Order() {
    }

    /**
     * Constructor để tạo một đối tượng Order với thông tin cơ bản về đơn hàng.
     *
     * @param orderId     ID của đơn hàng.
     * @param date        Ngày đặt hàng.
     * @param totalPrice  Tổng giá trị của đơn hàng.
     * @param customerId  ID của khách hàng.
     * @param address     Địa chỉ giao hàng.
     * @param phone       Số điện thoại liên hệ.
     * @param name        Tên khách hàng.
     */
    public Order(int orderId, Date date, float totalPrice, String customerId, String address, int phone, String name) {
        this.orderId = orderId;
        this.name = name;
        this.date = date;
        this.totalPrice = totalPrice;
        this.customerId = customerId;
        this.address = address;
        this.phone = phone;
    }

    /**
     * Constructor để tạo một đối tượng Order với thông tin về sản phẩm trong đơn hàng.
     *
     * @param productName     Tên sản phẩm trong đơn hàng.
     * @param productPrice    Giá của sản phẩm.
     * @param productImage    Hình ảnh sản phẩm.
     * @param productQuantity Số lượng sản phẩm.
     */
    public Order(String productName, float productPrice, String productImage, int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productQuantity = productQuantity;
    }

    // Getters và setters cho các thuộc tính

    /**
     * Lấy ID của đơn hàng.
     *
     * @return ID của đơn hàng.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Đặt ID của đơn hàng.
     *
     * @param orderId ID của đơn hàng.
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Lấy ngày đặt hàng.
     *
     * @return Ngày đặt hàng.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Đặt tên khách hàng.
     *
     * @return Tên khách hàng.
     */
    public String getName() {
        return name;
    }

    /**
     * Đặt tên khách hàng.
     *
     * @param name Tên khách hàng.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Đặt ngày đặt hàng.
     *
     * @param date Ngày đặt hàng.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Lấy tổng giá trị của đơn hàng.
     *
     * @return Tổng giá trị của đơn hàng.
     */
    public float getTotalPrice() {
        return totalPrice;
    }

    /**
     * Đặt tổng giá trị của đơn hàng.
     *
     * @param totalPrice Tổng giá trị của đơn hàng.
     */
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Lấy ID của khách hàng.
     *
     * @return ID của khách hàng.
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Đặt ID của khách hàng.
     *
     * @param customerId ID của khách hàng.
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Lấy địa chỉ giao hàng.
     *
     * @return Địa chỉ giao hàng.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Đặt địa chỉ giao hàng.
     *
     * @param address Địa chỉ giao hàng.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Lấy số điện thoại liên hệ.
     *
     * @return Số điện thoại liên hệ.
     */
    public int getPhone() {
        return phone;
    }

    /**
     * Đặt số điện thoại liên hệ.
     *
     * @param phone Số điện thoại liên hệ.
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * Lấy tên sản phẩm trong đơn hàng.
     *
     * @return Tên sản phẩm trong đơn hàng.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Đặt tên sản phẩm trong đơn hàng.
     *
     * @param productName Tên sản phẩm trong đơn hàng.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Lấy giá của sản phẩm.
     *
     * @return Giá của sản phẩm.
     */
    public float getProductPrice() {
        return productPrice;
    }

    /**
     * Đặt giá của sản phẩm.
     *
     * @param productPrice Giá của sản phẩm.
     */
    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * Lấy hình ảnh sản phẩm.
     *
     * @return Hình ảnh sản phẩm.
     */
    public String getProductImage() {
        return productImage;
    }

    /**
     * Đặt hình ảnh sản phẩm.
     *
     * @param productImage Hình ảnh sản phẩm.
     */
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    /**
     * Lấy số lượng sản phẩm.
     *
     * @return Số lượng sản phẩm.
     */
    public int getProductQuantity() {
        return productQuantity;
    }

    /**
     * Đặt số lượng sản phẩm.
     *
     * @param productQuantity Số lượng sản phẩm.
     */
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
