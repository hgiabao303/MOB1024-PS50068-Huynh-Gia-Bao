import java.util.ArrayList;
import java.util.List;

public class MainStudent {
    public static void main(String[] args) {
        // Tạo danh sách sinh viên gồm ít nhất 6 sinh viên với các loại khác nhau
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("SV01", "Nguyễn Văn An", StudentType.REGULAR));
        studentList.add(new Student("SV02", "Trần Thị Bích", StudentType.PART_TIME));
        studentList.add(new Student("SV03", "John Smith", StudentType.INTERNATIONAL));
        studentList.add(new Student("SV04", "Lê Hoàng Cường", StudentType.REGULAR));
        studentList.add(new Student("SV05", "Phạm Thị Dung", StudentType.PART_TIME));
        studentList.add(new Student("SV06", "Kim Tae Hee", StudentType.INTERNATIONAL));

        // 1. Hiển thị danh sách toàn bộ sinh viên
        System.out.println("=== DANH SÁCH TOÀN BỘ SINH VIÊN ===");
        for (Student s : studentList) {
            System.out.println(s);
        }

        // 2. Hiển thị danh sách sinh viên theo từng loại
        System.out.println("\n=== DANH SÁCH SINH VIÊN THEO TỪNG LOẠI ===");
        for (StudentType st : StudentType.values()) {
            System.out.println("Loại: " + st);
            for (Student s : studentList) {
                if (s.getType() == st) {
                    System.out.println("  - " + s);
                }
            }
        }

        // 3. Đếm số lượng sinh viên của mỗi loại
        System.out.println("\n=== THỐNG KÊ SỐ LƯỢNG SINH VIÊN MỖI LOẠI ===");
        for (StudentType st : StudentType.values()) {
            int count = 0;
            for (Student s : studentList) {
                if (s.getType() == st) {
                    count++;
                }
            }
            System.out.println("Loại " + st + ": " + count + " sinh viên");
        }
    }
}
