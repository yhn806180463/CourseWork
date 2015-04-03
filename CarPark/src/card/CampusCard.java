package card;

import java.util.Date;
import java.util.HashSet;

public class CampusCard extends Card {

    /*
     * the date should pay
     */
    public HashSet<Date> dates;

    public CampusCard(int id) {
        super(id);
    }

    /**
     * every month pay the bill, and clean the bill
     * 
     * @return void
     */
    public void payBillByMonth() {
        System.out.println("The User " + id + " should pay" + cost * dates.size() + " from salary ");
        dates.clear();
    }
}
