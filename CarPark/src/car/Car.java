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

    public void pay(List<Double> moneyList) {
        double totalMoney = 0;
        for (double money : moneyList) {
            totalMoney += money;
        }
        if (totalMoney >= countCost()) {
            System.out.println("already paied " + card.id);
        }
    };

    public abstract double countCost();
}
