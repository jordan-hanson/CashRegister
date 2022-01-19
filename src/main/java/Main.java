

import java.util.Scanner;

public class Main {
        public static void main(String[] args){

                System.out.println("ready");
                System.out.println("");
                // TODO update the property access modifiers of each class object

                //Initialize a CashDrawer Object: All int values default to 0
                CashDrawer cashDrawer = new CashDrawer();

                System.out.println("put 1 2 3 4 5");
                cashDrawer.putBillsInRegister(1, 2, 3, 4, 5);
                cashDrawer.setTotal();
                String showCashDrawer = cashDrawer.toString();
                System.out.println(showCashDrawer); // $68 1 2 3 4 5

                System.out.println();
                System.out.println("show");
                System.out.println(showCashDrawer);

                System.out.println();
                System.out.println("put 1 2 3 0 5");
                cashDrawer.putBillsInRegister(1, 2, 3, 0, 5);
                cashDrawer.setTotal();
                showCashDrawer = cashDrawer.toString();
                System.out.println(showCashDrawer); // $128 2 4 6 4 10

                System.out.println();
                System.out.println("take 1 4 3 0 10");
                cashDrawer.takeBillsFromRegister(1, 4, 3, 0, 10);
                cashDrawer.setTotal();
                showCashDrawer = cashDrawer.toString();
                System.out.println(showCashDrawer); // $43 1 0 3 4 0

                System.out.println();
                System.out.println("change 11");
                System.out.println(cashDrawer.getTotal());


                Scanner scanner = new Scanner(System.in);


        }
}
