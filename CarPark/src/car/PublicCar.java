package car;

import java.util.Date;
import card.TicketCard;

public class PublicCar extends Car<TicketCard> {

    public PublicCar(TicketCard card) {
        super(card);
    }

    @Override
    public double countCost() {
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

    @Override
    public boolean canPark(Date date) {
        int day = date.getDay();
        if (0 == day || 6 == day) {
            return true;
        }
        return false;
    }
}
