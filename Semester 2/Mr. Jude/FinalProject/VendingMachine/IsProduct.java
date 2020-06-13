package VendingMachine;

public interface IsProduct { //interface for product objects
    String getName();
    void setName(String name);
    int getPrice();
    void setPrice(int price);
    String getSize();
    void setSize(String size);
    int getAmount();
    void setAmount(int amount);
}
