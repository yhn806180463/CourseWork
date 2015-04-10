package ui;

import javax.swing.JComponent;
import javax.swing.JTextArea;

public class ControlUI extends JComponent {

    private static final long serialVersionUID = 1L;

    public ControlUI() {
        super();
        this.setSize(500, 300);
        JTextArea text = new JTextArea();
        text.setSize(500, 300);
        text.setText("Hello");
        this.add(text);
    }
}
