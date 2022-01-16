

public class Main {
        public static void main(String[] args){
                System.out.println("ready");
                // TODO update the property access modifiers of each class object

                //Build a CashDrawer Object and Define Default values of 0
                CashDrawer cashDrawer = new CashDrawer(0, 0, 0, 0, 0);

                // Set the first Value to Test
                int dollarAmount = 10;
                cashDrawer.setTwenty(dollarAmount);

                // Update the Total Property on the CashDrawer Object
                cashDrawer.setTotal();

                //
                String showOutput = cashDrawer.toString();
                System.out.println(showOutput);

        }
}
