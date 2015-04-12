package control.card;

import model.card.StaffCard;
import config.Config;

public class StaffCardControl extends CardControl<StaffCard> {

    /**
     * create spaces, entrance, payStation, exit, ticketCards and campusCards;
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
        }
    }
}
