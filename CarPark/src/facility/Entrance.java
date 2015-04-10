package facility;

import java.util.Date;
import State.FacilityState;
import car.Car;
import card.Card;

public class Entrance extends AbstractFacility {

    private FacilityState state;

    public Entrance(int id) {
        super.id = id;
        open();
    }

    /**
     * enter the park
     * 
     * @param car
     * @return void
     */
    public void through(Car<Card> car) {
        Date date = new Date();
        // check available of entrance
        if (state != FacilityState.available) {
            System.out.println("Entrance isn't available");
            return;
        }
        // check available of car
        if (car.canPark(date)) {
            car.setEnterTime(date);
            System.out.println("Entrance open barrier,car " + car.getCard().getId());
        } else {
            System.out.println("this car can't park,card id: " + car.getCard().getId());
        }
    }

    public FacilityState getState() {
        return state;
    }

    public void setState(FacilityState state) {
        this.state = state;
    }
}
