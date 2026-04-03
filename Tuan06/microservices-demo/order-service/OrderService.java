@Service
public class OrderService {
    @Autowired private OrderRepository orderRepo;
    @Autowired private CustomerClient customerClient;
    @Autowired private RabbitTemplate rabbitTemplate;

    @Transactional
    public Order createOrder(OrderRequest req) {
        // 1. Gọi sang Customer Service check xem khách có tồn tại ko
        customerClient.getCustomer(req.getCustomerId());

        // 2. Lưu đơn hàng vào PostgreSQL
        Order order = new Order();
        order.setProductId(req.getProductId());
        order.setQuantity(req.getQuantity());
        order.setStatus("SUCCESS");
        orderRepo.save(order);

        // 3. Bắn event sang Product Service qua RabbitMQ
        OrderEvent event = new OrderEvent(req.getProductId(), req.getQuantity());
        rabbitTemplate.convertAndSend("order_exchange", "order_routing_key", event);

        return order;
    }
}