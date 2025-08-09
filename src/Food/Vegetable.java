package Food;

import java.time.LocalDate;

public class Vegetable extends Food{
    // Declare attributes
    private String texture;
    private boolean isPeeled;

    // Builder Method
    public Vegetable(String name, double price, LocalDate expiryDate, String texture, boolean isPeeled){
        super(name, price, expiryDate);
        this.texture = texture;
        this.isPeeled = isPeeled;
    }

    // Getters Methods
    public String getTexture() {
        return texture;
    }
    public boolean isPeeled() {
        return isPeeled;
    }

    // Setters Methods
    public void setTexture(String texture) {
        this.texture = texture;
    }

    // Behaviour Methods
    public void peel(){
        texture = texture.concat(", peeled");
        isPeeled=true;
    }

    public double calcPrice(){
        if (isPeeled){
            return price + price/2 + (expiryDate.toEpochDay() - LocalDate.now().toEpochDay());
        }
        return price + (expiryDate.toEpochDay() - LocalDate.now().toEpochDay());
    }

    // Method toString()
    @Override
    public String toString() {
        return '{' + super.toString() +
                "Vegetable{" +
                "texture=" + texture + '\'' +
                ", isPeeled=" + isPeeled +
                '}' +
                '}';
    }
}
