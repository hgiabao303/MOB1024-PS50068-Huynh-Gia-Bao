package lab4.bai2;

import java.util.Scanner;
import lab4.bai2.model.Employee;
import lab4.bai2.service.EmployeeService;

public class Main {
    @SuppressWarnings("resource") // không đóng Scanner(System.in): đóng nó sẽ đóng luôn System.in
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        while (true) {
            System.out.println("\n===== QUAN LY NHAN VIEN =====");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Tim nhan vien theo ma");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            String choice = sc.nextLine().trim();

            if (choice.equals("0")) {
                System.out.println("Tam biet!");
                break;
            }
            switch (choice) {
                case "1" -> {
                    // TODO (DEMO Bài 2): sau khi add() có "throws", dòng service.add(...) sẽ báo lỗi biên dịch
                    //   -> bọc try-catch, bắt RIÊNG từng loại để thông báo cụ thể:
                    //      DuplicateEmployeeException -> "[Trùng mã] ..."
                    //      InvalidSalaryException     -> "[Lương sai] ..."
                    //      NumberFormatException      -> "Lương phải là số!"
                    try {
                        System.out.print("Ma NV: ");
                        String id = sc.nextLine().trim();
                        System.out.print("Ten NV: ");
                        String name = sc.nextLine().trim();
                        System.out.print("Luong: ");
                        double salary = Double.parseDouble(sc.nextLine().trim());

                        service.add(new Employee(id, name, salary));
                        System.out.println("=> Them thanh cong!");
                    } catch (lab4.bai2.exception.DuplicateEmployeeException e) {
                        System.out.println("[Trung ma] " + e.getMessage());
                    } catch (lab4.bai2.exception.InvalidSalaryException e) {
                        System.out.println("[Luong sai] " + e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Luong phai la so!");
                    }
                }
                case "2" -> {
                    System.out.print("Nhap ma can tim: ");
                    Employee e = service.findById(sc.nextLine().trim());
                    if (e == null) {
                        System.out.println("=> Khong tim thay nhan vien");
                    } else {
                        e.inThongTin();
                    }
                }
                default -> System.out.println("Lua chon khong hop le!");
            }
        }
    }
}