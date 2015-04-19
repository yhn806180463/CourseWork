package control.card;

import java.lang.reflect.Constructor;
import java.util.Map;
import javax.swing.JTextArea;
import main.view.SingletonModel;
import model.card.Card;

public class CardControl<T extends Card> {

    protected Map<Integer, T> cards;
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
            cards.put(id, (T) constructor.newInstance(id));
        } catch (Exception e) {
            e.printStackTrace();
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
        return cards.get(id);
    }

    protected void textShow(String string) {
        jTextArea.append(string + "\n");
    }
}
