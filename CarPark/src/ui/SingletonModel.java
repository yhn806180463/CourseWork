package ui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * singleton view
 */
public enum SingletonModel {
    Entrance("Entrance"), PayStation("PayStation"), Exit("Exit"), Control("Control");

    private JScrollPane jScrollPane = new JScrollPane();
    private JTextArea jTextArea = new JTextArea();
    private JLabel jLabel = new JLabel();
    private JPanel jPanel;

    /**
     * every block is made by a title and a scroll text area
     * 
     * @param title
     */
    private SingletonModel(String title) {
        jPanel = new JPanel();
        jLabel.setText(title);
        jScrollPane.getViewport().add(jTextArea);
        jScrollPane.setAutoscrolls(true);
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.add(jLabel);
        jPanel.add(jScrollPane);
    }

    public JPanel getJPanel() {
        return this.jPanel;
    }

    public JTextArea getTextArea() {
        return this.jTextArea;
    }
}
