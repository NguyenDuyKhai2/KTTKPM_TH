package payment;

/**
 * DECORATOR PATTERN - Thêm mã giảm giá vào thanh toán
 */
public class DiscountDecorator extends PaymentDecorator {
    private String discountCode;
    private double discountPercent;

    public DiscountDecorator(PaymentStrategy paymentStrategy, String discountCode, double discountPercent) {
        super(paymentStrategy);
        this.discountCode = discountCode;
        this.discountPercent = discountPercent;
    }

    @Override
    public boolean pay(double amount) {
        double discount = amount * (discountPercent / 100);
        double discountedAmount = amount - discount;
        System.out.printf("  [Mã giảm giá: %s] Giảm %.0f%%: -%.0f VND%n",
                discountCode, discountPercent, discount);
        return wrappedPayment.pay(discountedAmount);
    }

    @Override
    public String getPaymentMethod() {
        return wrappedPayment.getPaymentMethod() + " + Mã giảm giá (" + discountCode + ")";
    }
}
