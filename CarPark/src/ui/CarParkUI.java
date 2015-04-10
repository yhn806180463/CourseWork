package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import carPark.CarPark;

public class CarParkUI extends JFrame {

    private static final long serialVersionUID = 1L;

    public CarParkUI() {
        super();
        JPanel entranceUI = SingletonModel.Entrance.getJPanel();
        JPanel payStationUI = SingletonModel.PayStation.getJPanel();
        JPanel exitUI = SingletonModel.Exit.getJPanel();
        JPanel controlUI = SingletonModel.Control.getJPanel();
        entranceUI.setPreferredSize(new Dimension(200, 300));
        payStationUI.setPreferredSize(new Dimension(200, 300));
        exitUI.setPreferredSize(new Dimension(200, 300));
        controlUI.setPreferredSize(new Dimension(600, 400));
        this.add(entranceUI, BorderLayout.WEST);
        this.add(payStationUI, BorderLayout.CENTER);
        this.add(exitUI, BorderLayout.EAST);
        this.add(controlUI, BorderLayout.SOUTH);
        this.setTitle("Car Park");
        CarPark carPark = new CarPark();
        carPark.refreshData();
    }
}
