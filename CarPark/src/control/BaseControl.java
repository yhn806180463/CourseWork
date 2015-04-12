package control;

import java.lang.reflect.Constructor;
import java.util.List;
import javax.swing.JTextArea;
import model.AbstractFacility;
import state.FacilityState;
import car.Car;
import card.Card;

public abstract class BaseControl<T extends AbstractFacility> {

    // the view to show info
    protected JTextArea jTextArea;
    // the list of special facilities in park
    protected List<T> facilities;

    /**
     * construct to create a list of special facility
     * 
     * @param jTextArea
     * @param amount
     * @param cla
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected BaseControl(JTextArea jTextArea, int amount, Class cla) {
        this.jTextArea = jTextArea;
        try {
            for (int i = 1; i <= amount; i++) {
                Constructor<T> constructor = cla.getDeclaredConstructor(int.class);
                facilities.add((T) constructor.newInstance(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        openAll();
    }

    /**
     * get an available model
     * 
     * @return T
     */
    private T getAvailableOne() {
        for (T facility : facilities) {
            if (facility.getState() == FacilityState.available) {
                return facility;
            }
        }
        return null;
    }

    /**
     * count the amount of available model
     * 
     * @return int
     */
    public int getAvailableAmount() {
        int amount = facilities.size();
        for (T facility : facilities) {
            if (facility.getState() == FacilityState.unavailable) {
                amount--;
            }
        }
        return amount;
    }

    /**
     * count the amount of all model
     * 
     * @return int
     */
    public int getTotalAmount() {
        return facilities.size();
    }

    public void through(Car<Card> car) {
        T facilitiy = getAvailableOne();
        if (facilitiy == null) {
            textShow("none available");
            return;
        }
        dealWithCar(facilitiy, car);
    }

    public abstract void dealWithCar(T facility, Car<Card> car);

    public void openAll() {
        for (T facility : facilities) {
            facility.open();
        }
    }

    public void closeAll() {
        for (T facility : facilities) {
            facility.close();
        }
    }

    /**
     * clear all the text
     */
    public void textClear() {
        jTextArea.setText("");
    }

    /**
     * append the text to view
     * 
     * @param string
     * @return void
     */
    protected void textShow(String string) {
        jTextArea.append(string + "\n");
    }

    /**
     * append all state of facilities to view
     * 
     * @return void
     */
    public void showDetail() {
        textShow("Total amount:" + getTotalAmount());
        textShow("Available amount:" + getAvailableAmount());
        for (T facility : facilities) {
            if (facility.getState() == FacilityState.available) {
                textShow("The id:" + facility.getId() + " is available");
            } else {
                textShow("The id:" + facility.getId() + " is not available");
            }
        }
    }
}
