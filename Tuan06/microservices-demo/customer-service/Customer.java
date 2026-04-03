@Document(collection = "customers")
@Data
public class Customer {
    @Id private String id;
    private String name;
    private String email;
}

public interface CustomerRepository extends MongoRepository<Customer, String> {}