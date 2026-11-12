package cinejava.model;

public class Ticket {
    private String id;
    private String movieName;
    private double basePrice;

    public Ticket() {
    }

    public Ticket(String id, String movieName, double basePrice) {
        setId(id);
        setMovieName(movieName);
        setBasePrice(basePrice);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            this.id = "UNKNOWN";
        }
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        if (movieName != null && !movieName.trim().isEmpty()) {
            this.movieName = movieName;
        } else {
            this.movieName = "Unknown Movie";
        }
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        } else {
            this.basePrice = 0;
        }
    }

    // Đa hình: Tính giá cuối cùng (vé thường giữ nguyên giá gốc)
    public double finalPrice() {
        return basePrice;
    }

    public void printInfo() {
        System.out.printf("%-5s | %-15s | %10.0f\n", id, movieName, finalPrice());
    }

    @Override
    public String toString() {
        return String.format("%-5s | %-15s | %10.0f", id, movieName, finalPrice());
    }
}