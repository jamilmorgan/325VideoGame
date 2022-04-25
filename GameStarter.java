import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GameStarter extends JFrame implements ActionListener {
    JPanel pnlContain;
    JButton btnStart;

    public GameStarter () {
        Container cp = getContentPane();

        btnStart = new JButton("Start");
        btnStart.addActionListener(this);

    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnStart) {


        }
    }

}
