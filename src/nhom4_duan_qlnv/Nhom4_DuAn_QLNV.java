/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nhom4_duan_qlnv;

import java.util.Scanner;
import javax.swing.plaf.synth.Region;

/**
 *
 * @author Acer
 */
public class Nhom4_DuAn_QLNV {

    public static void menu() {
        System.out.println("\nMenu chuong trinh");
        System.out.println("1. Nhap dan sach nhanh vien");
        System.out.println("2. Xuat danh sach nhan vien");
        System.out.println("3. Tim nhan vien theo ma nhan vien");
        System.out.println("4. Xoa nhan vien theo ma nhan vien");
        System.out.println("5. Cap nhat thong tin nhan vien theo ma nhan vien");
        System.out.println("6.Xuat nhan vien theo khoang luong");
        System.out.println("7. Sap xep nhan vien theo ho va ten");
        System.out.println("8. Sap xep nhan vien theo thu nhap");
        System.out.println("9. Xuat 5 nhan vien co thu nhap cao nhat");
        System.out.println("0. Thoat");
        System.out.print("Moi ban chon: ");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("console.encoding", "UTF-8");
        QLNV ql = new QLNV();
        int option;
        while (true) {
            Scanner sc = new Scanner(System.in);
            menu();
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    System.out.println("----------Nhap Danh Sach Nhan Vien----------");
                    ql.Y01();
                    break;
                case 2:
                    System.out.println("----------Thong Tin Nhan Vien----------");
                    ql.Y02();
                    break;
                case 3:
                    ql.Y03();
                    break;
                case 4:
                    ql.Y04();
                    break;
                case 5:
                    ql.Y05();
                    break;
                case 6:
                    ql.Y06();
                    break;
                case 7:
                    ql.Y07();
                    break;
                case 8:
                    ql.Y08();
                    break;
                case 9:
                    ql.Y09();
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
