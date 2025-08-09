package Food;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class Meat extends Food{
    // Declare Attributes
    private final double weight;
    private int slices;

    // Methods, Builder
    public Meat(String name, double price, LocalDate expiryDate, double weight, int slices) {
        super(name, price, expiryDate);
        this.weight = weight;
        this.slices = slices;
    }

    // Methods, get
    public double getWeight() {
        return weight;
    }
    public int getSlices() {
        return slices;
    }

    // Methods, set
    public void setSlices(int slices) {
        this.slices = slices;
    }

    // Methods, behaviour
    public void cutMeat(int amountOfSlices){
        slices+=amountOfSlices;
    }

    public double calcPrice(){
        return price * weight + slices/10. + (expiryDate.toEpochDay() - LocalDate.now().toEpochDay())/10.;
    }

    // Methods, toString()
    @Override
    public String toString() {
        return "Meat{" +
                "weight=" + weight +
                ", slices=" + slices +
                '}';
    }
}
