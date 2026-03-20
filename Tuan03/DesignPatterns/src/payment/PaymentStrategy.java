package payment;

/**
 * STRATEGY PATTERN - Interface định nghĩa phương thức thanh toán
 */
public interface PaymentStrategy {
    boolean pay(double amount);
    String getPaymentMethod();
}
