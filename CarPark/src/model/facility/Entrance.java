package model.facility;

import java.util.Date;
import model.car.Car;
import model.card.Card;
import state.CarState;
import state.FacilityState;

public class Entrance extends AbstractFacility {

    public Entrance(int id) {
        super.id = id;
    }

    public boolean canThrough(Car<? extends Card> car, Date date) {
        return car.canPark(date);
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
        car.setState(CarState.regist);
    }
}
