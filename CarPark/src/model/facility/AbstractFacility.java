package model.facility;

import model.car.Car;
import model.card.Card;
import model.state.FacilityState;
import model.state.FacilityType;

/**
 * 
 */
public abstract class AbstractFacility {

    protected int id;
    protected FacilityState state;
    protected FacilityType type;

    protected AbstractFacility(FacilityType type) {
        this.type = type;
    }

    /**
     * this facility is available
     * 
     * @return void
     */
    public void open() {
        state = FacilityState.available;
    }

    /**
     * this facility is not available
     * 
     * @return void
     */
    public void close() {
        state = FacilityState.unavailable;
    }

    public abstract boolean canDeal(Car<? extends Card> car);

    public abstract void deal(Car<? extends Card> car);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FacilityState getState() {
        return state;
    }

    public FacilityType getType() {
        return type;
    }
}
