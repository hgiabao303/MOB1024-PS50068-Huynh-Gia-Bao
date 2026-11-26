package lab4.bai5;

import lab4.bai1.model.Student;
import lab4.bai5.exception.StudentNotFoundException;
import lab4.bai5.service.StudentService;

/** Bài 5 – Main chỉ gọi service và bắt StudentNotFoundException để in thông báo. */
public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        service.add(new Student("SV01", "Nguyen Van An", 3.2));
        service.add(new Student("SV02", "Tran Thi Binh", 3.6));

        // TODO (DEMO Bài 5):
        //   1. Tìm "SV02" (có) và "SV99" (không có) -> try-catch StudentNotFoundException,
        //      in e.getMessage() và e.getStudentId()
        //   2. deleteById("SV01") rồi xóa lần 2 -> lỗi

        System.out.println("--- 1. Tim SV02 ---");
        try {
            Student s2 = service.findById("SV02");
            System.out.print("Tim thay: ");
            s2.inThongTin();
        } catch (StudentNotFoundException e) {
            System.out.println("Loi: " + e.getMessage() + " | ID: " + e.getStudentId());
        }

        System.out.println("\n--- 1. Tim SV99 ---");
        try {
            Student s99 = service.findById("SV99");
            System.out.print("Tim thay: ");
            s99.inThongTin();
        } catch (StudentNotFoundException e) {
            System.out.println("Loi: " + e.getMessage() + " | ID: " + e.getStudentId());
        }

        System.out.println("\n--- 2. Xoa SV01 lan 1 ---");
        try {
            service.deleteById("SV01");
            System.out.println("Da xoa SV01 thanh cong.");
        } catch (StudentNotFoundException e) {
            System.out.println("Loi: " + e.getMessage() + " | ID: " + e.getStudentId());
        }

        System.out.println("\n--- 2. Xoa SV01 lan 2 ---");
        try {
            service.deleteById("SV01");
            System.out.println("Da xoa SV01 thanh cong.");
        } catch (StudentNotFoundException e) {
            System.out.println("Loi: " + e.getMessage() + " | ID: " + e.getStudentId());
        }

        System.out.println("\nDang co " + service.size() + " sinh vien.");
    }
}