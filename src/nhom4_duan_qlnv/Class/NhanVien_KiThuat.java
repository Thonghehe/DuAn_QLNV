/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhom4_duan_qlnv.Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class NhanVien_KiThuat extends NhanVien {

    private float overtimeHours;
    private float hourlyRateOvertime;
    private int projectsCompleted;
    private List<String> certifications;
    private String phongBan;

    public NhanVien_KiThuat(float overtimeHours, float hourlyRateOvertime, int projectsCompleted, List<String> certifications, String phongBan, String maNV, String ten, String email, float luong) {
        super(maNV, ten, email, luong);
        this.overtimeHours = overtimeHours;
        this.hourlyRateOvertime = hourlyRateOvertime;
        this.projectsCompleted = projectsCompleted;
        this.certifications = certifications;
        this.phongBan = phongBan;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public NhanVien_KiThuat() {
    }

    public float getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(float overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public float getHourlyRateOvertime() {
        return hourlyRateOvertime;
    }

    public void setHourlyRateOvertime(float hourlyRateOvertime) {
        this.hourlyRateOvertime = hourlyRateOvertime;
    }

    public int getProjectsCompleted() {
        return projectsCompleted;
    }

    public void setProjectsCompleted(int projectsCompleted) {
        this.projectsCompleted = projectsCompleted;
    }

    public List<String> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<String> certifications) {
        this.certifications = certifications;
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.println("nhap so gio tang: ");
        overtimeHours = Float.parseFloat(sc.nextLine());
        System.out.println("luong tang ca: ");
        hourlyRateOvertime = Float.parseFloat(sc.nextLine());
        System.out.println("Du An Hoan Thanh:");
        projectsCompleted = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap sa luong chung chi: ");
        int certCount = Integer.parseInt(sc.nextLine());
        certifications = new ArrayList<>();
        for (int i = 0; i < certCount; i++) {
            System.out.println("Nhap chung chi thu " + (i + 1) + ": ");
            String certification = sc.nextLine();
            certifications.add(certification);
        }
    }

    @Override
    public float calculatePay() {
        float baseSalary = getLuong();
        float overtimePay = overtimeHours * hourlyRateOvertime;
        float additionalPay = projectsCompleted * 1000;

        float totalSalary = baseSalary + overtimePay + additionalPay;

        return totalSalary;
    }

//    @Override
//    public void xuat() {
//        super.xuat();  // Call the xuat method in the superclass
//        System.out.println("So gio tang: " + overtimeHours);
//        System.out.println("Luong tang ca: " + hourlyRateOvertime);
//        System.out.println("Du an hoan thanh: " + projectsCompleted);
//        System.out.println("Chung chi:");
//        for (String cert : certifications) {
//            System.out.println(cert);
//        }
//        System.out.println("Phong ban: " + phongBan);
//    }

}
