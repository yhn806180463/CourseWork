package carPark;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import State.FacilityState;
import car.Car;
import card.StaffCard;
import card.Card;
import card.PublicCard;
import config.Config;
import facility.AbstractFacility;
import facility.Entrance;
import facility.Exit;
import facility.PayStation;
import facility.Space;

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
        System.out.println("Total space:" + spaceAmount + ", available:" + availableSpaceAmount);
        System.out.println("Total entrance:" + entranceAmount + ", available:" + availableEntranceAmount);
        System.out.println("Total payStation:" + payStationAmount + ", available:" + availablePayStationAmount);
        System.out.println("Total exitAmount:" + exitAmount + ", available:" + availableExitAmount);
        System.out.println("Total ticketCard:" + ticketCardAmount);
        System.out.println("Total campusCard:" + campusCardAmount);
        // if park is full ,close all entrances
    }

    private int checkFacilityAvailable(List<? extends AbstractFacility> facilities) {
        int availableAmount = facilities.size();
        for (AbstractFacility facility : facilities) {
            String facilityName = facility.getClass().getSimpleName() + " id:" + facility.getId();
            if (facility.getState() == FacilityState.unavailable) {
                System.out.println(facilityName + " is unavailable");
                availableAmount -= 1;
            } else {
                System.out.println(facilityName + " is available");
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
        for (StaffCard card : campusCards) {
            card.payBillByMonth();
        }
    }
}
