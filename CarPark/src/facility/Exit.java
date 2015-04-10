package facility;

import java.util.Date;
import car.Car;
import card.Card;

public class Exit extends AbstractFacility {

    public Exit(int id) {
        super.id = id;
        open();
    }

    /**
     * exit park
     * 
     * @param car
     * @return void
     */
    public void through(Car<Card> car) {
        Date date = new Date();
        car.setLeaveTime(date);
        // check the payment
        if (car.payCost()) {
            System.out.println("Exit open barrier,car " + car.getCard().getId());
        } else {}
    }
}
