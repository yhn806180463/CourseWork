package model.car;

import java.util.Date;
import model.card.Card;
import model.state.CarState;

public abstract class Car<T extends Card> {

    protected T card;
    protected Date enterTime;
    protected Date leaveTime;
    protected CarState state;

    public Car(T card) {
        if (card != null) {
            this.card = card;
            this.state = CarState.regist;
        }
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
    public void payCost() {
        if (card.pay(countCost())) {
            this.state = CarState.pay;
        }
    }

    public T getCard() {
        return card;
    }

    public void setCard(T card) {
        this.card = card;
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
