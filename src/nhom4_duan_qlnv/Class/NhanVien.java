/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhom4_duan_qlnv.Class;

import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class NhanVien {

    private String maNV;
    private String ten;
    private String email;
    private String phongBan;
    private float luong;

    public NhanVien(String maNV, String ten, String email, float luong) {
        this.maNV = maNV;
        this.ten = ten;
        this.email = email;
        this.luong = luong;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public void nhap() {
        System.out.println("Nhập thông tin nhân viên!");
        Scanner sc = new Scanner(System.in);
        System.out.println("ma la: ");
        maNV = sc.nextLine();
        System.out.println("ho ten la: ");
        ten = sc.nextLine();
        System.out.println("email la: ");
        email = sc.nextLine();
        System.out.println("lương cơ bản la: ");
        luong = Float.parseFloat(sc.nextLine());
    }

    public float calculatePay() {
        return luong;
    }

    public void xuat() {
        System.out.println("    ");
        System.out.printf("%-20s %-20s %-20s %-20s %-20.2f %-20.2f%n",
                maNV, ten, email, getPhongBan(), luong, getThue());
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s%n", "", "", "", "", "", "");
        System.out.printf("%-20s %-20.2f%n", "Tổng lương", calculatePay());
    }

    public float getThue() {
        if (getLuong() < 9000000) {
            return (float) 0.0;
        } else if (getLuong() < 15000000) {
            return (float) (getLuong() * 0.1);
        } else {
            return (float) (getLuong() * 0.12);
        }
    }
}
