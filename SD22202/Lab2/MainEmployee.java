import java.util.Scanner;

public class MainEmployee {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========== MENU QUẢN LÝ NHÂN VIÊN ==========");
            System.out.println("1. Thêm một nhân viên vào danh sách");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Tìm nhân viên theo mã");
            System.out.println("4. Cập nhật lương nhân viên theo mã");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã nhân viên: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập tên nhân viên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập lương nhân viên: ");
                    double salary = Double.parseDouble(scanner.nextLine());

                    Employee emp = new Employee(id, name, salary);
                    service.addEmployee(emp);
                    break;

                case 2:
                    service.displayAll();
                    break;

                case 3:
                    System.out.print("Nhập mã nhân viên cần tìm: ");
                    String searchId = scanner.nextLine();
                    Employee found = service.findById(searchId);
                    if (found != null) {
                        System.out.println("Đã tìm thấy: " + found);
                    } else {
                        System.out.println("Không tìm thấy nhân viên có mã: " + searchId);
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã nhân viên cần cập nhật lương: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Nhập mức lương mới: ");
                    double newSalary = Double.parseDouble(scanner.nextLine());

                    boolean updated = service.updateSalary(updateId, newSalary);
                    if (updated) {
                        System.out.println("Cập nhật lương thành công!");
                    } else {
                        System.out.println("Không tìm thấy nhân viên để cập nhật!");
                    }
                    break;

                case 0:
                    System.out.println("Đang thoát chương trình. Hẹn gặp lại!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại từ 0 đến 4.");
            }
        } while (choice != 0);

        scanner.close();
    }
}