public class CashDrawer {
    // Include Cash values to build a CashDrawer
    private long id;
    private int twenty;
    private int ten;
    private int five;
    private int two;
    private int one;
    private int total;

    //Build out two constructors Include all properties, and a Default

    public CashDrawer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CashDrawer(int twenty, int ten, int five, int two, int one) {
        this.twenty = twenty;
        this.ten = ten;
        this.five = five;
        this.two = two;
        this.one = one;
    }
    // Add Getter and Setter methods for the properties
    // Include a putAmount, takeAmount

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
        this.total = (20 * twenty)  + (10 * ten) + (5 * five) + (2 * two) + (1 * one);
    }

    public void putBillsInRegister(int twenty, int ten, int five, int two, int one){
        this.twenty += twenty;
        this.ten += ten;
        this.five += five;
        this.two += two;
        this.one += one;
    }

    public void takeBillsFromRegister(int twenty, int ten, int five, int two, int one){
        this.twenty -= twenty;
        this.ten -= ten;
        this.five -= five;
        this.two -= two;
        this.one -= one;
    }

    private boolean getAmountOfEachTotal(int changeAmount){
        return false;
    }

    public void makeChange(int changeAmount){
        getAmountOfEachTotal(changeAmount);
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
