
public class CustomerRepositoryImpl implements CustomerRepository{
    @Override
    public Customer findCustomerById(String id) {
        // Simulate finding a customer by ID
        return new Customer(id, "John Doe");
    }
    public void addCustomer(String id,String name)
    {
           Customer cus= new Customer(id, name);
    }
}
