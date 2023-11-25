/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Lớp Brand mô tả đối tượng hãng sản phẩm. 
 * Brand chứa thông tin về ID, tên hãng sản phẩm và URL hình ảnh của hãng.
 *
 * @author User
 */
public class Brand {
    private int brandId; // ID của hãng sản phẩm
    private String brandName; // Tên hãng sản phẩm
    private String brandImgUrl; // URL hình ảnh của hãng sản phẩm

    /**
     * Khởi tạo một đối tượng Brand trống rỗng.
     */
    public Brand() {
    }

    /**
     * Khởi tạo một đối tượng Brand với các thông tin cơ bản.
     *
     * @param brandId     ID của hãng sản phẩm
     * @param brandName   Tên hãng sản phẩm
     * @param brandImgUrl URL hình ảnh của hãng sản phẩm
     */
    public Brand(int brandId, String brandName, String brandImgUrl) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandImgUrl = brandImgUrl;
    }

    /**
     * Lấy ID của hãng sản phẩm.
     *
     * @return ID của hãng sản phẩm.
     */
    public int getBrandId() {
        return brandId;
    }

    /**
     * Đặt ID cho hãng sản phẩm.
     *
     * @param brandId ID của hãng sản phẩm.
     */
    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    /**
     * Lấy tên hãng sản phẩm.
     *
     * @return Tên hãng sản phẩm.
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Đặt tên cho hãng sản phẩm.
     *
     * @param brandName Tên hãng sản phẩm.
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * Lấy URL hình ảnh của hãng sản phẩm.
     *
     * @return URL hình ảnh của hãng sản phẩm.
     */
    public String getBrandImgUrl() {
        return brandImgUrl;
    }

    /**
     * Đặt URL hình ảnh cho hãng sản phẩm.
     *
     * @param brandImgUrl URL hình ảnh của hãng sản phẩm.
     */
    public void setBrandImgUrl(String brandImgUrl) {
        this.brandImgUrl = brandImgUrl;
    }
}
