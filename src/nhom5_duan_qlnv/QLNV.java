/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhom5_duan_qlnv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import nhom5_duan_qlnv.Class.NhanVien;
import nhom5_duan_qlnv.Class.NhanVien_BanHang;
import nhom5_duan_qlnv.Class.NhanVien_BanTG;
import nhom5_duan_qlnv.Class.NhanVien_KeToan;
import nhom5_duan_qlnv.Class.NhanVien_KiThuat;
import nhom5_duan_qlnv.Class.QuanLy;

/**
 *
 * @author Acer
 */
public class QLNV {

    ArrayList<NhanVien> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void enterEmployeeList() {
        System.out.println("Moi Ban Nhap so nhan vien: ");
        System.out.println("1-NV Hanh Chinh  2-NV Ban Hang 3-NV Ke Toan 4-NV Ban Thoi Gian 5-NV Ki Thuat 6-NV Quan Ly");
        int option = Integer.parseInt(sc.nextLine());
        switch (option) {
            case 1:
                NhanVien nv = new NhanVien();
                nv.nhap();
                nv.setPhongBan("Nhan Vien");
                list.add(nv);
                break;
            case 2:
                NhanVien_BanHang nvBH = new NhanVien_BanHang();
                nvBH.nhap();
                nvBH.setPhongBan("Phong Sales");
                list.add(nvBH);
                break;
            case 3:
                NhanVien_KeToan nvKT = new NhanVien_KeToan();
                nvKT.nhap();
                nvKT.setPhongBan("Phong Ke Toan");
                list.add(nvKT);
                break;
            case 4:
                NhanVien_BanTG nvPT = new NhanVien_BanTG();
                nvPT.nhap();
                nvPT.setPhongBan("Nhan Vien Ban Thoi Gian");
                list.add(nvPT);
                break;
            case 5:
                NhanVien_KiThuat nvKthuat = new NhanVien_KiThuat();
                nvKthuat.nhap();
                nvKthuat.setPhongBan("Phong Ki Thuat");
                list.add(nvKthuat);
                break;
            case 6:
                QuanLy nvQL = new QuanLy();
                nvQL.nhap();
                nvQL.setPhongBan("Quan Ly");
                list.add(nvQL);
                break;
            default:
                System.out.println("Option khong ton tai Moi ban chon lai");
                break;
        }
    }

    public void displayEmployeeList() {
        System.out.println("+------------+--------------------------+----------------------+--------------------------------+------------+----------+------------+");
        System.out.println("|   maNV     |       ten                |         email        |    phongBan                    |   luong    |  thueTn  |  tongLuong |");
        System.out.println("+------------+--------------------------+----------------------+--------------------------------+------------+----------+------------+");
        for (NhanVien nhanVien : list) {
            System.out.printf("| %-10s | %-24s | %-20s | %-30s | %-10.2f | %-8.2f | %-10.2f |\n",
                    nhanVien.getMaNV(), nhanVien.getTen(), nhanVien.getEmail(),
                    nhanVien.getPhongBan(), nhanVien.getLuong(), nhanVien.getThue(), nhanVien.calculatePay());
        }
        System.out.println("+------------+--------------------------+----------------------+--------------------------------+------------+----------+------------+");
    }

    public void findEmployeeById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien can tim: ");
        String ID = sc.nextLine();
        Boolean check = false;
        for (NhanVien nhanVien : list) {
            if (nhanVien.getMaNV().toLowerCase().contains(ID.toLowerCase())) {
                System.out.println("+------------+--------------------------+----------------------+--------------------------------+------------+----------+------------+");
                System.out.println("|   maNV     |       ten                |         email        |    phongBan                    |   luong    |  thueTn  |  tongLuong |");
                System.out.println("+------------+--------------------------+----------------------+--------------------------------+------------+----------+------------+");
                System.out.printf("| %-10s | %-24s | %-20s | %-30s | %-10.2f | %-8.2f | %-10.2f |\n",
                        nhanVien.getMaNV(), nhanVien.getTen(), nhanVien.getEmail(),
                        nhanVien.getPhongBan(), nhanVien.getLuong(), nhanVien.getThue(), nhanVien.calculatePay());
                System.out.println("+------------+--------------------------+----------------------+--------------------------------+------------+----------+------------+");
                check = true;
                break;
            }
        }

        if (check == false) {
            System.out.println("Nhan vien khong ton tai !");
        }
    }

    public void findEmployeeByName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten nhan vien can tim: ");
        String name = sc.nextLine();
        Boolean check = false;
        for (NhanVien nhanVien : list) {
            if (nhanVien.getTen().toLowerCase().contains(name.toLowerCase())) {
                System.out.println("+------------+--------------------------+----------------------+--------------------------------+------------+----------+------------+");
                System.out.println("|   maNV     |       ten                |         email        |    phongBan                    |   luong    |  thueTn  |  tongLuong |");
                System.out.println("+------------+--------------------------+----------------------+--------------------------------+------------+----------+------------+");
                System.out.printf("| %-10s | %-24s | %-20s | %-30s | %-10.2f | %-8.2f | %-10.2f |\n",
                        nhanVien.getMaNV(), nhanVien.getTen(), nhanVien.getEmail(),
                        nhanVien.getPhongBan(), nhanVien.getLuong(), nhanVien.getThue(), nhanVien.calculatePay());
                System.out.println("+------------+--------------------------+----------------------+--------------------------------+------------+----------+------------+");
                check = true;
                break;
            }
        }

        if (check == false) {
            System.out.println("Nhan vien khong ton tai !");
        }
    }

    public void findEmployeesByDepartment() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap phong ban can tim kiem: ");
        String department = sc.nextLine();
        boolean found = false;
        for (NhanVien nv : list) {
            if (nv.getPhongBan().equalsIgnoreCase(department)) {
                nv.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong co nhan vien nao o phong ban " + department);
        }
    }

    public void deleteEmployeeById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien can xoa: ");
        String ID = sc.nextLine();
        Boolean check = false;
        for (NhanVien nv : list) {
            if (ID.equalsIgnoreCase(nv.getMaNV())) {
                list.remove(nv);
                check = true;
                break;
            }
        }

        if (check == false) {
            System.out.println("Nhan vien khong ton tai !");
        } else {
            System.out.println("Nhan vien da bi xoa !");
        }
    }

    public void updateEmployeeInfoById() {
        System.out.println("Nhap ma nhan vien can cap nhat: ");
        String ID = sc.nextLine();
        for (NhanVien nv : list) {
            if (nv.getMaNV().equalsIgnoreCase(ID)) {
                System.out.println("--------------------------Cap Nhat Lai Thong Tin --------------------------");
                nv.nhap();
            }
        }
        displayEmployeeList();
    }

    public void displayEmployeeListBySalaryRange() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Xuat danh sach nhan vien theo luong");
        System.out.print("Nhap luong can duoi: ");
        double min = sc.nextDouble();
        System.out.print("Nhap luong can tren: ");
        double max = sc.nextDouble();
        for (NhanVien nv : list) {
            if (nv.getLuong() >= min && nv.getLuong() <= max) {
                /*for (NhanVien nv : list) {
                    System.out.printf("Ma nhan vien: %s | Ho ten: %s | Phong ban: %s | Luong: %.2f\n", nv.getMaNV(), nv.getTen(), nv.getPhongBan(), nv.getLuong());
                }*/
                nv.xuat();
            }
        }
    }

    public void sortEmployeesByName() {
        Comparator<NhanVien> comp = new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien nv1, NhanVien nv2) {
                return nv1.getTen().compareTo(nv2.getTen());
            }
        };
        Collections.sort(list, comp);
        displayEmployeeList();
    }

    public void sortEmployeesByIncome() {
        Comparator<NhanVien> comp = new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien nv1, NhanVien nv2) {
                if (nv1.calculatePay() > nv2.calculatePay()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        Collections.sort(list, comp);
        displayEmployeeList();
    }

    public void displayTop5EmployeesByIncome() {
        Collections.sort(list, (a, b) -> (int) (b.calculatePay() - a.calculatePay()));
        if (list.size() < 5) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).xuat();
            }
        } else {
            for (int i = 0; i < 5; i++) {
                list.get(i).xuat();
            }
        }
    }

    public void calculateTotalSalary() {
        double totalSalary = 0;
        for (NhanVien nv : list) {
            totalSalary += nv.calculatePay();
        }
        displayEmployeeList();
        System.out.println("Tong luong cua tat ca nhan vien trong cong ty: " + totalSalary);
    }

    public void generateReport() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chon loai bao cao:");
        System.out.println("1. Bao cao tong so nhan vien trong cong ty");
        System.out.println("2. Bao cao tong so nhan vien theo phong ban");
        System.out.println("3. Bao cao tong luong cua cong ty");
        
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                generateTotalEmployeeCountReport();
                break;
            case 2:
                generateEmployeeCountByDepartmentReport();
                break;
            case 3:
                calculateTotalSalary();
                break;
            default:
                System.out.println("Lua chon khong hop le!");
        }
    }

    private void generateTotalEmployeeCountReport() {
        int totalEmployeeCount = list.size();
        System.out.println("Bao cao tong so nhan vien trong cong ty:");
        System.out.println("Tong so nhan vien: " + totalEmployeeCount);
    }

    private void generateEmployeeCountByDepartmentReport() {
        Map<String, Integer> departmentCounts = new HashMap<>();

        for (NhanVien nv : list) {
            String department = nv.getPhongBan();
            departmentCounts.put(department, departmentCounts.getOrDefault(department, 0) + 1);
        }

        System.out.println("Bao cao tong so nhan vien theo phong ban:");
         departmentCounts.forEach((department, count) -> System.out.println(department + ": " + count));
    }

}
