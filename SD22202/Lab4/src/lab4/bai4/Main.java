package lab4.bai4;

import lab4.bai1.model.Student;
import lab4.bai4.exception.EmptyListException;
import lab4.bai4.service.GenericManager;

public class Main {
    private static void tryGetFirstAndLast(GenericManager<Student> manager) {
        try {
            Student first = manager.getFirst();
            Student last = manager.getLast();
            System.out.println("Phan tu dau: " + first);
            System.out.println("Phan tu cuoi: " + last);
        } catch (EmptyListException e) {
            System.out.println("Loi: " + e.getMessage());
        } finally {
            System.out.println("(Da kiem tra xong)");
        }
    }

    public static void main(String[] args) {
        // TODO (DEMO Bài 4):
        //   1. Tạo GenericManager<Student> manager (dùng Student của Bài 1)
        //   2. Lần 1 – danh sách RỖNG: gọi getFirst()/getLast() -> thấy EmptyListException
        //   3. Thêm 3 sinh viên
        //   4. Lần 2 – đã có dữ liệu: gọi lại -> thấy kết quả
        //   Gợi ý: viết hàm tryGetFirstAndLast(manager) dùng try - catch - finally
        //          (finally in "(Đã kiểm tra xong)" để thấy nó LUÔN chạy)

        GenericManager<Student> manager = new GenericManager<>();

        System.out.println("--- Lan 1: Danh sach rong ---");
        tryGetFirstAndLast(manager);

        manager.add(new Student("SV01", "Nguyen Van An", 3.2));
        manager.add(new Student("SV02", "Tran Thi Binh", 3.6));
        manager.add(new Student("SV03", "Le Hoang Cuong", 2.8));

        System.out.println("\n--- Lan 2: Da co du lieu ---");
        tryGetFirstAndLast(manager);
    }
}