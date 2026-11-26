package lab4.bai5.exception;

/**
 * Bài 5 - Custom exception thiết kế cùng AI.
 *
 * Tình huống: người dùng tìm / sửa / xóa sinh viên theo mã nhưng mã không tồn tại.
 *
 * TODO (DEMO Bài 5): hỏi AI rồi điền thiết kế vào đây
 *   - Tên exception? -> StudentNotFoundException
 *   - Kế thừa checked (Exception) hay unchecked (RuntimeException)? Vì sao? -> Kế thừa Exception (checked) để đồng bộ khai báo throws và bắt buộc nơi gọi xử lý khi không tìm thấy mã SV
 *   - Nên có field / method gì? (vd: studentId + getter) -> field final String studentId và getter getStudentId()
 */
public class StudentNotFoundException extends Exception {
    private final String studentId;

    public StudentNotFoundException(String studentId) {
        super("Khong tim thay sinh vien co ma: " + studentId);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }
}