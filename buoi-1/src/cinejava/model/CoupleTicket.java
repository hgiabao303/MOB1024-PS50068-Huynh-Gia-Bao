package cinejava.model;

public class CoupleTicket extends Ticket {

    public CoupleTicket(String id, String movieName, double basePrice) {
        super(id, movieName, basePrice);
    }

    @Override
    public double finalPrice() {
        return getBasePrice() * 2 * 0.9;
    }
}