package control.card;

import main.config.Config;
import model.card.PublicCard;
import model.state.CardState;

public class PublicCardControl extends CardControl<PublicCard> {

    /**
     * create public cards
     */
    public PublicCardControl() {
        for (int i = Integer.valueOf(Config.getProperty("card.public.start")); i <= Integer.valueOf(Config.getProperty("card.public.end")); i++) {
            PublicCard card = new PublicCard(i);
            cards.add(card);
        }
    }

    /**
     * get an available card
     * 
     * @return T
     */
    public PublicCard getAvailableCard() {
        for (PublicCard card : cards) {
            if (card.getState() == CardState.available) {
                textShow("issue public card:" + card.getId());
                return card;
            }
        }
        return null;
    }
}
