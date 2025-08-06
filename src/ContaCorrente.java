public class ContaCorrente extends Account{
    // Attributes:
    private final double limit;

    // Methods, builder
    public ContaCorrente(int number, double balance, double limit){
        super(number, balance);
        this.limit = limit;
    }

    //Methods, getter
    public double getLimit(){
        return this.limit;
    }

    // Implement Methods:
    public boolean sake(double value){
        if (value <= super.balance + this.limit){
            super.balance -= value;
            return true;
        }
        return false;
    }

    public void deposit(double value){
        super.balance += value;
    }

    // Methods, toString()

    @Override
    public String toString() {
        return super.toString() + "ContaCorrente{" +
                "limit=" + limit +
                '}';
    }
}
