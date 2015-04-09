package card;

import java.util.Date;

public abstract class Card {

    public int id;
    public double cost;

    public Card(int id) {
        this.id = id;
    }

    public abstract boolean pay(Double money, Date date);
}
