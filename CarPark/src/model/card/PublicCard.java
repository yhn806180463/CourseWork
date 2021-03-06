package model.card;

public class PublicCard extends Card {

    public PublicCard(int id) {
        super(id);
    }

    /**
     * pay by cash,can't change
     */
    @Override
    public boolean pay(Double bill) {
        if (bill <= account) {
            account = 0;
            return true;
        }
        return false;
    }
}
