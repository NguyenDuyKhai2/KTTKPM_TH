package order;

/**
 * STATE PATTERN - Context class
 * Quản lý trạng thái hiện tại của đơn hàng
 */
public class Order {
    private String orderId;
    private String productName;
    private double price;
    private OrderState currentState;

    public Order(String orderId, String productName, double price) {
        this.orderId = orderId;
        this.productName = productName;
        this.price = price;
        this.currentState = new NewOrderState(); // Trạng thái mặc định: Mới tạo
    }

    public void setState(OrderState state) {
        this.currentState = state;
    }

    public void processOrder() {
        System.out.println("--- Đơn hàng [" + orderId + "] - Trạng thái: " + currentState.getStateName() + " ---");
        currentState.processOrder(this);
    }

    public void cancelOrder() {
        System.out.println("--- Đơn hàng [" + orderId + "] - Trạng thái: " + currentState.getStateName() + " ---");
        currentState.cancelOrder(this);
    }

    public String getCurrentStateName() {
        return currentState.getStateName();
    }

    public String getOrderId()     { return orderId; }
    public String getProductName() { return productName; }
    public double getPrice()       { return price; }
}
