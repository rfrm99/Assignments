package VendingMachine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    private ArrayList<Account> UsersList = new ArrayList<Account>(); // Arraylist to store user's account
    private Drink[][] DrinkList; //Multidimensional list to store Drink objects
    private Snack[][] SnackList; //Multidimensional list to store Snack objects
    private int register; // Variable to store money that goes in the vending machine
    private Drink selectedDrink = null; // Variable to determine the selected Drink
    private Snack selectedSnack = null; // Variable to determine the selected snack

    public VendingMachine() { // Constructor to create a vending machine object
        this.DrinkList = new Drink[3][6]; //Setting a 3 by 6 drink slot in the vending machine
        this.SnackList = new Snack[3][6]; //Setting a 3 by 6 snack slot in the vending machine
        this.register = 0; //setting the initial register of the vending machine to 0
    }

    public Drink getSelectedDrink() {
        return selectedDrink;
    } //getter for selectedDrink

    public Snack getSelectedSnack() {
        return selectedSnack;
    } //setter for selectedDrink

    public void setSelectedItem(String id) {
        switch (id.substring(0, 1).toUpperCase()) { //Switch case used to check the 1st letter of an inputted string
            case "A":
                this.selectedDrink = DrinkList[0][Integer.parseInt(id.substring(1)) - 1]; //Setting a selected drink item by the id parseint used to convert string to int.
                System.out.println("Selected Drink: " + selectedDrink.toString());
                if (selectedDrink.getAmount() == 0) { //if condition to check whether the item is out of stock
                    this.selectedDrink = null; //sets it back to null
                    System.out.println("Drink is unavailable, please select another item");
                }
                break;
            case "B":
                this.selectedDrink = DrinkList[1][Integer.parseInt(id.substring(1)) - 1];
                System.out.println("Selected Drink: " + selectedDrink.toString());
                if (selectedDrink.getAmount() == 0) {
                    this.selectedDrink = null;
                    System.out.println("Drink is unavailable, please select another item");
                }
                break;
            case "C":
                this.selectedDrink = DrinkList[2][Integer.parseInt(id.substring(1)) - 1];
                System.out.println("Selected Drink: " + selectedDrink.toString());
                if (selectedDrink.getAmount() == 0) {
                    this.selectedDrink = null;
                    System.out.println("Drink is unavailable, please select another item");
                }
                break;
            case "D":
                this.selectedSnack = SnackList[0][Integer.parseInt(id.substring(1)) - 1];
                System.out.println("Selected Snack: " + selectedSnack.toString());
                if (selectedSnack.getAmount() == 0) {
                    this.selectedDrink = null;
                    System.out.println("Snack is unavailable, please select another item");
                }
                break;
            case "E":
                this.selectedSnack = SnackList[1][Integer.parseInt(id.substring(1)) - 1];
                System.out.println("Selected Snack: " + selectedSnack.toString());
                if (selectedSnack.getAmount() == 0) {
                    this.selectedDrink = null;
                    System.out.println("Snack is unavailable, please select another item");
                }
                break;
            case "F":
                this.selectedSnack = SnackList[2][Integer.parseInt(id.substring(1)) - 1];
                System.out.println("Selected Snack: " + selectedSnack.toString());
                if (selectedSnack.getAmount() == 0) {
                    this.selectedDrink = null;
                    System.out.println("Snack is unavailable, please select another item");
                }
                break;
            default:
                System.out.println("Input Invalid");
        }
    }

    public void getInfo(String id) { //gets info of the chosen product
        switch (id.substring(0, 1).toUpperCase()) {
            case "A":
                System.out.println(DrinkList[0][Integer.parseInt(id.substring(1)) - 1].toString());
                break;
            case "B":
                System.out.println(DrinkList[1][Integer.parseInt(id.substring(1)) - 1].toString());
                break;
            case "C":
                System.out.println(DrinkList[2][Integer.parseInt(id.substring(1)) - 1].toString());
                break;
            case "D":
                System.out.println(SnackList[0][Integer.parseInt(id.substring(1)) - 1].toString());
                break;
            case "E":
                System.out.println(SnackList[1][Integer.parseInt(id.substring(1)) - 1].toString());
                break;
            case "F":
                System.out.println(SnackList[2][Integer.parseInt(id.substring(1)) - 1].toString());
                break;
        }
    }

    public void restockProduct(String id, int stock) { //restocking a product can only be operated by the admin
        switch (id.substring(0, 1).toUpperCase()) {
            case "A":
                if (DrinkList[0][Integer.parseInt(id.substring(1)) - 1].getAmount() == 10) { //condition to check if the item is still full
                    System.out.println("Drink is already fully stocked");
                    break;
                } else if (DrinkList[0][Integer.parseInt(id.substring(1)) - 1].getAmount() < 10) { //condition to check if its less than max capacity
                    if (stock + DrinkList[0][Integer.parseInt(id.substring(1)) - 1].getAmount() > 10) {//condition to see if the stock will go over max capacity
                        int newstock = stock + DrinkList[0][Integer.parseInt(id.substring(1)) - 1].getAmount() - 10; //if so it will subtract it and leave the rest
                        int oldstock = DrinkList[0][Integer.parseInt(id.substring(1)) - 1].getAmount();
                        DrinkList[0][Integer.parseInt(id.substring(1))].setAmount(
                                DrinkList[0][Integer.parseInt(id.substring(1)) - 1].getAmount() + newstock);
                        System.out.println("Stock Filled, Excess Snack = " + (stock - oldstock));
                        break;
                    } else if (stock + DrinkList[0][Integer.parseInt(id.substring(1)) - 1].getAmount() <= 10) { //condition to check if it would not go over the max
                        DrinkList[0][Integer.parseInt(id.substring(1)) - 1].setAmount(
                                DrinkList[0][Integer.parseInt(id.substring(1)) - 1].getAmount() + stock);
                        System.out.println("Product Restocked");
                        break;
                    }
                }
                break;
            case "B":
                if (DrinkList[1][Integer.parseInt(id.substring(1)) - 1].getAmount() == 10) {
                    System.out.println("Drink is already fully stocked");
                    break;
                } else if (DrinkList[1][Integer.parseInt(id.substring(1)) - 1].getAmount() < 10) {
                    if (stock + DrinkList[1][Integer.parseInt(id.substring(1)) - 1].getAmount() > 10) {
                        int newstock = stock + DrinkList[1][Integer.parseInt(id.substring(1)) - 1].getAmount() - 10;
                        int oldstock = DrinkList[1][Integer.parseInt(id.substring(1)) - 1].getAmount();
                        DrinkList[1][Integer.parseInt(id.substring(1))].setAmount(
                                DrinkList[1][Integer.parseInt(id.substring(1)) - 1].getAmount() + newstock);
                        System.out.println("Stock Filled, Excess Snack = " + (stock - oldstock));
                        break;
                    } else if (stock + DrinkList[1][Integer.parseInt(id.substring(1)) - 1].getAmount() <= 10) {
                        DrinkList[1][Integer.parseInt(id.substring(1)) - 1].setAmount(
                                DrinkList[1][Integer.parseInt(id.substring(1)) - 1].getAmount() + stock);
                        System.out.println("Product Restocked");
                        break;
                    }
                }
                break;
            case "C":
                if (DrinkList[2][Integer.parseInt(id.substring(1)) - 1].getAmount() == 10) {
                    System.out.println("Drink is already fully stocked");
                    break;
                } else if (DrinkList[2][Integer.parseInt(id.substring(1)) - 1].getAmount() < 10) {
                    if (stock + DrinkList[2][Integer.parseInt(id.substring(1)) - 1].getAmount() > 10) {
                        int newstock = stock + DrinkList[2][Integer.parseInt(id.substring(1)) - 1].getAmount() - 10;
                        int oldstock = DrinkList[2][Integer.parseInt(id.substring(1)) - 1].getAmount();
                        DrinkList[2][Integer.parseInt(id.substring(1))].setAmount(
                                DrinkList[2][Integer.parseInt(id.substring(1)) - 1].getAmount() + newstock);
                        System.out.println("Stock Filled, Excess Snack = " + (stock - oldstock));
                        break;
                    } else if (stock + DrinkList[2][Integer.parseInt(id.substring(1)) - 1].getAmount() <= 10) {
                        DrinkList[2][Integer.parseInt(id.substring(1)) - 1].setAmount(
                                DrinkList[2][Integer.parseInt(id.substring(1)) - 1].getAmount() + stock);
                        System.out.println("Product Restocked");
                        break;
                    }
                }
                break;
            case "D":
                if (SnackList[0][Integer.parseInt(id.substring(1)) - 1].getAmount() == 10) { //same code but for snack
                    System.out.println("Drink is already fully stocked");
                    break;
                } else if (SnackList[0][Integer.parseInt(id.substring(1)) - 1].getAmount() < 10) {
                    if (stock + SnackList[0][Integer.parseInt(id.substring(1)) - 1].getAmount() > 10) {
                        int newstock = stock + SnackList[0][Integer.parseInt(id.substring(1)) - 1].getAmount() - 10;
                        int oldstock = SnackList[0][Integer.parseInt(id.substring(1)) - 1].getAmount();
                        SnackList[0][Integer.parseInt(id.substring(1)) - 1].setAmount(
                                SnackList[0][Integer.parseInt(id.substring(1)) - 1].getAmount() + newstock);
                        System.out.println("Stock Filled, Excess Snack = " + (stock - oldstock));
                        break;
                    } else if (stock + SnackList[0][Integer.parseInt(id.substring(1)) - 1].getAmount() <= 10) {
                        SnackList[0][Integer.parseInt(id.substring(1)) - 1].setAmount(
                                SnackList[0][Integer.parseInt(id.substring(1)) - 1].getAmount() + stock);
                        System.out.println("Product Restocked");
                        break;
                    }
                }
                break;
            case "E":
                if (SnackList[1][Integer.parseInt(id.substring(1)) - 1].getAmount() == 10) {
                    System.out.println("Drink is already fully stocked");
                    break;
                } else if (SnackList[1][Integer.parseInt(id.substring(1)) - 1].getAmount() < 10) {
                    if (stock + SnackList[1][Integer.parseInt(id.substring(1)) - 1].getAmount() > 10) {
                        int newstock = stock + SnackList[1][Integer.parseInt(id.substring(1)) - 1].getAmount() - 10;
                        int oldstock = SnackList[0][Integer.parseInt(id.substring(1)) - 1].getAmount();
                        SnackList[1][Integer.parseInt(id.substring(1)) - 1].setAmount(
                                SnackList[1][Integer.parseInt(id.substring(1)) - 1].getAmount() + newstock);
                        System.out.println("Stock Filled, Excess Snack = " + (stock - oldstock));
                        break;
                    } else if (stock + SnackList[1][Integer.parseInt(id.substring(1)) - 1].getAmount() <= 10) {
                        SnackList[1][Integer.parseInt(id.substring(1)) - 1].setAmount(
                                SnackList[1][Integer.parseInt(id.substring(1)) - 1].getAmount() + stock);
                        System.out.println("Product Restocked");
                        break;
                    }
                }
                break;
            case "F":
                if (SnackList[2][Integer.parseInt(id.substring(1)) - 1].getAmount() == 10) {
                    System.out.println("Drink is already fully stocked");
                    break;
                } else if (SnackList[2][Integer.parseInt(id.substring(1)) - 1].getAmount() < 10) {
                    if (stock + SnackList[2][Integer.parseInt(id.substring(1)) - 1].getAmount() > 10) {
                        int newstock = stock + SnackList[2][Integer.parseInt(id.substring(1)) - 1].getAmount() - 10;
                        int oldstock = SnackList[2][Integer.parseInt(id.substring(1)) - 1].getAmount();
                        SnackList[2][Integer.parseInt(id.substring(1)) - 1].setAmount(
                                SnackList[2][Integer.parseInt(id.substring(1)) - 1].getAmount() + newstock);
                        System.out.println("Stock Filled, Excess Snack = " + (stock - oldstock));
                        break;
                    } else if (stock + SnackList[2][Integer.parseInt(id.substring(1)) - 1].getAmount() <= 10) {
                        SnackList[2][Integer.parseInt(id.substring(1)) - 1].setAmount(
                                SnackList[2][Integer.parseInt(id.substring(1)) - 1].getAmount() + stock);
                        System.out.println("Product Restocked");
                        break;
                    }
                }
        }
    }

    public void addDrink(Drink drink) { //adds a drink object into the vending machine
        int flag = 0;
        for (int i = 0; i < DrinkList.length; i++) {
            for (int j = 0; j < DrinkList[i].length; j++) { //loop to find an empty slot in the vending machine
                if (DrinkList[i][j] == null) {
                    DrinkList[i][j] = drink;
                    System.out.println("Drink has been added");
                    flag = 1;
                    break;
                } else if (i == DrinkList.length - 1 && j == DrinkList[i].length - 1) {
                    System.out.println("Vending Machine drink slots are fully occupied");
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
        }
    }

    public void addSnack(Snack snack) { //adds a snack object into the vending machine
        int flag = 0;
        for (int i = 0; i < SnackList.length; i++) {
            for (int j = 0; j < SnackList[i].length; j++) { //loop to find an empty slot in the vending machine
                if (SnackList[i][j] == null) {
                    SnackList[i][j] = snack;
                    System.out.println("Snack has been added");
                    flag = 1;
                    break;
                } else if (i == SnackList.length - 1 && j == SnackList[i].length - 1) {
                    System.out.println("Vending Machine snack slots are fully occupied");
                }
            }
            if (flag == 1) {
                break;
            }
        }
    }

    public void addNewProduct(String id) { //adds a new product into a slot
        Scanner scan8 = new Scanner(System.in);
        if (id.substring(0, 1).equals("A") || id.substring(0, 1).equals("B") || id.substring(0, 1).equals("C")) {
            String name = scan8.nextLine();
            int price = scan8.nextInt();
            String size = scan8.nextLine();
            String temperature = scan8.nextLine();
            switch (id.substring(0, 1)) {
                case "A":
                    DrinkList[0][Integer.parseInt(id.substring(1)) - 1] = new Drink(name, price, size, temperature);
                    System.out.println("Drink Added");
                    break;
                case "B":
                    DrinkList[1][Integer.parseInt(id.substring(1)) - 1] = new Drink(name, price, size, temperature);
                    System.out.println("Drink Added");
                    break;
                case "C":
                    DrinkList[2][Integer.parseInt(id.substring(1)) - 1] = new Drink(name, price, size, temperature);
                    System.out.println("Drink Added");
                    break;
            }
        } else {
            String name = scan8.nextLine();
            int price = scan8.nextInt();
            String size = scan8.nextLine();
            String flavor = scan8.nextLine();
            switch (id.substring(0, 1)) {
                case "D":
                    SnackList[0][Integer.parseInt(id.substring(1)) - 1] = new Snack(name, price, size, flavor);
                    System.out.println("Snack Added");
                    break;
                case "E":
                    SnackList[1][Integer.parseInt(id.substring(1)) - 1] = new Snack(name, price, size, flavor);
                    System.out.println("Snack Added");
                    break;
                case "F":
                    SnackList[2][Integer.parseInt(id.substring(1)) - 1] = new Snack(name, price, size, flavor);
                    System.out.println("Snack Added");
                    break;
            }
        }
    }

    public void removeProduct(String id) { //removes a prodcut from the vending machine
        switch (id.substring(0, 1).toUpperCase()) {
            case "A":
                DrinkList[0][Integer.parseInt(id.substring(1)) - 1] = null;
                System.out.println("Drink Removed");
                break;
            case "B":
                DrinkList[1][Integer.parseInt(id.substring(1)) - 1] = null;
                System.out.println("Drink Removed");
                break;
            case "C":
                DrinkList[2][Integer.parseInt(id.substring(1)) - 1] = null;
                System.out.println("Drink Removed");
                break;
            case "D":
                SnackList[0][Integer.parseInt(id.substring(1)) - 1] = null;
                System.out.println("Snack Removed");
                break;
            case "E":
                SnackList[1][Integer.parseInt(id.substring(1)) - 1] = null;
                System.out.println("Snack Removed");
                break;
            case "F":
                SnackList[2][Integer.parseInt(id.substring(1)) - 1] = null;
                System.out.println("Snack Removed");
                break;
        }
    }

    public void displayContents() { // function to display contents of the vending machine
        System.out.println("Welcome to this Vending Machine");
        System.out.println("Vending Machine Contents");
        for (int i = 0; i < DrinkList.length; i++) {
            for (int j = 0; j < DrinkList[i].length; j++) { // loops the entire multidimensional array
                if (DrinkList[i][j] == null) {
                    System.out.print("[This drink is out of stock], ");
                } else if (i == 0) {
                    System.out.print("A" + (j + 1) + " " + DrinkList[i][j].getName() + ", ");
                } else if (i == 1) {
                    System.out.print("B" + (j + 1) + " " + DrinkList[i][j].getName() + ", ");
                } else {
                    System.out.print("C" + (j + 1) + " " + DrinkList[i][j].getName() + ", ");
                }
            }
            System.out.print("\n");
        }
        for (int i = 0; i < SnackList.length; i++) {
            for (int j = 0; j < SnackList[i].length; j++) {
                if (DrinkList[i][j] == null) {
                    System.out.print("[This Snack is out of stock], ");
                } else if (i == 0) {
                    System.out.print("D" + (j + 1) + " " + SnackList[i][j].getName() + ", ");
                } else if (i == 1) {
                    System.out.print("E" + (j + 1) + " " + SnackList[i][j].getName() + ", ");
                } else {
                    System.out.print("F" + (j + 1) + " " + SnackList[i][j].getName() + ", ");
                }
            }
            System.out.print("\n");
        }
    }


    public void payment() { //a method to decided which payment method the users want
        System.out.println("Choose Payment Method:");
        System.out.println("1. Vending Machine Account");
        System.out.println("2. Cash");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                vendaccount();
                break;
            case 2:
                cash();
                break;
            default:
                System.out.println("Input Invalid");
        }
    }

    public void vendaccount() { //method to pay with vending account
        Account logged = login(); //keeps logged in user's account in a variable
        if (selectedDrink != null) { //condition to check if theres a drink selected
            if (logged != null && logged.getBalance() > selectedDrink.getPrice()) { // condition to check if the user successfuly logged in or not and if the balance is enough
                logged.setBalance(logged.getBalance() - selectedDrink.getPrice());
                System.out.println("Transaction Successful");
                System.out.println("Current Balance:");
                System.out.println(logged.getBalance());
            } else if (logged != null && logged.getBalance() < selectedDrink.getPrice()) {// condition to check if the user successfuly logged in or not and if the balance is not enough
                System.out.println("Insufficient Balance");
            } else {
                System.out.println("Payment Canceled");
            }
        } else { // else if a snack is selected
            if (logged != null && logged.getBalance() > selectedSnack.getPrice()) {
                logged.setBalance(logged.getBalance() - selectedSnack.getPrice());
                System.out.println("Transaction Successful");
                System.out.println("Current Balance:");
                System.out.println(logged.getBalance());
            } else if (logged != null && logged.getBalance() < selectedSnack.getPrice()) {
                System.out.println("Insufficient Balance");
            } else {
                System.out.println("Payment canceled");
            }
        }
    }

    public void cash() { // cash payment method
        boolean flag = true;
        int totalmoney = 0;
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);
        while (flag) { //a loop so users can choose to keep adding money or not
            System.out.println("Insert Cash (Machine only accepts, $10, $20, $50)");
            int moneyinput = scan.nextInt();
            if (moneyinput == 10 || moneyinput == 20 || moneyinput == 50) { // condition that only allows users to input 10 20 or 50 dollars
                totalmoney += moneyinput;
            } else {
                System.out.println("We only accept $10, $20, or $50");
            }
            System.out.println("Add more money? [yes/no]");
            String choice = scan1.nextLine();
            if (choice.equals("no")) {
                flag = false;
            } else if (choice.equals("yes")) {
                flag = true;
            } else {
                System.out.println("Input Invalid");
                System.exit(0);
            }
        }
        setRegister(totalmoney);
        if (selectedDrink != null) {
            if (getRegister() < selectedDrink.getPrice()) { //checks if the money in register is insufficient
                System.out.println("Insufficient Money");
                int change = getRegister(); // gives back all the money in the register as change
                System.out.println("Money returned: " + change);
                setRegister(0);
            } else { //checks if the money in register is sufficient
                int change = getRegister() - selectedDrink.getPrice(); //code to calculate the change
                System.out.println("Money Inserted: " + getRegister());
                System.out.println("Item Price: " + getSelectedDrink().getPrice());
                System.out.println("Transaction Successful");
                System.out.println("Change: " + change);
                selectedDrink.setAmount(selectedDrink.getAmount() - 1);
                setRegister(0);
            }
        } else {
            if (getRegister() < selectedSnack.getPrice()) {
                System.out.println("Insufficient Money");
                int change = getRegister();
                System.out.println("Money returned: " + change);
                setRegister(0);
            } else {
                int change = getRegister() - selectedSnack.getPrice();
                System.out.println("Money Inserted: " + getRegister());
                System.out.println("Item Price: " + getSelectedSnack().getPrice());
                System.out.println("Transaction Successful");
                System.out.println("Change: " + change);
                selectedSnack.setAmount(selectedSnack.getAmount() - 1);
                setRegister(0);
            }
        }
    }

    public void setRegister(int money) { //register setter
        this.register = money;
    }

    public int getRegister() { //register getter
        return register;
    }

    public void createAccount() { //method that allows user to create an account
        System.out.println("Input a username");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        System.out.println("Input a password");
        ;
        String password = scan.nextLine();
        System.out.println("Input your name");
        String name = scan.nextLine();
        UsersList.add(new Account(username, password, name)); //adds the new account to the userslist
    }

    public void addAccount(Account account) { //function to addAccount to users list
        UsersList.add(account);
    }

    public void deleteAccount(Account account) { //function to delete and account
        UsersList.remove(account);
    }

    public Account login() { //login function for the account
        Account logged;
        int flag = 0;
        while (flag == 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Input your username");
            String username = scan.nextLine();
            System.out.println("Input your password");
            String password = scan.nextLine();
            for (int i = 0; i < UsersList.size(); i++) { //loops through the userslist
                if (UsersList.get(i).getPassword().equals(password) && UsersList.get(i).getUsername().equals(username)) {//checks for existing user
                    System.out.println("Login Successful");
                    logged = UsersList.get(i);
                    return logged; //returns the account
                }
            }
            System.out.println("Login Failed");
            System.out.println("Try again? [yes/no]");
            String choice = scan.nextLine();
            if ("no".equals(choice)) {
                flag = 1;
            }
        }
        return null; //returns null
    }

    public void topUpBalance() { //top up method
        Account logged = login(); //sets the user's account
        if (logged != null) {
            System.out.println("Current Balance:"); //gives out the current balance
            System.out.println(logged.getBalance());
            boolean flag = true;
            int totalmoney = 0;
            Scanner scan = new Scanner(System.in);
            Scanner scan1 = new Scanner(System.in);
            while (flag) {
                System.out.println("Insert Cash (Machine only accepts, $10, $20, $50)");
                int moneyinput = scan.nextInt();
                if (moneyinput == 10 || moneyinput == 20 || moneyinput == 50) { //asks users to input 10 20 or 50 dollars
                    totalmoney += moneyinput;
                } else {
                    System.out.println("We only accept $10, $20, or $50");
                }
                System.out.println("Add more money? [yes/no]");
                String choice = scan1.nextLine();
                if (choice.equals("no")) {
                    flag = false;
                } else if (choice.equals("yes")) {
                    flag = true;
                } else {
                    System.out.println("Input Invalid");
                    System.exit(0);
                }
            }
            setRegister(totalmoney);
            logged.setBalance(logged.getBalance() + getRegister());
            setRegister(0);
            System.out.println("Top Up Successful");
            System.out.println("Current Balance:");
            System.out.println(logged.getBalance());
        } else {
            System.out.println("Top up canceled");
        }
    }

    public ArrayList<Account> getUsersList() {
        return UsersList;
    }

    public void fileWrite() throws IOException { //file writing method
        FileWriter csvWriter = new FileWriter("database.csv");
        for (int i = 0; i < getUsersList().size(); i++) { //loops through the existing users list
            csvWriter.append(getUsersList().get(i).getUsername()).append(","); // writes the username,
            csvWriter.append(getUsersList().get(i).getPassword()).append(","); // password,
            csvWriter.append(getUsersList().get(i).getName()).append(","); // name,
            csvWriter.append(Integer.toString(getUsersList().get(i).getBalance())); //balance
            csvWriter.append("\n"); // going to the next line
        }

        csvWriter.flush();
        csvWriter.close();
    }

    public void loadFile() throws IOException { //load file method
        List<List<String>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("database.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); //reads the file and places it into a list
                data.add(Arrays.asList(values)); //inserts list into an array list
            }
            for (int i = 0; i < data.size(); i++) { //loop through the array list
                String username = data.get(i).get(0); //setting username to the username in the file
                String password = data.get(i).get(1); //setting password to the password in the file
                String name = data.get(i).get(2); //setting name to the name in the file
                int balance = Integer.parseInt(data.get(i).get(3)); //setting balance to the balance in the file
                addAccount(new Account(username, password, name, balance)); //adds them to the userslist in the system.
            }
        }
    }
}