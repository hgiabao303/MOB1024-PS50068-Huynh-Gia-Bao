import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Bai1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList(
            "An", "Binh", "Cuong", "Duong", "Hoang",
            "Khanh", "Minh Anh", "Phuong", "Quang", "Thao Nguyen"
        ));

        System.out.println("--- 1. Toan bo danh sach ---");
        names.forEach(name -> System.out.println(name));

        System.out.println("\n--- 2. Cac ten co do dai > 5 ---");
        Predicate<String> lengthGreaterThan5 = name -> name.length() > 5;
        names.forEach(name -> {
            if (lengthGreaterThan5.test(name)) {
                System.out.println(name);
            }
        });

        System.out.println("\n--- 3. Sap xep theo thu tu A-Z ---");
        names.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        names.forEach(System.out::println);

        System.out.println("\n--- 4. Sap xep theo do dai tang dan ---");
        names.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        names.forEach(System.out::println);
    }
}