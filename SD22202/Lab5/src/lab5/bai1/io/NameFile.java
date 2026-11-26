package lab5.bai1.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/** Bài 1 – Ghi/đọc file văn bản bằng Character Stream (BufferedWriter / BufferedReader). */
public class NameFile {

    /**
     * Ghi mỗi tên một dòng. Trả về true nếu ghi được.
     *
     * TODO (DEMO Bài 1):
     *   1. Tạo thư mục cha nếu chưa có: new File(path).getParentFile().mkdirs()
     *   2. try-with-resources: new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8))
     *   3. Mỗi tên: bw.write(name); bw.newLine();
     *   4. catch IOException -> in "Lỗi ghi file: ..." và return false
     */
    public static boolean write(String path, List<String> names) {
        File file = new File(path);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8))) {
            for (String name : names) {
                bw.write(name);
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
            return false;
        }
    }

    /**
     * Đọc từng dòng của file. Lỗi thì báo và trả về danh sách rỗng.
     *
     * TODO (DEMO Bài 1):
     *   1. try-with-resources: new BufferedReader(new FileReader(path, StandardCharsets.UTF_8))
     *   2. while ((line = br.readLine()) != null) lines.add(line);   // null = hết file
     *   3. catch IOException -> in "Lỗi đọc file: ..."
     */
    public static List<String> read(String path) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
        return lines;
    }
}