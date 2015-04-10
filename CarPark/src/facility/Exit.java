package facility;

import java.util.Date;
import ui.SingletonModel;
import car.Car;
import card.Card;

public class Exit extends AbstractFacility {

    public Exit(int id) {
        super.id = id;
        this.jTextArea = SingletonModel.Exit.getTextArea();
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
