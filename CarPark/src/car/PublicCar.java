package car;

import State.PayCash;
import card.TicketCard;

public class PublicCar extends Car<TicketCard> {

    public PublicCar(TicketCard card) {
        super(card);
    }

    /**
     * pay by time
     */
    public void payByCash(PayCash[] cashs) {
        double alreadyPay = 0;
        for (PayCash cash : cashs) {
            alreadyPay += cash.getMoney();
        }
        if (alreadyPay >= countCost()) {
            System.out.println("this car paied." + card.id);
        }
    }

    @Override
    public double countCost() {
        unpark();
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
}
