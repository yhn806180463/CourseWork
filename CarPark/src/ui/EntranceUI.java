package ui;

import java.util.List;
import javax.swing.JTextArea;
import facility.Entrance;

public class EntranceUI extends JTextArea {

    private static final long serialVersionUID = 1L;

    public EntranceUI(List<Entrance> entrances) {
        super();
        this.setText("Hello");
    }
}
