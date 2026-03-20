package order;

/**
 * STATE PATTERN - Trạng thái: Mới tạo
 * Hành vi: Kiểm tra thông tin đơn hàng
 */
public class NewOrderState implements OrderState {

    @Override
    public void processOrder(Order order) {
        System.out.println("[Mới tạo] Kiểm tra thông tin đơn hàng...");
        System.out.println("[Mới tạo] Thông tin hợp lệ. Chuyển sang trạng thái: Đang xử lý.");
        order.setState(new ProcessingState());
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("[Mới tạo] Hủy đơn hàng và hoàn tiền.");
        order.setState(new CancelledState());
    }

    @Override
    public String getStateName() {
        return "Mới tạo";
    }
}
