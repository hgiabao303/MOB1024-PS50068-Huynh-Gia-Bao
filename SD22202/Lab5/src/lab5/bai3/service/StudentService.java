package lab5.bai3.service;

import lab5.bai2.io.StudentFileStore;
import lab5.model.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Bài 3 – Quản lý danh sách sinh viên; đọc/ghi file qua StudentFileStore (Bài 2).
 * Main không cần biết dữ liệu được lưu thế nào.
 */
public class StudentService {

    private final String filePath;
    private List<Student> students = new ArrayList<>();

    public StudentService(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Đọc khi khởi động.
     *
     * TODO (DEMO Bài 3):
     *   - File chưa tồn tại (new File(filePath).exists() == false) -> báo, giữ danh sách rỗng
     *   - Có file -> students = new ArrayList<>(StudentFileStore.readFromFile(filePath));
     */
    public void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File chua ton tai: " + filePath + " (giu danh sach rong)");
            students = new ArrayList<>();
            return;
        }
        students = new ArrayList<>(StudentFileStore.readFromFile(filePath));
        System.out.println("Da nap " + students.size() + " sinh vien tu " + filePath);
    }

    /**
     * Ghi khi kết thúc.
     *
     * TODO (DEMO Bài 3): gọi StudentFileStore.writeToFile(filePath, students), báo số SV đã lưu
     */
    public void saveToFile() {
        if (StudentFileStore.writeToFile(filePath, students)) {
            System.out.println("Da luu " + students.size() + " sinh vien vao " + filePath);
        } else {
            System.out.println("Luu file that bai: " + filePath);
        }
    }

    /** Thêm sinh viên. Trùng mã → false. */
    public boolean add(Student s) {
        if (findById(s.getId()) != null) {
            return false;
        }
        students.add(s);
        return true;
    }

    public boolean delete(String id) {
        return students.removeIf(s -> s.getId().equalsIgnoreCase(id));
    }

    public Student findById(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public List<Student> getAll() {
        return students;
    }
}