package control.facility;

import main.config.Config;
import main.view.SingletonModel;
import model.car.Car;
import model.card.Card;
import model.facility.Entrance;

public class EntranceControl extends AbstractControl<Entrance> {

    public EntranceControl() {
        super(SingletonModel.Entrance.getTextArea(), Integer.valueOf(Config.getProperty("entrance")), Entrance.class);
    }

    @Override
    protected void dealWithCar(Entrance entrance, Car<? extends Card> car) {
        // check available of car
        if (entrance.canDeal(car)) {
            entrance.deal(car);
            textShow("Entrance:" + entrance.getId() + " open barrier,card id:" + car.getCard().getId());
        } else {
            textShow("this car can't park,card id: " + car.getCard().getId());
        }
        textShow("------------");
    }
}
