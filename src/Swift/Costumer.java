package Swift;

import java.util.Arrays;

public class Costumer extends User{
    // Declare attributes
    private String[][] history;
    private double spentMoney;
    private String password;

    // Builder Methods
    public Costumer(String name, int age, String cpf, String[][] history, double spentMoney){
        super(name, age, cpf);
        this.history = history;
        this.spentMoney = spentMoney;
        history = new String[100][100];
    }

    public Costumer(String name, int age, String cpf){
        super(name, age, cpf);
    }

    // No setter available
    // Getters Methods
    public String[][] getHistory() {
        return history;
    }
    public double getSpentMoney() {
        return spentMoney;
    }

    // Implement methods:
    @Override
    public boolean login(String authenticator) {
        return password.equals(this.password);
    }

    // Behaviour method
    public void buy(String product, double price, int x, int y){
        if (x == 100){
            x = 0;
        }
        if (y == 100){
            y = 0;
        }
        history[x] = new String[]{product, String.valueOf(price)};
        spentMoney+=price;
    }

    @Override
    public String toString() {
        return super.toString() + "Costumer{" +
                "history=" + Arrays.toString(history) +
                ", spentMoney=" + spentMoney +
                ", password='" + password + '\'' +
                '}';
    }
}
