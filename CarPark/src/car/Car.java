package car;

import java.util.Date;
import state.CarState;
import model.Space;
import card.Card;

public abstract class Car<T extends Card> {

    protected T card;
    protected Space space;
    protected Date enterTime;
    protected Date leaveTime;
    protected CarState state;

    public Car(T card) {
        this.card = card;
        this.state = CarState.unpark;
    }

    /**
     * park the car at one space
     * 
     * @param space
     * @return void
     */
    public void park(Space space) {
        this.state = CarState.park;
        this.space = space;
        space.close();
    }

    /**
     * unpark the car from the space
     * 
     * @return void
     */
    public void unpark() {
        this.state = CarState.unpark;
        this.space.open();
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

    /**
     * use card account to pay the cost
     * 
     * @return
     * @return boolean
     */
    public boolean payCost() {
        return card.pay(countCost());
    }

    public T getCard() {
        return card;
    }

    public void setCard(T card) {
        this.card = card;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public CarState getState() {
        return state;
    }

    public void setState(CarState state) {
        this.state = state;
    }
}
