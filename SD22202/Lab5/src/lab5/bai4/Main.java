package lab5.bai4;

import lab5.bai4.io.SafeFileReader;
import lab5.bai4.io.TestFiles;
import lab5.model.Student;

import java.io.IOException;
import java.util.List;

/** Bài 4 – Thử lần lượt các tình huống lỗi file. Main chỉ gọi lớp io và in kết quả. */
public class Main {
    public static void main(String[] args) throws IOException {
        TestFiles.prepare();

        System.out.println("=== 1. File khong ton tai ===");
        show(SafeFileReader.readBinary("data/khong_ton_tai.dat"));

        System.out.println("\n=== 2. File rong ===");
        show(SafeFileReader.readBinary("data/empty.dat"));

        System.out.println("\n=== 3. File sai dinh dang (text doi duoi .dat) ===");
        show(SafeFileReader.readBinary("data/wrong_format.dat"));

        System.out.println("\n=== 4. File text co vai dong sai dinh dang ===");
        show(SafeFileReader.readText("data/students_mixed.txt"));

        System.out.println("\n=== 5. File hop le ===");
        show(SafeFileReader.readBinary("data/valid.dat"));

        System.out.println("\n>> Chuong trinh van chay den cuoi, khong bi dung dot ngot.");
    }

    private static void show(List<Student> list) {
        System.out.println("   Doc duoc " + list.size() + " sinh vien");
        list.forEach(s -> System.out.println("   " + s));
    }
}