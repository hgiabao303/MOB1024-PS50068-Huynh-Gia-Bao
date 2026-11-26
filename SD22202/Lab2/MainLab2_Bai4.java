import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Lớp Product đơn giản dùng cho bài mẫu
enum ProductCategory {
    FOOD, ELECTRONIC, CLOTHING
}

class Product {
    private String id;
    private String name;
    private double price;
    private ProductCategory category;

    public Product(String id, String name, double price, ProductCategory category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [ID = " + id + ", Name = " + name + ", Price = " + price + ", Category = " + category + "]";
    }
}

public class MainLab2_Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();

        // 1. Khởi tạo dữ liệu mẫu hợp lệ
        productList.add(new Product("P01", "Gạo ST25", 150000, ProductCategory.FOOD));
        productList.add(new Product("P02", "iPhone 15", 22000000, ProductCategory.ELECTRONIC));

        System.out.println("=== DANH SÁCH DỮ LIỆU BAN ĐẦU ===");
        for (Product p : productList) {
            System.out.println(p);
        }

        // 2. Thêm dữ liệu có khả năng gây lỗi (Ví dụ: nhập giá tiền bằng chữ hoặc giá trị âm)
        System.out.println("\n--- THÊM SẢN PHẨM MỚI (CÓ XỬ LÝ LỖI DỮ LIỆU) ---");
        
        try {
            System.out.print("Nhập mã sản phẩm: ");
            String id = scanner.nextLine();

            System.out.print("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();

            System.out.print("Nhập giá sản phẩm (Nhập chữ để kiểm tra bắt lỗi): ");
            // Dùng Double.parseDouble kết hợp try-catch để bắt lỗi nếu người dùng nhập sai định dạng
            double price = Double.parseDouble(scanner.nextLine()); 

            if (price < 0) {
                throw new IllegalArgumentException("Giá sản phẩm không được phép là số âm!");
            }

            // Nếu không có lỗi, thêm vào danh sách
            productList.add(new Product(id, name, price, ProductCategory.FOOD));
            System.out.println("-> Thêm sản phẩm thành công!");

        } catch (NumberFormatException e) {
            // Xử lý khi người dùng nhập chữ vào ô số (Giá tiền)
            System.out.println("[AI Fix Lỗi]: Phát hiện lỗi nhập liệu! Bạn đã nhập chữ vào trường giá tiền thay vì số.");
            System.out.println("Chi tiết lỗi hệ thống: " + e.getMessage());
            
        } catch (IllegalArgumentException e) {
            // Xử lý khi giá trị âm
            System.out.println("[AI Fix Lỗi]: " + e.getMessage());
            
        } catch (Exception e) {
            // Xử lý các lỗi phát sinh khác nếu có
            System.out.println("[AI Fix Lỗi]: Đã xảy ra lỗi không xác định: " + e.getMessage());
        }

        // Hiển thị lại danh sách sau khi xử lý
        System.out.println("\n=== DANH SÁCH SẢN PHẨM SAU KHI XỬ LÝ ===");
        for (Product p : productList) {
            System.out.println(p);
        }

        scanner.close();
    }
}