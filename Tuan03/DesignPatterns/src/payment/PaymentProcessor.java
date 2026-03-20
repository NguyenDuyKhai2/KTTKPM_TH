package payment;

/**
 * STRATEGY PATTERN - Context class
 * Hệ thống thanh toán sử dụng phương thức thanh toán linh hoạt
 */
public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Thay đổi phương thức thanh toán tại runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        System.out.println("  Phương thức: " + paymentStrategy.getPaymentMethod());
        System.out.printf("  Số tiền gốc: %.0f VND%n", amount);
        boolean success = paymentStrategy.pay(amount);
        System.out.println("  Kết quả: " + (success ? "✓ Thành công" : "✗ Thất bại"));
    }
}
