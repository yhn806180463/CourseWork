package model.facility;

import model.car.Car;
import model.card.Card;

public class Exit extends AbstractFacility {

    public Exit(int id) {
        super.id = id;
    }

    /**
     * exit park
     * 
     * @param car
     * @return void
     */
    public boolean canThrough(Car<? extends Card> car) {
        return car.payCost();
    }
}
