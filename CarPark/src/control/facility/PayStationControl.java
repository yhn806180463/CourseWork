package control.facility;

import java.util.List;
import main.config.Config;
import main.view.SingletonModel;
import model.car.Car;
import model.card.Card;
import model.card.PublicCard;
import model.facility.PayStation;
import model.state.PayCashType;

public class PayStationControl extends AbstractControl<PayStation> {

    private double pays;

    public PayStationControl() {
        super(SingletonModel.PayStation.getTextArea(), Integer.valueOf(Config.getProperty("paystation")), PayStation.class);
    }

    @Override
    protected void dealWithCar(PayStation payStation, Car<? extends Card> car) {
        // check only collect Public Car
        if (payStation.canDeal(car)) {
            if (car.getCard() instanceof PublicCard) {
                payStation.collect(pays);
                payStation.deal(car);
                textShow("card:" + car.getCard().getId() + " account:" + car.getCard().getAccount());
            }
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
