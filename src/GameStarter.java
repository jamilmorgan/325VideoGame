import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;

public class GameStarter extends JFrame implements ActionListener, KeyListener, Battle{
    JPanel pnlContain;
    JButton btnStart, btnAbout, btnEnter;
    JLabel lblInputName, lblInputAge, notready;
    JTextField txtInputName, txtInputAge;
    boolean ready = false;
    JPanel NameInputs = new JPanel();
    String GameLocation;

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

        //BUTTONS FOR LATER
        NextButton.addActionListener(this);
        Desert.addActionListener(this);
        Forest.addActionListener(this);
        Mountains.addActionListener(this);
        btnNo.addActionListener(this);
        btnYes.addActionListener(this);
        btnBattle.addActionListener(this);
        btnDontBattle.addActionListener(this);
        btnOpt1.addActionListener(this);
        btnOpt2.addActionListener(this);

        Player = new Hero();
    }
    JPanel PlayerInfo = new JPanel();;
    //JPANEL UPDATING
    JLabel PHealth, HealthNum, PName, NameStr, PCurrency, CurrencyNum, PWeapon, PGap2;

    public void updatePlayerInfo(){

        try {
            GamePanel.remove(PHealth);
            GamePanel.remove(PName);
            GamePanel.remove(PCurrency);
            GamePanel.remove(PWeapon);
        }catch (Exception e){
            System.out.println("Not in yet");
        }

        PHealth = new JLabel("Health: " + this.Player.getHealth() + "  ");
        PName = new JLabel("Name: " + this.Player.getName() + "  ");
        PCurrency = new JLabel("Currency: " + this.Player.getCurrency() + "  ");
        PWeapon = new JLabel("Weapon: " + this.Player.getWeapon().getWeaponName() + " Damage: " + this.Player.getWeapon().getDamageDealt() + "  ");
        GamePanel.add(BorderLayout.WEST, PName);
        GamePanel.add(BorderLayout.WEST, PHealth);
        GamePanel.add(BorderLayout.WEST, PCurrency);
        GamePanel.add(BorderLayout.WEST, PWeapon);

        this.setContentPane(GamePanel);
        this.setVisible(true);
    }

    //PROGRESSING THROUGH THE GAME
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnStart) {
            pnlContain.remove(btnAbout);
            pnlContain.remove(btnStart);

            lblInputName = new JLabel("Enter Your Name:");
            txtInputName = new JFormattedTextField();
            txtInputName.addKeyListener(this);

            lblInputAge = new JLabel("Enter Your Age:");
            txtInputAge = new JFormattedTextField();
            txtInputAge.addKeyListener(this);

            btnEnter = new JButton("Enter");
            btnEnter.addActionListener(this);
            pnlContain.setLayout(new GridLayout(2,2));

            pnlContain.add(lblInputName);
            pnlContain.add(txtInputName);
            pnlContain.add(lblInputAge);
            pnlContain.add(txtInputAge);

            NameInputs.setLayout(new BorderLayout());
            NameInputs.add(BorderLayout.CENTER, pnlContain);
            NameInputs.add(BorderLayout.SOUTH, btnEnter);

            this.setContentPane(NameInputs);
            this.setVisible(true);

        }

        if (evt.getSource() == btnEnter) {
            //STARTING THE GAME GUI
            if (!txtInputAge.getText().equals("") && !txtInputName.getText().equals("")){
                this.Player.setName(txtInputName.getText());
                this.Player.setAge(Integer.parseInt(txtInputAge.getText()));
                System.out.println(this.Player.getName());
                System.out.println(this.Player.getAge());

                GameSession.setLineWrap(true);
                GameSession.addKeyListener(this);
                JScrollPane scroller = new JScrollPane(GameSession);
                scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);



                GamePanel.add(BorderLayout.CENTER, scroller);
                GamePanel.add(BorderLayout.SOUTH, NextButton);
                this.setContentPane(GamePanel);
                this.setVisible(true);
                updatePlayerInfo();


                //BACKGROUND INFORMATION START
                GameSession.append("The SunShine Kingdom has been at peace for hundreds of years." +
                        "\n\nOver this time many artists have enriched the kingdoms culture, creating a very stylistic culture" +
                        "\n\nDuring this time, the Kingdom's most valuable piece of artwork, The Golden Tower, was created." +
                        "\n\nPeople have marveled at the work for centuries and has become the an attraction for many\n\n\nPress Next to Continue"
                );

            }else {
                try {
                    notready = new JLabel("Your Inputs are invalid");
                    notready.setBackground(Color.RED);
                    notready.setOpaque(true);
                    NameInputs.add(BorderLayout.NORTH, notready);

                    this.setContentPane(NameInputs);
                    this.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }


        if (evt.getSource() == NextButton) {
            //JUST TO KEEP TRACK OF COUNT (IN CASE ERRORS OCCUR. CAN DELETE LATER)
            System.out.println(Counter);
            //BACKGROUND INFORMATION CONT.
            if (getCounter() == 0) {
                GameSession.setText("But suddenly, a group of monsters attacked the museum and stole the Golden Tower!!!" +
                        "\n\nThe Kingdom is in panic over the loss!!\n\nThe King has tasked you, " + this.Player.getName() + ", as the hero that will journey to the " +
                        "Monsters' hideout and retrieve the National Treasure!\n\n\nPress Next to Continue");
                setCounter(getCounter() + 1);
                //COUNTER = 1
            } else if (getCounter() == 1){
                GameSession.setText("You have left the Kingdom on you journey to the Monsters' Fortress.\n\n" +
                        "You must now Journey through either the Desert, Mountains, or Forest to reach the Monster's Fortress.\n\nEach route comes with it's own difficulties. Choose Wisely..." +
                        "\n\n\n Select a route to take");
                setCounter(getCounter() + 1);
                //COUNTER = 2
                GamePanel.remove(NextButton);

                //NEW BUTTONS ADDED
                GamePanel.add(BorderLayout.SOUTH,Desert);
                GamePanel.add(BorderLayout.SOUTH,Forest);
                GamePanel.add(BorderLayout.SOUTH,Mountains);
                this.setContentPane(GamePanel);

            }else if (getCounter() == 2){
                WeatherTest();
                LuckyYouCoin();
                setCounter(getCounter() + 1);
                //COUNTER = 3
                //RANDOM ENCOUNTER 1
                GameSession.append(GameDesert.randomEncounter1());
                RemoveNextButton();
                YesNoQuestion();

            }else if (getCounter() == 5){
                WeatherTest();
                setCounter(getCounter() + 1);
                //COUNTER = 6
                GameSession.append(GameDesert.randomEncounter2());
                GameSession.append("\n\n" + Bandit.getName() + "'s Stats : Health " + Bandit.getHealth() + " Damage: " + Bandit.getDamageDealt());
                RemoveNextButton();
                chooseToBattle();

            }else if (getCounter() == 6){
                WeatherTest();
                setCounter(getCounter() + 1);
                //COUNTER = 7
                GameSession.append(GameDesert.randomEncounter3());
                RemoveNextButton();
                YesNoQuestion();
            }else if (getCounter() == 7){
                WeatherTest();
                LuckyYouCoin();
                LuckyYouHealth();
                LuckyYouWeapon();

                setCounter(getCounter() + 1);
                //COUNTER = 8

                GameSession.append(GameDesert.randomEncounter4());
                RemoveNextButton();
                twoOptions();
            }else if (getCounter() == 8){
                setCounter(getCounter() + 1);
                //COUNTER = 9
                GameSession.setText("You've reached the Monster Fortress!\n\n");
                GameSession.append(Castle.LocationDescription + "\n\n" + Castle.randomEncounter1());
                RemoveNextButton();
                chooseToBattle();
            }else if (getCounter() == 9){
                GameSession.setText("You've returned after slaying the monster and returned the treasure!\n\nThe kingdom thanks you for your service, " + Player.getName() + ".\n\nYou are a Hero!");
                RemoveNextButton();
            }

        }
        if (evt.getSource() == btnOpt1){
            GameSession.setText("The old man wishes you luck and gift's you an elixir.\n\n +5 health\n\nPress next to continue");
            this.Player.setHealth(Player.getHealth() + 5);
            updatePlayerInfo();
            removeTwoOptions();
            nextButtonPrompt();
        }else if (evt.getSource() == btnOpt2){
            GameSession.setText("The old man smacks you with unprecedented force." + "\n\nThe old man screams: Respect Your Elders! How old are you " + Player.getAge() + "?\n\n -5 health\n\nPress Next to continue");
            this.Player.setHealth(Player.getHealth() - 5);
            updatePlayerInfo();
            YouDied("The old man beat you to death");
            removeTwoOptions();
            nextButtonPrompt();

        }


        if (evt.getSource() == btnBattle){
            if (getCounter() == 6){
                RemoveChooseToBattle();
                GameSession.setText("The Battle Begins!\n");
                battle(Bandit);
                   GameSession.append("\n\nPress Next to continue");
                   nextButtonPrompt();

            }else if (getCounter() == 9) {
                RemoveChooseToBattle();
                GameSession.setText("The Battle Begins!\n");
                battle(FinalBoss);
                GameSession.append("\n\nPress Next to continue");
                nextButtonPrompt();
            }

        }else if (evt.getSource() == btnDontBattle) {
            if (getCounter() == 6) {
                GameSession.setText("The bandit took 30 gold from you\n\nPress Next to continue");
                RemoveChooseToBattle();
                nextButtonPrompt();
                try {
                    this.Player.setCurrency(this.Player.getCurrency() - 30);
                } catch (Exception e) {
                    this.Player.setCurrency(0);

                }
                updatePlayerInfo();
            }else if (getCounter() == 9){
                GameSession.setText("The Monster Killed you while you turned your back");
                this.Player.setHealth(0);
                updatePlayerInfo();
                YouDied("The Monster Killed you while you turned your back");
            }
        }
        if (evt.getSource() == btnYes){
            if (getCounter() == 3) {
                setCounter(getCounter() + 1);
                //COUNTER = 4
                removeYesNo();
                this.Player.setCurrency(this.Player.getCurrency() + 50);
                updatePlayerInfo();
                Random PotentialHarmOrGood = new Random();
                int Checker = PotentialHarmOrGood.nextInt(8);
                GameSession.setText("As you approach the wagon, you realize someone left in a rush.\n\nYou still decide to search the wagon\n\nYou found 50 Gold Coins while looking through the wagon!\n\n");
                LuckyYouHealth();

                if (Checker >= 6) {
                    GameSession.append("You also found the Wimp's Sword!!");
                    wouldYouLikeToTakeWeapon(new Weapon("Wimp's Sword", "A strong sword dropped by a wimpy knight after being attacked by snakes", 30));
                    YesNoQuestion();

                } else if (Checker <= 1) {
                    GameSession.append("Suddenly, a snake jumps out from beneath the wagon, -10 Health\n\n\nPress next to leave.");
                    try {
                        this.Player.setHealth(this.Player.getHealth() - 10);
                    } catch (Exception e){
                        this.Player.setHealth(0);
                    }
                    updatePlayerInfo();

                    YouDied("Snake's venom killed you");
                    setCounter(getCounter() + 1);
                    //COUNT = 5
                    nextButtonPrompt();
                } else {
                    setCounter(getCounter() + 1);
                    //COUNT = 5
                    GameSession.append("\nPress next to continue");
                    nextButtonPrompt();
                }
            }else if (getCounter() == 4){

                //YES TO WEAPON
                this.Player.setWeapon(new Weapon("Wimp's Sword", "A strong sword dropped by a wimpy knight after being attacked by snakes", 30));
                removeYesNo();
                updatePlayerInfo();
                setCounter(getCounter() + 1);
                //COUNT = 5
                GameSession.setText("You Acquired the Wimp's Sword\n\n\nPress Next To Continue Traveling...");
                nextButtonPrompt();

            }else if (getCounter() == 7){
                GameSession.setText("\nThe Oasis is a nice break from your Journey.\n\n+10 Health\n");
                LuckyYouCoin();
                LuckyYouHealth();
                GameSession.append("\n\nPress next to continue");
                Player.setHealth(Player.getHealth() + 10);
                updatePlayerInfo();
                removeYesNo();
                nextButtonPrompt();
            }


        }else if (evt.getSource() == btnNo){
            if (getCounter() == 3){
                removeYesNo();
                GameSession.setText("You have decided to skip the wagon\n\n\nPress next to continue");
                setCounter(getCounter() + 2);
                //COUNT = 5
                nextButtonPrompt();

            }else if (getCounter() == 4){
                //NO TO WEAPON
                setCounter(getCounter() + 1);
                removeYesNo();
                //COUNT = 5
                GameSession.setText("You did not pick up the sword\n\n\nPress next to continue");
                nextButtonPrompt();

            }else if (getCounter() == 7){
                GameSession.setText("You skipped the Oasis.\n\nPress next to continue");
                removeYesNo();
                nextButtonPrompt();

            }

        }

        if (evt.getSource() == Desert){
            //STARTING DESERT STORYLINE
            setGameLocation("Desert");
            GameSession.setText("You have arrived at the " + GameDesert.getLocationName() + "\n\n" + GameDesert.getLocationDescription() +
                    "\n\n\nPress Next to Continue");
            GamePanel.remove(Desert);
            GamePanel.remove(Forest);
            GamePanel.remove(Mountains);
            GamePanel.add(NextButton);
            this.setContentPane(GamePanel);
        }



    }

    public static void main(String[] args) {
        GameStarter my = new GameStarter();
        my.setSize(600,500);
        my.setDefaultCloseOperation(EXIT_ON_CLOSE);
        my.setVisible(true);
        int count = 0;

    }

    public void wouldYouLikeToTakeWeapon (Weapon weapon) {
        GameSession.append("\nWould you like to take weapon with you?\n\n"
        + weapon.getWeaponName() + " Damage: " + weapon.getDamageDealt() +
                " Description: " + weapon.getWeaponDescription());

    }
    public void nextButtonPrompt (){
        GamePanel.add(BorderLayout.SOUTH, NextButton);
        this.setContentPane(GamePanel);
    }
    public void RemoveNextButton (){
        GamePanel.remove(NextButton);
        this.setContentPane(GamePanel);
    }
    public void YesNoQuestion (){
        GamePanel.add(BorderLayout.SOUTH, btnYes);
        GamePanel.add(BorderLayout.SOUTH, btnNo);
        this.setContentPane(GamePanel);
    }
    public void removeYesNo () {
        GamePanel.remove(btnNo);
        GamePanel.remove(btnYes);
        this.setContentPane(GamePanel);
    }
    public void twoOptions (){
        GamePanel.add(BorderLayout.SOUTH, btnOpt1);
        GamePanel.add(BorderLayout.SOUTH, btnOpt2);
        this.setContentPane(GamePanel);
    }
    public void removeTwoOptions (){
        GamePanel.remove(btnOpt1);
        GamePanel.remove(btnOpt2);
        this.setContentPane(GamePanel);
    }


    public void WeatherTest(){
        if(getGameLocation().equals("Desert")){
            int healthTrack = this.Player.getHealth();
            int ActualHealth = GameDesert.WeatherEffectsOnHealth(Player.getHealth());
            if (ActualHealth < healthTrack) {
                GameSession.setText("The Dessert is draining your energy! Loss of 5 Health Points!\n\n");
                Player.setHealth(ActualHealth);
                updatePlayerInfo();
                YouDied("Died from the unforgiving Desert");
            }else {
                GameSession.setText("The Dessert is scorching hot! Need to hurry!\n\n");
            }
        }

    }

    Boolean winner = false;
    Integer DamageTracker;
    public void battle (Enemy enemy) {
        setWinner(false);
            while(enemy.getHealth() > 0 && Player.getHealth() > 0) {
                if (HeroGoesFirst().equals("Hero")) {
                    try {
                        enemy.setHealth(enemy.getHealth() - this.Player.getWeapon().getDamageDealt());
                    } catch (Exception e) {
                        enemy.setHealth(0);
                    }
                    GameSession.append("\nYou Attacked " + enemy.getName());
                    if (enemy.getHealth() <= 0) {
                        GameSession.append("\n\nCongratulations, you defeated " + enemy.getName());
                        setWinner(true);
                    } else {
                        try {
                            this.Player.setHealth(this.Player.getHealth() - enemy.getDamageDealt());
                        } catch (Exception e) {
                            this.Player.setHealth(0);
                        }
                        GameSession.append("\n" + enemy.getName() + "attacked you");
                        YouDied(enemy.getName() + " Killed you");
                    }
                } else {
                    try {
                        this.Player.setHealth(this.Player.getHealth() - enemy.getDamageDealt());
                    } catch (Exception e) {
                        this.Player.setHealth(0);
                    }
                    GameSession.append("\n" + enemy.getName() + "attacked you");
                    YouDied(enemy.getName() + "Killed you");

                    try {
                        enemy.setHealth(enemy.getHealth() - this.Player.getWeapon().getDamageDealt());
                    } catch (Exception e) {
                        enemy.setHealth(0);
                    }
                    GameSession.append("\nYou Attacked " + enemy.getName());
                    if (enemy.getHealth() <= 0) {
                        GameSession.append("\n\nCongratulations, you defeated " + enemy.getName());
                        setWinner(true);
                    }

                }
                System.out.println(this.Player.getHealth());
                System.out.println(enemy.getHealth());
            }
        updatePlayerInfo();

    }


    public String HeroGoesFirst(){
        Random GoesFirst = new Random();
        int Checker = GoesFirst.nextInt(8);
        if (Checker % 2 == 0){
            return "Hero";
        }else {
            return "No";
        }
    }

    public void chooseToBattle(){
        GamePanel.add(BorderLayout.SOUTH, btnBattle);
        GamePanel.add(BorderLayout.SOUTH, btnDontBattle);
        this.setContentPane(GamePanel);
    }
    public void RemoveChooseToBattle(){
        GamePanel.remove(btnBattle);
        GamePanel.remove(btnDontBattle);
        this.setContentPane(GamePanel);
    }

    public void LuckyYouCoin(){
        Random Lucky = new Random();
        int Checker = Lucky.nextInt(8);

        if (Checker == 4 || Checker == 3){
            GameSession.append("\nWhile searching around, you found 5 gold coins on the ground.\nLucky you\n\n");
            Player.setCurrency(Player.getCurrency() + 5);
            updatePlayerInfo();
        }

    }
    public void LuckyYouWeapon(){
        Random Lucky = new Random();
        int Checker = Lucky.nextInt(8);

        if (Checker == 4 || Checker == 3){
            GameSession.append("\nWhile searching around, you found a magic piece that increases your weapon's damage.\n Damage +1\nLucky you\n\n");
            this.Player.getWeapon().setDamageDealt(this.Player.getWeapon().getDamageDealt() + 1);
            updatePlayerInfo();
        }

    }
    public void LuckyYouHealth(){
        Random Lucky = new Random();
        int Checker = Lucky.nextInt(8);

        if (Checker == 4 || Checker == 3){
            GameSession.append("\nWhile searching around, you found an elixir.\nLucky you\n\n");
            Player.setCurrency(Player.getCurrency() + 5);
            updatePlayerInfo();
        }

    }

    //PREVENTS PEOPLE FROM TYPING IN JTEXT AREA
    public void keyTyped (KeyEvent e){
        int a = e.getKeyChar();
        if (e.getSource() == GameSession){
            e.consume();
        }

        if(e.getSource() == txtInputName && !(a >= 97 && a <= 122) && !(a >= 65 && a <= 90) && !(a >= 48 && a <= 57) && !(a > 0 && a <= 31) && a != 127){
            e.consume();
        }
        if(e.getSource() == txtInputAge && !(a >= 48 && a <= 57) && !(a > 0 && a < 31) && a != 127){
            e.consume();
        }
        if(e.getSource() == txtInputAge){
            if (txtInputAge.getText().length() > 1){
                e.consume();
            }
        }

    }
    public void keyReleased (KeyEvent e){

    }
    public void keyPressed (KeyEvent e){

    }

    public void YouDied (String a){
        if (Player.getHealth() <= 0){
            setWinner(false);
            JPanel GameOver = new JPanel();
            JLabel Dead = new JLabel("You were Slain...\n\n" + a + "\n\nGame Over");
            GameOver.add(Dead);
            this.setContentPane(GameOver);
            this.setVisible(true);

        }
    }



    //GETTER AND SETTERS

    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }

    public Integer getDamageTracker() {
        return DamageTracker;
    }

    public void setDamageTracker(Integer damageTracker) {
        DamageTracker = damageTracker;
    }

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

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public String getGameLocation() {
        return GameLocation;
    }

    public void setGameLocation(String gameLocation) {
        GameLocation = gameLocation;
    }


    //RUNS THE GAME
    JPanel GamePanel = new JPanel();


    //BUTTON FOR PROGRESSING
    JButton NextButton = new JButton("Next");

    JButton Desert = new JButton("Desert");

    JButton Forest = new JButton("Forest");

    JButton Mountains = new JButton("Mountains");

    JButton btnYes = new JButton("Yes");
    JButton btnNo = new JButton("No");
    JButton btnBattle = new JButton("Battle");
    JButton btnDontBattle = new JButton("Don't Battle");

    JButton btnOpt1 = new JButton("Option 1");
    JButton btnOpt2 = new JButton("Option 2");

    //WHERE INFORMATION IS DISPLAYED
    JTextArea GameSession = new JTextArea(20,40);
    //KEEPS PLACEMENT IN STORY LINE
    Integer Counter = 0;
    //DESERT
    Desert GameDesert = new Desert();
    Castle Castle = new Castle();

    //PLAYER INFO
    Hero Player;




    //ENEMIES
    Enemy Bandit = new Enemy("Bandit","A skilled thief that takes what he wants", 30, 15);
    Enemy FinalBoss = new Enemy("Monster", "Monster who took the national treasue!", 50, 18);

}


