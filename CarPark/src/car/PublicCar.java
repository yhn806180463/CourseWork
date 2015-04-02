package car;

import card.Card;
import card.TicketCard;


public class PublicCar extends Car<TicketCard> implements Parking {

    
    
    public PublicCar(Card card) {
        super(card);
    }

    /**
     * pay by time
     */
    @Override
    public float pay() {
        // TODO Auto-generated method stub
        return 0;
    }
    
    
}
