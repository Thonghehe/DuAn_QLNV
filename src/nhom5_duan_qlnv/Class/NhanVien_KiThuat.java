/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhom5_duan_qlnv.Class;

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

    public NhanVien_KiThuat(float overtimeHours, float hourlyRateOvertime, int projectsCompleted, List<String> certifications, String maNV, String ten, String email, String phongBan, float luong) {
        super(maNV, ten, email, phongBan, luong);
        this.overtimeHours = overtimeHours;
        this.hourlyRateOvertime = hourlyRateOvertime;
        this.projectsCompleted = projectsCompleted;
        this.certifications = certifications;
    }

    public NhanVien_KiThuat(String maNV, String ten, String email, String phongBan, float luong) {
        super(maNV, ten, email, phongBan, luong);
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
        super.nhap();
        Scanner sc = new Scanner(System.in);

        
        boolean isValidOvertimeHours = false;
        boolean isValidHourlyRateOvertime = false;
        boolean isValidProjectsCompleted = false;
        boolean isValidCertifications = false;

        while (!isValidOvertimeHours) {
            try {
                System.out.println("Nhap số gio tang ca: ");
                overtimeHours = Float.parseFloat(sc.nextLine());
                if (overtimeHours >= 0) {
                    isValidOvertimeHours = true;
                } else {
                    System.out.println("So gio tang ca khong hop le. Vui long nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so cho so gio tang.");
            }
        }

        while (!isValidHourlyRateOvertime) {
            try {
                System.out.println("Nhap luong tang ca: ");
                hourlyRateOvertime = Float.parseFloat(sc.nextLine());
                if (hourlyRateOvertime >= 0) {
                    isValidHourlyRateOvertime = true;
                } else {
                    System.out.println("Luong tang ca khong hop le. Vui long nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so cho luong tang ca.");
            }
        }

        while (!isValidProjectsCompleted) {
            try {
                System.out.println("Nhap so du an hoan thanh:");
                projectsCompleted = Integer.parseInt(sc.nextLine());
                if (projectsCompleted >= 0) {
                    isValidProjectsCompleted = true;
                } else {
                    System.out.println("So du an hoan thanh khong hop le. Vui long nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen cho so du an hoan thanh.");
            }
        }

        while (!isValidCertifications) {
            System.out.println("Nhap so luong chung chi: ");
            int certCount = Integer.parseInt(sc.nextLine());
            certifications = new ArrayList<>();
            for (int i = 0; i < certCount; i++) {
                System.out.println("Nhap chung chi thu " + (i + 1) + ": ");
                String certification = sc.nextLine();
                if (!isEmpty(certification)) {
                    certifications.add(certification);
                } else {
                    System.out.println("Chung chi khong đuoc đe trong. Vui long nhap lai.");
                    break;
                }
            }
            if (certifications.size() == certCount) {
                isValidCertifications = true;
            }
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

    private boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
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

