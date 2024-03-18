/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhom5_duan_qlnv.Class;

import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class QuanLy extends NhanVien {

    private int teamSize;
    private float managementAllowance;
    private int projectsManaged;

    public QuanLy(int teamSize, float managementAllowance, int projectsManaged, String maNV, String ten, String email, String phongBan, float luong) {
        super(maNV, ten, email, phongBan, luong);
        this.teamSize = teamSize;
        this.managementAllowance = managementAllowance;
        this.projectsManaged = projectsManaged;
    }

    public QuanLy(String maNV, String ten, String email, String phongBan, float luong) {
        super(maNV, ten, email, phongBan, luong);
    }
    

    

    

    public QuanLy() {
    }

        
    
    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public float getManagementAllowance() {
        return managementAllowance;
    }

    public void setManagementAllowance(float managementAllowance) {
        this.managementAllowance = managementAllowance;
    }

    public int getProjectsManaged() {
        return projectsManaged;
    }

    public void setProjectsManaged(int projectsManaged) {
        this.projectsManaged = projectsManaged;
    }

    @Override
    public void nhap() {
        super.nhap();

        Scanner sc = new Scanner(System.in);
        
        
        boolean isValidTeamSize = false;
        boolean isValidManagementAllowance = false;
        boolean isValidprojectsManaged = false;
        
        while (!isValidTeamSize) {
            try {
                System.out.println("Nhap số luong thanh vien trong nhom: ");
                teamSize = Integer.parseInt(sc.nextLine());
                if (teamSize >= 0) {
                    isValidTeamSize = true;
                } else {
                    System.out.println("So luong thanh vien khong hop le. Vui long nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so cho so luong thanh vien.");
            }
        }
        
        
        while (!isValidManagementAllowance) {
            try {
                System.out.println("Nhap phu cap quan ly: ");
                managementAllowance = Float.parseFloat(sc.nextLine());
                if (managementAllowance >= 0) {
                    isValidManagementAllowance = true;
                } else {
                    System.out.println("phu cap quan ly khong hop le. Vui long nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so cho phu cap quan ly.");
            }
        }
        
        while (!isValidprojectsManaged) {
            try {
                System.out.println("Nhap so du an quan ly: ");
                projectsManaged = Integer.parseInt(sc.nextLine());
                if (projectsManaged >= 0) {
                    isValidprojectsManaged = true;
                } else {
                    System.out.println("so du an quan ly khong hop le. Vui long nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so cho so du an quan ly.");
            }
        }
       
    }

    @Override
    public float calculatePay() {
        // Giả sử mỗi dự án quản lý đều đóng góp 5000 đồng lương
        float projectBonus = projectsManaged * 5000;

        // Giả sử mỗi thành viên trong nhóm đều đóng góp 2000 đồng lương
        float teamBonus = teamSize * 2000;

        // Tính lương dựa trên cơ sở lương, phụ cấp quản lý và các khoản thưởng
        float totalSalary = getLuong() + managementAllowance + projectBonus + teamBonus;

        return totalSalary;
    }

}
