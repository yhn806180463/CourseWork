package park;

import java.util.HashMap;
import java.util.Map;
import State.PayCash;
import car.Car;
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

    public void collect(Car<Card> car,PayCash cash){
        double bill = car.pay();
        double alreadyPay = payment.get(car.card);
        
    }
}
