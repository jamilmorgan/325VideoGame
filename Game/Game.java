
import java.util.*;

public class Game {

    private ArrayList <Location> map; 
    private ArrayList <Weapon> weapons;
    private Player player;
    private Enemy bear, guard, ugly, goblin, dragon, king;
    private HealthItem nullPotion, potion1, potion2;
    
    GameGUI gui;

    List<String> commands = new ArrayList<>(Arrays.asList("enter", "take", "drop", "attack", "run", "submit", "n", "s", "w", "e"));
    List<String> objects = new ArrayList<>(Arrays.asList("weapon", "potion"));

    public Game(GameGUI gui) {
        
        this.gui = gui;
        
        map = new ArrayList<Location>(); 
        weapons = new ArrayList<Weapon>();
        

        weapons.add(new Weapon("Hands", "Just your measly bare fists.", 1));
        weapons.add(new Weapon("Bear Hands", "The hands of a great grizzly.", 6));
        weapons.add(new Weapon("Dagger", "A small dagger with mighty precision.", 2));
        weapons.add(new Weapon("Sword", "A standard sword. Nothing too special.", 3));
        weapons.add(new Weapon("Long Sword", "A longer sword to reach the farthest of foes.", 3));
        weapons.add(new Weapon("Wooden Staff", "A crusty wooden stick used to fight.", 6));
        weapons.add(new Weapon("Dragon Breath", "The ferocious burn of a breath of fire.", 9));
        weapons.add(new Weapon("Magical Staff", "One ancient staff rumored to be created by the gods.", 10));
        weapons.add(new Weapon("Kings Sword", "Smelted by the best for... well the not so best.", 13));
        
        nullPotion = new HealthItem("NULL", "No potion.", 0);
        potion1 = new HealthItem("Health Potion", "A standard health potion.", 5);
        potion2 = new HealthItem("Health Potion", "A very potent health potion.", 10);
        
        bear = new Enemy("Grizzly Bear", "Is it a mama bear or a papa bear?... Because it is certaintly not a baby bear.", null, weapons.get(1), 6, false);
        guard = new Enemy("Castle Guard", "A stern guard who takes his job too seriously.", null, weapons.get(4), 5, false);
        ugly = new Enemy("Ugly Creature", "Oh my! It is hideous. It has five eyes, crooked teeth, and large, dirty claws.", null, weapons.get(0), 0, false);
        goblin = new Enemy("Old Goblin", "A wrinkly, old goblin.", null, weapons.get(5), 6, false);
        dragon = new Enemy("Dragon", "A magestic ruby-scaled dragon with fire breath.", null, weapons.get(6), 10, false);
        king = new Enemy("Mighty King", "A strong, intelligent king with little legs.", null, weapons.get(8), 8, false);
        
        map.add(new Location("Cross Road", "A lonely cross road for lonely men.", weapons.get(3), nullPotion, null, 3, Direction.NOEXIT, 1, 2));
        map.add(new Location("Forest", "A vast leafy woodland.", weapons.get(7), potion1, ugly, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 0));
        map.add(new Location("Cave", "A dark, dismal cave with bones littering the entrance.", weapons.get(1), potion2, bear, Direction.NOEXIT, Direction.NOEXIT, 0, Direction.NOEXIT));
        map.add(new Location("Castle Gates", "Large iron-traced, wooden gates built to protect.", weapons.get(4), nullPotion, guard, 4, 0, Direction.NOEXIT, Direction.NOEXIT));
        map.add(new Location("Castle", "A gigantic stone castle that touches the clouds.", weapons.get(0), nullPotion, null,  7, 3, 5, 6));
        map.add(new Location("Dungeon", "An ill-lit dungeon fit for nightmares.", weapons.get(5), nullPotion, goblin, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 4));
        map.add(new Location("Mysterious Room", "A room with no purpose behind a random door.", weapons.get(6), nullPotion, dragon, Direction.NOEXIT, Direction.NOEXIT, 4, 8));
        map.add(new Location("Throne Room", "A large room for such a tiny throne.", weapons.get(8), nullPotion, king, Direction.NOEXIT, 4, Direction.NOEXIT, Direction.NOEXIT));
        map.add(new Location("Treasure Room", "Behold! A room glistening in pure gold!", weapons.get(0), nullPotion, null, Direction.NOEXIT, Direction.NOEXIT, 6, Direction.NOEXIT));
        map.add(new Location("NO_WHERE", "", weapons.get(0), nullPotion, null, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT));
        
        bear.setLocation(map.get(2));
        guard.setLocation(map.get(3));
        ugly.setLocation(map.get(1));
        goblin.setLocation(map.get(5));
        dragon.setLocation(map.get(6));
        king.setLocation(map.get(7));
        

        player = new Player("player", "a loveable game-player", map.get(0), weapons.get(0), 5);
        
    }

   
    private ArrayList getMap() {
        return map;
    }

    private void setMap(ArrayList<Location> aMap) {
        map = aMap;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player aPlayer) {
        player = aPlayer;
    }

    private void moveCharacterTo(Character p, Location aLocation) {
        p.setLocation(aLocation);
    }

    private int moveTo(Character anCharacter, Direction dir) {
       
        
        Location l = anCharacter.getLocation();
        int exit;

        switch (dir) {
            case NORTH:
                exit = l.getN();
                break;
            case SOUTH:
                exit = l.getS();
                break;
            case EAST:
                exit = l.getE();
                break;
            case WEST:
                exit = l.getW();
                break;
            default:
                exit = Direction.NOEXIT;
                break;
        }
        if (exit != Direction.NOEXIT) {
            moveCharacterTo(anCharacter, map.get(exit));
        }
       
        return exit;
    }

    public int movePlayerTo(Direction dir) {
        
        return moveTo(player, dir);
    }
    
    public void endGame()
    {
        String GAME_OVER = "\n  You didn't complete your task. Your game is over.\n\n  1. quit\n";
        
        gui.printOutput(GAME_OVER);
        
        System.out.println(GAME_OVER);
    }
    
    public void runWin()
    {
        String WIN = "\n  Congrats! You have found the treasure. You must be proud... I surely am.";
        String QUIT_ONLY = "\n\n  1. quit\n";
        
        gui.printOutput(WIN + getNextMessage() + QUIT_ONLY);
        
        System.out.println(WIN);
    }
    
    private void Attack(Enemy e, Location l)
    {
        
        Weapon eWeapon = e.getWeapon();
        int eDamage = eWeapon.getDamage();
        int eHealth = e.getHealth();
        
        Weapon pWeapon = player.getWeapon();
        int pDamage = pWeapon.getDamage();
        int pHealth = player.getHealth();
        
        boolean eAlive = e.checkHealth(eHealth);
        boolean pAlive = player.checkHealth(pHealth);
 
        if(eDamage < pHealth && pDamage < eHealth)
        {
            pHealth = player.removeHealth(pHealth, eDamage);
            eHealth = e.removeHealth(eHealth, pDamage);
            
            gui.setPHealth(pHealth);
            
            eAlive = e.checkHealth(eHealth);
            pAlive = player.checkHealth(pHealth);

            
            while(eAlive && pAlive)
            {
                String DAM_1 = "\n  You gave the ";
                String DAM_2 = " damage!\n";
                String DAM_3 = "It gave you ";
                String DAM_4 = "\n  The fight can still go on!\n";
                
                gui.printOutput(DAM_1 + e.getName() + " " + pDamage + DAM_2 + DAM_3 + eDamage + DAM_2 + DAM_4 + getNextMessage());
                
                System.out.println(DAM_1 + e.getName() + " " + pDamage + DAM_2 + DAM_3 + eDamage + DAM_2 + DAM_4 + getNextMessage());
                
                pHealth = player.removeHealth(pHealth, eDamage);
                eHealth = e.removeHealth(eHealth, pDamage);
                
                gui.setPHealth(pHealth);

                eAlive = e.checkHealth(eHealth);
                pAlive = player.checkHealth(pHealth);

            } 
         
            
            pAlive = player.checkHealth(pHealth);
            
            if(pAlive == true)
            {
                String WON_1 = "\n  Congrats you lad!\nYou defeated the ";
                String A_DROP = " was dropped.\n";
                String PWD_OPTION = "\n  1. take potion\n  2. take weapon\n  3. n / s / e / w \n  4. quit\n";
                String WD_OPTION = "\n  1. take weapon\n  2. n / s / e / w \n  3. quit\n";
                
                gui.printOutput(WON_1 + e.getName() + ".\n" + "\n" + l.getWeapon().getName() + A_DROP);
                
                System.out.println(WON_1 + e.getName() + ".\n" + "\n" + l.getWeapon().getName() + A_DROP);
                
                if(!l.getHealthItem().getName().equals("NULL"))
                {
                    gui.printOutput("  " + l.getHealthItem().getName() + A_DROP + "\n" + getNextMessage() + PWD_OPTION);
                    
                    System.out.println(l.getHealthItem().getName() + A_DROP + "\n" + getNextMessage() + PWD_OPTION);
                    
                }
                else
                {
                    gui.printOutput(getNextMessage() + "\n" + WD_OPTION);
                    
                    System.out.println(getNextMessage() + "\n" + WD_OPTION);
                }
            }
            else
            {
                String LOST_1 = "\n  Oh ... well, you were slained.\n";
                
                gui.printOutput(LOST_1);
                
                System.out.println(LOST_1);
                
                endGame();
            }
        }
        else if(pDamage >= eHealth)
        {
            String WON_2 = "\n  You are stronger than you seem.\n  You defeated the ";
            String A_DROP = " was dropped.\n";
            
            e.removeHealth(eHealth, pDamage);
            
            gui.printOutput(WON_2 + e.getName() + ".\n\n  " + l.getWeapon().getName() + A_DROP);
            
            System.out.println(WON_2 + e.getName() + ".\n  " + l.getWeapon().getName() + A_DROP);
            
            if(!l.getHealthItem().getName().equals("NULL"))
            {
                String PWD_OPTION = "\n  1. take potion\n  2. take weapon\n  3. n / s / e / w \n  4. quit\n";
                
                gui.printOutput("  " + l.getHealthItem().getName() + A_DROP + "\n" + getNextMessage() + PWD_OPTION);
                
                System.out.println(l.getHealthItem().getName() + A_DROP + "\n" + getNextMessage() + PWD_OPTION);
            }
            else
            {
                String WD_OPTION = "\n  1. take weapon\n  2. n / s / e / w \n  3. quit\n";
                
                gui.printOutput(getNextMessage() + "\n" + WD_OPTION);
                
                System.out.println(getNextMessage() + "\n" + WD_OPTION);
            }
            
        }
        else if(eDamage >= pHealth)
        {
            String LOST_2 = "\n  Weak! You were slain immediately by the ";
            
            player.removeHealth(pHealth, eDamage);
            
            gui.setPHealth(player.getHealth());
            
            gui.printOutput(LOST_2 + e.getName() + ".");
            
            System.out.println(LOST_2 + e.getName() + ".");
            
            endGame();
        }
        else
        {
            System.out.println("IDK");
        }
        
    }

    private void goN() {
        updateOutput(movePlayerTo(Direction.NORTH));
    }

    private void goS() {
        updateOutput(movePlayerTo(Direction.SOUTH));
    }

    private void goW() {
        updateOutput(movePlayerTo(Direction.WEST));
    }

    private void goE() {
        updateOutput(movePlayerTo(Direction.EAST));
    }

    private void runEnter()
    {
        Location l = player.getLocation();
        
        if(l.getEnemy() != null)
        {
            Enemy e = l.getEnemy();
            e.setDiscovered(true);
            
            String ITS_A = "\n  Oh no! It's a ";
            String A_OPTION = "\n  1. attack\n  2. quit\n";
            
            gui.printOutput(ITS_A + e.getName() + ".\n  " + e.getDescription() + "\n" + getNextMessage() + A_OPTION);
            
            System.out.println(ITS_A + e.getName() + ".\n" + e.getDescription() + "\n" + getNextMessage() + A_OPTION);
        }
        else
        {
            String NOTHING_HERE = "  There is nothing here.\n";
            String D_OPTION = "\n  1. n / s / e / w\n  2. quit\n";
            
            gui.printOutput(NOTHING_HERE + getNextMessage() + "\n" + D_OPTION);
            
            System.out.println(NOTHING_HERE + getNextMessage() + "\n" + D_OPTION);
        }
        
    }
    
    private void runAttack()
    {
        Location l = player.getLocation();
        Enemy e = l.getEnemy();
        
        boolean b = e.getDiscovered();
        
        if(b)
        {
            Attack(e, l);
        }
        else
        {
            String NO_ENEMY = "\n  There is no enemy yet.\n";
            
            System.out.println(NO_ENEMY + getNextMessage());
        }
    }
    
    private void updateOutput(int roomNumber) {

        if (roomNumber == Direction.NOEXIT) {
            
            String DIF_DIR = "\n  Can't go that way!\n  Try a different direction.\n";
            
            gui.printOutput(DIF_DIR);
            
            System.out.println(DIF_DIR);
            
        } else {
            Location l = getPlayer().getLocation();
            
            String TR_N = "Treasure Room";
            
            if(l.getName().equals(TR_N))
            {
                runWin();
            }
            else
            {
                String AT = "\n  You are at the ";
                String E_OPTION = "\n  1. enter\n  2. quit\n";
                
                gui.printOutput(AT + l.getName() + ". " + l.getDescription() + "\n" + getNextMessage() + E_OPTION);
                
                System.out.println(AT + l.getName() + ". " + l.getDescription() + "\n" + getNextMessage() + E_OPTION);
            }
        }
    }

    public String processVerb(List<String> wordlist) {
        String verb;
        String msg = "";
        
        verb = wordlist.get(0);
        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
        } else {
            switch (verb) {
                case "enter":
                    runEnter();
                    break;
                case "attack":
                    runAttack();
                    break;
                case "n":
                    goN();
                    break;
                case "s":
                    goS();
                    break;
                case "w":
                    goW();
                    break;
                case "e":
                    goE();
                    break;
                default:
                    msg = verb + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }

    public String processVerbNoun(List<String> wordlist) {
        String verb;
        String noun;
        String msg = "";
        
        verb = wordlist.get(0);
        noun = wordlist.get(1);
        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
        }
        if (!objects.contains(noun)) {
            msg += (noun + " is not a known noun!");
        }
        
        if (verb.equals("take") && noun.equals("weapon"))
        {
            Location l = getPlayer().getLocation();
            Weapon w = l.getWeapon();
            player.setWeapon(w);
            
            gui.setPWeapon(w);
            
            String H = "Hands";
            String NO_WEAPON = "\n  There is no weapon.\n";
            String PICK_UP = "\n  You picked up a ";
           
            if(w.getName().equals(H))
            {
                gui.printOutput(NO_WEAPON + getNextMessage());
                
                System.out.println(NO_WEAPON + getNextMessage());
            }
            else
            {
                gui.printOutput(PICK_UP + w.getName() + ".\n" + getNextMessage());
                
                System.out.println(PICK_UP + w.getName() + ".\n" + getNextMessage());
            }
        }
        
        if (verb.equals("take") && noun.equals("potion"))
        {
            Location l = getPlayer().getLocation();
            HealthItem h = l.getHealthItem();
            int hItem = h.getLevel();
            int hPlayer = player.getHealth();
            
            String NO_POTION = "\n  There is no potion.\n";
            String DRINK = "\n  You drank a ";
            
            if(h.getName().equals("NULL"))
            {
                gui.printOutput(NO_POTION + getNextMessage());
                
                System.out.println(NO_POTION + getNextMessage());
            }
            else
            {
                int newHealth = player.addHealth(hPlayer, hItem);
                player.setHealth(newHealth);
                
                gui.printOutput(DRINK + h.getName() + ". " + h.getDescription() + ".\n" + getNextMessage());
                
                System.out.println(DRINK + h.getName() + ". " + h.getDescription() + ".\n" + getNextMessage());
            }
        }
        
        if (verb.equals("drop") && noun.equals("weapon"))
        {
            Location l = player.getLocation();
            Weapon inHand = player.getWeapon();
            Weapon d = player.getDefaultWeapon();
            player.setWeapon(d);
            
            gui.setPWeapon(d);
            
            String H = "Hands";
            String NO_WEAPON_HAND = "\n  You have no weapon in hand.\n";
            String DROP = "\n  You dropped your ";
            
            if(inHand.getName().equals(H))
            {
                
                gui.printOutput(NO_WEAPON_HAND + getNextMessage());
                
                System.out.println(NO_WEAPON_HAND + getNextMessage());
            }
            else
            {
                if(inHand.getName().equals(H))
                {
                
                }

                gui.printOutput(DROP + inHand.getName() + ".\n" + getNextMessage());
                
                System.out.println(DROP + inHand.getName() + ".\n" + getNextMessage());
            }
        }
       

        return msg;
    }

    public String getNextMessage()
    {
        String NEXT_MOVE = "  What is your next move?\n";
        return(NEXT_MOVE);
    }
    
    public String parseCommand(List<String> wordlist) {
        String msg;
        if (wordlist.size() == 1) {
            msg = processVerb(wordlist);
        } else if (wordlist.size() == 2) {
            msg = processVerbNoun(wordlist);
        } else {
            msg = "Only 2 word commands allowed!";
        }
        return msg;
    }

    public static List<String> wordList(String input) {        
        String delims = "[ \t,.:;?!\"']+"; 
        List<String> strlist = new ArrayList<>();      
        String[] words = input.split(delims);
    
        for (String word : words) {
            strlist.add(word);
        }        
        return strlist;
    }

    public void showIntro(){
        
        String INTRO = "  You awake in a crossroad. "
                + "Beside you is a note.\n  The note reads...\n\n"
                + "            ...You have one task. Find the treasure...\n\n"
                + "  There is a weapon lying next to you.\n"
                + "  What is your next move?\n";
        
        String WD_OPTION = "\n  1. take weapon\n  2. n / s / e / w \n  3. quit\n";
       
        
        gui.printOutput(INTRO + WD_OPTION);
        
        System.out.println(INTRO + WD_OPTION);
        
    }
    
    public String runCommand(String inputstr) {
        List<String> wordlist;
        String s = "Ok";
        String lowstr = inputstr.trim().toLowerCase();        
        if (!lowstr.equals("q")) {
            if (lowstr.equals("")) {
                s = "You must enter a command.";
            } else {
                wordlist = wordList(lowstr);                
                s = parseCommand(wordlist);
            }
        }
        return s;
    }

}
