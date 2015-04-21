package control.facility;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import util.state.FacilityState;
import util.state.FacilityType;
import model.car.Car;
import model.card.Card;
import model.facility.AbstractFacility;

public abstract class AbstractControl<T extends AbstractFacility> {

    // the view to show info
    protected JTextArea jTextArea;
    // the list of special facilities in park
    protected List<T> facilities = new ArrayList<>();
    protected FacilityType type;

    /**
     * construct to create a list of special facility
     * 
     * @param jTextArea
     * @param amount
     * @param cla
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected AbstractControl(JTextArea jTextArea, int amount, Class cla) {
        this.jTextArea = jTextArea;
        T t = null;
        try {
            for (int i = 1; i <= amount; i++) {
                Constructor<T> constructor = cla.getDeclaredConstructor(int.class);
                t = constructor.newInstance(i);
                facilities.add(t);
            }
            this.type = t.getType();
            openAll();
            showDetail();
        } catch (Exception e) {
            System.out.println("create facility control error");
        }
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

    public void through(Car<? extends Card> car) {
        T facilitiy = getAvailableOne();
        if (facilitiy == null) {
            textShow("none available");
            return;
        }
        dealWithCar(facilitiy, car);
    }

    protected abstract void dealWithCar(T facility, Car<? extends Card> car);

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
    protected void textShow() {
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
        textShow("==> " + type + " Datail<==");
        textShow("Total amount:" + getTotalAmount());
        textShow("Available amount:" + getAvailableAmount());
        StringBuffer availableIds = new StringBuffer();
        StringBuffer unAvailableIds = new StringBuffer();
        for (T facility : facilities) {
            if (facility.getState() == FacilityState.available) {
                availableIds.append(facility.getId() + " ");
            } else {
                unAvailableIds.append(facility.getId() + " ");
            }
        }
        if (availableIds.length() != 0) {
            textShow("The " + type + " id:" + availableIds + " is available");
        }
        if (unAvailableIds.length() != 0) {
            textShow("The " + type + " id:" + unAvailableIds + " is not available");
        }
        textShow("=========");
    }
}
