package test;

import car.Car;
import car.StaffCar;
import carPark.CarPark;
import card.StaffCard;

public class Test {

    public static void main(String[] arg) throws InterruptedException {
        CarPark carPark = new CarPark();
        //CampusCard card = new CampusCard(1);
        //Car car = new StaffCar(card);
        carPark.refreshData();
        //carPark.parkCar(car);
        //Thread.sleep(1000);
        //carPark.unparkCar(car);
    }
}
