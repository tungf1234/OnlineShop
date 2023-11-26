/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Lớp Customer mô tả đối tượng khách hàng. 
 * Customer chứa thông tin về mã khách hàng, tên, họ, trạng thái xác minh, địa chỉ, email và số điện thoại của khách hàng.
 *
 * @author User
 */
public class Customer {
    private String customerId; // Mã khách hàng
    private String firstName; // Tên đầu tiên của khách hàng
    private String lastName; // Họ của khách hàng
    private int isVerified; // Trạng thái xác minh của khách hàng
    private String address; // Địa chỉ của khách hàng
    private String email; // Địa chỉ email của khách hàng
    private String phoneNumber; // Số điện thoại của khách hàng

    /**
     * Khởi tạo một đối tượng Customer trống rỗng.
     */
    public Customer() {
    }

    /**
     * Khởi tạo một đối tượng Customer với các thông tin cơ bản.
     *
     * @param customerId   Mã khách hàng
     * @param firstName    Tên đầu tiên của khách hàng
     * @param lastName     Họ của khách hàng
     * @param isVerified   Trạng thái xác minh của khách hàng
     * @param address      Địa chỉ của khách hàng
     * @param email        Địa chỉ email của khách hàng
     * @param phoneNumber  Số điện thoại của khách hàng
     */
    public Customer(String customerId, String firstName, String lastName, int isVerified, String address, String email, String phoneNumber) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isVerified = isVerified;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Lấy mã khách hàng.
     *
     * @return Mã khách hàng.
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Đặt mã cho khách hàng.
     *
     * @param customerId Mã khách hàng.
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Lấy tên đầu tiên của khách hàng.
     *
     * @return Tên đầu tiên của khách hàng.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Đặt tên đầu tiên cho khách hàng.
     *
     * @param firstName Tên đầu tiên của khách hàng.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Lấy họ của khách hàng.
     *
     * @return Họ của khách hàng.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Đặt họ cho khách hàng.
     *
     * @param lastName Họ của khách hàng.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Lấy trạng thái xác minh của khách hàng.
     *
     * @return Trạng thái xác minh của khách hàng.
     */
    public int getIsVerified() {
        return isVerified;
    }

    /**
     * Đặt trạng thái xác minh cho khách hàng.
     *
     * @param isVerified Trạng thái xác minh của khách hàng.
     */
    public void setIsVerified(int isVerified) {
        this.isVerified = isVerified;
    }

    /**
     * Lấy địa chỉ của khách hàng.
     *
     * @return Địa chỉ của khách hàng.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Đặt địa chỉ cho khách hàng.
     *
     * @param address Địa chỉ của khách hàng.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Lấy địa chỉ email của khách hàng.
     *
     * @return Địa chỉ email của khách hàng.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Đặt địa chỉ email cho khách hàng.
     *
     * @param email Địa chỉ email của khách hàng.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Lấy số điện thoại của khách hàng.
     *
     * @return Số điện thoại của khách hàng.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Đặt số điện thoại cho khách hàng.
     *
     * @param phoneNumber Số điện thoại của khách hàng.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
