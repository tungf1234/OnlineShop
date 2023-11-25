/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 * Lớp Account mô tả đối tượng tài khoản người dùng. 
 * Account chứa thông tin về mã tài khoản, trạng thái kích hoạt, trạng thái khoá tài khoản, số lần thử đăng nhập không thành công, thời gian khoá tài khoản và mật khẩu của tài khoản.
 *
 * @author User
 */
public class Account {
    private String accountId; // Mã tài khoản
    private int isActive; // Trạng thái kích hoạt tài khoản
    private int isAccountNonLock; // Trạng thái khoá tài khoản
    private int failAttemp; // Số lần thử đăng nhập không thành công
    private Date lockTime; // Thời gian khoá tài khoản
    private String password; // Mật khẩu tài khoản

    /**
     * Khởi tạo một đối tượng Account trống rỗng.
     */
    public Account() {
    }

    /**
     * Khởi tạo một đối tượng Account với các thông tin cơ bản.
     *
     * @param accountId        Mã tài khoản
     * @param isActive         Trạng thái kích hoạt tài khoản
     * @param isAccountNonLock Trạng thái khoá tài khoản
     * @param failAttemp       Số lần thử đăng nhập không thành công
     * @param lockTime         Thời gian khoá tài khoản
     * @param password         Mật khẩu tài khoản
     */
    public Account(String accountId, int isActive, int isAccountNonLock, int failAttemp, Date lockTime, String password) {
        this.accountId = accountId;
        this.isActive = isActive;
        this.isAccountNonLock = isAccountNonLock;
        this.failAttemp = failAttemp;
        this.lockTime = lockTime;
        this.password = password;
    }

    /**
     * Lấy mã tài khoản.
     *
     * @return Mã tài khoản.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Đặt mã cho tài khoản.
     *
     * @param accountId Mã tài khoản.
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Lấy trạng thái kích hoạt tài khoản.
     *
     * @return Trạng thái kích hoạt tài khoản.
     */
    public int getIsActive() {
        return isActive;
    }

    /**
     * Đặt trạng thái kích hoạt cho tài khoản.
     *
     * @param isActive Trạng thái kích hoạt tài khoản.
     */
    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    /**
     * Lấy trạng thái khoá tài khoản.
     *
     * @return Trạng thái khoá tài khoản.
     */
    public int getIsAccountNonLock() {
        return isAccountNonLock;
    }

    /**
     * Đặt trạng thái khoá cho tài khoản.
     *
     * @param isAccountNonLock Trạng thái khoá tài khoản.
     */
    public void setIsAccountNonLock(int isAccountNonLock) {
        this.isAccountNonLock = isAccountNonLock;
    }

    /**
     * Lấy số lần thử đăng nhập không thành công.
     *
     * @return Số lần thử đăng nhập không thành công.
     */
    public int getFailAttemp() {
        return failAttemp;
    }

    /**
     * Đặt số lần thử đăng nhập không thành công.
     *
     * @param failAttemp Số lần thử đăng nhập không thành công.
     */
    public void setFailAttemp(int failAttemp) {
        this.failAttemp = failAttemp;
    }

    /**
     * Lấy thời gian khoá tài khoản.
     *
     * @return Thời gian khoá tài khoản.
     */
    public Date getLockTime() {
        return lockTime;
    }

    /**
     * Đặt thời gian khoá tài khoản.
     *
     * @param lockTime Thời gian khoá tài khoản.
     */
    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    /**
     * Lấy mật khẩu tài khoản.
     *
     * @return Mật khẩu tài khoản.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Đặt mật khẩu tài khoản.
     *
     * @param password Mật khẩu tài khoản.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
