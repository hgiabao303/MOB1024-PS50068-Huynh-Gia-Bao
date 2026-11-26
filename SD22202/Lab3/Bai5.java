import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bai5 {
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

        Map<StudentType, Long> countByType = students.stream()
                .collect(Collectors.groupingBy(Student::getType, Collectors.counting()));

        System.out.println("--- 1. So luong sinh vien theo tung loai ---");
        countByType.forEach((type, count) ->
            System.out.println(type + ": " + count + " sinh vien")
        );

        Map<StudentType, Double> avgGpaByType = students.stream()
                .collect(Collectors.groupingBy(Student::getType, Collectors.averagingDouble(Student::getGpa)));

        System.out.println("\n--- 2. GPA trung binh theo tung loai ---");
        avgGpaByType.forEach((type, avg) ->
            System.out.printf("%s: %.2f\n", type, avg)
        );

        System.out.println("\n--- 3. Loai sinh vien co GPA trung binh cao nhat ---");
        avgGpaByType.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> System.out.printf("Loai %s voi GPA trung binh la %.2f\n",
                        entry.getKey(), entry.getValue()));

        System.out.println("\n--- Thong ke chi tiet bang summarizingDouble ---");
        Map<StudentType, DoubleSummaryStatistics> statsByType = students.stream()
                .collect(Collectors.groupingBy(Student::getType, Collectors.summarizingDouble(Student::getGpa)));

        statsByType.forEach((type, stats) ->
            System.out.printf("%s -> So luong: %d | GPA TB: %.2f | Cao nhat: %.2f | Thap nhat: %.2f\n",
                    type, stats.getCount(), stats.getAverage(), stats.getMax(), stats.getMin())
        );
    }
}