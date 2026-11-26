package lab5.bai4.io;

import lab5.model.Student;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/** Bài 4 – (CÓ SẴN) Tạo sẵn các file lỗi / hợp lệ để thử SafeFileReader. */
public class TestFiles {

    /** Hàm phụ trợ tạo dữ liệu thử nên cho phép throws IOException. */
    public static void prepare() throws IOException {
        new File("data").mkdirs();
        new FileOutputStream("data/empty.dat").close();
        try (FileWriter fw = new FileWriter("data/wrong_format.dat")) {
            fw.write("day la file text, khong phai file object");
        }
        try (FileWriter fw = new FileWriter("data/students_mixed.txt", StandardCharsets.UTF_8)) {
            fw.write("SV01,Nguyen Van An,3.2\n");
            fw.write("SV02,Tran Thi Binh\n");          // thiếu cột
            fw.write("SV03,Le Hoang Cuong,ba diem\n");  // GPA không phải số
            fw.write("SV04,Pham Ngoc Diep,3.9\n");
        }
        List<Student> validList = new ArrayList<>();
        validList.add(new Student("SV09", "Vu Minh Duc", 3.0));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/valid.dat"))) {
            oos.writeObject(validList);
        } catch (NotSerializableException e) {
            System.out.println("(Chua tao duoc data/valid.dat: Student chua implements Serializable – lam Bai 2 truoc)");
        }
    }
}