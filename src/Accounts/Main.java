package Accounts;

public class Main {
    public static void main(String[] args) {
        // Declare and may implement variables
        ContaCorrente currentAccount1 = new ContaCorrente(123456, 1000, 10000);
        ContaPoupanca savingAccount1 = new ContaPoupanca(98765, 100000, 30);
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String RESET = "\u001B[0m";

        // Print currentAccount1
        System.out.println("----------CURRENT ACCOUNT ----------");
        System.out.println("Initial Valuess");
        System.out.println(currentAccount1);

        // Check verifyNumber()
        if (currentAccount1.verifyNumber()){
            System.out.println(GREEN + "Valid number, more than 5 digits" + RESET);
        } else {
            System.out.println(RED + "Invalid number, less or equal to 5 digits" + RESET);
        }

        // Check deposit()
        System.out.println("Check Deposit");
        currentAccount1.deposit(1000);
        System.out.println();

        // Check sake()
        if (currentAccount1.sake(700)){
            System.out.println(GREEN + "Saked sucessfuly" + RESET);
        } else {
            System.out.println(RED + "Not enough money" + RESET);
        }

        // Print values of currentAccount1
        System.out.println(currentAccount1);


        // Print currentAccount1
        System.out.println("\n----------SAVING ACCOUNT ----------");
        System.out.println("Initial Values");
        System.out.println(savingAccount1);

        // Check sake()
        if (savingAccount1.sake(10000)){
            System.out.println(GREEN + "Saked sucessfuly" + RESET);
        } else {
            System.out.println(RED + "Not enough money" + RESET);
        }

        // Check deposit()
        savingAccount1.deposit(10000);

        // Print savingAccount1
        System.out.println(savingAccount1);
    }
}