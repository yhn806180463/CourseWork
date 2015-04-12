package model;

import car.Car;
import card.Card;

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
    public boolean canThrough(Car<Card> car) {
        return car.payCost();
    }
}
