package lab5.bai2.io;

import lab5.model.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/** Bài 2 – Lưu & khôi phục danh sách sinh viên bằng Object Stream (dùng lại ở Bài 3). */
public class StudentFileStore {

    /**
     * Ghi cả List xuống file. Trả về true nếu ghi được.
     *
     * TODO (DEMO Bài 2):
     *   1. Tạo thư mục cha nếu chưa có
     *   2. try-with-resources: new ObjectOutputStream(new FileOutputStream(path))
     *   3. oos.writeObject(new ArrayList<>(list));   // ArrayList cũng là Serializable
     *   4. catch IOException -> in lỗi, return false
     *   (Student chưa implements Serializable -> NotSerializableException)
     */
    public static boolean writeToFile(String path, List<Student> list) {
        File file = new File(path);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(new ArrayList<>(list));
            return true;
        } catch (IOException e) {
            System.out.println("Loi ghi file nhi phan: " + e.getMessage());
            return false;
        }
    }

    /**
     * Đọc lại danh sách. Lỗi thì báo và trả về danh sách rỗng – chương trình không bị dừng.
     *
     * TODO (DEMO Bài 2):
     *   1. try-with-resources: new ObjectInputStream(new FileInputStream(path))
     *   2. return (List<Student>) ois.readObject();   // ép kiểu -> @SuppressWarnings("unchecked")
     *   3. catch IOException và catch ClassNotFoundException (checked, readObject bắt buộc)
     */
    @SuppressWarnings("unchecked")
    public static List<Student> readFromFile(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (List<Student>) ois.readObject();
        } catch (IOException e) {
            System.out.println("Loi doc file nhi phan: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Khong tim thay class khi doc file: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}