import java.util.*;

public class MyLocale {
    
    Locale locale;
    ResourceBundle dictionary;

    public void MyLocale()
    {

    }
    
    public void displayCntry()
    {
        System.out.println(locale.getCountry());
    }
    
    public void setLocale(String lang, String loc)
    {
        locale = new Locale(lang, loc);
    }
    
    public String getLocaleWord(String key)
    {
        String word = "";
        word = getWord(this.locale, key);

        return word;
    }
    
    public String getWord(Locale curLocale, String key)
    {
        String loc = curLocale.getCountry();
        String value = "";

        if(loc.equals("US"))
        {
                dictionary = ResourceBundle.getBundle("dictionary_en_US", curLocale);
                value = dictionary.getString(key);
        }
        else if(loc.equals("ES"))
        {
                dictionary = ResourceBundle.getBundle("dictionary_es_ES", curLocale);
                value = dictionary.getString(key);
        }

        return value;
    }

}
