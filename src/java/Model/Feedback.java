/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author CaoTung
 */
public class Feedback {

    private String customerId; // ID của khách hàng gửi phản hồi
    private int vote; // Điểm đánh giá của sản phẩm
    private String commnent; // Nội dung bình luận
    private int feedbackId; // ID của phản hồi
    private String productId; // ID của sản phẩm được đánh giá

    /**
     * Constructor mặc định của lớp Feedback.
     */
    public Feedback() {
    }

    /**
     * Constructor để tạo một đối tượng Feedback với thông tin cụ thể.
     *
     * @param customerId   ID của khách hàng gửi phản hồi.
     * @param vote         Điểm đánh giá của sản phẩm.
     * @param commnent     Nội dung bình luận.
     * @param feedbackId   ID của phản hồi.
     * @param productId    ID của sản phẩm được đánh giá.
     */
    public Feedback(String customerId, int vote, String commnent, int feedbackId, String productId) {
        this.customerId = customerId;
        this.vote = vote;
        this.commnent = commnent;
        this.feedbackId = feedbackId;
        this.productId = productId;
    }

    /**
     * Lấy ID của khách hàng gửi phản hồi.
     *
     * @return ID của khách hàng.
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Đặt ID của khách hàng gửi phản hồi.
     *
     * @param customerId ID của khách hàng.
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Lấy điểm đánh giá của sản phẩm.
     *
     * @return Điểm đánh giá.
     */
    public int getVote() {
        return vote;
    }

    /**
     * Đặt điểm đánh giá của sản phẩm.
     *
     * @param vote Điểm đánh giá.
     */
    public void setVote(int vote) {
        this.vote = vote;
    }

    /**
     * Lấy nội dung bình luận.
     *
     * @return Nội dung bình luận.
     */
    public String getCommnent() {
        return commnent;
    }

    /**
     * Đặt nội dung bình luận.
     *
     * @param commnent Nội dung bình luận.
     */
    public void setCommnent(String commnent) {
        this.commnent = commnent;
    }

    /**
     * Lấy ID của phản hồi.
     *
     * @return ID của phản hồi.
     */
    public int getFeedbackId() {
        return feedbackId;
    }

    /**
     * Đặt ID của phản hồi.
     *
     * @param feedbackId ID của phản hồi.
     */
    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    /**
     * Lấy ID của sản phẩm được đánh giá.
     *
     * @return ID của sản phẩm.
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Đặt ID của sản phẩm được đánh giá.
     *
     * @param productId ID của sản phẩm.
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }
}