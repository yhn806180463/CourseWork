package car;

import java.util.Date;
import park.Space;
import State.CarState;
import State.SpaceState;
import card.Card;

public abstract class Car<T extends Card> {

    public Card card;
    public Space space;
    public Date enterTime;
    public Date leaveTime;
    public CarState state;

    public Car(Card card) {
        this.card = card;
        this.state = CarState.unpark;
    }

    public void park(Space space) {
        enterTime = new Date();
        System.out.println(enterTime);
        state = CarState.park;
        space.state = SpaceState.full;
        this.space = space;
    }

    public void unpark() {
        leaveTime = new Date();
        System.out.println(leaveTime);
        state = CarState.unpark;
        space.state = SpaceState.empty;
        space = null;
    }
}
