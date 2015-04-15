package control.card;

import main.config.Config;
import model.card.PublicCard;

public class PublicCardControl extends CardControl<PublicCard> {

    /**
     * create spaces, entrance, payStation, exit, ticketCards and campusCards;
     */
    public PublicCardControl() {
        for (int i = Integer.valueOf(Config.getProperty("card.public.start")); i <= Integer.valueOf(Config.getProperty("card.public.end")); i++) {
            PublicCard card = new PublicCard(i);
            cards.put(i, card);
        }
    }
}
