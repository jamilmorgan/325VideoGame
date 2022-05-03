import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {

    LocalDateTime timeBegin;


    public Time() {

        timeBegin = LocalDateTime.now();


    }


    public Integer getTimeScore(){
        LocalDateTime timeFinal = LocalDateTime.now();
        timeFinal = timeFinal.minusMinutes(timeBegin.getMinute());
        timeFinal = timeFinal.minusSeconds(timeBegin.getSecond());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("mm ss");
        String save = timeFinal.format(format);
        String min = save.substring(0, save.indexOf(" "));
        String sec = save.substring(save.indexOf(" ") + 1);
        int minute = Integer.parseInt(min) * 60;
        int second = Integer.parseInt(sec);

        return minute + second;

    }

    public String getCompletedTimeStamp(){
        String line = "Getting Time";
        try
        {
            Socket s = new Socket("time-A.timefreq.bldrdoc.gov",13);
            try
            {
                InputStream inStream = s.getInputStream();
                Scanner in = new Scanner(inStream);
                while(in.hasNextLine())
                {
                    line = in.nextLine();
                } }
            finally {

                s.close();
            }
        }
        catch(IOException ioexc)
        {
            ioexc.printStackTrace();
        }

        return line.substring(line.indexOf(" ", 6) + 1,line.indexOf(" ", 6) + 9);

    }



        /*
        String time = my.getTime();
        time = time.substring(time.indexOf(" ", 6) + 1,time.indexOf(" ", 6) + 9);
        System.out.println(time);
         */






    public LocalDateTime getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(LocalDateTime timeBegin) {
        this.timeBegin = timeBegin;
    }


}
