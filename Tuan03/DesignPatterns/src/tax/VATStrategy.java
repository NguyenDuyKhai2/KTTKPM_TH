package tax;

/**
 * STRATEGY PATTERN - Thuế VAT (Giá trị gia tăng) 10%
 */
public class VATStrategy implements TaxStrategy {
    private static final double VAT_RATE = 0.10;

    @Override
    public double calculateTax(double price) {
        return price * VAT_RATE;
    }

    @Override
    public String getTaxName() {
        return "Thuế VAT (10%)";
    }
}
