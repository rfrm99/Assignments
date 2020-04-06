package Banking;

public class Driver {
    public static void main(String[] arg) {
        boolean flag;
        Account a1 = new Account(500); //manually creating accounts for the customers
        Account a2 = new Account(500);
        Account a3 = new Account(500);
        Customer c1 = new Customer("Rowin", "Wingwing"); //creating the customers
        Customer c2 = new Customer("Jeco", "Richard");
        Customer c3 = new Customer("Calvin", "Scorp");
        c1.setAccount(a1); //manually setting the accounts to each customer
        c2.setAccount(a2);
        c3.setAccount(a3);
        System.out.println(c1.getAccount()); //getting account info which shows the balance
        System.out.println(c2.getAccount());
        System.out.println(c3.getAccount());
        System.out.println("Firstname: " + c1.getFirstName()); //get firstname
        System.out.println("Lastname: " + c1.getLastName()); //get lastname
        flag = c1.getAccount().deposit(100); //deposit 100 to customer's account
        if(flag){
            System.out.println("Deposit Success"); //code if flag == true
        }else{
            System.out.println("Deposit Failed"); //code if flag == false
        }
        System.out.println(c1.getAccount());
        flag = c1.getAccount().withdraw(50); //withdraw 50 from customer's account
        if(flag){
            System.out.println("Deposit Success");
        }else{
            System.out.println("Deposit Failed");
        }
        System.out.println(c1.getAccount());
        System.out.println(c1.toString());
        Bank b1 = new Bank("Bank Indonesia"); //creating a new bank
        b1.addCustomer(c1); //adding the customers to the bank
        b1.addCustomer(c2);
        b1.addCustomer(c3);
        b1.addCustomer("Sunny","Jo"); //adding a non-existent/new customer, as well as automatically creating an account for them
        System.out.println(b1.getBankName()); //get bank name
        System.out.println("Customers: " + b1.getCustomers()); //prints out all the customers of the bank
        System.out.println(b1.getCustomer(2)); //get a customer by their index
        System.out.println(b1.getNumberOfCustomers()); //get the number of customers in the bank
        System.out.println(b1.getCustomer(2).getAccount().getBalance()); //get a specific customer's account and show its balance
    }
}
