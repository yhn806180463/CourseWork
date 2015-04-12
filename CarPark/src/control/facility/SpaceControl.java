package control.facility;

import model.car.Car;
import model.card.Card;
import model.facility.Space;
import view.SingletonModel;
import config.Config;

public class SpaceControl extends AbstractControl<Space> {

    public SpaceControl() {
        super(SingletonModel.MainControl.getTextArea(), Integer.valueOf(Config.getProperty("space")), Space.class);
    }

    @Override
    protected void dealWithCar(Space space, Car<? extends Card> car) {
        car.park(space);
        textShow("car:" + car.getCard().getId() + " park in the space:" + space.getId());
    }
}
