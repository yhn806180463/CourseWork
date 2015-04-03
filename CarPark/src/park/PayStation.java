package park;

import java.util.HashMap;
import java.util.Map;
import State.CarState;
import State.PayCash;
import car.Car;
import car.PublicCar;
import car.StaffCar;
import card.Card;

public class PayStation {

    public int id;
    /*
     * use a map to store the payment of car
     */
    public Map<Card, Double> payment = new HashMap<>();

    public PayStation(int id) {
        this.id = id;
    }

    public void through(Car<Card> car) {}

    /**
     * Public should pay a list of cash
     * 
     * @param car
     * @param cashs
     * @return void
     */
    public void collectPublicCar(PublicCar car, PayCash[] cashs) {
      
    }

    public void collectStaffCar(StaffCar car) {}
}
