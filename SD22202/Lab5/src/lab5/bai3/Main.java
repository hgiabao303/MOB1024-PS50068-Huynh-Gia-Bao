package lab5.bai3;

import lab5.bai3.service.StudentService;
import lab5.model.Student;

import java.util.Scanner;

/** Bài 3 – Menu quản lý sinh viên có lưu file. Main chỉ nhập / xuất, mọi xử lý nằm trong StudentService. */
public class Main {
    @SuppressWarnings("resource") // không đóng Scanner(System.in): đóng nó sẽ đóng luôn System.in
    public static void main(String[] args) {
        StudentService service = new StudentService("data/students_service.dat");
        service.loadFromFile(); // 1. đọc khi khởi động

        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            System.out.println("\n===== QUAN LY SINH VIEN (luu file) =====");
            System.out.println("1. Them  2. Xem danh sach  3. Xoa  0. Luu & thoat");
            System.out.print("Chon: ");
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> {
                    try {
                        System.out.print("Ma: ");
                        String id = sc.nextLine().trim();
                        System.out.print("Ten: ");
                        String name = sc.nextLine().trim();
                        System.out.print("GPA: ");
                        double gpa = Double.parseDouble(sc.nextLine().trim());
                        System.out.println(service.add(new Student(id, name, gpa))
                                ? "=> Da them" : "=> Trung ma!");
                    } catch (NumberFormatException e) {
                        System.out.println("=> GPA phai la so");
                    }
                }
                case "2" -> {
                    if (service.getAll().isEmpty()) System.out.println("(Trong)");
                    service.getAll().forEach(System.out::println);
                }
                case "3" -> {
                    System.out.print("Ma can xoa: ");
                    System.out.println(service.delete(sc.nextLine().trim()) ? "=> Da xoa" : "=> Khong tim thay");
                }
                case "0" -> service.saveToFile(); // 2. ghi khi kết thúc
                default -> System.out.println("Khong hop le");
            }
        } while (!choice.equals("0"));
    }
}