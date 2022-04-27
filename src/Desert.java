import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Desert extends Location{


    Desert(){
        this.setLocationDescription("The Desert is a harsh environment." +
                "\nThe sand is scorching to the touch and the heat drains you of your energy." +
                "\nYou will lose 5 health points occasionally");
        this.setLocationName("Desert");

    }

    public String randomEncounter1() {
        return "During your travels, you come across an abandoned wagon alongside the road, do you stop?";
    }




        public Integer WeatherEffectsOnHealth (Integer Health){
            Random IfLoseHealth = new Random();
            int Checker = IfLoseHealth.nextInt(8);


            if (Checker == 7){
                return Health - 5;
            }else {
                return Health;
            }


            }

        }



