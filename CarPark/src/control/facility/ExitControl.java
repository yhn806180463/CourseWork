package control.facility;

import main.config.Config;
import main.view.SingletonModel;
import model.car.Car;
import model.card.Card;
import model.facility.Exit;

public class ExitControl extends AbstractControl<Exit> {

    public ExitControl() {
        super(SingletonModel.Exit.getTextArea(), Integer.valueOf(Config.getProperty("exit")), Exit.class);
    }

    @Override
    protected void dealWithCar(Exit exit, Car<? extends Card> car) {
        // check the payment
        if (exit.canDeal(car)) {
            exit.deal(car);
            textShow("Exit:" + exit.getId() + " open barrier,card id:" + car.getCard().getId());
        } else {
            textShow("Can't exit,didn't pay enough,card id:" + car.getCard().getId() + " Need to pay "
                     + car.countCost());
        }
        textShow("------------");
    }
}
