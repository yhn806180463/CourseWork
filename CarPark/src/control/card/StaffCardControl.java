package control.card;

import main.config.Config;
import model.card.StaffCard;

public class StaffCardControl extends CardControl<StaffCard> {

    /**
     * create staff cards
     */
    public StaffCardControl() {
        for (int i = Integer.valueOf(Config.getProperty("card.staff.start")); i <= Integer.valueOf(Config.getProperty("card.staff.end")); i++) {
            StaffCard card = new StaffCard(i);
            cards.put(i, card);
        }
    }

    /**
     * every staff pay bill
     * 
     */
    public void staffPayBill() {
        for (StaffCard card : cards.values()) {
            card.payBillByMonth();
            textShow("The card:" + card.getId() + " should pay " + card.getMonthBill());
        }
    }
}
