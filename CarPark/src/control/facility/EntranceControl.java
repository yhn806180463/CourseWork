package control.facility;

import java.util.Date;
import model.car.Car;
import model.card.Card;
import model.facility.Entrance;
import view.SingletonModel;
import config.Config;

public class EntranceControl extends AbstractControl<Entrance> {

    public EntranceControl() {
        super(SingletonModel.Entrance.getTextArea(), Integer.valueOf(Config.getProperty("entrance")), Entrance.class);
    }

    @Override
    protected void dealWithCar(Entrance entrance, Car<? extends Card> car) {
        Date date = new Date();
        // check available of car
        if (entrance.canThrough(car, date)) {
            entrance.deal(car);
            textShow("open barrier,car:" + car.getCard().getId());
        } else {
            textShow("this car can't park,card id: " + car.getCard().getId());
        }
    }
}
