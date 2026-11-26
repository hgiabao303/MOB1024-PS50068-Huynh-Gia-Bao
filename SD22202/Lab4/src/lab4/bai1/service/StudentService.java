package lab4.bai1.service;

/**
 * StudentService
 */
import java.util.ArrayList;
import java.util.List;
import lab4.bai1.model.Student;

public class StudentService {

    private final List<Student> students = new ArrayList<>();

    /**
     * Them sinh vien.
     *
     * TODO (DEMO Bai 1): kiem tra du lieu, sai thi nem IllegalArgumentException
     *   - id rong / null    -> "Ma sinh vien khong duoc de trong"
     *   - name rong / null  -> "Ten sinh vien khong duoc de trong"
     *   - gpa ngoai [0, 4]  -> "GPA phai nam trong khoang 0 - 4"
     */
    public void add(Student s) {
        if (s == null) {
            throw new IllegalArgumentException("Thong tin sinh vien khong duoc null");
        }
        if (s.getId() == null || s.getId().trim().isEmpty()) {
            throw new IllegalArgumentException("Ma sinh vien khong duoc de trong");
        }
        if (s.getName() == null || s.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Ten sinh vien khong duoc de trong");
        }
        if (s.getGpa() < 0 || s.getGpa() > 4) {
            throw new IllegalArgumentException("GPA phai nam trong khoang 0 - 4");
        }

        students.add(s);
    }

    public void showAll() {
        if (students.isEmpty()) {
            System.out.println("(Danh sach trong)");
            return;
        }
        for (Student s : students) {
            s.inThongTin();
        }
    }
}