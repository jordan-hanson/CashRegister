import com.fasterxml.jackson.annotation.JsonProperty;

public class DollarBills {
    @JsonProperty("one")
    private double one;
    @JsonProperty("two")
    private int two;
    @JsonProperty("five")
    private double five;
    @JsonProperty("ten")
    private int ten;
    @JsonProperty("twenty")
    private int twenty;

    public double getOne() {
        return one;
    }

    public void setOne(double one) {
        this.one = one;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public double getFive() {
        return five;
    }

    public void setFive(double five) {
        this.five = five;
    }

    public int getTen() {
        return ten;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public int getTwenty() {
        return twenty;
    }

    public void setTwenty(int twenty) {
        this.twenty = twenty;
    }
}
