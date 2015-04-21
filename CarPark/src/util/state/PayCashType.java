package util.state;

public enum PayCashType {
    FIFTY(0.5), ONE(1), TWO(2);

    private double money;

    private PayCashType(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
