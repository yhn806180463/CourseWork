package card;

import java.util.Date;
import java.util.HashSet;

public class CampusCard extends Card {

    // the date should pay
    private HashSet<Date> dates;
    private double monthBill;

    public CampusCard(int id) {
        super(id);
    }

    @Override
    public boolean pay(Double bill) {
        dates.add(new Date());
        monthBill += bill;
        return true;
    }

    /**
     * every month pay the bill, and clean the monthBill
     * 
     * @return void
     */
    public void payBillByMonth() {
        System.out.println("The User " + id + " should pay " + monthBill + " from salary " + account);
        dates.clear();
    }

    public HashSet<Date> getDates() {
        return dates;
    }

    public void setDates(HashSet<Date> dates) {
        this.dates = dates;
    }

    public double getMonthBill() {
        return monthBill;
    }

    public void setMonthBill(double monthBill) {
        this.monthBill = monthBill;
    }
}
