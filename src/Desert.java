import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Desert extends Location{


    Desert(){
        this.setLocationDescription("The Desert is a harsh environment." +
                "\nThe sand is scorching to the touch and the heat drains you of your energy." +
                "\nYou will lose 5 health points occasionally");
        this.setLocationName("Desert");

    }




        public Integer WeatherEffectsOnHealth (Integer Health){
            return Health - 5;
        }


}
