/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhom4_duan_qlnv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import nhom4_duan_qlnv.Class.NhanVien;
import nhom4_duan_qlnv.Class.NhanVien_BanHang;
import nhom4_duan_qlnv.Class.NhanVien_BanTG;
import nhom4_duan_qlnv.Class.NhanVien_KeToan;
import nhom4_duan_qlnv.Class.NhanVien_KiThuat;
import nhom4_duan_qlnv.Class.QuanLy;

/**
 *
 * @author Acer
 */
public class QLNV {

    ArrayList<NhanVien> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void Y01() {
        System.out.println("Mời Bạn Nhập số nhân viên: ");
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

    public void Y02() {
        System.out.println("--------------------------Danh Sach Nhan Vien--------------------------");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s", "maNV", "ten", "email", "phongBan", "luong", "thueTn");
        for (NhanVien nhanVien : list) {
            nhanVien.xuat();
        }
    }

    public void Y03() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien can tim: ");
        String ID = sc.nextLine();
        Boolean check = false;
        for (NhanVien nv : list) {
            if (ID.equalsIgnoreCase(nv.getMaNV())) {
                System.out.printf("Ma nhan vien: %s | Ho ten: %s | Phong ban: %s | Luong: %.2f\n", nv.getMaNV(), nv.getTen(), nv.getPhongBan(), nv.getLuong());
                check = true;
                break;
            }
        }

        if (check == false) {
            System.out.println("Nhan vien khong ton tai !");
        }
    }

    public void Y04() {
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

    public void Y05() {
        System.out.println("Nhap ma nhan vien can cap nhat: ");
        String ID = sc.nextLine();
        for (NhanVien nv : list) {
            if (nv.getMaNV().equalsIgnoreCase(ID)) {
                System.out.println("--------------------------Cap Nhat Lai Thong Tin --------------------------");
                nv.nhap();
            }
        }
        Y02();
    }

    public void Y06() {
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

    public void Y07() {
        Comparator<NhanVien> comp = new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien nv1, NhanVien nv2) {
                return nv1.getTen().compareTo(nv2.getTen());
            }
        };
        Collections.sort(list, comp);
        Y02();
    }

    public void Y08() {
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
        Y02();
    }

    public void Y09() {
        Collections.sort(list, (a, b) -> (int) (b.getLuong() - a.getLuong()));
        if(list.size() < 5){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).xuat();
            }
        }
        else{
            for (int i = 0; i < 5; i++) {
                list.get(i).xuat();
            }
        }
    }

}
