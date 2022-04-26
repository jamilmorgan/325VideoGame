import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GameStarter extends JFrame implements ActionListener, KeyListener{
    JPanel pnlContain;
    JButton btnStart, btnAbout, Desert, Forest, Mountains;


    //GAME GUI INFORMATION

    //RUNS THE GAME
    JPanel GamePanel = new JPanel();
    //BUTTON FOR PROGRESSING
    JButton NextButton = new JButton("Next");
    //WHERE INFORMATION IS DISPLAYED
    JTextArea GameSession = new JTextArea(20,40);
    //KEEPS PLACEMENT IN STORY LINE
    Integer Counter = 0;
    //DESERT
    Desert GameDesert = new Desert();


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

    //PROGRESSING THROUGH THE GAME
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnStart) {
            //STARTING THE GAME GUI
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


            //BACKGROUND INFORMATION START
            GameSession.append("The SunShine Kingdom has been at peace for hundreds of years." +
                    "\n\nOver this time many artists have enriched the kingdoms culture, creating a very stylistic culture" +
                    "\n\nDuring this time, the Kingdom's most valuable piece of artwork, The Golden Tower, was created." +
                    "\n\nPeople have marveled at the work for centuries and has become the an attraction for many\n\n\nPress Next to Continue"
            );

        }


        if (evt.getSource() == NextButton) {
            //JUST TO KEEP TRACK OF COUNT (IN CASE ERRORS OCCUR. CAN DELETE LATER)
            System.out.println(Counter);
            //BACKGROUND INFORMATION CONT.
            if (getCounter() == 0) {
                GameSession.setText("But suddenly, a group of monsters attacked the museum and stole the Golden Tower" +
                        "\n\nThe King has tasked you, the hero, to journey to the the Monster's hideout and retrieve the Artwork\n\n\nPress Next to Continue");
                setCounter(getCounter() + 1);
                //COUNTER = 1
            } else if (getCounter() == 1){
                GameSession.setText("You must now Journey through either the Desert, Mountains, or Forest to reach the Monster's Fortress.\n\nEach route comes with it's own difficulties. Choose Wisely..." +
                        "\n\n\n Select an option below");
                setCounter(getCounter() + 1);
                //COUNTER = 2
                GamePanel.remove(NextButton);

                //NEW BUTTONS ADDED
                Desert = new JButton("Desert");
                Desert.addActionListener(this);
                Forest = new JButton("Forest");
                Forest.addActionListener(this);
                Mountains = new JButton("Mountains");
                Mountains.addActionListener(this);
                GamePanel.add(BorderLayout.SOUTH,Desert);
                GamePanel.add(BorderLayout.SOUTH,Forest);
                GamePanel.add(BorderLayout.SOUTH,Mountains);
                this.setContentPane(GamePanel);

            }

        }

        if (evt.getSource() == Desert){
            setCounter(getCounter() + 1);
            //Starting the Desert
            GameSession.setText("You have arrived at the " + GameDesert.getLocationName() + "\n\n" + GameDesert.getLocationDescription() +
                    "\n\n\nPress Next to Continue");

        }



    }

    public static void main(String[] args) {
        GameStarter my = new GameStarter();
        my.setSize(500,500);
        my.setDefaultCloseOperation(EXIT_ON_CLOSE);
        my.setVisible(true);
        int count = 0;

    }




    //PREVENTS PEOPLE FROM TYPING IN JTEXT AREA
    public void keyTyped (KeyEvent e){
        if (e.getSource() == GameSession){
            e.consume();
        }
    }
    public void keyReleased (KeyEvent e){

    }
    public void keyPressed (KeyEvent e){

    }



    //GETTER AND SETTERS
    public Integer getCounter() {
        return Counter;
    }

    public void setCounter(Integer counter) {
        Counter = counter;
    }

    public JPanel getPnlContain() {
        return pnlContain;
    }

    public void setPnlContain(JPanel pnlContain) {
        this.pnlContain = pnlContain;
    }

    public JButton getBtnStart() {
        return btnStart;
    }

    public void setBtnStart(JButton btnStart) {
        this.btnStart = btnStart;
    }

    public JButton getBtnAbout() {
        return btnAbout;
    }

    public void setBtnAbout(JButton btnAbout) {
        this.btnAbout = btnAbout;
    }

    public JButton getDesert() {
        return Desert;
    }

    public void setDesert(JButton desert) {
        Desert = desert;
    }

    public JButton getForest() {
        return Forest;
    }

    public void setForest(JButton forest) {
        Forest = forest;
    }

    public JButton getMountains() {
        return Mountains;
    }

    public void setMountains(JButton mountains) {
        Mountains = mountains;
    }

    public JPanel getGamePanel() {
        return GamePanel;
    }

    public void setGamePanel(JPanel gamePanel) {
        GamePanel = gamePanel;
    }

    public JButton getNextButton() {
        return NextButton;
    }

    public void setNextButton(JButton nextButton) {
        NextButton = nextButton;
    }

    public JTextArea getGameSession() {
        return GameSession;
    }

    public void setGameSession(JTextArea gameSession) {
        GameSession = gameSession;
    }
}


