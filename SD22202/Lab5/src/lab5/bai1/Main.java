package lab5.bai1;

import lab5.bai1.io.NameFile;

import java.util.ArrayList;
import java.util.List;

/** Bài 1 – Main chỉ gọi lớp io và in kết quả. */
public class Main {

    private static final String FILE_PATH = "data/names.txt";

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Nguyen Van An");
        names.add("Tran Thi Binh");
        names.add("Le Hoang Cuong");
        names.add("Pham Ngoc Diep");
        names.add("Vu Minh Duc");

        if (NameFile.write(FILE_PATH, names)) {
            System.out.println("Da ghi " + names.size() + " ten vao " + FILE_PATH);
        }

        System.out.println("\n===== NOI DUNG FILE =====");
        List<String> lines = NameFile.read(FILE_PATH);
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ". " + lines.get(i));
        }
    }
}