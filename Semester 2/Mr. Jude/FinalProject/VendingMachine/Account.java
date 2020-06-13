package VendingMachine;

public class Account { // account class
    private String username;
    private String password;
    private String name;
    private int balance;

    public Account(String username, String password, String name){ //constructor
        this.username = username;
        this.password = password;
        this.name = name;
        this.balance = 0;
    }
    public Account(String username, String password, String name, int balance){ //constructor with balance parameter
        this.username = username;
        this.password = password;
        this.name = name;
        this.balance = balance;
    }
    //all the getter and setters initialized below
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
