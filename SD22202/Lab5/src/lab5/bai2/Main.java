package lab5.bai2;

import lab5.bai2.io.StudentFileStore;
import lab5.model.Student;

import java.util.ArrayList;
import java.util.List;

/** Bài 2 – Main chỉ gọi lớp io và in kết quả. */
public class Main {

    private static final String FILE_PATH = "data/students.dat";

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("SV01", "Nguyen Van An", 3.2));
        students.add(new Student("SV02", "Tran Thi Binh", 3.6));
        students.add(new Student("SV03", "Le Hoang Cuong", 2.8));

        // 1. Ghi cả List xuống file
        if (StudentFileStore.writeToFile(FILE_PATH, students)) {
            System.out.println("Ghi thanh cong " + students.size() + " sinh vien vao " + FILE_PATH);
        }

        // 2. Đọc lại
        List<Student> loaded = StudentFileStore.readFromFile(FILE_PATH);
        System.out.println("\n===== DU LIEU DOC TU FILE (" + loaded.size() + ") =====");
        loaded.forEach(System.out::println);
    }
}