package model.facility;

import java.util.Date;
import util.DateUtil;
import util.state.CarState;
import util.state.FacilityState;
import util.state.FacilityType;
import model.car.Car;
import model.card.Card;

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
