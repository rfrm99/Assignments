package Banking;

public class Account {
    private double balance;

    public Account(double balance){
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    public boolean deposit(double amount){
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        else{
            System.out.println("Deposit amount needs to be bigger than 0");
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            return true;
        } else {
            System.out.println("Amount exeeded balance");
            return false;
        }
    }
    @Override
    public String toString(){
        return "balance= " + balance;
    }
}
