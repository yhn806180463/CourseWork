package facility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ui.SingletonModel;
import State.PayCashType;
import car.PublicCar;
import card.Card;

public class PayStation extends AbstractFacility {

    /*
     * use a map to store the payment of car
     */
    public Map<Card, Double> payment = new HashMap<>();

    public PayStation(int id) {
        super.id = id;
        this.jTextArea = SingletonModel.PayStation.getTextArea();
        open();
    }

    /**
     * collect cash from public car and put it into public card's account
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

    public Map<Card, Double> getPayment() {
        return payment;
    }

    public void setPayment(Map<Card, Double> payment) {
        this.payment = payment;
    }
}
