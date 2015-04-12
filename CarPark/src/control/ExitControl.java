package control;

import java.util.Date;
import car.Car;
import card.Card;
import model.Exit;
import view.SingletonModel;
import config.Config;

public class ExitControl extends BaseControl<Exit> {

    public ExitControl() {
        super(SingletonModel.Exit.getTextArea(), Integer.valueOf(Config.getProperty("exit")), Exit.class);
    }

    @Override
    public void dealWithCar(Exit exit, Car<Card> car) {
        Date date = new Date();
        car.setLeaveTime(date);
        // check the payment
        if (exit.canThrough(car)) {
            textShow("open barrier,car:" + car.getCard().getId());
        } else {
            textShow("Can't exit,didn't pay,car " + car.getCard().getId());
        }
    }
}
