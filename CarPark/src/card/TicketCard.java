package card;

import java.util.ArrayList;
import java.util.List;
import State.PayCashType;

public class TicketCard extends Card {

    public TicketCard(int id) {
        super(id);
    }

    /**
     * owner should pay the cost
     * 
     * @param payCash
     * @return List<Double>
     */
    public List<Double> payCoust(List<PayCashType> payCash) {
        List<Double> pays = new ArrayList<>();
        for (PayCashType cash : payCash) {
            pays.add(cash.getMoney());
        }
        return pays;
    }
}
