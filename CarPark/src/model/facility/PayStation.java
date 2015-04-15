package model.facility;

import java.util.Date;
import model.state.CarState;
import model.car.Car;
import model.card.Card;

public class PayStation extends AbstractFacility {

    private double money;

    public PayStation(int id) {
        super.id = id;
    }

    /**
     * collect cash from public car and put it into public card's account
     * 
     * @param car
     * @param payCash
     */
    public void collect(double money) {
        this.money = money;
    }

    @Override
    public void deal(Car<? extends Card> car) {
        car.getCard().setAccount(money);
        car.setLeaveTime(new Date());
        car.setState(CarState.unpark);
        car.payCost();
    }

    @Override
    public boolean canDeal(Car<? extends Card> car) {
        if (car.getState() == CarState.park) {
            return true;
        } else {
            return false;
        }
    }
}
