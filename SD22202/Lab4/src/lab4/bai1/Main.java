package lab4.bai1;

import java.util.Scanner;
import lab4.bai1.model.Student;
import lab4.bai1.service.StudentService;

public class Main {
    @SuppressWarnings("resource") // không đóng Scanner(System.in): đóng nó sẽ đóng luôn System.in
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n===== QUAN LY SINH VIEN =====");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Hien thi danh sach");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            String choice = sc.nextLine().trim();

            if (choice.equals("0")) {
                System.out.println("Tam biet!");
                break;
            }
            switch (choice) {
                case "1" -> {
                    // TODO (DEMO Bài 1): bọc phần nhập + add trong try-catch
                    //   - catch NumberFormatException    (nhập GPA là chữ)  -> đặt TRƯỚC
                    //   - catch IllegalArgumentException (service ném ra)   -> đặt SAU
                    //   Hỏi SV: vì sao thứ tự catch quan trọng?
                    try {
                        System.out.print("Ma SV: ");
                        String id = sc.nextLine();
                        System.out.print("Ten SV: ");
                        String name = sc.nextLine();
                        System.out.print("GPA: ");
                        double gpa = Double.parseDouble(sc.nextLine().trim());

                        service.add(new Student(id.trim(), name.trim(), gpa));
                        System.out.println("=> Them thanh cong!");
                    } catch (NumberFormatException e) {
                        System.out.println("Loi: GPA phai la so!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Loi: " + e.getMessage());
                    }
                }
                case "2" -> service.showAll();
                default -> System.out.println("Lua chon khong hop le!");
            }
        }
    }
}