import java.util.ArrayList;
import java.util.Set;

public class CustomerManager implements CustomerInterface{

    public static Set<Customer> customers = (Set<Customer>) new ArrayList<Customer>();

    @Override
    public void add(Customer customer) {
        customers.add(customer);
    }
}
