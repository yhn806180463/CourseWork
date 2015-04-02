package test;

import park.CarPark;
import car.Car;
import car.StaffCar;
import card.CampusCard;
import card.Card;

public class Test {

    public static void main(String[] arg) throws InterruptedException {
        CarPark carPark = new CarPark();
        Card card = new CampusCard(1);
        Car car = new StaffCar(card);
        carPark.refreshData();
        carPark.parkCar(car);
        Thread.sleep(1000);
        carPark.unparkCar(car);
       
    }
}
