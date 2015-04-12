package control;

import java.util.Date;
import model.Entrance;
import view.SingletonModel;
import car.Car;
import card.Card;
import config.Config;

public class EntranceControl extends BaseControl<Entrance> {

    public EntranceControl() {
        super(SingletonModel.Entrance.getTextArea(), Integer.valueOf(Config.getProperty("entrance")), Entrance.class);
    }

    @Override
    public void dealWithCar(Entrance entrance, Car<Card> car) {
        Date date = new Date();
        // check available of car
        if (entrance.canThrough(car, date)) {
            car.setEnterTime(date);
            textShow("open barrier,car:" + car.getCard().getId());
        } else {
            textShow("this car can't park,card id: " + car.getCard().getId());
        }
    }
}
