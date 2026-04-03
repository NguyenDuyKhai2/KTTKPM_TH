@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired private CustomerRepository repo;

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable String id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
    
    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return repo.save(customer);
    }
}