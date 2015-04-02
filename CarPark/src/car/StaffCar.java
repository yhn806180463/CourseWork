package car;

import card.CampusCard;
import card.Card;


public class StaffCar extends Car<CampusCard> implements Parking {

    public StaffCar(Card card) {
        super(card);
    }

    /**
     * flat pay
     */
    @Override
    public float pay() {
        // TODO Auto-generated method stub
        return 0;
    }
}
