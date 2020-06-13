package VendingMachine;

public class Snack implements IsProduct { //Snack class that implements IsProduct interface
    private String name;
    private int price;
    private String size;
    private String flavor;
    private int amount;

    public Snack(String name, int price, String size, String flavor){ //Snack constructor
        this.name = name;
        this.price = price;
        this.size = size;
        this.flavor = flavor;
        this.amount = 5;
    }
    //methods from the interface defined in the class
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() { //override toString
        return "SNACK [Name= " + name + ", Price= " + price + ", Size= " + size + ", Flavor= " + flavor + ", Stock Left= " + amount + "]";
    }
}
