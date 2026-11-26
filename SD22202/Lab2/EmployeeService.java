import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();

    // 1. Thêm một nhân viên vào danh sách
    public void addEmployee(Employee emp) {
        employeeList.add(emp);
        System.out.println("Đã thêm nhân viên thành công!");
    }

    // 2. Hiển thị danh sách nhân viên
    public void displayAll() {
        if (employeeList.isEmpty()) {
            System.out.println("Danh sách nhân viên trống!");
            return;
        }
        System.out.println("=== DANH SÁCH NHÂN VIÊN ===");
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
    }

    // 3. Tìm nhân viên theo mã
    public Employee findById(String id) {
        for (Employee emp : employeeList) {
            if (emp.getId().equalsIgnoreCase(id)) {
                return emp;
            }
        }
        return null;
    }

    // 4. Cập nhật lương nhân viên theo mã
    public boolean updateSalary(String id, double newSalary) {
        Employee emp = findById(id);
        if (emp != null) {
            emp.setSalary(newSalary);
            return true;
        }
        return false;
    }
}
