package Accounts;

public class ContaPoupanca extends  Account{
    // Attributes:
    private int numAniv;

    // Methods, builder
    public ContaPoupanca(int number, double balance, int numAniv){
        super(number, balance);
        this.numAniv = numAniv;
    }

    // Methods, abstracted
    public boolean sake(double value){
        if (value <=super.balance){
            super.balance -=value;
            return true;
        }
        return false;
    }

    // Methods, abstract
    public void deposit(double value){
        super.balance+=value;
        this.numAniv++;
    }

    // Methods, toString()
    @Override
    public String toString(){
        return super.toString() + "Accounts.ContaPoupanca={" +
                "numAniv=" +
                +numAniv
                + "}";
    }

}
