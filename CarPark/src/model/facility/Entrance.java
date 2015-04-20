package model.facility;

import java.util.Date;
import util.DateUtil;
import model.car.Car;
import model.card.Card;
import model.state.CarState;
import model.state.FacilityState;
import model.state.FacilityType;

public class Entrance extends AbstractFacility {

    public Entrance(int id) {
        super(FacilityType.Entrance);
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
        return car.canPark(DateUtil.getSystemDate()) && car.getState() == CarState.regist;
    }
}
