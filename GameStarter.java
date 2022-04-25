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

        cp.add(pnlContain);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnStart) {
           JTextArea GameSession;

            JFrame jf = new JFrame();
            JPanel jp = new JPanel();
            JButton jb = new JButton("Just click it");
            jb.addActionListener(this);
            GameSession = new JTextArea(10,20);
            GameSession.setLineWrap(true);
            JScrollPane scroller = new JScrollPane(GameSession);
            scroller.setVerticalScrollBarPolicy(
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scroller.setHorizontalScrollBarPolicy(
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            jp.add(scroller);
            jf.getContentPane().add(BorderLayout.CENTER,jp);
            jf.getContentPane().add(BorderLayout.SOUTH,jb);


            jf.setSize(500,500);
            jf.setVisible(true);

        }
        if (evt.getSource() == btnAbout) {


        }


    }

    public static void main(String[] args) {
        GameStarter my = new GameStarter();
        my.setSize(500,500);
        my.setVisible(true);

    }

}


