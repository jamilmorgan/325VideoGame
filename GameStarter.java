import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GameStarter extends JFrame implements ActionListener {
    JPanel pnlContain;
    JButton btnStart, btnAbout;

    public GameStarter () {
        Container cp = getContentPane();

        btnStart = new JButton("Start");
        btnStart.addActionListener(this);

        btnAbout = new JButton("About");
        btnAbout.addActionListener(this);

        pnlContain = new JPanel();

        pnlContain.add(btnAbout);
        pnlContain.add(btnStart);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnStart) {
            

        }
        if (evt.getSource() == btnAbout) {


        }
    }

}
