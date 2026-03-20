package payment;

/**
 * DECORATOR PATTERN - Thêm phí xử lý vào thanh toán
 */
public class ProcessingFeeDecorator extends PaymentDecorator {
    private static final double FEE_RATE = 0.02; // Phí xử lý 2%

    public ProcessingFeeDecorator(PaymentStrategy paymentStrategy) {
        super(paymentStrategy);
    }

    @Override
    public boolean pay(double amount) {
        double fee = amount * FEE_RATE;
        System.out.printf("  [Phí xử lý] Áp dụng phí xử lý 2%%: +%.0f VND%n", fee);
        return wrappedPayment.pay(amount + fee);
    }

    @Override
    public String getPaymentMethod() {
        return wrappedPayment.getPaymentMethod() + " + Phí xử lý (2%)";
    }
}
