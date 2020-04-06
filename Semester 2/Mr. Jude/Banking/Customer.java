package Banking;

public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String f, String l){
        this.firstName = f;
        this.lastName = l;
        this.account = new Account(500);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    @Override
    public String toString(){
        return firstName + " "+ lastName;
    }
}
