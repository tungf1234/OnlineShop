/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Lớp ProductDetails đại diện cho thông tin chi tiết về sản phẩm, bao gồm các thuộc tính như CPU, RAM, màn hình, pin, GPU, ROM, trọng lượng,
 * kích thước, camera, ID sản phẩm và URL hình ảnh.
 *
 * @author User
 */
public class ProductDetails {
    private int detailsId;
    private String cpu;
    private String ram;
    private String monitor;
    private String battery;
    private String gpu;
    private String rom;
    private float weight;
    private String size;
    private int webcam;
    private String productId;
    private String imgUrl;

    /**
     * Khởi tạo một đối tượng ProductDetails mặc định.
     */
    public ProductDetails() {
    }

    /**
     * Khởi tạo một đối tượng ProductDetails với thông tin chi tiết cụ thể.
     *
     * @param detailsId  ID chi tiết sản phẩm
     * @param cpu        Thông tin về CPU
     * @param ram        Thông tin về RAM
     * @param monitor    Thông tin về màn hình
     * @param battery    Thông tin về pin
     * @param gpu        Thông tin về GPU
     * @param rom        Thông tin về ROM
     * @param weight     Trọng lượng của sản phẩm
     * @param size       Kích thước của sản phẩm
     * @param webcam     Thông tin về camera
     * @param productId  ID của sản phẩm liên quan
     * @param imgUrl     URL hình ảnh đại diện
     */
    public ProductDetails(int detailsId, String cpu, String ram, String monitor, String battery, String gpu, String rom, float weight, String size, int webcam, String productId, String imgUrl) {
        this.detailsId = detailsId;
        this.cpu = cpu;
        this.ram = ram;
        this.monitor = monitor;
        this.battery = battery;
        this.gpu = gpu;
        this.rom = rom;
        this.weight = weight;
        this.size = size;
        this.webcam = webcam;
        this.productId = productId;
        this.imgUrl = imgUrl;
    }

    /**
     * Lấy giá trị của detailsId.
     *
     * @return Giá trị detailsId.
     */
    public int getDetailsId() {
        return detailsId;
    }

    /**
     * Đặt giá trị cho detailsId.
     *
     * @param detailsId Giá trị detailsId mới.
     */
    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }

    /**
     * Lấy giá trị của cpu.
     *
     * @return Giá trị của cpu.
     */
    public String getCpu() {
        return cpu;
    }

    /**
     * Đặt giá trị cho cpu.
     *
     * @param cpu Giá trị của cpu mới.
     */
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    /**
     * Lấy giá trị của ram.
     *
     * @return Giá trị của ram.
     */
    public String getRam() {
        return ram;
    }

    /**
     * Đặt giá trị cho ram.
     *
     * @param ram Giá trị của ram mới.
     */
    public void setRam(String ram) {
        this.ram = ram;
    }

    /**
     * Lấy giá trị của monitor.
     *
     * @return Giá trị của monitor.
     */
    public String getMonitor() {
        return monitor;
    }

    /**
     * Đặt giá trị cho monitor.
     *
     * @param monitor Giá trị của monitor mới.
     */
    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    /**
     * Lấy giá trị của battery.
     *
     * @return Giá trị của battery.
     */
    public String getBattery() {
        return battery;
    }

    /**
     * Đặt giá trị cho battery.
     *
     * @param battery Giá trị của battery mới.
     */
    public void setBattery(String battery) {
        this.battery = battery;
    }

    /**
     * Lấy giá trị của gpu.
     *
     * @return Giá trị của gpu.
     */
    public String getGpu() {
        return gpu;
    }

    /**
     * Đặt giá trị cho gpu.
     *
     * @param gpu Giá trị của gpu mới.
     */
    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    /**
     * Lấy giá trị của rom.
     *
     * @return Giá trị của rom.
     */
    public String getRom() {
        return rom;
    }

    /**
     * Đặt giá trị cho rom.
     *
     * @param rom Giá trị của rom mới.
     */
    public void setRom(String rom) {
        this.rom = rom;
    }

    /**
     * Lấy giá trị của weight.
     *
     * @return Giá trị của weight.
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Đặt giá trị cho weight.
     *
     * @param weight Giá trị của weight mới.
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * Lấy giá trị của size.
     *
     * @return Giá trị của size.
     */
    public String getSize() {
        return size;
    }

    /**
     * Đặt giá trị cho size.
     *
     * @param size Giá trị của size mới.
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Lấy giá trị của webcam.
     *
     * @return Giá trị của webcam.
     */
    public int getWebcam() {
        return webcam;
    }

    /**
     * Đặt giá trị cho webcam.
     *
     * @param webcam Giá trị của webcam mới.
     */
    public void setWebcam(int webcam) {
        this.webcam = webcam;
    }

    /**
     * Lấy giá trị của productId.
     *
     * @return Giá trị của productId.
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Đặt giá trị cho productId.
     *
     * @param productId Giá trị của productId mới.
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Lấy giá trị của imgUrl.
     *
     * @return Giá trị của imgUrl.
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * Đặt giá trị cho imgUrl.
     *
     * @param imgUrl Giá trị của imgUrl mới.
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
