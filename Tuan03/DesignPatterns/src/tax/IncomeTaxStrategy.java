package tax;

/**
 * STRATEGY PATTERN - Thuế tiêu thụ đặc biệt 5%
 */
public class IncomeTaxStrategy implements TaxStrategy {
    private static final double INCOME_TAX_RATE = 0.05;

    @Override
    public double calculateTax(double price) {
        return price * INCOME_TAX_RATE;
    }

    @Override
    public String getTaxName() {
        return "Thuế tiêu thụ đặc biệt (5%)";
    }
}
