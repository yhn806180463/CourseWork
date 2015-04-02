package car;

import card.CampusCard;
import card.Card;


public class StaffCar extends Car<CampusCard> {

    public StaffCar(CampusCard card) {
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
