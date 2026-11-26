package lab4.bai4.exception;

/**
 * Phát sinh khi thao tác lấy phần tử trên danh sách rỗng.
 *
 * TODO (DEMO Bài 4): kế thừa Exception, constructor nhận message -> super(message)
 */
public class EmptyListException extends Exception {

    public EmptyListException(String message) {
        super(message);
    }
}