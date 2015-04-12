package control;

import java.util.Map;
import javax.swing.JTextArea;
import view.SingletonModel;
import card.PublicCard;
import card.StaffCard;
import config.Config;

public class MainControl {

    private Map<Integer, PublicCard> publicCards;
    private Map<Integer, StaffCard> staffCards;
    private JTextArea jTextArea = SingletonModel.MainControl.getTextArea();;

    /**
     * create spaces, entrance, payStation, exit, ticketCards and campusCards;
     */
    public MainControl() {
        for (int i = 1; i <= Integer.valueOf(Config.getProperty("publiccard")); i++) {
            PublicCard card = new PublicCard(i);
            publicCards.put(i, card);
        }
        for (int i = 1; i <= Integer.valueOf(Config.getProperty("staffcard")); i++) {
            StaffCard card = new StaffCard(i);
            staffCards.put(i, card);
        }
    }

    /**
     * every staff pay bill
     * 
     */
    public void staffPayBill() {
        for (StaffCard card : staffCards.values()) {
            card.payBillByMonth();
        }
    }

    protected void textShow(String string) {
        jTextArea.append(string + "\n");
    }
}
