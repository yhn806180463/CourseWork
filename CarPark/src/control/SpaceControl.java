package control;

import model.Space;
import view.SingletonModel;
import car.Car;
import card.Card;
import config.Config;

public class SpaceControl extends BaseControl<Space> {

    public SpaceControl() {
        super(SingletonModel.MainControl.getTextArea(), Integer.valueOf(Config.getProperty("space")), Space.class);
    }

    @Override
    public void dealWithCar(Space space, Car<Card> car) {
        car.park(space);
        textShow("car:" + car.getCard().getId() + " park in the space:" + space.getId());
    }
}
