package Swift;

public class Seller extends User{
    // Declare attributes
    private double commissionRate;
    private double payment;

    // Builder methods
    public Seller(String name, int age, String cpf, double commissionRate, double payment){
        super(name, age, cpf);
        this.commissionRate = commissionRate;
        this.payment = payment;
    }

    public Seller(String name, int age, String cpf, double commissionRate){
        super(name, age, cpf);
        this.commissionRate = commissionRate;
    }

    // Setters methods
    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    // Getters method
    public double getCommissionRate() {
        return commissionRate;
    }
    public double getPayment() {
        return payment;
    }

    // Implement methods
    @Override
    public boolean login(String cpf){
        return this.cpf.equals(cpf);
    }

    // Classic Method
    public void sell(double price){
        this.payment+=price/100*commissionRate;
    }

    // Method toString()
    public String toString(){
        return super.toString() +
                "Seller{" +
                "commissionRate=" + commissionRate
                + "payment=" + payment;
    }
}
