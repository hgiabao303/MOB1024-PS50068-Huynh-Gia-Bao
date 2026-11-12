package cinejava.model;

public class StudentTicket extends Ticket {
    private double discountPercent; // Phần trăm giảm giá (0 - 50%)

    public StudentTicket(String id, String movieName, double basePrice, double discountPercent) {
        super(id, movieName, basePrice);
        this.discountPercent = discountPercent;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        if (discountPercent >= 0 && discountPercent <= 50) {
            this.discountPercent = discountPercent;
        } else {
            this.discountPercent = 0;
        }
    }

    @Override
    public double finalPrice() {
        return getBasePrice() * (1 - discountPercent / 100.0);
    }
}