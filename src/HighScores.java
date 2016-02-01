/***************************************************************
* file: HighScores.java
* author: Team Water Bottle
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project - Checkpoint 1
* date last modified: 1/31/2016
*
* purpose: Class to handle the reading and writing of our high scores. 
*
****************************************************************/ 
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

public class HighScores 
{
    
    private ArrayList<String> scores;
    private File highScores = null;
    private String path;
    private Scanner sc = null;
    private PrintWriter pw = null;
    
    //method:constructor
    //purpose: Checks if there is already a high scores txt file  and creates a new one if there isn't.
    //If it exists then it reads in the scores.
    public HighScores() throws IOException
    {
        
        scores = new ArrayList<String>();
        path = "High Scores.txt";
        highScores = new File(path);
        //Get current high scores
        if(highScores.exists() && !highScores.isDirectory())
        {
            sc = new Scanner(highScores);
            int i = 0;
            while(sc.hasNextLine())
            {
                scores.add(sc.nextLine());
                i++;
            }
            sc.close();
        }
        //Create new high scores
        else
        {
            pw = new PrintWriter(new FileWriter(highScores));
            for(int i = 0; i < 5; i++)
            {
                pw.println("ABC....000");
                scores.add("ABC....000");
            }
            pw.close();         
        }  
    }
    //method:checkScore
    //purpose:Checks if the given score is higher than any of the current high scores.
    //        Returns the index if score is higher, and -1 if not.
    public int checkScore(int score)
    {
        for(int i = 0; i < 5; i++)
        {
            if(Integer.parseInt(scores.get(i).substring(7)) < score)
                return i;
        }
        return -1;
    }
    //method:addScore
    //purpose:Check if new score is a high score and updates the scores ArrayListand file if it is.
    public boolean addScore(int score, String player) throws IOException
    {
        int i = checkScore(score);
        if(i > -1)
        {
            scores.add(i, player+"...."+String.format("%03d", score));
            scores.remove(scores.size()-1);
            writeNewScores();
            return true;
        }
        return false;
    }
    //method:getScores
    //purpose:Returns the score array.
    public String[] getScores()
    {   
        return scores.toArray(new String[5]);
    }

    private void writeNewScores() throws IOException 
    {
        pw = new PrintWriter(new FileWriter(highScores));
        for(String s:scores)
        {
            pw.println(s);
        }
        pw.close();
    }
}
