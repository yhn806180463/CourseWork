package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import carPark.CarPark;

public class CarParkUI extends JFrame {

    private static final long serialVersionUID = 1L;

    public CarParkUI(CarPark carPark) {
        super();
        EntranceUI entranceUI = new EntranceUI(carPark.getEntrances());
        PayStationUI payStationUI = new PayStationUI(carPark.getPayStations());
        ExitUI exitUI = new ExitUI(carPark.getExits());
        ControlUI controlUI = new ControlUI();
        entranceUI.setPreferredSize(new Dimension(200, 300));
        payStationUI.setPreferredSize(new Dimension(200, 300));
        exitUI.setPreferredSize(new Dimension(200, 300));
        controlUI.setPreferredSize(new Dimension(600, 400));
        this.add(entranceUI, BorderLayout.WEST);
        this.add(payStationUI, BorderLayout.CENTER);
        this.add(exitUI, BorderLayout.EAST);
        this.add(controlUI, BorderLayout.SOUTH);
        this.setTitle("Car Park");
    }
}
