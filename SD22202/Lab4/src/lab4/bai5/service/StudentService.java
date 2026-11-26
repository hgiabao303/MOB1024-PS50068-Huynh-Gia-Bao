package lab4.bai5.service;

import lab4.bai1.model.Student;
import lab4.bai5.exception.StudentNotFoundException;

import java.util.ArrayList;
import java.util.List;

/** Bài 5 – Áp dụng StudentNotFoundException vào việc tìm / xóa sinh viên theo mã. */
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public void add(Student s) {
        students.add(s);
    }

    // TODO (DEMO Bài 5):
    //   public Student findById(String id) throws StudentNotFoundException
    //       -> duyệt danh sách, không thấy thì throw new StudentNotFoundException(id)
    //   public void deleteById(String id) throws StudentNotFoundException
    //       -> tái sử dụng findById: exception tự "nổi" lên nơi gọi
    public Student findById(String id) throws StudentNotFoundException {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        throw new StudentNotFoundException(id);
    }

    public void deleteById(String id) throws StudentNotFoundException {
        Student found = findById(id);
        students.remove(found);
    }

    public int size() {
        return students.size();
    }
}