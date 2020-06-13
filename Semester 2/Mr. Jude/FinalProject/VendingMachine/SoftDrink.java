package VendingMachine;

public class SoftDrink extends Drink { //Softdrink drink subclass
    private String flavor;
    public SoftDrink(String name, int price, String size, String temperature, String flavor) { //softdrink constructor
        super(name, price, size, temperature); //calls the super class constructor
        this.flavor = flavor;
    }
    //setter and getter for flavor
    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override //override toString
    public String toString(){ return "SOFT DRINK [" + super.toString() + " Flavor= " + flavor + " ]";
    }
}
