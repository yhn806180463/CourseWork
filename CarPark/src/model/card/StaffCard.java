package model.card;

import java.util.Date;
import java.util.HashSet;
import util.DateUtil;

public class StaffCard extends Card {

    // the dates should pay
    private HashSet<Date> dates = new HashSet<>();
    private double monthBill = 0;

    public StaffCard(int id) {
        super(id);
    }

    @Override
    public boolean pay(Double bill) {
        dates.add(DateUtil.getSystemDate());
        monthBill += bill;
        return true;
    }

    /**
     * every month pay the bill, and clean the monthBill
     * 
     * @return void
     */
    public void payBillByMonth() {
        account -= monthBill;
        monthBill = 0;
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
