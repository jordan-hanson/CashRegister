

public class Main {
        public static void main(String[] args){
                System.out.println("ready");
                // TODO update the property access modifiers of each class object

                //Build a CashDrawer Object and Define Default values of 0
                CashDrawer cashDrawer = new CashDrawer(0, 0, 0, 0, 0);

                // Update the Total Property on the CashDrawer Object
                cashDrawer.setTotal();

                // Show the totals
                String showOutput = cashDrawer.toString();
                System.out.println(showOutput);
        }
}
