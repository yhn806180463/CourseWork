package card;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class CampusCard extends Card {

    /*
     * the date should pay
     */
    public HashSet<Date> dates;

    public CampusCard(int id) {
        super(id);
    }
    
    /**
     * owner should pay the cost
     * 
     * @param date
     * @return List<Double>
     */
    public List<Double> payCost(Date date){
        dates.add(date);
        List<Double> pays = new ArrayList<>();
        pays.add((double) 1);
        return pays;
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
