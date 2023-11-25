/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Đây là lớp chứa thông tin về cá nhân từ dịch vụ Google.
 * 
 * @author User
 */
public class GooglePojo {

    private String id;
    private String email;
    private boolean verified_email;
    private String name;
    private String given_name;
    private String family_name;
    private String link;
    private String picture;

    /**
     * Constructor mặc định.
     */
    public GooglePojo() {
    }

    /**
     * Constructor với tham số.
     * 
     * @param id             ID của cá nhân.
     * @param email          Địa chỉ email của cá nhân.
     * @param verified_email Trạng thái xác minh email.
     * @param name           Tên đầy đủ của cá nhân.
     * @param given_name     Tên gọi của cá nhân.
     * @param family_name    Họ của cá nhân.
     * @param link           Đường dẫn đến trang cá nhân.
     * @param picture        Đường dẫn đến hình ảnh cá nhân.
     */
    public GooglePojo(String id, String email, boolean verified_email, String name, String given_name, String family_name, String link, String picture) {
        this.id = id;
        this.email = email;
        this.verified_email = verified_email;
        this.name = name;
        this.given_name = given_name;
        this.family_name = family_name;
        this.link = link;
        this.picture = picture;
    }

    /**
     * Trả về ID của cá nhân.
     * 
     * @return ID của cá nhân.
     */
    public String getId() {
        return id;
    }

    /**
     * Thiết lập ID của cá nhân.
     * 
     * @param id ID của cá nhân.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Trả về địa chỉ email của cá nhân.
     * 
     * @return Địa chỉ email của cá nhân.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Thiết lập địa chỉ email của cá nhân.
     * 
     * @param email Địa chỉ email của cá nhân.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Trả về trạng thái xác minh email.
     * 
     * @return Trạng thái xác minh email.
     */
    public boolean isVerified_email() {
        return verified_email;
    }

    /**
     * Thiết lập trạng thái xác minh email.
     * 
     * @param verified_email Trạng thái xác minh email.
     */
    public void setVerified_email(boolean verified_email) {
        this.verified_email = verified_email;
    }

    /**
     * Trả về tên đầy đủ của cá nhân.
     * 
     * @return Tên đầy đủ của cá nhân.
     */
    public String getName() {
        return name;
    }

    /**
     * Thiết lập tên đầy đủ của cá nhân.
     * 
     * @param name Tên đầy đủ của cá nhân.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Trả về tên gọi của cá nhân.
     * 
     * @return Tên gọi của cá nhân.
     */
    public String getGiven_name() {
        return given_name;
    }

    /**
     * Thiết lập tên gọi của cá nhân.
     * 
     * @param given_name Tên gọi của cá nhân.
     */
    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    /**
     * Trả về họ của cá nhân.
     * 
     * @return Họ của cá nhân.
     */
    public String getFamily_name() {
        return family_name;
    }

    /**
     * Thiết lập họ của cá nhân.
     * 
     * @param family_name Họ của cá nhân.
     */
    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    /**
     * Trả về đường dẫn đến trang cá nhân.
     * 
     * @return Đường dẫn đến trang cá nhân.
     */
    public String getLink() {
        return link;
    }

    /**
     * Thiết lập đường dẫn đến trang cá nhân.
     * 
     * @param link Đường dẫn đến trang cá nhân.
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Trả về đường dẫn đến hình ảnh cá nhân.
     * 
     * @return Đường dẫn đến hình ảnh cá nhân.
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Thiết lập đường dẫn đến hình ảnh cá nhân.
     * 
     * @param picture Đường dẫn đến hình ảnh cá nhân.
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "GooglePojo [id=" + this.id + ", email=" + this.email + ", verified_email=" + this.verified_email + ", name="
                + this.name + ", given_name=" + this.given_name + ", family_name=" + this.family_name + "]";
    }   
}
