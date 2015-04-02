package car;

import card.Card;
import card.TicketCard;


public class PublicCar extends Car<TicketCard>{

    
    
    public PublicCar(TicketCard card) {
        super(card);
    }

    /**
     * pay by time
     */
    @Override
    public float pay() {
        if(enterTime!=null&&leaveTime!=null){
            long liveTime = leaveTime.getTime()-enterTime.getTime();
        }
        return 0;
    }
    
    
}
