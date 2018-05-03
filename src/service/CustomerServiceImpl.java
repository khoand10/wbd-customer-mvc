package service;

import bean.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private static Map<Integer, Customer> customerMap;
    static{
        customerMap = new HashMap<>();
        customerMap.put(1,new Customer(1,"khoand","khoand@gmail.com","Bac Ninh"));
        customerMap.put(2,new Customer(2,"dat","dat@gmail.com","Ha Noi"));
        customerMap.put(3,new Customer(3,"hieu","hieu@gmail.com","Ha Nam"));
    }


    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void save(Customer customer) {
        customerMap.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
        return customerMap.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerMap.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customerMap.remove(id);
    }
}
