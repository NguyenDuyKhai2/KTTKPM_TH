package tax;

/**
 * STRATEGY PATTERN - Interface định nghĩa thuật toán tính thuế
 */
public interface TaxStrategy {
    double calculateTax(double price);
    String getTaxName();
}
