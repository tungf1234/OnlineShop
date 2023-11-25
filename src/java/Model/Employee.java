/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Lớp Employee mô tả đối tượng nhân viên. 
 * Employee chứa thông tin về mã nhân viên, vai trò, chức vụ, số điện thoại, địa chỉ, và email của nhân viên.
 *
 * @author User
 */
public class Employee {
    private String employeeId; // Mã nhân viên
    private int roleId; // Vai trò của nhân viên
    private int positionId; // Chức vụ của nhân viên
    private String phoneNumber; // Số điện thoại của nhân viên
    private String address; // Địa chỉ của nhân viên
    private String email; // Địa chỉ email của nhân viên

    /**
     * Khởi tạo một đối tượng Employee trống rỗng.
     */
    public Employee() {
    }

    /**
     * Khởi tạo một đối tượng Employee với các thông tin cơ bản.
     *
     * @param employeeId  Mã nhân viên
     * @param roleId      Vai trò của nhân viên
     * @param positionId  Chức vụ của nhân viên
     * @param phoneNumber Số điện thoại của nhân viên
     * @param address     Địa chỉ của nhân viên
     * @param email       Địa chỉ email của nhân viên
     */
    public Employee(String employeeId, int roleId, int positionId, String phoneNumber, String address, String email) {
        this.employeeId = employeeId;
        this.roleId = roleId;
        this.positionId = positionId;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    /**
     * Lấy mã nhân viên.
     *
     * @return Mã nhân viên.
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Đặt mã cho nhân viên.
     *
     * @param employeeId Mã nhân viên.
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Lấy vai trò của nhân viên.
     *
     * @return Vai trò của nhân viên.
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Đặt vai trò cho nhân viên.
     *
     * @param roleId Vai trò của nhân viên.
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Lấy chức vụ của nhân viên.
     *
     * @return Chức vụ của nhân viên.
     */
    public int getPositionId() {
        return positionId;
    }

    /**
     * Đặt chức vụ cho nhân viên.
     *
     * @param positionId Chức vụ của nhân viên.
     */
    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    /**
     * Lấy số điện thoại của nhân viên.
     *
     * @return Số điện thoại của nhân viên.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Đặt số điện thoại cho nhân viên.
     *
     * @param phoneNumber Số điện thoại của nhân viên.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Lấy địa chỉ của nhân viên.
     *
     * @return Địa chỉ của nhân viên.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Đặt địa chỉ cho nhân viên.
     *
     * @param address Địa chỉ của nhân viên.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Lấy địa chỉ email của nhân viên.
     *
     * @return Địa chỉ email của nhân viên.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Đặt địa chỉ email cho nhân viên.
     *
     * @param email Địa chỉ email của nhân viên.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
