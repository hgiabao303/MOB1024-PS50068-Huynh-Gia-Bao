package lab4.bai3.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Lớp quản lý danh sách TỔNG QUÁT.
 *
 * TODO (DEMO Bài 3): biến thành lớp generic GenericManager<T>
 *   - field: List<T> items = new ArrayList<>()
 *   - void add(T item)
 *   - void display()     // in từng phần tử (gọi toString())
 *   - int size()
 *   - T get(int index)   // trả về đúng kiểu T, không cần ép kiểu
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
}