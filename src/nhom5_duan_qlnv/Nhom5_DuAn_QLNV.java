/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nhom5_duan_qlnv;

import java.util.Arrays;
import java.util.Scanner;
import javax.swing.plaf.synth.Region;
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
public class Nhom5_DuAn_QLNV {

    public static void menu() {
        System.out.println("\n==================== Menu chuong trinh ======================");
        System.out.println("| 1. Nhap danh sach nhanh vien                               |");
        System.out.println("| 2. Xuat danh sach nhan vien                                |");
        System.out.println("| 3. Tim nhan vien theo ma nhan vien                         |");
        System.out.println("| 4. Tim nhan vien theo ten nhan vien                        |");
        System.out.println("| 5. Tim nhan vien theo Phong ban nhan vien                  |");
        System.out.println("| 6. Xoa nhan vien theo ma nhan vien                         |");
        System.out.println("| 7. Cap nhat thong tin nhan vien theo ma nhan vien          |");
        System.out.println("| 8. Xuat nhan vien theo khoang luong                        |");
        System.out.println("| 9. Sap xep nhan vien theo ho va ten                        |");
        System.out.println("| 10. Sap xep nhan vien theo thu nhap                        |");
        System.out.println("| 11. Xuat 5 nhan vien co thu nhap cao nhat                  |");
        System.out.println("| 12. Lap Bao Cao                                            |");
        System.out.println("| 0. Thoat                                                   |");
        System.out.println("==============================================================");
        System.out.print("Moi ban chon: ");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("console.encoding", "UTF-8");
        QLNV ql = new QLNV();

        ql.list.add(new NhanVien("NV001", "Nguyen Van A", "vana@gmail.com", "Nhan Vien", 1000));
        ql.list.add(new NhanVien_BanHang(1500000, 0.1f, 20, "NV002", "Nguyen Thi B", "vanb@gmail.com", "Phong Sales", 1200));
        ql.list.add(new NhanVien_KeToan(3, "Certification XYZ", Arrays.asList("SoftwareA", "SoftwareB"), "NV003", "Tran Van C", "vanc@gmail.com", "Phong Ke Toan", 1500));
        ql.list.add(new NhanVien_BanTG(30, 10, 160, 10, "NV004", "Hoang Van D", "vand@gmail.com", "Nhan Vien Ban Thoi Gian", 800));
        ql.list.add(new NhanVien_KiThuat(10, 15, 5, Arrays.asList("Certification 1", "Certification 2"), "NV005", "Le Thi E", "vane@gmail.com", "Phong Ki Thuat", 1800));
        ql.list.add(new QuanLy(10, 1000, 3, "NV006", "Tran Thi F", "vanf@gmail.com", "Quan Ly", 2000));

        int option;
        while (true) {
            Scanner sc = new Scanner(System.in);
            menu();
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    System.out.println("----------Nhap Danh Sach Nhan Vien----------");
                    ql.enterEmployeeList();
                    break;
                case 2:
                    System.out.println("----------Thong Tin Nhan Vien----------");
                    ql.displayEmployeeList();
                    break;
                case 3:
                    ql.findEmployeeById();
                    break;
                case 4:
                    ql.findEmployeeByName();
                    break;
                case 5:
                    ql.findEmployeesByDepartment();
                    break;
                case 6:
                    ql.deleteEmployeeById();
                    break;
                case 7:
                    ql.updateEmployeeInfoById();
                    break;
                case 8:
                    ql.displayEmployeeListBySalaryRange();
                    break;
                case 9:
                    ql.sortEmployeesByName();
                    break;
                case 10:
                    ql.sortEmployeesByIncome();
                    break;
                case 11:
                    ql.displayTop5EmployeesByIncome();
                    break;
                case 12:
                    ql.generateReport();
                    break;
                case 0:
                    System.out.println("Cam On đa su dung!!!");
                    System.exit(0);
                default:
                    System.out.println("Lua chon cua ban khong ton tai!!! Moi Nhap Lai");
                    break;
            }
        }
    }

}
