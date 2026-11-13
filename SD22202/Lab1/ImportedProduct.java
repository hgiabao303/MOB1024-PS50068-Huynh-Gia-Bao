
public class ImportedProduct extends Product {

    private double importTaxRate;
    private double shippingFee;

    // Constructor
    public ImportedProduct(String id, String name,
            double basePrice, double importTaxRate,
            double shippingFee) {

        super(id, name, basePrice);

        setImportTaxRate(importTaxRate);
        setShippingFee(shippingFee);
    }

    // Getter
    public double getImportTaxRate() {
        return importTaxRate;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    // Setter co Validate
    public void setImportTaxRate(double importTaxRate) {
        if (importTaxRate >= 0 && importTaxRate <= 1) {
            this.importTaxRate = importTaxRate;
        } else {
            System.out.println("Thue nhap khau khong hop le!");
        }
    }

    public void setShippingFee(double shippingFee) {
        if (shippingFee >= 0) {
            this.shippingFee = shippingFee;
        } else {
            System.out.println("Phi van chuyen khong hop le!");
        }
    }

    // Ghi de method finalPrice
    @Override
    public double finalPrice() {
        return getBasePrice()
                + getBasePrice() * importTaxRate
                + shippingFee;
    }

    // Hien thi thong tin
    @Override
    public String toString() {
        return super.toString()
                + ", Import Tax Rate: " + importTaxRate
                + ", Shipping Fee: " + shippingFee;
    }
}

