package car;

import card.CampusCard;


public class StaffCar extends Car<CampusCard> {

    public StaffCar(CampusCard card) {
        super(card);
    }

    /**
     * flat pay
     */
    @Override
    public double pay() {
        return 1;
    }
}
