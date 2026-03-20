package tax;

/**
 * STRATEGY PATTERN - Thuế hàng xa xỉ 20%
 */
public class LuxuryTaxStrategy implements TaxStrategy {
    private static final double LUXURY_TAX_RATE = 0.20;

    @Override
    public double calculateTax(double price) {
        return price * LUXURY_TAX_RATE;
    }

    @Override
    public String getTaxName() {
        return "Thuế hàng xa xỉ (20%)";
    }
}
