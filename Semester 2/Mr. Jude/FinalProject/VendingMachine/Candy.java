package VendingMachine;

public class Candy extends Snack { //candy snack subclass
    private String candytype;
    public Candy(String name, int price, String size, String flavor, String candytype) { //candy constuctor
        super(name, price, size, flavor); //calls the constructor of the superclass
        this.candytype = candytype;
    }
    //setter and getter for candytype
    public String getCandytype() {
        return candytype;
    }

    public void setCandytype(String candytype) {
        this.candytype = candytype;
    }

    @Override
    public String toString() { //override toString
        return "CANDY [" + super.toString() + " candy type = " + candytype + " ]";
    }
}
