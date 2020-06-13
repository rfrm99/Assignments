package VendingMachine;

public class Drink implements IsProduct { //Drink class that implements IsProduct interface
    private String name;
    private int price;
    private String size;
    private String temperature;
    private int amount;

    public Drink(String name, int price, String size, String temperature){ //Drink constructor
        this.name = name;
        this.price = price;
        this.size = size;
        this.temperature = temperature;
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

    public String getTemperature(){
        return temperature;
    }

    public void setTemperature(String temperature){
        this.temperature = temperature;
    }

    @Override
    public String toString(){ //override toString
        return "DRINK [Name= " + name + ", Price= " + price + ", Size= " + size + ", Temperature= " + temperature + ", Stock Left= " + amount + "]";
    }
}
