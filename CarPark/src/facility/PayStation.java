package facility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import State.PayCashType;
import car.PublicCar;
import card.Card;

public class PayStation extends AbstractFacility {

    private int id;
    /*
     * use a map to store the payment of car
     */
    public Map<Card, Double> payment = new HashMap<>();

    public PayStation(int id) {
        this.id = id;
        open();
    }

    /**
     * collect cash from public car
     * 
     * @param car
     * @param payCash
     */
    public void collect(PublicCar car, List<PayCashType> payCash) {
        double pays = 0;
        for (PayCashType cash : payCash) {
            pays += cash.getMoney();
        }
        car.getCard().setAccount(pays);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Card, Double> getPayment() {
        return payment;
    }

    public void setPayment(Map<Card, Double> payment) {
        this.payment = payment;
    }
}
