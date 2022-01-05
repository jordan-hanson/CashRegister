import java.util.Scanner;

public class Main {
        /*
         * Cash register initialized with 0 0 0 0 0
         * PUT bills of 1 2 3 4 5
         * Print the Total and values of each
         *
         * int[] register (array of cash)
         */


        public static void main(String[] args){
                System.out.println("ready");

                // use a Scanner for input from command line string
                Scanner scanner = new Scanner(System.in);

                // number values for a scanner is scanner.nextInt
                scanner.nextLine();

                int[] register = new int[]{0, 0, 0, 0, 0};
                // possibly use a 2D array for a header but use Object to initialize with to use more than one type
                // OR make a toString method in the Cash class to print the values of each dollar value
                // {20's, 10's, 5's, 2's, 1's} so we can print the header with the value ??
                // access with register[indexValue]

                // loop through a scanner input loop for each value with index add the value to index of the register
                // 1 2 3 4 5
                // Then loop through our register and add the values.
                // display the results

        }
}
