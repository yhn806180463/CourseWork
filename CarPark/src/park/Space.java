package park;

import State.SpaceState;
import car.Car;
import card.Card;

public class Space {

    public int id;
    public Car<Card> car;
    public SpaceState state;

    public Space(int id) {
        this.id = id;
        state = SpaceState.empty;
    }
    
    public void park() {
        state = SpaceState.full;
    }
    
    public void unpark() {
        state = SpaceState.empty;
    }
}
