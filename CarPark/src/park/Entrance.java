package park;

import State.EntranceState;
import car.Car;
import card.Card;

public class Entrance {

    public int id;
    public EntranceState state;

    public Entrance(int id) {
        this.id = id;
        this.state = EntranceState.available;
    }

    public void through(Car<Card> car) {
        if (car.card!=null) {
            System.out.println("open barrier,car "+car.card.id);
        }
    }

   public void close(){
       this.state = EntranceState.unavailable;
   }
}
