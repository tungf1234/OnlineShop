/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *
 * @author User
 */
public class Encryption {

    //md5
    //sha-1 => thuong su dung
    public static String toSHA1(String toEncrypt) {
        String salt = "fE4wd#u*d9b9kdKszgè02ep5à4qZa!éi6";
        String res = null;
        toEncrypt = toEncrypt + salt;
        try {
            byte[] dataBytes = toEncrypt.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            res = Base64.getEncoder().encodeToString(md.digest(dataBytes));
        } catch (NoSuchAlgorithmException e) {
            // Xử lý ngoại lệ NoSuchAlgorithmException
            System.err.println("Lỗi: Thuật toán băm SHA-1 không tồn tại.");
        } catch (UnsupportedEncodingException e) {
            // Xử lý ngoại lệ UnsupportedEncodingException
            System.err.println("Lỗi: Không hỗ trợ bộ mã UTF-8.");
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(toSHA1("654311"));
    }
}
