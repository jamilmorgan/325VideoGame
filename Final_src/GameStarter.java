
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class GameStarter extends JFrame implements ActionListener, KeyListener, Battle{
    Score score = new Score();
    Time clock = new Time();
    JPanel pnlContain;
    JButton btnEng, btnSpan, btnStart, btnAbout, btnEnter;
    JLabel lblLang, lblInputName, lblInputAge, notready, MonFor;
    JTextField txtInputName, txtInputAge;
    boolean ready;
    JPanel NameInputs, monsterFor, borders;
    String GameLocation;
    
    MyLocale theLocale;
    
    //RUNS THE GAME
    JPanel GamePanel;

    //BUTTON FOR PROGRESSING
    JButton NextButton;
    JButton Desert;
    JButton Forest;
    JButton Mountains;

    JButton btnYes;
    JButton btnNo;
    JButton btnBattle;
    JButton btnDontBattle;

    JButton btnOpt1;
    JButton btnOpt2;

    //WHERE INFORMATION IS DISPLAYED
    JTextArea GameSession;
    //KEEPS PLACEMENT IN STORY LINE
    Integer Counter = 0;
    
    //DESERT
    Desert GameDesert;
    Castle Castle;

    //PLAYER INFO
    Hero Player;
    
    //ENEMIES
    Enemy Bandit;
    Enemy FinalBoss;

    //HOME SCREEN INFORMATION
    public GameStarter () {

        ready = false;
        NameInputs = new JPanel();
        
        theLocale = new MyLocale();
        theLocale.setLocale("en","US");
        
        GamePanel = new JPanel();
        
        NextButton = new JButton(theLocale.getLocaleWord("NEXT"));
        Desert = new JButton(theLocale.getLocaleWord("DESERT_NAME"));
        Forest = new JButton(theLocale.getLocaleWord("FOREST"));
        Mountains = new JButton(theLocale.getLocaleWord("MOUNTAINS"));
        
        btnYes = new JButton(theLocale.getLocaleWord("YES"));
        btnNo = new JButton(theLocale.getLocaleWord("NO"));
        btnBattle = new JButton(theLocale.getLocaleWord("BATTLE"));
        btnDontBattle = new JButton(theLocale.getLocaleWord("NO_BATTLE"));
        
        btnOpt1 = new JButton(theLocale.getLocaleWord("OPTION_1"));
        btnOpt2 = new JButton(theLocale.getLocaleWord("OPTION_2"));

        GameSession = new JTextArea(20,40);
        //Sets line wrap by word
        GameSession.setLineWrap(true);
        GameSession.setWrapStyleWord(true);
        
        GameDesert = new Desert(theLocale);
        Castle = new Castle(theLocale);
        
        Container cp = getContentPane();
        
        lblLang = new JLabel(theLocale.getLocaleWord("LANGUAGE"));

        btnStart = new JButton(theLocale.getLocaleWord("START"));
        btnStart.addActionListener(this);

        btnAbout = new JButton(theLocale.getLocaleWord("ABOUT"));
        btnAbout.addActionListener(this);
        
        btnEng = new JButton(theLocale.getLocaleWord("ENGLISH"));
        btnEng.addActionListener(this);
        
        btnSpan = new JButton(theLocale.getLocaleWord("SPANISH"));
        btnSpan.addActionListener(this);

        pnlContain = new JPanel();
        monsterFor = new JPanel();
        borders = new JPanel();
        MonFor = new JLabel("Monster Fortress");
        MonFor.setFont(new Font("Times", Font.BOLD, 30));
        MonFor.setForeground(Color.red);

        borders.setLayout(new GridBagLayout());
        borders.add(MonFor);
        borders.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        borders.setBackground(Color.ORANGE);
        //this.setBackground(Color.BLACK);
        pnlContain.setBackground(Color.ORANGE);
        monsterFor.setBackground(Color.ORANGE);
        //pnlContain.add(btnAbout);
        pnlContain.setLayout(new BorderLayout());
        pnlContain.add(BorderLayout.NORTH, borders);
        monsterFor.add(btnStart);
        monsterFor.add(btnAbout);
        monsterFor.add(lblLang);
        monsterFor.add(btnEng);
        monsterFor.add(btnSpan);

        pnlContain.add(BorderLayout.CENTER, monsterFor);
        cp.add(pnlContain);

        lblInputName = new JLabel(theLocale.getLocaleWord("ENTER_NAME"));
        txtInputName = new JFormattedTextField();
        lblInputAge = new JLabel(theLocale.getLocaleWord("ENTER_AGE"));
        txtInputAge = new JFormattedTextField();
        btnEnter = new JButton(theLocale.getLocaleWord("ENTER"));
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
        btnEnter.addActionListener(this);

        BtnScoreSend = new JButton(theLocale.getLocaleWord("SEND_SC"));
        BtnScoreSend.addActionListener(this);


        Bandit = new Enemy(theLocale.getLocaleWord("BANDIT_NAME"),theLocale.getLocaleWord("BANDIT_DESC"), 30, 15);
        FinalBoss = new Enemy(theLocale.getLocaleWord("MONSTER_NAME"), theLocale.getLocaleWord("MONSTER_DESC"), 50, 18);
        
        Player = new Hero(theLocale);
    }
    JButton BtnScoreSend;
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

        PHealth = new JLabel(theLocale.getLocaleWord("HEALTH") + " " + this.Player.getHealth() + "  ");
        PName = new JLabel(theLocale.getLocaleWord("NAME") + " " + this.Player.getName() + "  ");
        PCurrency = new JLabel(theLocale.getLocaleWord("CURRENCY") + " " + this.Player.getCurrency() + "  ");
        PWeapon = new JLabel(theLocale.getLocaleWord("WEAPON") + " " + this.Player.getWeapon().getWeaponName() + "   " + theLocale.getLocaleWord("DAMAGE") + " " + this.Player.getWeapon().getDamageDealt() + "  ");
        GamePanel.add(BorderLayout.WEST, PName);
        GamePanel.add(BorderLayout.WEST, PHealth);
        GamePanel.add(BorderLayout.WEST, PCurrency);
        GamePanel.add(BorderLayout.WEST, PWeapon);

        this.setContentPane(GamePanel);
        this.setVisible(true);
    }
    JTextField ipTxt = new JTextField(20);
    JTextField portTxt = new JTextField(4);
    JPanel scoreSend = new JPanel();
    JLabel ip, port;
    JLabel myScore, YourScore;
    JLabel reload = new JLabel("Reload app to continue");
    //PROGRESSING THROUGH THE GAME
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnAbout) {

            ip = new JLabel("ip: ");
            port = new JLabel("" + theLocale.getLocaleWord("PORT"));
            scoreSend.setBackground(Color.ORANGE);
            scoreSend.add(ip);
            scoreSend.add(ipTxt);
            scoreSend.add(port);
            scoreSend.add(portTxt);
            scoreSend.add(BtnScoreSend);



            this.setContentPane(scoreSend);
            this.setVisible(true);
        }
        if (evt.getSource() == BtnScoreSend){
            scoreSend.remove(ip);
            scoreSend.remove(ipTxt);
            scoreSend.remove(port);
            scoreSend.remove(portTxt);
            scoreSend.remove(BtnScoreSend);

            score.sendMostRecentScore(ipTxt.getText(), Integer.parseInt(portTxt.getText()));
            String mine = "";
            String theirs = "";

            try {
                BufferedReader readScore = new BufferedReader(new FileReader("./src/friendScores.txt"));
                theirs = readScore.readLine();

            }catch (Exception e){
                System.out.println("Something went wrong");
            }
            try {
                BufferedReader readScore = new BufferedReader(new FileReader("./src/savedScores.txt"));
                mine = readScore.readLine();

            }catch (Exception e){
                System.out.println("Something went wrong");
            }


            YourScore = new JLabel("Friend's Score: " + theirs);
            myScore = new JLabel("Your Score: " + mine);

            scoreSend.add(YourScore);
            scoreSend.add(myScore);
            scoreSend.add(reload);

            this.setContentPane(scoreSend);
            this.setVisible(true);
        }
        if (evt.getSource() == btnEng)
        {
            theLocale.setLocale("en","US");
            refreshComponents();
        }
        
        if (evt.getSource() == btnSpan)
        {
            theLocale.setLocale("es","ES");
            refreshComponents();
        }
        
        if (evt.getSource() == btnStart) {

            pnlContain.remove(borders);
            pnlContain.remove(monsterFor);

            txtInputName.addKeyListener(this);
            txtInputAge.addKeyListener(this);



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
                GamePanel.setBackground(Color.ORANGE);
                this.setContentPane(GamePanel);
                this.setVisible(true);
                updatePlayerInfo();


                //BACKGROUND INFORMATION START
                GameSession.append(theLocale.getLocaleWord("BACKGROUND_INFO_1"));

            }else {
                try {
                    notready = new JLabel(theLocale.getLocaleWord("INPUT_INVALID"));
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
                GameSession.setText(theLocale.getLocaleWord("BACKGROUND_INFO_2_1") + " " + this.Player.getName() + theLocale.getLocaleWord("BACKGROUND_INFO_2_2"));
                setCounter(getCounter() + 1);
                //COUNTER = 1
            } else if (getCounter() == 1){
                GameSession.setText(theLocale.getLocaleWord("BACKGROUND_INFO_3"));
                setCounter(getCounter() + 1);
                //COUNTER = 2
                GamePanel.remove(NextButton);

                //NEW BUTTONS ADDED
                GamePanel.add(BorderLayout.SOUTH,Desert);
                //GamePanel.add(BorderLayout.SOUTH,Forest);
                //GamePanel.add(BorderLayout.SOUTH,Mountains);
                this.setContentPane(GamePanel);

            }else if (getCounter() == 2){
                RemoveNextButton();
                YesNoQuestion();
                WeatherTest();
                LuckyYouCoin();
                setCounter(getCounter() + 1);
                //COUNTER = 3
                //RANDOM ENCOUNTER 1
                GameSession.append(GameDesert.randomEncounter1());


            }else if (getCounter() == 5){
                RemoveNextButton();
                chooseToBattle();
                WeatherTest();
                setCounter(getCounter() + 1);
                //COUNTER = 6
                GameSession.append(GameDesert.randomEncounter2());
                GameSession.append("\n\n" + Bandit.getName() + theLocale.getLocaleWord("PLAYER_STAT") + "  " + theLocale.getLocaleWord("HEALTH") + " " + Bandit.getHealth() + "  " + theLocale.getLocaleWord("DAMAGE") + " " + Bandit.getDamageDealt());


            }else if (getCounter() == 6){
                RemoveNextButton();
                YesNoQuestion();
                WeatherTest();
                setCounter(getCounter() + 1);
                //COUNTER = 7
                GameSession.append(GameDesert.randomEncounter3());

            }else if (getCounter() == 7){
                RemoveNextButton();
                twoOptions();
                WeatherTest();
                LuckyYouCoin();
                LuckyYouHealth();
                LuckyYouWeapon();

                setCounter(getCounter() + 1);
                //COUNTER = 8

                GameSession.append(GameDesert.randomEncounter4());

            }else if (getCounter() == 8){
                RemoveNextButton();
                chooseToBattle();
                setCounter(getCounter() + 1);
                //COUNTER = 9
                GameSession.setText(theLocale.getLocaleWord("REACH_MON_FORT"));
                GameSession.append(Castle.LocationDescription + "\n\n" + Castle.randomEncounter1());

            }else if (getCounter() == 9){
                try {
                    score.setFinalScore(this.Player.getHealth(), this.Player.getCurrency(), clock.getTimeScore());
                }catch (Exception e){
                    System.out.println("Oops, Something went wrong");
                }

                GameSession.setText(theLocale.getLocaleWord("RETURNED_AFTER_SLAY_1") + " " + Player.getName() + theLocale.getLocaleWord("RETURNED_AFTER_SLAY_2")
                + "\n\n" + theLocale.getLocaleWord("TIME_PLAY") + clock.getCompletedTimeStamp() + "\n\n" + theLocale.getLocaleWord("SCORE") + score.getScore() + "\n\n" + theLocale.getLocaleWord("RELOAD"));
                setCounter(20);

                //System.out.println(clock.getTimeScore());
                //System.out.println(clock.getCompletedTimeStamp());

            }else if (getCounter() == 20) {
                /*
                setCounter(0);
                RemoveNextButton();
                pnlContain.remove(lblInputName);
                pnlContain.remove(txtInputName);
                pnlContain.remove(lblInputAge);
                pnlContain.remove(txtInputAge);
                pnlContain.setLayout(new BorderLayout());
                pnlContain.add(BorderLayout.NORTH, borders);
                pnlContain.add(BorderLayout.CENTER, monsterFor);
                this.setContentPane(pnlContain);
                this.setVisible(true);

                 */
                System.exit(0);

            }else if (getCounter() == 21) {
               /*
                setCounter(0);
                pnlContain.remove(lblInputName);
                pnlContain.remove(txtInputName);
                pnlContain.remove(lblInputAge);
                pnlContain.remove(txtInputAge);
                pnlContain.setLayout(new BorderLayout());
                pnlContain.add(BorderLayout.NORTH, borders);
                pnlContain.add(BorderLayout.CENTER, monsterFor);
                this.setContentPane(pnlContain);
                this.setVisible(true);

                */
                System.exit(0);


            }

        }
        if (evt.getSource() == btnOpt1){
            GameSession.setText(theLocale.getLocaleWord("OLD_MAN_WISH"));
            this.Player.setHealth(Player.getHealth() + 5);
            updatePlayerInfo();
            removeTwoOptions();
            nextButtonPrompt();
        }else if (evt.getSource() == btnOpt2){
            GameSession.setText(theLocale.getLocaleWord("OLD_MAN_SMACK_1") + " " + Player.getAge() + theLocale.getLocaleWord("OLD_MAN_SMACK_2"));
            this.Player.setHealth(Player.getHealth() - 5);
            updatePlayerInfo();

            removeTwoOptions();
            nextButtonPrompt();
            YouDied(theLocale.getLocaleWord("OLD_MAN_DEATH"));

        }


        if (evt.getSource() == btnBattle){
            if (getCounter() == 6){
                RemoveChooseToBattle();
                GameSession.setText(theLocale.getLocaleWord("BATTLE_BEGIN"));
                nextButtonPrompt();
                battle(Bandit);
                   GameSession.append(theLocale.getLocaleWord("NEXT_CONT"));


            }else if (getCounter() == 9) {
                RemoveChooseToBattle();
                GameSession.setText(theLocale.getLocaleWord("BATTLE_BEGIN"));
                nextButtonPrompt();
                battle(FinalBoss);
                GameSession.append(theLocale.getLocaleWord("NEXT_CONT"));

            }

        }else if (evt.getSource() == btnDontBattle) {
            if (getCounter() == 6) {
                GameSession.setText(theLocale.getLocaleWord("BANDIT_GOLD"));
                RemoveChooseToBattle();
                nextButtonPrompt();
                try {
                    this.Player.setCurrency(this.Player.getCurrency() - 30);
                } catch (Exception e) {
                    this.Player.setCurrency(0);

                }
                updatePlayerInfo();
            }else if (getCounter() == 9){
                GameSession.setText(theLocale.getLocaleWord("MONSTER_KILL"));
                this.Player.setHealth(0);
                updatePlayerInfo();
                YouDied(theLocale.getLocaleWord("MONSTER_KILL"));
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
                GameSession.setText(theLocale.getLocaleWord("WAGON_APPROACH"));
                LuckyYouHealth();

                if (Checker >= 6) {
                    GameSession.append(theLocale.getLocaleWord("FOUND_WIMP_SWORD"));
                    wouldYouLikeToTakeWeapon(new Weapon(theLocale.getLocaleWord("WIMP_SWORD_NAME"), theLocale.getLocaleWord("WIMP_SWORD_DESC"), 30));
                    YesNoQuestion();

                } else if (Checker <= 1) {
                    GameSession.append(theLocale.getLocaleWord("SNAKE"));
                    try {
                        this.Player.setHealth(this.Player.getHealth() - 10);
                    } catch (Exception e){
                        this.Player.setHealth(0);
                    }
                    updatePlayerInfo();


                    setCounter(getCounter() + 1);
                    //COUNT = 5
                    nextButtonPrompt();
                    YouDied(theLocale.getLocaleWord("SNAKE_KILL"));
                } else {
                    setCounter(getCounter() + 1);
                    //COUNT = 5
                    GameSession.append(theLocale.getLocaleWord("NEXT_CONT"));
                    nextButtonPrompt();
                }
            }else if (getCounter() == 4){

                //YES TO WEAPON
                this.Player.setWeapon(new Weapon(theLocale.getLocaleWord("WIMP_SWORD_NAME"), theLocale.getLocaleWord("WIMP_SWORD_DESC"), 30));
                removeYesNo();
                updatePlayerInfo();
                setCounter(getCounter() + 1);
                //COUNT = 5
                GameSession.setText(theLocale.getLocaleWord("ACQ_WIMP_SWORD"));
                nextButtonPrompt();

            }else if (getCounter() == 7){
                GameSession.setText(theLocale.getLocaleWord("OASIS"));
                LuckyYouCoin();
                LuckyYouHealth();
                GameSession.append(theLocale.getLocaleWord("NEXT_CONT"));
                Player.setHealth(Player.getHealth() + 10);
                updatePlayerInfo();
                removeYesNo();
                nextButtonPrompt();
            }


        }else if (evt.getSource() == btnNo){
            if (getCounter() == 3){
                removeYesNo();
                GameSession.setText(theLocale.getLocaleWord("WAGON_SKIP"));
                setCounter(getCounter() + 2);
                //COUNT = 5
                nextButtonPrompt();

            }else if (getCounter() == 4){
                //NO TO WEAPON
                setCounter(getCounter() + 1);
                removeYesNo();
                //COUNT = 5
                GameSession.setText(theLocale.getLocaleWord("NO_PICK_SWORD"));
                nextButtonPrompt();

            }else if (getCounter() == 7){
                GameSession.setText(theLocale.getLocaleWord("SKIP_OASIS"));
                removeYesNo();
                nextButtonPrompt();

            }

        }

        if (evt.getSource() == Desert){
            //STARTING DESERT STORYLINE
            setGameLocation(theLocale.getLocaleWord("DESERT_NAME"));
            GameSession.setText(theLocale.getLocaleWord("ARRIVE") + " " + GameDesert.getLocationName() + "\n\n" + GameDesert.getLocationDescription() + theLocale.getLocaleWord("NEXT_CONT"));
            GamePanel.remove(Desert);
            //GamePanel.remove(Forest);
            //GamePanel.remove(Mountains);
            GamePanel.add(NextButton);
            this.setContentPane(GamePanel);
        }



    }

    public static void main(String[] args) {
        
        GameStarter my = new GameStarter();
        my.setSize(600,500);
        my.setDefaultCloseOperation(EXIT_ON_CLOSE);
        my.setVisible(true);
        my.score.receiveScore();
        int count = 0;

    }

    public void wouldYouLikeToTakeWeapon (Weapon weapon) {
        GameSession.append(theLocale.getLocaleWord("TAKE_WEAPON")
        + weapon.getWeaponName() + " " + theLocale.getLocaleWord("DAMAGE") + " " + weapon.getDamageDealt() +
                " " + theLocale.getLocaleWord("DESC") + " " + weapon.getWeaponDescription());

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
        if(getGameLocation().equals(theLocale.getLocaleWord("DESERT_NAME"))){
            int healthTrack = this.Player.getHealth();
            int ActualHealth = GameDesert.WeatherEffectsOnHealth(Player.getHealth());
            if (ActualHealth < healthTrack) {
                GameSession.setText(theLocale.getLocaleWord("DESERT_DRAIN"));
                Player.setHealth(ActualHealth);
                updatePlayerInfo();
                YouDied(theLocale.getLocaleWord("DESERT_DIE"));
            }else {
                GameSession.setText(theLocale.getLocaleWord("DESERT_HURRY"));
            }
        }

    }

    Boolean winner = false;
    Integer DamageTracker;
    public void battle (Enemy enemy) {
        setWinner(false);
            while(enemy.getHealth() > 0 && Player.getHealth() > 0) {
                if (HeroGoesFirst().equals(theLocale.getLocaleWord("HERO"))) {
                    try {
                        enemy.setHealth(enemy.getHealth() - this.Player.getWeapon().getDamageDealt());
                    } catch (Exception e) {
                        enemy.setHealth(0);
                    }
                    GameSession.append(theLocale.getLocaleWord("ATTACK") + " " + enemy.getName());
                    if (enemy.getHealth() <= 0) {
                        GameSession.append(theLocale.getLocaleWord("CONGRAT_DEFEAT") + " " + enemy.getName());
                        setWinner(true);
                    } else {
                        try {
                            this.Player.setHealth(this.Player.getHealth() - enemy.getDamageDealt());
                        } catch (Exception e) {
                            this.Player.setHealth(0);
                        }
                        GameSession.append("\n" + enemy.getName() + " " + theLocale.getLocaleWord("O_ATTACK"));
                        YouDied(enemy.getName() + " " + theLocale.getLocaleWord("O_KILL"));
                    }
                } else {
                    try {
                        this.Player.setHealth(this.Player.getHealth() - enemy.getDamageDealt());
                    } catch (Exception e) {
                        this.Player.setHealth(0);
                    }
                    GameSession.append("\n" + enemy.getName() + " " + theLocale.getLocaleWord("O_ATTACK"));
                    YouDied(enemy.getName() + " " + theLocale.getLocaleWord("O_KILL"));

                    try {
                        enemy.setHealth(enemy.getHealth() - this.Player.getWeapon().getDamageDealt());
                    } catch (Exception e) {
                        enemy.setHealth(0);
                    }
                    GameSession.append(theLocale.getLocaleWord("ATTACK") + " " + enemy.getName());
                    if (enemy.getHealth() <= 0) {
                        GameSession.append(theLocale.getLocaleWord("CONGRAT_DEFEAT") + " " + enemy.getName());
                        setWinner(true);
                    }

                }

            }
        updatePlayerInfo();
        YouDied(enemy.getName() + " " + theLocale.getLocaleWord("O_KILL"));

    }


    public String HeroGoesFirst(){
        Random GoesFirst = new Random();
        int Checker = GoesFirst.nextInt(8);
        if (Checker % 2 == 0){
            return theLocale.getLocaleWord("HERO");
        }else {
            return theLocale.getLocaleWord("NO");
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
            GameSession.append(theLocale.getLocaleWord("FOUND_COIN"));
            Player.setCurrency(Player.getCurrency() + 5);
            updatePlayerInfo();
        }

    }
    public void LuckyYouWeapon(){
        Random Lucky = new Random();
        int Checker = Lucky.nextInt(8);

        if (Checker == 4 || Checker == 3){
            GameSession.append(theLocale.getLocaleWord("FOUND_PIECE"));
            this.Player.getWeapon().setDamageDealt(this.Player.getWeapon().getDamageDealt() + 1);
            updatePlayerInfo();
        }

    }
    public void LuckyYouHealth(){
        Random Lucky = new Random();
        int Checker = Lucky.nextInt(8);

        if (Checker == 4 || Checker == 3){
            GameSession.append(theLocale.getLocaleWord("FOUND_ELIXIR"));
            Player.setHealth(Player.getHealth() + 5);
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
    JPanel GameOver;
    JLabel Dead;
    public void YouDied (String a){
        if (this.Player.getHealth().toString().contains("-")){
            this.Player.setHealth(0);
        }
        if (Player.getHealth() <= 0){
            setWinner(false);
            GameOver = new JPanel();
            Dead = new JLabel(theLocale.getLocaleWord("SLAIN_1") + a + theLocale.getLocaleWord("SLAIN_2"));
            GameOver.add(Dead);
            GameOver.add(NextButton);
            GameOver.add(reload);
            setCounter(21);
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

    public void refreshComponents()
    {
            btnStart.setText(theLocale.getLocaleWord("START"));
            btnAbout.setText(theLocale.getLocaleWord("ABOUT"));
            btnEng.setText(theLocale.getLocaleWord("ENGLISH"));
            btnSpan.setText(theLocale.getLocaleWord("SPANISH"));
            lblLang.setText(theLocale.getLocaleWord("LANGUAGE"));
            NextButton.setText(theLocale.getLocaleWord("NEXT"));
    }
}
