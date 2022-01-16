public class CashDrawer {
    // Include Cash values to build a CashDrawer Array of a Cash Register
    int twenty;
    int ten;
    int five;
    int two;
    int one;
    int total;

    //Build out two constructors Include all properties, and a Default

    public CashDrawer() {
    }

    public CashDrawer(int twenty, int ten, int five, int two, int one) {
        this.twenty = twenty;
        this.ten = ten;
        this.five = five;
        this.two = two;
        this.one = one;
    }
    // Add Getter and Setter methods for the properties
    // Include a putAmount, takeAmount, and showCashDrawer

    public int getTwenty() {
        return twenty;
    }

    public void setTwenty(int twenty) {
        this.twenty = twenty;
    }

    public int getTen() {
        return ten;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public int getFive() {
        return five;
    }

    public void setFive(int five) {
        this.five = five;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal() {
        this.total = twenty + ten + five + two + one;
    }

    @Override
    public String toString() {
        return "$" + total +
                " " + twenty +
                " " + ten +
                " " + five +
                " " + two +
                " " + one;
    }
}
