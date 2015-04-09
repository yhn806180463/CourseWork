package car;

import java.util.Date;
import card.CampusCard;

public class StaffCar extends Car<CampusCard> {

    public StaffCar(CampusCard card) {
        super(card);
    }

    @Override
    public double countCost() {
        return 1;
    }

    @Override
    public boolean canPark(Date date) {
        return true;
    }
}
