package cinejava.model;

public class VipTicket extends Ticket {
    private double surcharge; // Phụ thu VIP
    private double comboFee;  // Phí combo bắp nước

    public VipTicket(String id, String movieName, double basePrice, double surcharge, double comboFee) {
        super(id, movieName, basePrice);
        this.surcharge = surcharge;
        this.comboFee = comboFee;
    }

    public double getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(double surcharge) {
        this.surcharge = surcharge;
    }

    public double getComboFee() {
        return comboFee;
    }

    public void setComboFee(double comboFee) {
        this.comboFee = comboFee;
    }

    @Override
    public double finalPrice() {
        return getBasePrice() + surcharge + comboFee;
    }
}