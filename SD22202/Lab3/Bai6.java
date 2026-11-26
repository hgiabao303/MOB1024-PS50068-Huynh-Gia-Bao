import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bai6 {

    static class EmpDemo {
        String name;
        double salary;

        EmpDemo(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return name + " (" + salary + ")";
        }
    }

    public static void main(String[] args) {
        // Loi 1: Dung lai 1 Stream da dong -> IllegalStateException
        System.out.println("--- Loi 1: Dung lai Stream da dong ---");
        List<String> langs = Arrays.asList("Java", "Python", "C++");
        Stream<String> stream = langs.stream();
        stream.forEach(s -> System.out.print(s + " "));
        System.out.println();
        // Loi: stream.count();
        long countFixed = langs.stream().count();
        System.out.println("So luong phan tu (da sua): " + countFixed);

        // Loi 2: Thay doi bien cuc bo ben trong Lambda -> Loi bien dich
        System.out.println("\n--- Loi 2: Thay doi bien cuc bo trong Lambda ---");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        // int sum = 0;
        // Loi: numbers.forEach(n -> sum += n);
        int sumFixed = numbers.stream()
                              .mapToInt(Integer::intValue)
                              .sum();
        System.out.println("Tong (da sua): " + sumFixed);

        // Loi 3: Thieu tu khoa return khi dung dau {} trong Lambda -> Loi bien dich
        System.out.println("\n--- Loi 3: Thieu return trong block Lambda ---");
        List<String> names = Arrays.asList("An", "Binh", "Cuong", "Dung");
        // Loi:
        // List<String> errList = names.stream()
        //     .filter(name -> {
        //         name.length() > 3;
        //     })
        //     .collect(Collectors.toList());
        List<String> fixedList = names.stream()
                                      .filter(name -> {
                                          return name.length() > 3;
                                      })
                                      .collect(Collectors.toList());
        System.out.println("Ten dai > 3 ky tu (da sua): " + fixedList);

        // Loi 4: Thieu Terminal Operation nen Stream khong chay -> Loi logic
        System.out.println("\n--- Loi 4: Thieu thao tac ket thuc ---");
        List<Integer> nums = Arrays.asList(10, 20, 30);
        // Loi (khong co collect/forEach nen khong chay):
        nums.stream().map(n -> {
            System.out.println("Dang nhan doi (code loi - khong chay): " + (n * 2));
            return n * 2;
        });
        // Sua:
        List<Integer> doubled = nums.stream()
                                    .map(n -> {
                                        int res = n * 2;
                                        System.out.println("Dang nhan doi (da sua): " + res);
                                        return res;
                                    })
                                    .collect(Collectors.toList());
        System.out.println("Ket qua nhan doi: " + doubled);

        // Loi 5: Sai thu tu tham so trong sorted() -> Sai chieu sap xep (Loi logic)
        System.out.println("\n--- Loi 5: Sai chieu sap xep trong sorted() ---");
        List<EmpDemo> emps = Arrays.asList(
            new EmpDemo("An", 1000),
            new EmpDemo("Binh", 3000),
            new EmpDemo("Chi", 2000)
        );
        // Loi (ra tang dan thay vi giam dan):
        List<EmpDemo> wrongSort = emps.stream()
                                      .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                                      .collect(Collectors.toList());
        System.out.println("Sap xep sai (tang dan): " + wrongSort);

        // Sua (dao e2 truoc e1 de ra giam dan):
        List<EmpDemo> rightSort = emps.stream()
                                      .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                                      .collect(Collectors.toList());
        System.out.println("Sap xep dung (giam dan): " + rightSort);
    }
}