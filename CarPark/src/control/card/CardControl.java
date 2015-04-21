package control.card;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import util.state.CardState;
import main.view.SingletonModel;
import model.card.Card;

public class CardControl<T extends Card> {

    protected List<T> cards = new ArrayList<>();
    protected JTextArea jTextArea = SingletonModel.MainControl.getTextArea();;

    /**
     * register a new card
     * 
     * @param id
     * @param c
     * @return boolean
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public boolean registerCard(int id, Class c) {
        boolean sign = true;
        if (isExist(id)) {
            sign = false;
        }
        try {
            Constructor<T> constructor = c.getDeclaredConstructor(Integer.class);
            cards.add((T) constructor.newInstance(id));
        } catch (Exception e) {
            System.out.println("create card control error");
            sign = false;
        }
        return sign;
    }

    /**
     * check whether the special card exist
     * 
     * @param id
     * @return boolean
     */
    public boolean isExist(int id) {
        if (getCard(id) == null) {
            return false;
        }
        return true;
    }

    public T getCard(int id) {
        for (T card : cards) {
            if (card.getId() == id) {
                return card;
            }
        }
        return null;
    }

    /**
     * count the amount of available card
     * 
     * @return int
     */
    public int getAvailableAmount() {
        int amount = cards.size();
        for (T card : cards) {
            if (card.getState() != CardState.available) {
                amount--;
            }
        }
        return amount;
    }

    protected void textShow(String string) {
        jTextArea.append(string + "\n");
    }
}
