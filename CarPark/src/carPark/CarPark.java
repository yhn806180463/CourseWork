package carPark;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import model.AbstractFacility;
import model.Entrance;
import model.Exit;
import model.PayStation;
import model.Space;
import view.SingletonModel;
import State.FacilityState;
import car.Car;
import card.StaffCard;
import card.Card;
import card.PublicCard;
import config.Config;

public class CarPark {

    private List<Space> spaces = new ArrayList<>();
    private List<Entrance> entrances = new ArrayList<>();
    private List<PayStation> payStations = new ArrayList<>();
    private List<Exit> exits = new ArrayList<>();
    private List<PublicCard> ticketCards = new ArrayList<>();
    private List<StaffCard> campusCards = new ArrayList<>();
    private int spaceAmount = Integer.valueOf(Config.getProperty("space"));
    private int entranceAmount = Integer.valueOf(Config.getProperty("entrance"));
    private int payStationAmount = Integer.valueOf(Config.getProperty("paystation"));
    private int exitAmount = Integer.valueOf(Config.getProperty("exit"));
    private int ticketCardAmount = Integer.valueOf(Config.getProperty("ticketcard"));
    private int campusCardAmount = Integer.valueOf(Config.getProperty("campuscard"));
    private JTextArea jTextArea = SingletonModel.MainControl.getTextArea();;

    /**
     * create spaces, entrance, payStation, exit, ticketCards and campusCards;
     */
    public CarPark() {
        try {
            build(spaces, spaceAmount, Space.class);
            build(entrances, entranceAmount, Entrance.class);
            build(payStations, payStationAmount, PayStation.class);
            build(exits, exitAmount, Exit.class);
            build(ticketCards, ticketCardAmount, PublicCard.class);
            build(campusCards, campusCardAmount, StaffCard.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private <T> void build(List<T> list, int amount, Class cla) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        for (int i = 1; i <= amount; i++) {
            Constructor<T> constructor = cla.getDeclaredConstructor(int.class);
            list.add((T) constructor.newInstance(i));
        }
    }

    public void refreshData() {
        int availableSpaceAmount = checkFacilityAvailable(spaces);
        if (availableSpaceAmount == 0) {
            for (Entrance entrance : entrances) {
                entrance.close();
            }
        }
        int availableEntranceAmount = checkFacilityAvailable(entrances);
        int availablePayStationAmount = checkFacilityAvailable(payStations);
        int availableExitAmount = checkFacilityAvailable(exits);
        jTextArea.append("Total space:" + spaceAmount + ", available:" + availableSpaceAmount + "\n");
        jTextArea.append("Total entrance:" + entranceAmount + ", available:" + availableEntranceAmount + "\n");
        jTextArea.append("Total payStation:" + payStationAmount + ", available:" + availablePayStationAmount + "\n");
        jTextArea.append("Total exitAmount:" + exitAmount + ", available:" + availableExitAmount + "\n");
        jTextArea.append("Total ticketCard:" + ticketCardAmount);
        jTextArea.append("Total campusCard:" + campusCardAmount);
        // if park is full ,close all entrances
    }

    private int checkFacilityAvailable(List<? extends AbstractFacility> facilities) {
        int availableAmount = facilities.size();
        for (AbstractFacility facility : facilities) {
            String facilityName = facility.getClass().getSimpleName() + " id:" + facility.getId();
            if (facility.getState() == FacilityState.unavailable) {
                jTextArea.append(facilityName + " is unavailable" + "\n");
                availableAmount -= 1;
            } else {
                jTextArea.append(facilityName + " is available" + "\n");
            }
        }
        return availableAmount;
    }

    /**
     * assign a space to the car
     * 
     * @param car
     * @return void
     */
    public void parkCar(Car<Card> car) {
        for (Space space : spaces) {
            if (space.getState() == FacilityState.available) {
                jTextArea.append("space " + space.getId() + " park the card id " + car.getCard().getId() + "\n");
                car.park(space);
                break;
            }
        }
        refreshData();
    }

    /**
     * remove the space of the car
     * 
     * @param car
     * @return void
     */
    public void unparkCar(Car<Card> car) {
        car.unpark();
        refreshData();
    }

    /**
     * every staff pay bill
     * 
     * @return void
     */
    public void staffPayBill() {
        for (StaffCard card : campusCards) {
            card.payBillByMonth();
        }
    }

    public List<Space> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<Space> spaces) {
        this.spaces = spaces;
    }

    public List<Entrance> getEntrances() {
        return entrances;
    }

    public void setEntrances(List<Entrance> entrances) {
        this.entrances = entrances;
    }

    public List<PayStation> getPayStations() {
        return payStations;
    }

    public void setPayStations(List<PayStation> payStations) {
        this.payStations = payStations;
    }

    public List<Exit> getExits() {
        return exits;
    }

    public void setExits(List<Exit> exits) {
        this.exits = exits;
    }

    public List<PublicCard> getTicketCards() {
        return ticketCards;
    }

    public void setTicketCards(List<PublicCard> ticketCards) {
        this.ticketCards = ticketCards;
    }

    public List<StaffCard> getCampusCards() {
        return campusCards;
    }

    public void setCampusCards(List<StaffCard> campusCards) {
        this.campusCards = campusCards;
    }

    public int getSpaceAmount() {
        return spaceAmount;
    }

    public void setSpaceAmount(int spaceAmount) {
        this.spaceAmount = spaceAmount;
    }

    public int getEntranceAmount() {
        return entranceAmount;
    }

    public void setEntranceAmount(int entranceAmount) {
        this.entranceAmount = entranceAmount;
    }

    public int getPayStationAmount() {
        return payStationAmount;
    }

    public void setPayStationAmount(int payStationAmount) {
        this.payStationAmount = payStationAmount;
    }

    public int getExitAmount() {
        return exitAmount;
    }

    public void setExitAmount(int exitAmount) {
        this.exitAmount = exitAmount;
    }

    public int getTicketCardAmount() {
        return ticketCardAmount;
    }

    public void setTicketCardAmount(int ticketCardAmount) {
        this.ticketCardAmount = ticketCardAmount;
    }

    public int getCampusCardAmount() {
        return campusCardAmount;
    }

    public void setCampusCardAmount(int campusCardAmount) {
        this.campusCardAmount = campusCardAmount;
    }
}
