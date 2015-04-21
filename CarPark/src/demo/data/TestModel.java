package demo.data;

import java.util.Date;
import java.util.List;
import util.state.PayCashType;

public class TestModel {

    private int cardId;
    private String type;
    private Date enterTime;
    private Date leaveTime;
    private double account;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public List<PayCashType> getPays() {
        return pays;
    }

    public void setPays(List<PayCashType> pays) {
        this.pays = pays;
    }

    private List<PayCashType> pays;
}
