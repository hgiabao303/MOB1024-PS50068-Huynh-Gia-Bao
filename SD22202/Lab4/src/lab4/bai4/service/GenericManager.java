package lab4.bai4.service;

import java.util.ArrayList;
import java.util.List;
import lab4.bai4.exception.EmptyListException;

/**
 * Phiên bản nâng cấp của GenericManager (Bài 3).
 *
 * TODO (DEMO Bài 4):
 *   - Chép GenericManager<T> của Bài 3 sang đây (add, display, size)
 *   - Thêm T getFirst() throws EmptyListException   // rỗng -> throw
 *   - Thêm T getLast()  throws EmptyListException   // rỗng -> throw
 */
public class GenericManager<T> {
    private final List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public void display() {
        if (items.isEmpty()) {
            System.out.println("(Danh sach trong)");
            return;
        }
        for (T item : items) {
            System.out.println(item.toString());
        }
    }

    public int size() {
        return items.size();
    }

    public T get(int index) {
        return items.get(index);
    }

    public T getFirst() throws EmptyListException {
        if (items.isEmpty()) {
            throw new EmptyListException("Danh sach rong, khong the lay phan tu dau tien");
        }
        return items.get(0);
    }

    public T getLast() throws EmptyListException {
        if (items.isEmpty()) {
            throw new EmptyListException("Danh sach rong, khong the lay phan tu cuoi cung");
        }
        return items.get(items.size() - 1);
    }
}