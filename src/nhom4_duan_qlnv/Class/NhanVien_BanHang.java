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
public class NhanVien_BanHang extends NhanVien {

    private float doanhSo;
    private float hoaHong;
    private int successfulDeals;
    private String phongBan;

    public NhanVien_BanHang(float doanhSo, float hoaHong, int successfulDeals, String phongBan, String maNV, String ten, String email, float luong) {
        super(maNV, ten, email, luong);
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
        this.successfulDeals = successfulDeals;
        this.phongBan = phongBan;
    }

    public NhanVien_BanHang(float doanhSo, float hoaHong, int successfulDeals, String phongBan) {
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
        this.successfulDeals = successfulDeals;
        this.phongBan = phongBan;
    }

    public NhanVien_BanHang() {
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public float getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(float doanhSo) {
        this.doanhSo = doanhSo;
    }

    public float getHoaHong() {
        return hoaHong;
    }

    public void setHoaHong(float hoaHong) {
        this.hoaHong = hoaHong;
    }

    public int getSuccessfulDeals() {
        return successfulDeals;
    }

    public void setSuccessfulDeals(int successfulDeals) {
        this.successfulDeals = successfulDeals;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);

        boolean isValidDoanhSo = false;
        boolean isValidHoaHong = false;
        boolean isValidSuccessfulDeals = false;

        while (!isValidDoanhSo) {
            System.out.print("Nhap doanh so: ");
            doanhSo = Float.parseFloat(sc.nextLine());
            if (doanhSo >= 0) {
                isValidDoanhSo = true;
            } else {
                System.out.println("Doanh se khong hop le. Vui long nhap lai.");
            }
        }

        while (!isValidHoaHong) {
            System.out.print("Nhap ty le hoa hong (%): ");
            hoaHong = Float.parseFloat(sc.nextLine());
            if (hoaHong >= 0 && hoaHong <= 100) {
                isValidHoaHong = true;
            } else {
                System.out.println("Ty le hoa hong khong hop le. Vui lòng nhap lai.");
            }
        }

        while (!isValidSuccessfulDeals) {
            System.out.print("Nhap so giao dich thanh cong: ");
            successfulDeals = Integer.parseInt(sc.nextLine());
            if (successfulDeals >= 0) {
                isValidSuccessfulDeals = true;
            } else {
                System.out.println("So giao dich thanh cong khong hop le. Vui long nhap lai.");
            }
        }
    }

    @Override
    public float calculatePay() {
        float bonusPerDeal = successfulDeals * 1000;
        float totalPay = getLuong() + bonusPerDeal + ((doanhSo * hoaHong) / 100);
        return totalPay;
    }
}
