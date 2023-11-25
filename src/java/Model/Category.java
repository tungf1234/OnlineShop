    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Lớp Category đại diện cho danh mục sản phẩm trong cơ sở dữ liệu. Mỗi danh mục có thông tin về mã danh mục và tên danh mục.
 *
 * @author User
 */
public class Category {
    private int cateId; // Mã danh mục
    private String cateName; // Tên danh mục

    /**
     * Khởi tạo một đối tượng Category trống rỗng.
     */
    public Category() {
    }

    /**
     * Khởi tạo một đối tượng Category với các thông tin cơ bản.
     *
     * @param cateId   Mã danh mục
     * @param cateName Tên danh mục
     */
    public Category(int cateId, String cateName) {
        this.cateId = cateId;
        this.cateName = cateName;
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
     * Lấy tên danh mục.
     *
     * @return Tên danh mục.
     */
    public String getCateName() {
        return cateName;
    }

    /**
     * Đặt tên danh mục.
     *
     * @param cateName Tên danh mục.
     */
    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
}
