package VendingMachine;

public class Chocolate extends Snack{ //chocolate snack subclass
    private int cacaopercentage;
    public Chocolate(String name, int price, String size, String flavor, int cacaopercentage) {
        super(name, price, size, flavor);
        this.cacaopercentage = cacaopercentage;
    }
    //setter and getter for cacaopercentage
    public int getCacaopercentage() {
        return cacaopercentage;
    }

    public void setCacaopercentage(int cacaopercentage) {
        this.cacaopercentage = cacaopercentage;
    }

    @Override
    public String toString() { //override toString
        return "CHOCOLATE [" + super.toString() + " cacao percentage = " + cacaopercentage + " ]";
    }
}
