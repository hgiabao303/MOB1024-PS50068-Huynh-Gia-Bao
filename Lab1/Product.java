
public class Product {

    private String id;
    private String name;
    private double basePrice;

    // Constructor
    public Product(String id, String name, double basePrice) {
        setId(id);
        this.name = name;
        setBasePrice(basePrice);
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    // Setter co Validate
    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            System.out.println("ID khong hop le!");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        } else {
            System.out.println("Gia san pham khong hop le!");
        }
    }

    // Tinh gia cuoi cung
    public double finalPrice() {
        return basePrice;
    }

    // Hien thi thong tin
    @Override
    public String toString() {
        return "ID: " + id
                + ", Name: " + name
                + ", Base Price: " + basePrice;
    }
}
