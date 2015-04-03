package car;

import card.CampusCard;

public class StaffCar extends Car<CampusCard> {

    public StaffCar(CampusCard card) {
        super(card);
    }

    @Override
    public double countCost() {
        return 1;
    }
}
