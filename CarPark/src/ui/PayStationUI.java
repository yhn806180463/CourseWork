package ui;

import java.util.List;
import javax.swing.JComponent;
import facility.PayStation;

public class PayStationUI extends JComponent {

    private static final long serialVersionUID = 1L;

    public PayStationUI(List<PayStation> payStations) {
        super();
        this.setSize(100, 200);
    }
}
