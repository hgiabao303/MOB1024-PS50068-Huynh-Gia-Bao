import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bai4 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("SV01", "Nguyen Van An", StudentType.REGULAR, 3.4),
            new Student("SV02", "Tran Thi Binh", StudentType.INTERNATIONAL, 3.8),
            new Student("SV03", "Le Hoang Cuong", StudentType.PART_TIME, 2.9),
            new Student("SV04", "Pham Minh Duy", StudentType.INTERNATIONAL, 3.1),
            new Student("SV05", "Hoang Ngoc Han", StudentType.REGULAR, 3.6),
            new Student("SV06", "Vu Quoc Khanh", StudentType.INTERNATIONAL, 3.5),
            new Student("SV07", "Dang Thu Lan", StudentType.PART_TIME, 3.2),
            new Student("SV08", "Bui Tan Phat", StudentType.INTERNATIONAL, 3.9),
            new Student("SV09", "Do Thanh Tam", StudentType.REGULAR, 3.0),
            new Student("SV10", "Ngo Hai Uyen", StudentType.PART_TIME, 3.3)
        );

        System.out.println("--- 1. Sinh vien INTERNATIONAL co GPA >= 3.2 ---");
        students.stream()
                .filter(s -> s.getType() == StudentType.INTERNATIONAL && s.getGpa() >= 3.2)
                .forEach(System.out::println);

        System.out.println("\n--- 2. Top 3 sinh vien co GPA cao nhat ---");
        students.stream()
                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                .limit(3)
                .forEach(System.out::println);

        List<String> partTimeNames = students.stream()
                                             .filter(s -> s.getType() == StudentType.PART_TIME)
                                             .map(Student::getName)
                                             .collect(Collectors.toList());
        System.out.println("\n--- 3. Ten cac sinh vien PART_TIME ---");
        System.out.println(partTimeNames);
    }
}