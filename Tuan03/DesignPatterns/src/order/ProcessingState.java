package order;

/**
 * STATE PATTERN - Trạng thái: Đang xử lý
 * Hành vi: Đóng gói và vận chuyển
 */
public class ProcessingState implements OrderState {

    @Override
    public void processOrder(Order order) {
        System.out.println("[Đang xử lý] Đóng gói hàng hóa...");
        System.out.println("[Đang xử lý] Vận chuyển đến địa chỉ khách hàng.");
        System.out.println("[Đang xử lý] Chuyển sang trạng thái: Đã giao.");
        order.setState(new DeliveredState());
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("[Đang xử lý] Hủy đơn hàng và hoàn tiền.");
        order.setState(new CancelledState());
    }

    @Override
    public String getStateName() {
        return "Đang xử lý";
    }
}
