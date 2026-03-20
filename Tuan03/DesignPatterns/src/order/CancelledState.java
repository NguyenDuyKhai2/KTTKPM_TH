package order;

/**
 * STATE PATTERN - Trạng thái: Đã hủy
 * Hành vi: Hủy đơn hàng và hoàn tiền
 */
public class CancelledState implements OrderState {

    @Override
    public void processOrder(Order order) {
        System.out.println("[Đã hủy] Đơn hàng đã bị hủy. Không thể xử lý.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("[Đã hủy] Đơn hàng đã được hủy trước đó.");
    }

    @Override
    public String getStateName() {
        return "Đã hủy";
    }
}
