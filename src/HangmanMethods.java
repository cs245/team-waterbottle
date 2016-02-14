/***************************************************************
* file: .java
* author: Team Water Bottle
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project - Checkpoint 1
* date last modified: 1/31/2016
*
* purpose: Class that contains the methods used in our hangman game.
*
****************************************************************/ 
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;


public class HangmanMethods {

    private String[] wordList;     //array full of words to be used for hangman

    private String currentWord;    //word currently in play
    private int lettersLeft;       //letters left to guess
    private int guessesLeft = 6;   //guesses user has left
    private int score = 100;       //user's score


    //constructor
    //purpose: populates the list of words to be used for hangman game and picks one.
    HangmanMethods(){
       wordList = new String[] {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
       pickWord();
    }

    //method: pickWord
    //purpose: randomly picks a word at random from the array.
    public void pickWord(){

       Random ran = new Random();
       int randomNumber = ran.nextInt(wordList.length); 
       currentWord =  wordList[randomNumber];
       lettersLeft = currentWord.length();
    }

    //method: checkLetter
    //purpose: checks letter passed in, return true or false and updates the score and 
    //# of guesses and letters left.
    public boolean checkLetter(char guessedLetter)
    {
        //Find count of the guessed letter in the word.
        int count = currentWord.length() - currentWord.replace(Character.toString(Character.toLowerCase(guessedLetter)), "").length();
        if(count > 0)
        {
            for(int i = 0; i < currentWord.length(); i++)
            {
                if(Character.toLowerCase(guessedLetter) == (currentWord.charAt(i)))
                    lettersLeft--;             
            }
            return true;
        }
       guessesLeft--;

       score-=10;
       return false;

    }

    //method:word
    //purpose: returns the current word
    public String word(){

       return currentWord;
    }
    //method:guessesLeft
    //purpose: returns the remaining amount of guesses
    public int guessesLeft()
    {
        return guessesLeft;
    }
    //method:getScore
    //purpose: returns the users current score
    public int getScore()
    {
        return score;
    }
    //method: gameOver
    //purpose: returns score once game is over.
    public int gameOver()
    { 
        return score;
    }
    public void skipper()
    {
        score = 0;
    }
    //method:completed
    //purpose:returns true if the word is complete and false otherwise
    public boolean completed()
    {
        return lettersLeft == 0;
            
    }
}
