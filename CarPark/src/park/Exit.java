package park;

import car.Car;
import card.Card;

public class Exit {

    public int id;

    public Exit(int id) {
        this.id = id;
    }

    public void through(Car<Card> car) {
        if (car.card!=null) {
            System.out.println("open barrier,car "+car.card.id);
        }
    }

}
