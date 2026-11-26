import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bai2_3 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("NV01", "Anh Tuan", 12_000_000),
            new Employee("NV02", "Bao Ngoc", 18_500_000),
            new Employee("NV03", "an nhien", 15_000_000),
            new Employee("NV04", "Minh Hoang", 22_000_000),
            new Employee("NV05", "Thuy Linh", 14_000_000),
            new Employee("NV06", "Anh Duong", 19_000_000),
            new Employee("NV07", "Quoc Bao", 25_000_000),
            new Employee("NV08", "Hai Yen", 16_000_000)
        );

        System.out.println("================ BAI 2 ================");
        System.out.println("--- Nhan vien co luong >= 15,000,000 ---");
        employees.stream()
                 .filter(e -> e.getSalary() >= 15_000_000)
                 .forEach(System.out::println);

        System.out.println("\n--- Sap xep theo luong giam dan ---");
        employees.stream()
                 .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                 .forEach(System.out::println);

        List<String> employeeNames = employees.stream()
                                              .map(Employee::getName)
                                              .collect(Collectors.toList());
        System.out.println("\n--- Danh sach ten nhan vien ---");
        System.out.println(employeeNames);

        long countA = employees.stream()
                               .filter(e -> e.getName().toLowerCase().startsWith("a"))
                               .count();
        System.out.println("\nSo nhan vien ten bat dau bang 'A': " + countA);

        System.out.println("\n================ BAI 3 ================");
        double totalSalary = employees.stream()
                                      .mapToDouble(Employee::getSalary)
                                      .sum();

        double avgSalary = employees.stream()
                                    .mapToDouble(Employee::getSalary)
                                    .average()
                                    .orElse(0.0);

        Employee highestPaidEmp = employees.stream()
                                           .max(Comparator.comparingDouble(Employee::getSalary))
                                           .orElse(null);

        System.out.printf("Tong luong tat ca nhan vien : %,.0f VND\n", totalSalary);
        System.out.printf("Luong trung binh            : %,.0f VND\n", avgSalary);
        System.out.println("Nhan vien luong cao nhat    : " + highestPaidEmp);
    }
}