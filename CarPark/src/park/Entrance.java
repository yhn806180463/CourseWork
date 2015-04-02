package park;

import State.EntranceState;
import car.Car;
import card.Card;

public class Entrance {

    public int id;
    public EntranceState state;

    public Entrance(int id) {
        this.id = id;
        this.state = EntranceState.available;
    }

    public void through(Car<Card> car) {
        if (checkCar(car)) {
            System.out.println("open barrier");
        }
    }

    private boolean checkCar(Car<Card> car) {
        return true;
    }
}
