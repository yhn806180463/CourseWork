package facility;

import javax.swing.JTextArea;
import State.FacilityState;

/**
 * 
 */
public abstract class AbstractFacility {

    protected int id;
    private FacilityState state;
    protected JTextArea jTextArea;

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

    public void setState(FacilityState state) {
        this.state = state;
    }
}
