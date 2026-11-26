package lab4.bai2.service;

import java.util.ArrayList;
import java.util.List;
import lab4.bai2.exception.DuplicateEmployeeException;
import lab4.bai2.exception.InvalidSalaryException;
import lab4.bai2.model.Employee;

public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    /**
     * Thêm nhân viên.
     *
     * TODO (DEMO Bài 2):
     *   - Khai báo: throws DuplicateEmployeeException, InvalidSalaryException
     *   - Trùng mã (findById != null) -> throw new DuplicateEmployeeException(...)
     *   - Lương < 0                   -> throw new InvalidSalaryException(...)
     */
    public void add(Employee e) throws DuplicateEmployeeException, InvalidSalaryException {
        if (findById(e.getId()) != null) {
            throw new DuplicateEmployeeException(e.getId());
        }
        if (e.getSalary() < 0) {
            throw new InvalidSalaryException(e.getSalary());
        }

        employees.add(e);
    }

    /** Trả về null nếu không tìm thấy. */
    public Employee findById(String id) {
        for (Employee e : employees) {
            if (e.getId().equalsIgnoreCase(id)) {
                return e;
            }
        }
        return null;
    }
}