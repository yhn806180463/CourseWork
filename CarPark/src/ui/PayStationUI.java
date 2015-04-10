package ui;

import java.util.List;
import javax.swing.JTextArea;
import facility.PayStation;

public class PayStationUI extends JTextArea {

    private static final long serialVersionUID = 1L;

    public PayStationUI(List<PayStation> payStations) {
        super();
        this.setText("Hello");
    }
}
