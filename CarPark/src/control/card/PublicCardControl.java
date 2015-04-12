package control.card;

import model.card.PublicCard;
import config.Config;

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
