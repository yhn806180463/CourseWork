package car;

import java.util.Date;
import card.StaffCard;

public class StaffCar extends Car<StaffCard> {

    public StaffCar(StaffCard card) {
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
