package model.card;

import model.state.CardState;

public abstract class Card {

    protected int id;
    protected double account = 0;
    protected CardState state;

    public Card(int id) {
        this.id = id;
        this.state = CardState.available;
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

    public CardState getState() {
        return state;
    }

    public void setState(CardState state) {
        this.state = state;
    }
}
