package carPark;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import State.FacilityState;
import car.Car;
import card.CampusCard;
import card.Card;
import card.TicketCard;
import config.Config;
import facility.Entrance;
import facility.Exit;
import facility.PayStation;
import facility.Space;

public class CarPark {

    private List<Space> spaces = new ArrayList<>();
    private List<Entrance> entrances = new ArrayList<>();
    private List<PayStation> payStations = new ArrayList<>();
    private List<Exit> exits = new ArrayList<>();
    private List<TicketCard> ticketCards = new ArrayList<>();
    private List<CampusCard> campusCards = new ArrayList<>();
    private int spaceAmount = Integer.valueOf(Config.getProperty("space"));
    private int entranceAmount = Integer.valueOf(Config.getProperty("entrance"));
    private int payStationAmount = Integer.valueOf(Config.getProperty("paystation"));
    private int exitAmount = Integer.valueOf(Config.getProperty("exit"));
    private int ticketCardAmount = Integer.valueOf(Config.getProperty("ticketcard"));
    private int campusCardAmount = Integer.valueOf(Config.getProperty("campuscard"));

    /**
     * construct
     */
    public CarPark() {
        try {
            build(spaces, spaceAmount, Space.class);
            build(entrances, entranceAmount, Entrance.class);
            build(payStations, payStationAmount, PayStation.class);
            build(exits, exitAmount, Exit.class);
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
        System.out.println("spaceTotal:" + spaceAmount);
        System.out.println("entranceTotal:" + entranceAmount);
        System.out.println("payStationTotal:" + payStationAmount);
        System.out.println("exitAmountTotal:" + exitAmount);
        int emptySpaceAmount = spaceAmount;
        for (Space space : spaces) {
            if (space.getState() == FacilityState.available) {
                System.out.println("space " + space.getId() + " is empty");
            } else {
                System.out.println("space " + space.getId() + " is full");
                emptySpaceAmount -= 1;
            }
        }
        // if park is full ,close all entrances
        if (emptySpaceAmount == 0) {
            for (Entrance entrance : entrances) {
                entrance.close();
            }
        }
        for (Entrance entrance : entrances) {
            if (entrance.getState() == FacilityState.unavailable) {
                System.out.println("entrance " + entrance.getId() + " is close");
            } else {
                System.out.println("entrance " + entrance.getId() + " is open");
            }
        }
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
                System.out.println("space " + space.getId() + " park the card id " + car.getCard().getId());
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
        for (CampusCard card : campusCards) {
            card.payBillByMonth();
        }
    }
}
