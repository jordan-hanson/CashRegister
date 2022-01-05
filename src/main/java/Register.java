import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Register {

    @JsonProperty("dollarBills")
    private DollarBills dollarBills;

    public DollarBills getDollarBills() {
        return dollarBills;
    }

    public void setDollarBills(DollarBills dollarBills) {
        this.dollarBills = dollarBills;
    }
}
