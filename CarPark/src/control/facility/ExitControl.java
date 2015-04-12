package control.facility;

import java.util.Date;
import model.car.Car;
import model.card.Card;
import model.facility.Exit;
import view.SingletonModel;
import config.Config;

public class ExitControl extends AbstractControl<Exit> {

    public ExitControl() {
        super(SingletonModel.Exit.getTextArea(), Integer.valueOf(Config.getProperty("exit")), Exit.class);
    }

    @Override
    protected void dealWithCar(Exit exit, Car<? extends Card> car) {
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