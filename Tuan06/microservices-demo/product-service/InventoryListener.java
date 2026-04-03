@Service
public class InventoryListener {
    @Autowired private ProductRepository productRepository;

    @RabbitListener(queues = "order_queue")
    public void handleOrderCreated(OrderEvent event) {
        Product product = productRepository.findById(event.getProductId()).orElseThrow();
        // Trừ kho
        product.setStock(product.getStock() - event.getQuantity());
        productRepository.save(product);
        System.out.println("==> Đã trừ kho cho SP: " + product.getName());
    }
}


@Data @AllArgsConstructor @NoArgsConstructor
class OrderEvent {
    private String productId;
    private Integer quantity;
}