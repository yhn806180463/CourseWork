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
            cards.add(card);
        }
    }

    /**
     * every staff pay bill
     * 
     */
    public void allStaffsPayBill() {
        textShow("===> This month staffs need to pay <===");
        for (StaffCard card : cards) {
            if (card.getMonthBill() != 0) {
                textShow("The staff card:" + card.getId() + " should pay " + card.getMonthBill());
                card.payBillByMonth();
            }
        }
    }
}
