import bean.Customer;

import java.util.HashMap;
import java.util.Map;

public class app {
    public static void main(String[] args) {
        Map<Integer,Customer> customerMap = new HashMap<>();
        customerMap.put(1,new Customer(1,"khoand","khoand@gmail.com","Bac Ninh"));
        customerMap.put(2,new Customer(2,"dat","dat@gmail.com","Ha Noi"));
        customerMap.put(3,new Customer(3,"hieu","hieu@gmail.com","Ha Nam"));
        System.out.println(customerMap.get(1).toString());;
    }
}
