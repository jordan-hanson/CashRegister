package com.example.main;

import com.example.main.exceptions.CustomEmptyStringException;
import com.example.main.exceptions.InvalidAmountException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class Main {



        public static void main(String[] args) throws InvalidAmountException, IOException {
                SpringApplication.run(Main.class,
                        args);
                String input;
                int number = 0;
                Scanner scanner = new Scanner(System.in);
                do{
                        try{
                                displayMenu();
                        } catch(Exception e){
                                System.out.println("Display menu error with " + e.getMessage());
                        }

                        input = scanner.nextLine();
                        try {
                                checkForEmptyString(input);
                        } catch (CustomEmptyStringException e) {
                                System.out.println(e.getMessage());
                        }
                        try {
                                number = processInput(input);
                        } catch (NumberFormatException e) {
                                System.out.println("Process string to integer error with " + e.getMessage());
                        }

                } while (number == 0);

                try{
                        isValid(number);
                }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        displayMenu();
                        return;
                }

                //Initialize a CashDrawer Object: All int values default to 0
                CashDrawer cashDrawer = new CashDrawer();
                StringBuilder show = new StringBuilder("");
                int[] values = processValues(scanner);
                cashDrawer.putBillsInCashDrawer(values[0], values[1], values[2], values[3], values[4]);
                cashDrawer.setTotal();
                show.replace(0, show.length(), cashDrawer.toString());
                System.out.println(show);


                int numberInput = 0;

                while(numberInput < 5) {
                        try {
                                displayAllMenuOptions();
                        } catch (Exception e) {
                                System.out.println("Display menu error with " + e.getMessage());
                        }

                        numberInput = scanner.nextInt();

                        try {
                                isValidHigherRange(numberInput);
                        } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                        }
                        displayResult(numberInput, cashDrawer, scanner);
                }

        }

        public static void displayMenu() {
                System.out.println();
                System.out.println("*******Welcome to the CashRegister!*******");
                System.out.println();
                System.out.println("The cash register was initialized with no bills inside your cash drawer. \n" +
                        "First Put bills in each denomination in: $20's $10's $5's $2's $1's, or exit the program. \n" +
                        "After each transaction I'll show you how much is available with the current cash drawer.");
                System.out.println();
                System.out.println("Enter a number option 1 or 2");
                System.out.println("1. Put bills in the CashDrawer");
                System.out.println("2. Exit program");
                System.out.println();
                System.out.print(">");

        }

        public static void displayAllMenuOptions() {
                System.out.println();
                System.out.println("*******Continue with your CashRegister!*******");
                System.out.println();
                System.out.println(" You can put bills into your cash drawer in each denomination as before, show your current amount,\n" +
                        " or remove some number of each. If you need to make change we can give you that also. \n" +
                        " Remember you are only able to take or make change if we have that amount available. \n" +
                        " If you run into an error for insufficient amounts, try to put more bills into the register before trying to continue.");
                System.out.println();
                System.out.println("Enter a number between 1-5:");
                System.out.println("1. Show the current number of each denomination");
                System.out.println("2. Put bills in the CashDrawer");
                System.out.println("3. Takes bills from the CashDrawer");
                System.out.println("4. Return Change for some amount.");
                System.out.println("5. Exit the program");
                System.out.println();
                System.out.print(">");

        }

        private static void displayResult(int number, CashDrawer cashDrawer, Scanner scanner) throws FileNotFoundException, IOException, InvalidAmountException {
                // display result
                StringBuilder show = new StringBuilder("");
                switch (number) {
                        case 1:
                                cashDrawer.setTotal();
                                show.replace(0, show.length(), cashDrawer.toString());
                                System.out.println(show);
                                break;
                        case 2:
                                int[] valuesToPut = processValues(scanner);
                                cashDrawer.putBillsInCashDrawer(valuesToPut[0], valuesToPut[1], valuesToPut[2], valuesToPut[3], valuesToPut[4]);
                                cashDrawer.setTotal();
                                show.replace(0, show.length(), cashDrawer.toString());
                                System.out.println(show);
                                break;
                        case 3:
                                int[] valuesToTake = processValues(scanner);
                                cashDrawer.takeBillsFromCashDrawer(valuesToTake[0], valuesToTake[1], valuesToTake[2], valuesToTake[3], valuesToTake[4]);
                                cashDrawer.setTotal();
                                show.replace(0, show.length(), cashDrawer.toString());
                                System.out.println(show);
                                break;
                        case 4:
                                CashDrawer changeFromCashDrawer = new CashDrawer();
                                System.out.println("What is the total amount in dollars you want in change? Example: For $10 input 10");
                                int changeInput = scanner.nextInt();
                                int[] changeLeftOver = cashDrawer.makeChange(changeInput);
                                cashDrawer.takeBillsFromCashDrawer(changeLeftOver[0], changeLeftOver[1], changeLeftOver[2], changeLeftOver[3], changeLeftOver[4]);
                                changeFromCashDrawer.putBillsInCashDrawer(changeLeftOver[0], changeLeftOver[1], changeLeftOver[2], changeLeftOver[3], changeLeftOver[4]);
                                String showChangeAmountDrawer = changeFromCashDrawer.changeDrawerString();
                                System.out.println("This is the change amount you are receiving.");
                                System.out.println(showChangeAmountDrawer);
                                cashDrawer.setTotal();
                                show.replace(0, show.length(), cashDrawer.toString());
                                System.out.println("This is the total you have left in the register.");
                                System.out.println(show);
                                break;
                        case 5:
                                System.out.println("Have a great day!");
                                break;
                        default:
                                System.out.println("Input not recognized.");
                                break;
                }
        }

        public static boolean isValid(int cleanNumber){

                // otherwise return true
                if(cleanNumber >= 1 && cleanNumber <= 2){
                        return true;
                } else {
                        throw new IllegalArgumentException("Number must be 1 or 2.");
                }
        }

        public static boolean isValidHigherRange(int cleanNumber){

                // otherwise return true
                if(cleanNumber >= 1 && cleanNumber <= 5){
                        return true;
                } else {
                        throw new IllegalArgumentException("Number must be between 1 - 5.");
                }
        }

        // With message: "Invalid input: Empty string entered."
        public static void checkForEmptyString(String input) throws CustomEmptyStringException {

                if(input.length() < 1){
                        throw new CustomEmptyStringException("Invalid input: Empty string entered.");
                }
        }

        // only turn the input from a String into an int
        public static int processInput(String input) {
                int convertedInteger = 0;

                if(Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 2){
                        convertedInteger = Integer.parseInt(input);
                } else {
                        throw new NumberFormatException("Not a valid number");
                }

                return convertedInteger;
        }

        public static boolean verifyNoNegativeNumbers(int inputNumber){
                // otherwise return true
                if(inputNumber >= 0){
                        return true;
                } else {
                        throw new IllegalArgumentException("Number must be at least 0.");
                }
        }

        public static int[] processValues(Scanner scanner){

                int[] valuesToAdd = new int[5];
                String[] availableAmounts = new String[]{"$20's", "$10's", "$5's", "$2's", "$1's"};

                for (int i = 0; i < availableAmounts.length; i++) {
                        System.out.println("Input how many bills in " + availableAmounts[i]);
                        int amount = scanner.nextInt();
                        try{
                                verifyNoNegativeNumbers(amount);
                        } catch(IllegalArgumentException e){
                                System.out.println(e.getMessage());
                                processValues(scanner);
                        }
                        valuesToAdd[i] = amount;
                }

                return valuesToAdd;
        }

}
