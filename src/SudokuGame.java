
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Timothy
 */
public class SudokuGame extends javax.swing.JPanel 
{
    private javax.swing.JTextField dateTxt;
    private javax.swing.JButton submit;
    private javax.swing.JButton quit;
    private javax.swing.JLabel jLabel1;
    private SudokuGrid grid;
    
    //CardLayout to switch between screens
    private CardLayout cl;
    //Highscores class to update scores
    private HighScores scores;
    private JPanel mainPanel;
    private JLabel finalScore;
    private JLabel newHS;
    private JButton saveScoreBtn;
    private int score;
    /**
     * Creates new form Sudoku
     */
    public SudokuGame(int scr, CardLayout layout, JPanel mPanel, JLabel scoreLabel, JLabel nhs, HighScores hs, JButton saveBtn) 
    {
        initComponents();
        
        grid.setPreferredSize(new Dimension(368,352));
        score = 540+scr;
        cl = layout;
        mainPanel = mPanel;
        finalScore = scoreLabel;
        newHS = nhs;
        scores = hs;
        saveScoreBtn = saveBtn;
        
        Timer timer = new Timer(500, new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                currentDate();
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        dateTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        quit = new javax.swing.JButton();
        grid = new SudokuGrid();

        setPreferredSize(new java.awt.Dimension(600, 400));

        dateTxt.setEditable(false);
        dateTxt.setText("Date & Time");

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        jLabel1.setText("SUDOKU");

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        quit.setText("Cancel");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(submit)
                        .addGap(1, 1, 1)
                        .addComponent(grid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quit)
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(quit)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(submit)
                                .addGap(40, 40, 40))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>     
    
    private void submitActionPerformed(java.awt.event.ActionEvent evt) 
    {                                        
        boolean[][] result = checkSolution();
        for(int i = 0; i < result.length; i++)
        {
            for(int j = 0; j < result.length; j++)
            {
                if(!result[i][j])
                    score -= 10;
            }
        }
        gameOver(false);
    }                 
    private void quitActionPerformed(java.awt.event.ActionEvent evt) 
    {                                        
         gameOver(true);
    }    
    
    public void gameOver(boolean skipped)
    {
        newHS.setVisible(false);
        saveScoreBtn.setVisible(false);
        if(skipped)
        {
            finalScore.setText("Score:" + 0);
        }
        else
        {
            finalScore.setText("Score:" + score);
            //See if new score is a high score
            if(scores.checkScore2(score))
            {
                newHS.setVisible(true);
                saveScoreBtn.setVisible(true);
            }
            
        }
        
        //Removes this panel instance from the main panel to enable creating new games.
        mainPanel.remove(this);
        cl.show(mainPanel, "game over");         
    }
    public void setScore(String name)
    {
        try {
            scores.addScore(score, name);    
        } catch (IOException ex) {
            Logger.getLogger(ColorGame.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    public boolean[][] checkSolution()
    {
        boolean[][] correct = new boolean[grid.getW()][grid.getH()];
        try {
            String path = "grid solution.txt";
            Scanner sc = new Scanner(new File(path));
            SudokuFields[][] board = grid.getFields();
            for(int i = 0; i < board.length;i++)
            {
                for(int j = 0; j < board.length; j++)
                {
                    
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return correct;
    }
    
    public void currentDate()
    {
        dateTxt.setText(DateFormat.getDateTimeInstance().format(new Date()));
    }
}
