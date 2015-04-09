package park;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import State.PayCashType;
import car.PublicCar;
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

    /**
     * 
     * @param car
     * @param payCash
     */
    public void payCost(PublicCar car, List<PayCashType> payCash) {
        double pays = 0;
        for (PayCashType cash : payCash) {
            pays += cash.getMoney();
        }
        car.card.pay(pays, car.leaveTime);
    }
}
