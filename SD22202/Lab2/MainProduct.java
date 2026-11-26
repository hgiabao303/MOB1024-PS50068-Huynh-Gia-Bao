import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainProduct {
    public static void main(String[] args) {
        // Bước 1: Khởi tạo danh sách ít nhất 8 sản phẩm thuộc nhiều loại khác nhau
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("P01", "Gạo ST25", 150000, ProductCategory.FOOD));
        productList.add(new Product("P02", "iPhone 15", 22000000, ProductCategory.ELECTRONIC));
        productList.add(new Product("P03", "Áo sơ mi", 250000, ProductCategory.CLOTHING));
        productList.add(new Product("P04", "Thịt bò", 250000, ProductCategory.FOOD));
        productList.add(new Product("P05", "Tai nghe Bluetooth", 800000, ProductCategory.ELECTRONIC));
        productList.add(new Product("P06", "Quần Jean", 350000, ProductCategory.CLOTHING));
        productList.add(new Product("P07", "Bánh ngọt", 50000, ProductCategory.FOOD));
        productList.add(new Product("P08", "Laptop Dell", 18000000, ProductCategory.ELECTRONIC));

        // Bước 2: Thống kê bằng Map
        // Map đếm số lượng sản phẩm theo từng loại
        Map<ProductCategory, Integer> countMap = new HashMap<>();
        // Map tính tổng giá trị sản phẩm theo từng loại
        Map<ProductCategory, Double> totalPriceMap = new HashMap<>();

        // Duyệt qua danh sách sản phẩm để gom nhóm
        for (Product p : productList) {
            ProductCategory cat = p.getCategory();
            
            // Xử lý đếm số lượng
            countMap.put(cat, countMap.getOrDefault(cat, 0) + 1);
            
            // Xử lý tính tổng giá tiền
            totalPriceMap.put(cat, totalPriceMap.getOrDefault(cat, 0.0) + p.getPrice());
        }

        // Hiển thị kết quả thống kê
        System.out.println("=== KẾT QUẢ THỐNG KÊ SẢN PHẨM THEO LOẠI ===");
        for (ProductCategory cat : ProductCategory.values()) {
            int quantity = countMap.getOrDefault(cat, 0);
            double totalValue = totalPriceMap.getOrDefault(cat, 0.0);
            System.out.println("Loại: " + cat);
            System.out.println("  - Số lượng sản phẩm: " + quantity);
            System.out.println("  - Tổng giá trị: " + totalValue);
        }
    }
}