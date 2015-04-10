package ui;

import javax.swing.JFrame;
import carPark.CarPark;

public class Windows {

    public static void main(String args[]) {
        CarPark carPark = new CarPark();
        CarParkUI ui = new CarParkUI(carPark);
        ui.setSize(600, 700);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }
}
