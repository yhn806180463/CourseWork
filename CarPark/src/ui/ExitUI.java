package ui;

import java.util.List;
import javax.swing.JTextArea;
import facility.Exit;

public class ExitUI extends JTextArea {

    private static final long serialVersionUID = 1L;

    public ExitUI(List<Exit> exits) {
        super();
        this.setText("Hello");
    }
}
