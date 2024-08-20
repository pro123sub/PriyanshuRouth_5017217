public class CustomerService
{
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private CustomerRepository customerRepository;

    public Customer getCustomerbyID(String id) {
        return customerRepository.findCustomerById(id);
    }


}
