
import java.io.IOException;


public class AdventureTest {

    public static void main(String[] args) throws IOException {
        
        //Instantiate the game gui
        GameGUI gui = new GameGUI();
        gui.setSize(740,550);
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
        gui.setResizable(false);
        gui.setDefaultCloseOperation(GameGUI.EXIT_ON_CLOSE);
        
        gui.showIntro();
        
    }

}