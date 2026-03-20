package payment;

/**
 * DECORATOR PATTERN - Abstract base decorator cho PaymentStrategy
 * Cho phép thêm tính năng bổ sung vào phương thức thanh toán
 */
public abstract class PaymentDecorator implements PaymentStrategy {
    protected PaymentStrategy wrappedPayment;

    public PaymentDecorator(PaymentStrategy paymentStrategy) {
        this.wrappedPayment = paymentStrategy;
    }

    @Override
    public boolean pay(double amount) {
        return wrappedPayment.pay(amount);
    }

    @Override
    public String getPaymentMethod() {
        return wrappedPayment.getPaymentMethod();
    }
}
