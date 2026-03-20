package tax;

/**
 * STRATEGY PATTERN - Context class
 * Sản phẩm sử dụng chiến lược tính thuế khác nhau
 */
public class Product {
    private String name;
    private double basePrice;
    private TaxStrategy taxStrategy;

    public Product(String name, double basePrice, TaxStrategy taxStrategy) {
        this.name = name;
        this.basePrice = basePrice;
        this.taxStrategy = taxStrategy;
    }

    // Thay đổi chiến lược thuế mà không cần sửa code Product
    public void setTaxStrategy(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }

    public void printPriceDetails() {
        double tax = taxStrategy.calculateTax(basePrice);
        double totalPrice = basePrice + tax;
        System.out.printf("Sản phẩm : %-20s | Giá gốc: %8.0f VND | %s: %6.0f VND | Tổng: %8.0f VND%n",
                name, basePrice, taxStrategy.getTaxName(), tax, totalPrice);
    }

    public double getTotalPrice() {
        return basePrice + taxStrategy.calculateTax(basePrice);
    }

    public String getName()       { return name; }
    public double getBasePrice()  { return basePrice; }
}
