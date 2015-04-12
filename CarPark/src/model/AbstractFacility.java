package model;

import state.FacilityState;

/**
 * 
 */
public abstract class AbstractFacility {

    protected int id;
    protected FacilityState state;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FacilityState getState() {
        return state;
    }
}
