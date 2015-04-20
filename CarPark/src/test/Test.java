package test;

import java.util.List;
import javax.swing.JFrame;
import main.view.CarParkUI;
import model.car.PublicCar;
import model.car.StaffCar;
import model.card.PublicCard;
import model.card.StaffCard;
import test.data.TestData;
import test.model.TestModel;
import util.DateUtil;
import control.card.PublicCardControl;
import control.card.StaffCardControl;
import control.facility.EntranceControl;
import control.facility.ExitControl;
import control.facility.PayStationControl;
import control.facility.SpaceControl;

public class Test {

    public static void main(String[] arg) throws InterruptedException {
        uiTest();
    }

    public static void uiTest() throws InterruptedException {
        // create UI
        CarParkUI ui = new CarParkUI();
        ui.setSize(600, 700);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
        // create controllers
        EntranceControl entranceControl = new EntranceControl();
        ExitControl exitControl = new ExitControl();
        PayStationControl payStationControl = new PayStationControl();
        SpaceControl spaceControl = new SpaceControl();
        StaffCardControl staffCardControl = new StaffCardControl();
        PublicCardControl publicCardControl = new PublicCardControl();
        // set current date to test
        DateUtil.setSystemDate("2015-4-19");
        // read test data from xml
        List<TestModel> list = TestData.readCarData();
        // for every test data ,run whole flow
        for (TestModel testModel : list) {
            if (testModel.getType().equals("PublicCar")) {
                PublicCard card = publicCardControl.getAnAvailableCard();
                PublicCar car = new PublicCar(card);
                car.setEnterTime(testModel.getEnterTime());
                car.setLeaveTime(testModel.getLeaveTime());
                entranceControl.through(car);
                spaceControl.through(car);
                payStationControl.collect(testModel.getPays());
                payStationControl.through(car);
                exitControl.through(car);
            } else if (testModel.getType().equals("StaffCar")) {
                StaffCard card = staffCardControl.getCard(testModel.getCardId());
                card.setAccount(testModel.getAccount());
                StaffCar car = new StaffCar(card);
                car.setEnterTime(testModel.getEnterTime());
                car.setLeaveTime(testModel.getLeaveTime());
                entranceControl.through(car);
                spaceControl.through(car);
                payStationControl.through(car);
                exitControl.through(car);
            }
        }
        //test others
        //staff cards pay bill by month
        staffCardControl.allStaffsPayBill();
        //public cards show detail
        publicCardControl.showDetail();
    }
}
