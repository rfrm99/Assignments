package Banking;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private int numberOfCustomers;
    private String bankName;

    public Bank(String bName){
        this.bankName = bName;
    }

    public void addCustomer(String f, String l){
        this.customers.add(new Customer(f,l));
    }

    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }

    public Customer getCustomer(int i) {
        return customers.get(i);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public int getNumberOfCustomers() {
        this.numberOfCustomers = customers.size();
        return numberOfCustomers;
    }

    public String getBankName() {
        return bankName;
    }

    @Override
    public String toString() {
        return "Bank[" + bankName + ", Customers= " + customers.toString() + "]";
    }
}
