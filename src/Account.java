public abstract class Account {
    // Declare Attributes
    protected int number;
    protected double balance;

    // Methods, Builder:
    public Account(int number, double balance){
        this.number = number;
        this.balance = balance;
    }

    // Methods, getters:
    public int getNumber(){
        return this.number;
    }
    public double getBalance(){
        return this.balance;
    }

    // Methods, abstract:
    public abstract boolean sake(double value);
    public abstract void deposit(double value);

    // Method
    public boolean verifyNumber(){
        if(Integer.toString(this.number).length() > 5){
            return true;
        }
        return false;
    }

    // Methods, toString()

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", balance=" + balance +
                '}';
    }
}
