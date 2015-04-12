package test;

import javax.swing.JFrame;
import view.CarParkUI;
import control.facility.EntranceControl;
import control.facility.ExitControl;
import control.facility.PayStationControl;
import control.facility.SpaceControl;

public class Test {

    public static void main(String[] arg) throws InterruptedException {
        // CarPark carPark = new CarPark();
        // CampusCard card = new CampusCard(1);
        // Car car = new StaffCar(card);
        // carPark.refreshData();
        // carPark.parkCar(car);
        // Thread.sleep(1000);
        // carPark.unparkCar(car);
        
        CarParkUI ui = new CarParkUI();
        ui.setSize(600, 700);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
        
        /*
         * CarPark carPark = new CarPark(); carPark.refreshData();
         */
        EntranceControl entranceControl = new EntranceControl();
        ExitControl exitControl = new ExitControl();
        PayStationControl payStationControl = new PayStationControl();
        SpaceControl spaceControl = new SpaceControl();
        
    }
}
