package model.car;

import java.util.Date;
import model.card.PublicCard;

public class PublicCar extends Car<PublicCard> {

    public PublicCar(PublicCard card) {
        super(card);
    }

    @Override
    public double countCost() {
        if (leaveTime == null) {
            leaveTime = new Date();
        }
        long liveTime = leaveTime.getTime() - enterTime.getTime();
        int hour = (int) (liveTime / 60 / 60 / 1000);
        switch (hour / 2) {
            case 0:
                return 0.5;
            case 1:
                return 1;
            case 2 | 3:
                return 2;
            case 4 | 5:
                return 3;
            default:
                return 5;
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean canPark(Date date) {
        int day = date.getDay();
        // can park in weekend
        if (0 == day || 6 == day) {
            return true;
        }
        // TODO can park in holiday
        return false;
    }
}
