package order;

/**
 * STATE PATTERN - Interface định nghĩa các hành vi của từng trạng thái đơn hàng
 */
public interface OrderState {
    void processOrder(Order order);
    void cancelOrder(Order order);
    String getStateName();
}
