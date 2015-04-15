package control.facility;

import main.config.Config;
import main.view.SingletonModel;
import model.car.Car;
import model.card.Card;
import model.facility.Space;

public class SpaceControl extends AbstractControl<Space> {

    public SpaceControl() {
        super(SingletonModel.MainControl.getTextArea(), Integer.valueOf(Config.getProperty("space")), Space.class);
    }

    @Override
    protected void dealWithCar(Space space, Car<? extends Card> car) {
        if (space.canDeal(car)) {
            space.deal(car);
            textShow("car:" + car.getCard().getId() + " park in the space:" + space.getId());
        }
    }
}
