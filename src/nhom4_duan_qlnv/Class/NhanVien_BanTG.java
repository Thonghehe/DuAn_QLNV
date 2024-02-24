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
public class NhanVien_BanTG extends NhanVien {

    private int caLam;
    private int hourlyRate;
    private int hoursWorked;
    private int overtimeHours;

    public NhanVien_BanTG(int caLam, int hourlyRate, int hoursWorked, int overtimeHours, String maNV, String ten, String email, String phongBan, float luong) {
        super(maNV, ten, email, phongBan, luong);
        this.caLam = caLam;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.overtimeHours = overtimeHours;
    }

    public NhanVien_BanTG(String maNV, String ten, String email, String phongBan, float luong) {
        super(maNV, ten, email, phongBan, luong);
    }

    

    public NhanVien_BanTG() {
    }

    public int getCaLam() {
        return caLam;
    }

    public void setCaLam(int caLam) {
        this.caLam = caLam;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    @Override
    public void nhap() {
        super.nhap();

        Scanner sc = new Scanner(System.in);

        boolean isValidCaLam = false;
        boolean isValidHourlyRate = false;
        boolean isValidHoursWorked = false;
        boolean isValidOvertimeHours = false;

        while (!isValidCaLam) {
            System.out.print("Nhap ca lam (1: Sang, 2: Chieu, 3: Toi): ");
            caLam = Integer.parseInt(sc.nextLine());
            if (caLam >= 1 && caLam <= 3) {
                isValidCaLam = true;
            } else {
                System.out.println("Ca lam khong hop le. Vui long nhap lai.");
            }
        }

        while (!isValidHourlyRate) {
            System.out.print("Nhap gia luong theo gio: ");
            hourlyRate = Integer.parseInt(sc.nextLine());
            if (hourlyRate >= 0) {
                isValidHourlyRate = true;
            } else {
                System.out.println("Gia luong khong hop le. Vui long nhap lai.");
            }
        }

        while (!isValidHoursWorked) {
            System.out.print("Nhap so gio lam viec: ");
            hoursWorked = Integer.parseInt(sc.nextLine());
            if (hoursWorked >= 0) {
                isValidHoursWorked = true;
            } else {
                System.out.println("So gio lam viec khong hop le. Vui long nhap lai.");
            }
        }

        while (!isValidOvertimeHours) {
            System.out.print("Nhap so gio lam them: ");
            overtimeHours = Integer.parseInt(sc.nextLine());
            if (overtimeHours >= 0) {
                isValidOvertimeHours = true;
            } else {
                System.out.println("So gio lam them khong hop le. Vui long nhap lai.");
            }
        }
    }

    @Override
    public float calculatePay() {
        // Lương cơ bản dựa trên giờ làm việc
        float basicPay = hourlyRate * hoursWorked;

        // Lương làm thêm giờ (nếu có)
        float overtimePay = overtimeHours * (hourlyRate * 1.5f);

        // Tổng lương
        float totalPay = basicPay + overtimePay;

        return totalPay;
    }

}
                