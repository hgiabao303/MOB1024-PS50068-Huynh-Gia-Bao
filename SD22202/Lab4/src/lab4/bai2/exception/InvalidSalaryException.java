package lab4.bai2.exception;

/**
 * Custom exception: phat sinh khi luong am.
 *
 * TODO (DEMO Bai 2):
 *   - Ke thua Exception (checked)
 *   - Constructor nhan salary, goi super("Luong khong hop le: ...")
 */
public class InvalidSalaryException extends Exception {

    public InvalidSalaryException(double salary) {
        super("Luong khong hop le: " + salary);
    }
}