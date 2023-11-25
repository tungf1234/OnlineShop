/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Acer Nitro5
 */
/**
 * Lớp CustomerBill đại diện cho thông tin về một hóa đơn của khách hàng. Mỗi hóa đơn ghi lại thông tin về đơn hàng,
 * sản phẩm, số lượng, giá và ID của hóa đơn.
 *
 * @author Acer Nitro5
 */
public class CustomerBill {
    private int orderId;     // ID của đơn hàng
    private String productId; // ID của sản phẩm
    private int quantity;    // Số lượng sản phẩm
    private double price;    // Giá sản phẩm
    private int billId;      // ID của hóa đơn

    /**
     * Constructor mặc định của lớp CustomerBill.
     */
    public CustomerBill() {
    }

    /**
     * Constructor để tạo một đối tượng CustomerBill với thông tin cụ thể về hóa đơn.
     *
     * @param orderId   ID của đơn hàng.
     * @param productId ID của sản phẩm.
     * @param quantity  Số lượng sản phẩm.
     * @param price     Giá sản phẩm.
     * @param billId    ID của hóa đơn.
     */
    public CustomerBill(int orderId, String productId, int quantity, double price, int billId) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.billId = billId;
    }

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
     * Lấy ID của sản phẩm.
     *
     * @return ID của sản phẩm.
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Đặt ID của sản phẩm.
     *
     * @param productId ID của sản phẩm.
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Lấy số lượng sản phẩm trong hóa đơn.
     *
     * @return Số lượng sản phẩm.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Đặt số lượng sản phẩm trong hóa đơn.
     *
     * @param quantity Số lượng sản phẩm.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Lấy giá sản phẩm trong hóa đơn.
     *
     * @return Giá sản phẩm.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Đặt giá sản phẩm trong hóa đơn.
     *
     * @param price Giá sản phẩm.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Lấy ID của hóa đơn.
     *
     * @return ID của hóa đơn.
     */
    public int getBillId() {
        return billId;
    }

    /**
     * Đặt ID của hóa đơn.
     *
     * @param billId ID của hóa đơn.
     */
    public void setBillId(int billId) {
        this.billId = billId;
    }
}
