package model.facility;

import model.car.Car;
import model.card.Card;

public class Space extends AbstractFacility {

    private int id;
    private Car<Card> car;

    public Space(int id) {
        this.id = id;
        open();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car<Card> getCar() {
        return car;
    }

    public void setCar(Car<Card> car) {
        this.car = car;
    }
}
