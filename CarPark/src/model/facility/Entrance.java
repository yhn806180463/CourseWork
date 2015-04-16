package model.facility;

import java.util.Date;
import model.car.Car;
import model.card.Card;
import model.state.CarState;
import model.state.FacilityState;

public class Entrance extends AbstractFacility {

    public Entrance(int id) {
        super.id = id;
    }

    public FacilityState getState() {
        return state;
    }

    public void setState(FacilityState state) {
        this.state = state;
    }

    @Override
    public void deal(Car<? extends Card> car) {
        car.setEnterTime(new Date());
        car.setState(CarState.enter);
    }

    @Override
    public boolean canDeal(Car<? extends Card> car) {
        return car.canPark(new Date()) && car.getState() == CarState.regist;
    }
}
