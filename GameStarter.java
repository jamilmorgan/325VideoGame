import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GameStarter extends JFrame implements ActionListener, KeyListener{
    JPanel pnlContain;
    JButton btnStart, btnAbout;


    //GAME GUI INFORMATION
    JFrame Game = new JFrame();
    JPanel GamePanel = new JPanel();
    JButton NextButton = new JButton("Next");
    JTextArea GameSession = new JTextArea(20,40);
    Integer Counter = 0;

    public Integer getCounter() {
        return Counter;
    }

    public void setCounter(Integer counter) {
        Counter = counter;
    }

    //HOME SCREEN INFORMATION
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
        if (evt.getSource() == NextButton) {
            System.out.println(Counter);

        }
        if (evt.getSource() == btnStart) {
            //STARTING THE GAME GUI
            Container cp = getContentPane();
            NextButton.addActionListener(this);
            GameSession.setLineWrap(true);
            GameSession.addKeyListener(this);
            JScrollPane scroller = new JScrollPane(GameSession);
            scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            GamePanel.add(BorderLayout.CENTER, scroller);
            GamePanel.add(BorderLayout.SOUTH,NextButton);
            this.setContentPane(GamePanel);
            this.setVisible(true);


            GameSession.append("The SunShine Kingdom has been at peace for hundreds of years." +
                    "\n\nOver this time many artists have enriched the kingdoms culture, creating a very stylistic culture" +
                    "\n\nDuring this time, the Kingdom's most valuable piece of artwork, The Golden Tower, was created." +
                    "\n\nPeople have marveled at the work for centuries and has become the an attraction for many\n\n\nPress Next to Continue"
            );

        }

        if (evt.getSource() == NextButton && Counter == 0) {
            setCounter(Counter + 1);
            GameSession.setText("But suddenly, a group of monsters attacked the museum and stole the Golden Tower" +
                    "\n\nThe King has tasked you, the hero, to journey to the the Monster's hideout and retrieve the Artwork\n\n\nPress Next to Continue");

        }




    }

    public static void main(String[] args) {
        GameStarter my = new GameStarter();
        my.setSize(500,500);
        my.setVisible(true);

    }



    public void keyTyped (KeyEvent e){
        if (e.getSource() == GameSession){
            e.consume();
        }
    }
    public void keyReleased (KeyEvent e){

    }
    public void keyPressed (KeyEvent e){

    }
}


