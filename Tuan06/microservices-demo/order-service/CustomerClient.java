@FeignClient(name = "customer-service", url = "http://customer-svc:8081")
public interface CustomerClient {
    @GetMapping("/customers/{id}")
    Object getCustomer(@PathVariable String id);
}