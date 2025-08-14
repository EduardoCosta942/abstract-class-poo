package Swift;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // Declare attributes
        boolean got_caught;
        String returned;
        Scanner scanner = new Scanner(System.in);
        Seller[] sellers = new Seller[10];
        Costumer[] costumers = new Costumer[10];
        int sellerCount = 0;
        int costumerCount = 0;
        int choice;
        String authenticator;
        boolean isAuthenticated;


        choice = 0;
        do {
            do {
                got_caught = false;
                System.out.println(menu());
                returned = validateChoice(1,3,scanner);
                try{
                    choice = Integer.parseInt(returned);
                } catch (NumberFormatException nfe){
                    System.out.println(returned + ". Statement: " + nfe);
                    got_caught = true;
                }
            } while (got_caught);

            if (choice == 1){ // Employee
                do {
                    got_caught = false;
                    System.out.println(insideMenu());
                    returned = validateChoice(1,2, scanner);
                    try{
                        choice = Integer.parseInt(returned);
                    } catch (NumberFormatException nfe){
                        System.out.println(returned + ". Statement: " + nfe);
                        got_caught = true;
                    }
                } while (got_caught);

                if (choice == 1){ // Seller's Login
                    System.out.println("Type your cpf: ");
                    authenticator = scanner.next();
                    isAuthenticated = false;
                    for (int x = 0; x < sellerCount; x++){
                        if (sellers[x].login(authenticator)){
                            System.out.println("Login successful. Welcome " + sellers[x].getName());

                            // Action
                            boolean sellerMenu = true;
                            while (sellerMenu) {
                                System.out.println("""
                                        Select an action:
                                        [1] Sell a product
                                        [2] View total payment
                                        [3] Logout
                                        Your choice:""");
                                String sellerChoice = validateChoice(1,3,scanner);
                                if (sellerChoice.equals("1")) {
                                    System.out.print("Product price: ");
                                    double price = scanner.nextDouble();
                                    sellers[x].sell(price);
                                    System.out.println("Sale registered! Commission updated.");
                                } else if (sellerChoice.equals("2")) {
                                    System.out.println("Total payment: " + sellers[x].getPayment());
                                } else {
                                    sellerMenu = false;
                                }
                            }
                            break;
                        }
                    }
                    if (!isAuthenticated) System.out.println("Invalid CPF.");

                } else { // SIGN-UP SELLER
                    System.out.print("Name: ");
                    String name = scanner.next();
                    scanner.next();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    System.out.print("CPF: ");
                    String cpf = scanner.next();
                    System.out.print("Commission Rate (%): ");
                    double commissionRate = scanner.nextDouble();
                    sellers[sellerCount++] = new Seller(name, age, cpf, commissionRate);
                    System.out.println("Seller registered successfully!");
                }

            } else if (choice == 2){ // Costumer
                do {
                    got_caught = false;
                    System.out.println(insideMenu());
                    returned = validateChoice(1,2, scanner);
                    try{
                        choice = Integer.parseInt(returned);
                    } catch (NumberFormatException nfe){
                        System.out.println(returned + ". Statement: " + nfe);
                        got_caught = true;
                    }
                } while (got_caught);

                if (choice == 1){ // LOGIN COSTUMER
                    System.out.print("Type your password: ");
                    authenticator = scanner.next();
                    isAuthenticated = false;
                    for (int x = 0; x < costumerCount; x++){
                        if (costumers[x].login(authenticator)){
                            isAuthenticated = true;
                            System.out.println("Login successful. Welcome " + costumers[x].getName());

                            // ADIÇÃO: opções após login do Costumer
                            boolean costumerMenu = true;
                            while (costumerMenu) {
                                System.out.println("""
                                        Select an action:
                                        [1] Buy a product
                                        [2] View spent money
                                        [3] Logout
                                        Your choice:""");
                                String costumerChoice = validateChoice(1,3,scanner);
                                if (costumerChoice.equals("1")) {
                                    System.out.print("Product name: ");
                                    String product = scanner.next();
                                    System.out.print("Product price: ");
                                    double price = scanner.nextDouble();
                                    costumers[x].buy(product, price, 0, 0); // posição simples por enquanto
                                    System.out.println("Purchase registered!");
                                } else if (costumerChoice.equals("2")) {
                                    System.out.println("Total spent: " + costumers[x].getSpentMoney());
                                } else {
                                    costumerMenu = false;
                                }
                            }
                            break;
                        }
                    }
                    if (!isAuthenticated) System.out.println("Invalid password.");

                } else { // Sing-up costumer
                    System.out.print("Name: ");
                    String name = scanner.next();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    scanner.next();
                    System.out.print("CPF: ");
                    String cpf = scanner.next();
                    System.out.print("Password: ");
                    String password = scanner.next();
                    costumers[costumerCount++] = new Costumer(name, age, cpf, password);
                    System.out.println("Costumer registered successfully!");
                }
            }
        } while (choice != 3);
        scanner.close();
    }

    public static String menu(){
        return """
                            Welcome to Swift
                ----------------------------------------
                Select the option that matches your role
                [1] Employee
                [2] Costumer
                [3] Leave
                Your choice:
                """;
    }

    public static String validateChoice(int min, int max, Scanner scanner){
        try{
            int choice = scanner.nextInt();
            if (choice < min || choice > max ) throw new IllegalArgumentException("Choose an option of the list");
            return String.valueOf(choice);
        } catch (InputMismatchException ime){
            scanner.next(); // limpa buffer
            return "The input type must be a number";
        } catch (IllegalArgumentException iae){
            return iae.getMessage();
        }
    }

    public static String insideMenu(){
        return """
                            Welcome to Swift
                ----------------------------------------
                Select the action you want
                [1] Login
                [2] Sign-up
                Your choice:
                """;
    }
}