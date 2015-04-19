package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import javax.swing.JFrame;
import test.data.CarData;
import test.model.TestModel;
import main.view.CarParkUI;
import model.car.Car;
import model.car.PublicCar;
import model.card.Card;
import model.card.PublicCard;
import model.state.PayCashType;
import control.card.PublicCardControl;
import control.card.StaffCardControl;
import control.facility.EntranceControl;
import control.facility.ExitControl;
import control.facility.PayStationControl;
import control.facility.SpaceControl;

public class Test {

    public static void main(String[] arg) {
        carDataTest();
    }

    public static void uiTest(String[] arg) throws InterruptedException {
        //
        CarParkUI ui = new CarParkUI();
        ui.setSize(600, 700);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
        //
        EntranceControl entranceControl = new EntranceControl();
        ExitControl exitControl = new ExitControl();
        PayStationControl payStationControl = new PayStationControl();
        SpaceControl spaceControl = new SpaceControl();
        StaffCardControl staffCardControl = new StaffCardControl();
        PublicCardControl publicCardControl = new PublicCardControl();
        //
        int id = 1;
        List<PayCashType> cashs = new ArrayList<>();
        cashs.add(PayCashType.FIFTY);
        cashs.add(PayCashType.ONE);
        cashs.add(PayCashType.TWO);
        //
        PublicCard card = publicCardControl.getCard(id);
        PublicCar car = new PublicCar(card);
        entranceControl.through(car);
        spaceControl.through(car);
        payStationControl.collect(cashs);
        payStationControl.through(car);
        exitControl.through(car);
    }

    public static void carDataTest() {
        List<TestModel> list = CarData.readCarData();
    }
}
