
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Desert extends Location{

    MyLocale theLocale;

    Desert(MyLocale loc){
        
        theLocale = loc;
        
        System.out.println(theLocale);
        
        this.setLocationDescription(theLocale.getLocaleWord("DESERT_DESC"));
        this.setLocationName(theLocale.getLocaleWord("DESERT_NAME"));

    }

    public String randomEncounter1() {
        return (theLocale.getLocaleWord("DESERT_ENC_1"));
    }
    public String randomEncounter2() {
        return (theLocale.getLocaleWord("DESERT_ENC_2"));
    }
    public String randomEncounter3() {
        return (theLocale.getLocaleWord("DESERT_ENC_3"));
    }
    public String randomEncounter4() {
        return (theLocale.getLocaleWord("DESERT_ENC_4"));
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
