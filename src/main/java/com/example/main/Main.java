package com.example.main;

import com.example.main.exceptions.InvalidAmountException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main {

        public static void main(String[] args) throws InvalidAmountException {
                SpringApplication.run(Main.class,
                        args);

                System.out.println("ready");
                System.out.println("");

                //Initialize a CashDrawer Object: All int values default to 0
                CashDrawer cashDrawer = new CashDrawer();

                System.out.println("put 1 2 3 4 5");
                cashDrawer.putBillsInCashDrawer(1, 2, 3, 4, 5);
                cashDrawer.setTotal();
                String showCashDrawer = cashDrawer.toString();
                System.out.println(showCashDrawer); // $68 1 2 3 4 5

                System.out.println();
                System.out.println("show");
                System.out.println(showCashDrawer);

                System.out.println();
                System.out.println("put 1 2 3 0 5");
                cashDrawer.putBillsInCashDrawer(1, 2, 3, 0, 5);
                cashDrawer.setTotal();
                showCashDrawer = cashDrawer.toString();
                System.out.println(showCashDrawer); // $128 2 4 6 4 10

                System.out.println();
                System.out.println("take 1 4 3 0 8");
                cashDrawer.takeBillsFromCashDrawer(1, 4, 3, 0, 8);
                cashDrawer.setTotal();
                showCashDrawer = cashDrawer.toString();
                System.out.println(showCashDrawer); // $43 1 0 3 4 0

                System.out.println();
                System.out.println("change 13");
                CashDrawer changeFromCashDrawer = new CashDrawer();
                int[] changeLeftOver = cashDrawer.makeChange(13);
                cashDrawer.takeBillsFromCashDrawer(changeLeftOver[0], changeLeftOver[1], changeLeftOver[2], changeLeftOver[3], changeLeftOver[4]);
                changeFromCashDrawer.putBillsInCashDrawer(changeLeftOver[0], changeLeftOver[1], changeLeftOver[2], changeLeftOver[3], changeLeftOver[4]);
                String showChangeAmountDrawer = changeFromCashDrawer.changeDrawerString();
                System.out.println(showChangeAmountDrawer);
                cashDrawer.setTotal();
                showCashDrawer = cashDrawer.toString();
                System.out.println(showCashDrawer);// $33 1 0 1 4 0


                Scanner scanner = new Scanner(System.in);
        }
}
