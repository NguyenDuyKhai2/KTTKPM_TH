package payment;

/**
 * STRATEGY PATTERN - Thanh toán bằng thẻ tín dụng
 */
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public boolean pay(double amount) {
        System.out.printf("  [Thẻ tín dụng] Thanh toán %.0f VND - Chủ thẻ: %s - Số thẻ: %s%n",
                amount, cardHolder, maskCardNumber());
        System.out.println("  [Thẻ tín dụng] Giao dịch thành công!");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Thẻ tín dụng";
    }

    private String maskCardNumber() {
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }
}
