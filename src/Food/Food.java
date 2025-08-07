package Food;

import java.time.LocalDate;

public abstract class Food {
    // Declare attributes
    protected String name;
    protected double price;
    protected LocalDate expiryDate;

    // Methods, builder
    public Food(String name, double price, LocalDate expiryDate){
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    // Methods, get
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public  LocalDate getExpiryDate(){
        return expiryDate;
    }

    // Methods, set
    public void setPrice(double price){
        this.price = price;
    }

    // Methods, calcPrice()
    public abstract double calcPrice();

    // Methods, verifyExpiryDate()
    public boolean verifyExpiryDate(LocalDate dateToCompare){
        if (expiryDate.isAfter(dateToCompare)){
            return false;
        }
        return true;
    }

    // Methods, toString()
    @Override
    public String toString() {
        return "Food{" +
                "name=" + name + '\'' +
                ", price=" + price +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
