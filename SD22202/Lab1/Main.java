
public class Main {

    public static void main(String[] args) {

        // Tao danh sach 5 san pham
        Product[] products = new Product[5];

        products[0] = new Product(
                "P01", "Laptop", 15000000);

        products[1] = new Product(
                "P02", "Ban phim", 500000);

        products[2] = new ImportedProduct(
                "P03", "iPhone", 20000000, 0.1, 500000);

        products[3] = new ImportedProduct(
                "P04", "MacBook", 30000000, 0.15, 700000);

        products[4] = new Product(
                "P05", "Chuot", 300000);

        // In danh sach san pham
        System.out.println("===== DANH SACH SAN PHAM =====");

        for (int i = 0; i < products.length; i++) {

            System.out.println(products[i]);

            System.out.println(
                    "Gia cuoi cung: "
                    + products[i].finalPrice());

            System.out.println("-------------------------");
        }

        // Tim san pham co gia cao nhat
        Product maxProduct = products[0];

        for (int i = 1; i < products.length; i++) {

            if (products[i].finalPrice()
                    > maxProduct.finalPrice()) {

                maxProduct = products[i];
            }
        }

        // In san pham co gia cao nhat
        System.out.println("===== SAN PHAM DAT NHAT =====");

        System.out.println(maxProduct);

        System.out.println(
                "Gia cuoi cung: "
                + maxProduct.finalPrice());
    }
}
