package facility;

import State.FacilityState;

/**
 * 
 */
public abstract class AbstractFacility {

    private FacilityState state;

    public FacilityState getState() {
        return state;
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
}
