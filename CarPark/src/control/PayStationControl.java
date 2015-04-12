package control;

import java.util.List;
import model.PayStation;
import state.PayCashType;
import view.SingletonModel;
import car.Car;
import card.Card;
import card.PublicCard;
import config.Config;

public class PayStationControl extends BaseControl<PayStation> {

    private double pays;

    public PayStationControl() {
        super(SingletonModel.PayStation.getTextArea(), Integer.valueOf(Config.getProperty("paystation")), PayStation.class);
    }

    @Override
    public void dealWithCar(PayStation payStation, Car<Card> car) {
        // check only collect Public Car
        if (car.getCard() instanceof PublicCard) {
            payStation.through(car, pays);
            textShow("card:" + car.getCard().getId() + " account:" + car.getCard().getAccount());
        }
    }

    public void collect(List<PayCashType> cashList) {
        this.pays = 0;
        for (PayCashType cash : cashList) {
            pays += cash.getMoney();
        }
        textShow("collect total cash:" + pays);
    }
}
