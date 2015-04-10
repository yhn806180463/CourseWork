package ui;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import carPark.CarPark;

public class CarParkUI extends JFrame {

    private static final long serialVersionUID = 1L;

    public CarParkUI(CarPark carPark) {
        super();
        this.setSize(500, 700);
        
        Container container = new JPanel();
        container.setSize(500, 400);
        container.setLayout(new FlowLayout());
        container.add(new EntranceUI(carPark.getEntrances()));
        container.add(new PayStationUI(carPark.getPayStations()));
        container.add(new ExitUI(carPark.getExits()));
        
        this.setLayout(new FlowLayout());
        this.add(container);
        this.add(new ControlUI());
        
        this.add(new JButton());
        this.setTitle("Car Park");
    }
}
