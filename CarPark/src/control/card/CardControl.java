package control.card;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import javax.swing.JTextArea;
import main.view.SingletonModel;
import model.card.Card;

public class CardControl<T extends Card> {

    protected Map<Integer, T> cards;
    protected JTextArea jTextArea = SingletonModel.MainControl.getTextArea();;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public boolean registCard(int id, Class t) {
        boolean sign = true;
        if(isExist(id)){
            sign = false;
        }
        try {
            Constructor<T> constructor = t.getDeclaredConstructor(Integer.class);
            cards.put(id, (T) constructor.newInstance(id));
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                 | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            sign= false;
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
