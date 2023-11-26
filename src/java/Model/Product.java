/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Lớp Product đại diện cho sản phẩm trong cơ sở dữ liệu. Mỗi sản phẩm có thông tin về mã sản phẩm, tên sản phẩm, giá sản phẩm, mã thương hiệu, mã danh mục và URL hình ảnh.
 *
 * @author User
 */
public class Product {
    private String productId; // Mã sản phẩm
    private String productName; // Tên sản phẩm
    private float productPrice; // Giá sản phẩm
    private int brandId; // Mã thương hiệu
    private int cateId; // Mã danh mục
    private String imgUrl; // URL hình ảnh
    private int quantity;

    /**
     * Khởi tạo một đối tượng Product trống rỗng.
     */
    public Product() {
    }

    /**
     * Khởi tạo một đối tượng Product với các thông tin cơ bản.
     *
     * @param productId     Mã sản phẩm
     * @param productName   Tên sản phẩm
     * @param productPrice  Giá sản phẩm
     * @param brandId       Mã thương hiệu
     * @param cateId        Mã danh mục
     * @param imgUrl        URL hình ảnh
     */
    public Product(String productId, String productName, float productPrice, 
            int brandId, int cateId, String imgUrl, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.brandId = brandId;
        this.cateId = cateId;
        this.imgUrl = imgUrl;
        this.quantity = quantity;
    }

    /**
     * Lấy mã sản phẩm.
     *
     * @return Mã sản phẩm.
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Đặt mã sản phẩm.
     *
     * @param productId Mã sản phẩm.
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Lấy tên sản phẩm.
     *
     * @return Tên sản phẩm.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Đặt tên sản phẩm.
     *
     * @param productName Tên sản phẩm.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Lấy giá sản phẩm.
     *
     * @return Giá sản phẩm.
     */
    public float getProductPrice() {
        return productPrice;
    }

    /**
     * Đặt giá sản phẩm.
     *
     * @param productPrice Giá sản phẩm.
     */
    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * Lấy mã thương hiệu.
     *
     * @return Mã thương hiệu.
     */
    public int getBrandId() {
        return brandId;
    }

    /**
     * Đặt mã thương hiệu.
     *
     * @param brandId Mã thương hiệu.
     */
    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    /**
     * Lấy mã danh mục.
     *
     * @return Mã danh mục.
     */
    public int getCateId() {
        return cateId;
    }

    /**
     * Đặt mã danh mục.
     *
     * @param cateId Mã danh mục.
     */
    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    /**
     * Lấy URL hình ảnh sản phẩm.
     *
     * @return URL hình ảnh sản phẩm.
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * Đặt URL hình ảnh sản phẩm.
     *
     * @param imgUrl URL hình ảnh sản phẩm.
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
