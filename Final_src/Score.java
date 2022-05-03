import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Score {

    Integer score = 0;

    public Score () {
        setScore(0);

    }

    public void setFinalScore(Integer health, Integer currency, Integer time){
        this.setScore((health + currency) - time);

        try {
            FileWriter scoreWrite = new FileWriter("./src/savedScores.txt");
            scoreWrite.write("" + getScore());
            scoreWrite.close();
        } catch (Exception e){
            System.out.println("Something went wrong when writing the score");
        }
    }

    public void sendMostRecentScore(String ip, Integer port){

        String a = "";
        try {
            BufferedReader readScore = new BufferedReader (new FileReader("./src/savedScores.txt"));

            a = readScore.readLine();
            System.out.println(a);
        }catch (Exception e){
            System.out.println("Something went wrong when sending the score");
        }

        try {
            Socket s = new Socket(ip,port);
            try {
                OutputStream outStream = s.getOutputStream();
                PrintWriter out = new PrintWriter(outStream,true);
                InputStream inStream = s.getInputStream();
                Scanner in = new Scanner(inStream);
                out.println(a);
            } finally {
                s.close();
            }
        } catch (IOException ioexc) {
            ioexc.printStackTrace();
        }


    }
    public void receiveScore(){

        try {
            ServerSocket s = new ServerSocket(7100);

                Socket incoming = s.accept();
                try {
                    InputStream inStream = incoming.getInputStream();
                    OutputStream outStream = incoming.getOutputStream();
                    Scanner in = new Scanner(inStream);
                    PrintWriter out = new PrintWriter(outStream,true);
                    boolean done = false;
                    while (!done && in.hasNextLine()) {

                        String lineIn = in.nextLine();
                        try {
                            FileWriter scoreWrite = new FileWriter("./src/friendScores.txt");
                            scoreWrite.write("" + getScore());
                            scoreWrite.close();
                        } catch (Exception e){
                            System.out.println("Something went wrong when writing the score");
                        }

                        if (lineIn.trim().equals("BYE"))
                        {
                            done = true;
                        }
                    }
                }
                catch(Exception exc1) {
                    exc1.printStackTrace();
                }

        }
        catch(Exception exc2) {
            exc2.printStackTrace();
        }


    }


    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
