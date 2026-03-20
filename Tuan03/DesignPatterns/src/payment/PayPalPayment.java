package payment;

/**
 * STRATEGY PATTERN - Thanh toán bằng PayPal
 */
public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public boolean pay(double amount) {
        System.out.printf("  [PayPal] Thanh toán %.0f VND - Tài khoản: %s%n", amount, email);
        System.out.println("  [PayPal] Giao dịch thành công!");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
}
