package model.facility;

import model.state.CarState;
import model.car.Car;
import model.card.Card;

public class Exit extends AbstractFacility {

    public Exit(int id) {
        super.id = id;
    }

    @Override
    public void deal(Car<? extends Card> car) {
        car.setState(CarState.leave);
    }

    @Override
    public boolean canDeal(Car<? extends Card> car) {
        if (car.getState() == CarState.pay) {
            return true;
        } else {
            return false;
        }
    }
}
