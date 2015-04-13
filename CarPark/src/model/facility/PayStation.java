package model.facility;

import model.car.Car;
import model.card.Card;

public class PayStation extends AbstractFacility {

    private double money;

    public PayStation(int id) {
        super.id = id;
    }

    /**
     * collect cash from public car and put it into public card's account
     * 
     * @param car
     * @param payCash
     */
    public void through(double money) {
        this.money = money;
    }

    @Override
    public void deal(Car<? extends Card> car) {
        car.getCard().setAccount(money);
    }
}
