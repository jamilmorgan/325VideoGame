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
    public String randomEncounter2() {
        return "As you continue your travels, a bandits notices you.\n\n He approaches you and pulls out a knife, demanding your money.\n\nWhat will you do?";
    }
    public String randomEncounter3() {
        return "You are nearing the fortress, but first you see and Oasis. Will you stop to rest?";
    }
    public String randomEncounter4() {
        return "You've reached the end of the desert! But before you could enter the Monster's fortress, you are stopped by an rather old man.\n" +
                "\nHe urges you to not go because it is too dangerous. How do you respond?\n\n1. Sorry, I have no choice, but I promise to come back alive\n\n2. Move out of the way!";
    }




        public Integer WeatherEffectsOnHealth (Integer Health){
            Random IfLoseHealth = new Random();
            int Checker = IfLoseHealth.nextInt(8);


            if (Checker >= 6){
                return Health - 5;
            }else {
                return Health;
            }


            }

        }



