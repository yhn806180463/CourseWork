package card;

public abstract class Card {

    protected int id;
    protected double account = 0;

    public Card(int id) {
        this.id = id;
    }

    /**
     * use card's account to pay the bill
     * 
     * @param bill
     * @return
     * @return boolean
     */
    public abstract boolean pay(Double bill);

    @Override
    public boolean equals(Object object) {
        Card card = (Card) object;
        if (this.id == card.id) {
            return true;
        } else {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }
}
