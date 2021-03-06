package model.facility;

import util.state.CarState;
import util.state.FacilityState;
import util.state.FacilityType;
import model.car.Car;
import model.card.Card;

public class Space extends AbstractFacility {

    private int id;
    private Car<? extends Card> car;

    public Space(int id) {
        super(FacilityType.Space);
        this.id = id;
        open();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car<? extends Card> getCar() {
        return car;
    }

    public void setCar(Car<Card> car) {
        this.car = car;
    }

    @Override
    public void deal(Car<? extends Card> car) {
        car.setState(CarState.park);
        this.car = car;
        this.state = FacilityState.unavailable;
    }

    @Override
    public boolean canDeal(Car<? extends Card> car) {
        if (car.getState() == CarState.enter) {
            return true;
        } else {
            return false;
        }
    }
}
