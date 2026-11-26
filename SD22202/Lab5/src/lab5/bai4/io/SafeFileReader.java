package lab5.bai4.io;

import lab5.model.Student;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Đọc file an toàn: phân biệt từng tình huống lỗi để báo cho người dùng.
 * Mọi method đều trả về danh sách (có thể rỗng) - KHÔNG BAO GIỜ làm dừng chương trình.
 */
public class SafeFileReader {

    /**
     * Đọc file nhị phân .dat chứa List<Student>.
     *
     * TODO (DEMO Bài 4): kiểm tra lần lượt
     *   - !file.exists()        -> "[!] File không tồn tại"
     *   - file.length() == 0    -> "[!] File rỗng"
     *   - đọc bằng ObjectInputStream, obj không phải List -> báo lỗi
     *   - catch StreamCorruptedException -> "Sai định dạng (không phải file đối tượng Java)"
     *   - catch EOFException             -> "File bị cắt cụt / thiếu dữ liệu"
     *   - catch ClassNotFoundException, IOException
     *   Hỏi SV: vì sao 2 catch đầu phải đặt TRƯỚC IOException?
     */
    public static List<Student> readBinary(String path) {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("   [!] File khong ton tai: " + path);
            return new ArrayList<>();
        }
        if (file.length() == 0) {
            System.out.println("   [!] File rong: " + path);
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (!(obj instanceof List<?> rawList)) {
                System.out.println("   [!] Du lieu khong phai danh sach List");
                return new ArrayList<>();
            }

            List<Student> result = new ArrayList<>();
            for (Object item : rawList) {
                if (item instanceof Student s) {
                    result.add(s);
                } else {
                    System.out.println("   [!] Bo qua phan tu khong phai Student: " + item);
                }
            }
            return result;
        } catch (StreamCorruptedException e) {
            System.out.println("   [!] Sai dinh dang (khong phai file doi tuong Java)");
        } catch (EOFException e) {
            System.out.println("   [!] File bi cat cut / thieu du lieu");
        } catch (ClassNotFoundException e) {
            System.out.println("   [!] Khong tim thay class Student: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("   [!] Loi doc file nhi phan: " + e.getMessage());
        }

        return new ArrayList<>();
    }

    /**
     * Đọc file văn bản, mỗi dòng: id,name,gpa.
     *
     * TODO (DEMO Bài 4):
     *   - Đọc bằng BufferedReader (UTF-8), đếm số dòng
     *   - Mỗi dòng split(","): thiếu cột / GPA không phải số -> BỎ QUA dòng đó, báo số dòng
     *     (try-catch NẰM TRONG vòng lặp để các dòng đúng vẫn được đọc)
     *   - catch FileNotFoundException, IOException
     */
    public static List<Student> readText(String path) {
        List<Student> result = new ArrayList<>();
        int lineNumber = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    String[] parts = line.split(",");
                    if (parts.length < 3) {
                        System.out.println("   [!] Dong " + lineNumber + " thieu cot -> bo qua: " + line);
                        continue;
                    }
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    double gpa = Double.parseDouble(parts[2].trim());
                    result.add(new Student(id, name, gpa));
                } catch (NumberFormatException e) {
                    System.out.println("   [!] Dong " + lineNumber + " co GPA khong phai so -> bo qua: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("   [!] File van ban khong ton tai: " + path);
        } catch (IOException e) {
            System.out.println("   [!] Loi doc file van ban: " + e.getMessage());
        }

        return result;
    }
}