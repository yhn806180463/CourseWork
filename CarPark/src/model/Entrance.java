package model;

import java.util.Date;
import car.Car;
import card.Card;
import State.FacilityState;

public class Entrance extends AbstractFacility {

    public Entrance(int id) {
        super.id = id;
    }

    public boolean canThrough(Car<Card> car, Date date) {
        return car.canPark(date);
    }

    public FacilityState getState() {
        return state;
    }

    public void setState(FacilityState state) {
        this.state = state;
    }
}
