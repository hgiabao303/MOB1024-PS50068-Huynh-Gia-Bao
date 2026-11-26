package lab4.bai2.exception;

/**
 * Custom exception: phat sinh khi them nhan vien trung ma.
 *
 * TODO (DEMO Bai 2):
 *   - Ke thua Exception (checked) -> noi goi BAT BUOC try-catch hoac throws tiep
 *   - Constructor nhan id, goi super("Ma nhan vien '" + id + "' da ton tai")
 */
public class DuplicateEmployeeException extends Exception {

    public DuplicateEmployeeException(String id) {
        super("Ma nhan vien '" + id + "' da ton tai");
    }
}