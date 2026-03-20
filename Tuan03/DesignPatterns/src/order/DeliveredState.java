package order;

/**
 * STATE PATTERN - Trạng thái: Đã giao
 * Hành vi: Cập nhật trạng thái đơn hàng là đã giao
 */
public class DeliveredState implements OrderState {

    @Override
    public void processOrder(Order order) {
        System.out.println("[Đã giao] Đơn hàng đã được giao thành công. Không thể xử lý thêm.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("[Đã giao] Không thể hủy đơn hàng đã giao. Vui lòng liên hệ hỗ trợ.");
    }

    @Override
    public String getStateName() {
        return "Đã giao";
    }
}
