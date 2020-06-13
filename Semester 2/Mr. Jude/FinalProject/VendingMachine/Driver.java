package VendingMachine;

import java.io.IOException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] arg) throws IOException {
        VendingMachine v = new VendingMachine(); //creating vending machine object

        //creating the objects to put in the vending machine
        Drink cola = new SoftDrink("Coca Cola", 30, "150ml", "Cold", "Original");
        Drink cola2 = new SoftDrink("Coca Cola", 40, "200ml", "Cold", "Original");
        Drink pepsi = new SoftDrink("Pepsi", 30, "150ml", "Can", "Cold");
        Drink pepsi2 = new SoftDrink("Pepsi", 40, "200ml", "Bottled", "Cold");
        Drink water = new Drink("Aqua", 10, "150ml", "Cold");
        Drink water1 = new Drink("Aqua", 20, "200ml",  "Cold");
        Drink water2 = new Drink("Ades", 10, "150ml",  "Cold");
        Drink water3 = new Drink("Ades", 20, "200ml",  "Cold");
        Drink tea = new Drink("Green Tea", 50, "150ml",  "Cold");
        Drink tea2 = new Drink("Green Tea", 40, "150ml",  "Hot");
        Drink tea3 = new Drink("Teh Pucuk Harum", 30, "150ml",  "Cold");
        Drink tea4 = new Drink("Teh Pucuk Harum", 20, "200ml",  "Cold");
        Drink teasquare = new Drink("Teh kotak", 30, "150ml", "Cold");
        Drink teasquare2 = new Drink("Teh kotak", 30, "200ml",  "Cold");
        Drink coffee = new Drink("Black Coffee", 20, "150ml",  "Hot");
        Drink coffee2 = new Drink("Cold Brew", 40, "150ml",  "Cold");
        Drink pocari = new Drink("Pocari Sweat", 40, "150ml",  "Cold");
        Drink pocari2 = new Drink("Pocari Sweat", 50, "200ml",  "Cold");
        Snack taro = new Snack("Taro", 30, "200g",  "seaweed");
        Snack taro1 = new Snack("Taro", 30, "200g",  "bbq");
        Snack cheetos = new Snack("Cheetos", 50, "200g",  "original");
        Snack cheetos1 = new Snack("Cheetos", 50, "200g",  "hot cheeto");
        Snack lays = new Snack("Lays", 40, "200g", "seaweed");
        Snack lays1 = new Snack("Lays", 40, "200g",  "original");
        Snack chitato = new Snack("Chitato", 30, "200g",  "heinz tomato sauce");
        Snack chitato1 = new Snack("Chitato", 30, "200g",  "bbq");
        Snack pringles = new Snack("Pringles", 40, "200g",  "sour cream");
        Snack pringles1 = new Snack("Pringles", 40, "200g",  "seaweed");
        Snack doritos = new Snack("Doritos", 50, "200g",  "paprika");
        Snack doritos1 = new Snack("Doritos", 50, "200g",  "cheese");
        Snack oreo = new Snack("Oreo", 50, "200g",  "vanilla");
        Snack oreo1 = new Snack("Oreo", 50, "200g",  "chocolate");
        Snack cadburry = new Chocolate("Cadburry", 60, "200g", "Milk", 60);
        Snack cadburry1 = new Chocolate("Cadburry", 60, "200g",  "Black Forest", 70);
        Snack sourpatch = new Candy("Sour Patch", 50, "200g",  "Sour", "Gummies");
        Snack nerds = new Candy("Nerds", 50, "200g",  "Sweet", "Candy Rocks");

        //adding them all in initially
        v.addDrink(cola);
        v.addDrink(cola2);
        v.addDrink(pepsi);
        v.addDrink(pepsi2);
        v.addDrink(water);
        v.addDrink(water1);
        v.addDrink(water2);
        v.addDrink(water3);
        v.addDrink(tea);
        v.addDrink(tea2);
        v.addDrink(tea3);
        v.addDrink(tea4);
        v.addDrink(teasquare);
        v.addDrink(teasquare2);
        v.addDrink(coffee);
        v.addDrink(coffee2);
        v.addDrink(pocari);
        v.addDrink(pocari2);
        v.addSnack(taro);
        v.addSnack(taro1);
        v.addSnack(cheetos);
        v.addSnack(cheetos1);
        v.addSnack(lays);
        v.addSnack(lays1);
        v.addSnack(chitato);
        v.addSnack(chitato1);
        v.addSnack(pringles);
        v.addSnack(pringles1);
        v.addSnack(doritos);
        v.addSnack(doritos1);
        v.addSnack(oreo);
        v.addSnack(oreo1);
        v.addSnack(cadburry);
        v.addSnack(cadburry1);
        v.addSnack(sourpatch);
        v.addSnack(nerds);

        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);

        boolean flag = true; //flag for while loop
        v.loadFile(); //loads the user accounts
        while (flag) {
            v.displayContents(); //display the vending machine contents
            System.out.println("Select what you want to do");
            System.out.println("1. Purchase");
            System.out.println("2. Create a Vend Account");
            System.out.println("3. Top up your Vend Account");
            System.out.println("4. Get product information");
            System.out.println("5. Admin Login");
            int choice = scan.nextInt();
            switch (choice) { //switch case for user choice input
                case 1:
                    System.out.println("Select a product you want to purchase");
                    while(v.getSelectedDrink() == null && v.getSelectedSnack() == null) {
                        String id = scan1.nextLine();
                        v.setSelectedItem(id);
                    }
                    Scanner scan2 = new Scanner(System.in);
                    System.out.println("1. Confirm Selection");
                    System.out.println("2. Cancel");
                    choice = scan2.nextInt();
                    if (choice == 1) {
                        v.payment();
                    } else {
                        flag = false;
                    }
                    break;
                case 2:
                    v.createAccount();
                    break;
                case 3:
                    v.topUpBalance();
                    break;
                case 4:
                    Scanner scan4 = new Scanner(System.in);
                    System.out.println("Enter Product ID: ");
                    String id = scan4.nextLine();
                    v.getInfo(id);
                    break;
                case 5:
                    Account admin = v.login();
                    if (admin.getName().equals("Admin")) {
                        System.out.println("Welcome Admin");
                        System.out.println("What would you like to do today");
                        System.out.println("1. Remove Product");
                        System.out.println("2. Restock Product");
                        System.out.println("3. Add New Product");
                        System.out.println("4. Shutdown Vending Machine");
                        Scanner scan5 = new Scanner(System.in);
                        choice = scan5.nextInt();
                        Scanner scan6 = new Scanner(System.in);
                        Scanner scan7 = new Scanner(System.in);
                        System.out.println("Enter Product ID");
                        String id1 = scan6.nextLine();
                        switch (choice) {
                            case 1:
                                v.removeProduct(id1);
                                break;
                            case 2:
                                System.out.println("Enter the amount of stock you want to add");
                                int stock = scan7.nextInt();
                                v.restockProduct(id1, stock);
                                break;
                            case 3:
                                v.addNewProduct(id1);
                                break;
                            case 4:
                                System.exit(0);
                        }
                    } else {
                        System.out.println("Youre not the admin, admin login failed");
                    }
            }
            v.fileWrite();
        }
    }
}
