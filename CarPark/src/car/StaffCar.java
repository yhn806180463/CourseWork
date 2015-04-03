package car;

import card.CampusCard;

public class StaffCar extends Car<CampusCard> {

    public StaffCar(CampusCard card) {
        super(card);
    }

    public void payByBill() {}

    @Override
    public double countCost() {
        return 1;
    }
}
