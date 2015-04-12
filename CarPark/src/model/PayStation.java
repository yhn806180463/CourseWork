package model;

import car.Car;
import card.Card;

public class PayStation extends AbstractFacility {

    public PayStation(int id) {
        super.id = id;
    }

    /**
     * collect cash from public car and put it into public card's account
     * 
     * @param car
     * @param payCash
     */
    public void through(Car<Card> car, double pays) {
        car.getCard().setAccount(pays);
    }
}
