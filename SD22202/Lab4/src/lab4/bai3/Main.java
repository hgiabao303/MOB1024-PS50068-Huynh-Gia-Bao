package lab4.bai3;

import lab4.bai1.model.Student;
import lab4.bai2.model.Employee;
import lab4.bai3.service.GenericManager;

public class Main {
    public static void main(String[] args) {
        // Dữ liệu mẫu (dùng lại model của Bài 1 và Bài 2)
        Student[] students = {
            new Student("SV01", "Nguyen Van An", 3.2),
            new Student("SV02", "Tran Thi Binh", 3.6),
            new Student("SV03", "Le Hoang Cuong", 2.8)
        };
        Employee[] employees = {
            new Employee("NV01", "Pham Ngoc Diep", 15_000_000),
            new Employee("NV02", "Vu Minh Duc", 18_000_000)
        };

        // TODO (DEMO Bài 3):
        //   1. Tạo GenericManager<Student> và GenericManager<Employee>  -> 1 class, 2 kiểu
        //   2. add dữ liệu mẫu ở trên vào từng manager
        //   3. In size() và display() của từng manager
        //   4. Student first = studentManager.get(0);   -> KHÔNG cần ép kiểu
        //   5. Thử studentManager.add(employees[0]);     -> LỖI BIÊN DỊCH (Generics bắt sai kiểu)

        GenericManager<Student> studentManager = new GenericManager<>();
        GenericManager<Employee> employeeManager = new GenericManager<>();

        for (Student s : students) {
            studentManager.add(s);
        }
        for (Employee e : employees) {
            employeeManager.add(e);
        }

        System.out.println("=== DANH SACH SINH VIEN (size: " + studentManager.size() + ") ===");
        studentManager.display();

        System.out.println("\n=== DANH SACH NHAN VIEN (size: " + employeeManager.size() + ") ===");
        employeeManager.display();

        Student first = studentManager.get(0);
        System.out.println("\nSinh vien dau tien: " + first.toString());

        // Dong duoi se bao loi bien dich vi Employee khong phai Student:
        // studentManager.add(employees[0]);

        System.out.println("Co " + students.length + " sinh vien va " + employees.length + " nhan vien mau.");
    }
}