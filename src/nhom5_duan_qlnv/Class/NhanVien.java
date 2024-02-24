/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhom5_duan_qlnv.Class;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public NhanVien(String maNV, String ten, String email, String phongBan, float luong) {
        this.maNV = maNV;
        this.ten = ten;
        this.email = email;
        this.luong = luong;
        this.phongBan = phongBan;
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
        System.out.println("Nhap thong tin nhan vien!");
        Scanner sc = new Scanner(System.in);

        // Biến địa phương để lưu trạng thái của validate
        boolean isValidMaNV = false;
        boolean isValidTen = false;
        boolean isValidEmail = false;
        boolean isValidLuong = false;

        while (!isValidMaNV) {
            System.out.println("ma la: ");
            maNV = sc.nextLine();
            if (!isEmpty(maNV)) {
                isValidMaNV = true;
            } else {
                System.out.println("Ma khong duoc de trong. Vui long nhap lai.");
            }
        }

        while (!isValidTen) {
            System.out.println("ho ten la: ");
            ten = sc.nextLine();
            if (!isEmpty(ten)) {
                isValidTen = true;
            } else {
                System.out.println("Ten khong duoc de trong. Vui long nhap lai.");
            }
        }

        while (!isValidEmail) {
            System.out.println("email la: ");
            email = sc.nextLine();
            if (isValidEmail(email)) {
                isValidEmail = true;
            } else {
                System.out.println("Email khong hop le. Vui long nhap lai.");
            }
        }

        while (!isValidLuong) {
            try {
                System.out.println("luong co ban la: ");
                luong = Float.parseFloat(sc.nextLine());
                if (luong >= 0) {
                    isValidLuong = true;
                } else {
                    System.out.println("Luong khong hop le. Vui long nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so cho luong.");
            }
        }
    }

    public float calculatePay() {
        return luong;
    }

    public void xuat() {
        System.out.println("+------------+--------------------------+----------------------+--------------------------------+------------+----------+------------+");
        System.out.println("|   maNV     |       ten                |         email        |    phongBan                    |   luong    |  thueTn  |  tongLuong |");
        System.out.println("+------------+--------------------------+----------------------+--------------------------------+------------+----------+------------+");
        System.out.printf("| %-10s | %-24s | %-20s | %-30s | %-10.2f | %-8.2f | %-10.2f |\n",
                getMaNV(), getTen(), getEmail(),
                getPhongBan(), getLuong(), getThue(), calculatePay());
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s%n", "", "", "", "", "", "");
        
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

    private boolean isValidEmail(String email) {
        // Biểu thức chính quy để kiểm tra email
        String regex = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
        return email.matches(regex);
    }

    private boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
