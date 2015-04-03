package State;

public enum PayCash {
    FIFTY(0.5), ONE(1), TWO(2);

    private double money;

    private PayCash(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
