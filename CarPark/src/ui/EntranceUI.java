package ui;

import java.util.List;
import javax.swing.JComponent;
import facility.Entrance;

public class EntranceUI extends JComponent {

    private static final long serialVersionUID = 1L;

    public EntranceUI(List<Entrance> entrances) {
        super();
        this.setSize(100, 200);
    }
}
