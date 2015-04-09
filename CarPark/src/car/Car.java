package car;

import java.util.Date;
import java.util.List;
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

    public void park(Space space, Date date) {
        if (!canPark(date)) {
            System.out.println("unavailable");
            return;
        }
        this.enterTime = date;
        this.state = CarState.park;
        this.space.state = SpaceState.full;
        this.space = space;
    }

    public void unpark(Date date) {
        this.leaveTime = date;
        this.state = CarState.unpark;
        this.space.state = SpaceState.empty;
        this.space = null;
    }


    /**
     * count the cost of the car
     * 
     * @return double
     */
    public abstract double countCost();

    /**
     * check if it can park
     * 
     * @param date
     * @return boolean
     */
    public abstract boolean canPark(Date date);
}
