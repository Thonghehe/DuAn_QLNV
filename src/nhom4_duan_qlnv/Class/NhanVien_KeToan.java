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
public class NhanVien_KeToan extends NhanVien {

    private int accountingExperience;
    private String certification;
    private List<String> softwareSkills;
    private String phongBan;

    public NhanVien_KeToan(int accountingExperience, String certification, List<String> softwareSkills, String phongBan, String maNV, String ten, String email, float luong) {
        super(maNV, ten, email, luong);
        this.accountingExperience = accountingExperience;
        this.certification = certification;
        this.softwareSkills = softwareSkills;
        this.phongBan = phongBan;
    }

    public NhanVien_KeToan(int accountingExperience, String certification, List<String> softwareSkills, String phongBan) {
        this.accountingExperience = accountingExperience;
        this.certification = certification;
        this.softwareSkills = softwareSkills;
        this.phongBan = phongBan;
    }

    public NhanVien_KeToan() {
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public int getAccountingExperience() {
        return accountingExperience;
    }

    public void setAccountingExperience(int accountingExperience) {
        this.accountingExperience = accountingExperience;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public List<String> getSoftwareSkills() {
        return softwareSkills;
    }

    public void setSoftwareSkills(List<String> softwareSkills) {
        this.softwareSkills = softwareSkills;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        super.nhap();

       
        while (true) {
            try {
                System.out.println("nhap so nam kinh nghiem: ");
                accountingExperience = Integer.parseInt(sc.nextLine());
                if (accountingExperience >= 0) {
                    break; 
                } else {
                    System.out.println("So nam kinh nghiem phai >= 0. Vui long nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen cho so nam kinh nghiem.");
            }
        }
        while (true) {
            try {
                System.out.println("Nhap so luong Ky nang phan mem: ");
                int skillCount = Integer.parseInt(sc.nextLine());
                if (skillCount >= 0) {
                    softwareSkills = new ArrayList<>();
                    for (int i = 0; i < skillCount; i++) {
                        System.out.println("Nhap chung chi thu " + (i + 1) + ": ");
                        String skill = sc.nextLine();
                        softwareSkills.add(skill);
                    }
                    break;
                } else {
                    System.out.println("So luong kỹ năng phai >= 0. Vui long nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen cho so luong kỹ năng phần mềm.");
            }
        }
    }

    @Override
    public float calculatePay() {
        float baseSalary = getLuong(); 

        //tính lương  dựa trên kinh nghiệm kế toán
        float experienceBonus = accountingExperience * 5000;  // Giả sử

        // tính lương dựa trên số lượng kỹ năng phần mềm
        float softwareSkillsBonus = softwareSkills.size() * 1000;  // Giả sử

        float totalSalary = baseSalary + experienceBonus + softwareSkillsBonus;

        return totalSalary;
    }

}
