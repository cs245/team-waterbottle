/***************************************************************
* file: ColorGame.java
* author: Team Water Bottle
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project - Checkpoint 2
* date last modified: 2/14/2016
*
* purpose: The panel that contains the ColorGame
*
*****************************************************************/ 

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Timothy
 */
public class ColorGame extends javax.swing.JPanel 
{
    
    //purpose: initialize all colors and buttons here.
    private final Color[] COLORS = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA};
    private final String[] CLR_STR = new String[]{"RED", "BLUE", "GREEN", "YELLOW", "PURPLE"};
    private final String[] CLR_PATH = new String[]{"/Buttons/Red.png", "/Buttons/Blue.png", "/Buttons/Green.png", "/Buttons/Yellow.png", "/Buttons/Purple.png"};
    private final String[] CLRH_PATH = new String[]{"/Buttons/RedH.png", "/Buttons/BlueH.png", "/Buttons/GreenH.png", "/Buttons/YellowH.png", "/Buttons/PurpleH.png"};                                              
   
    private JLabel[] colorBtns;
    private int turns, answer, score;
    private Integer[] num;
    //CardLayout to switch between screens
    private CardLayout cl;
    //Highscores class to update scores
    private HighScores scores;
    private JPanel mainPanel;
    private JLabel finalScore;
    private JLabel newHS;
    private Random rand;
    private JButton saveScoreBtn;
    
    private SudokuGame sudoku;
    
    public ColorGame(int scr, CardLayout layout, JPanel mPanel, JLabel scoreLabel, JLabel nhs, HighScores hs, JButton saveBtn) 
    {
        initComponents();
        rand = new Random();
        turns = 0;
        score = scr;
        cl = layout;
        mainPanel = mPanel;
        finalScore = scoreLabel;
        newHS = nhs;
        scores = hs;
        saveScoreBtn = saveBtn;
        
        colorBtns = new JLabel[]{color1, color2, color3, color4, color5};
        
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
        
        skipBtn.setToolTipText("Click this button to skip this mini game");
        
        newGame();
        for(int i = 0; i < 5; i++)
        {
            colorBtns[i].addMouseListener(new ColorMouseAdapter(i));
        }

    }
    
    //method: newGame
    //purpose: Ends game if user runs out of turns
    public void newGame()
    {
        scoreLabel.setText("Score:"+score);
        if(turns < 5)
            pickColors();
        else
            gameOver(false);

    }
    public class ColorMouseAdapter extends java.awt.event.MouseAdapter
    {
        int current;
        
        public ColorMouseAdapter(int i)
        {
            current = i;
        }
        @Override
        public void mouseEntered(java.awt.event.MouseEvent evt)
        {
            hover(current);
        }
        @Override
        public void mouseExited(java.awt.event.MouseEvent evt)
        {
            noHover(current);
        }
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt)
        {
            turns++;
            rounds.setText("Round:"+turns);
            if(num[current] == answer)
                score += 100;
            newGame();
        }
    }
    
    //method: gameOver
    //purpose: once game ends will display score and if highscore also set
    public void gameOver(boolean skipped)
    {
        newHS.setVisible(false);
        saveScoreBtn.setVisible(false);
        if(skipped)
        {
            score = 0;
        }
        sudoku = new SudokuGame(score, cl, mainPanel, finalScore, newHS, scores, saveScoreBtn);
        mainPanel.add("sudoku", sudoku);
        mainPanel.remove(this);
        cl.show(mainPanel, "sudoku");
   
    }
    
    public SudokuGame sudokuGame()
    {
        return sudoku;
    }
    
    //method: hover
    //purpose: if mouse hovers over circle change image
    public void hover(int i)
    {
        ImageIcon imageIcon = scaleImg(new ImageIcon(getClass().getResource(CLRH_PATH[num[i]])), 100, 100);
        colorBtns[i].setIcon(imageIcon);
    }
    //method: noHover
    //purpose: default state of circle button when not being hovered
    public void noHover(int i)
    {
        ImageIcon imageIcon = scaleImg(new ImageIcon(getClass().getResource(CLR_PATH[num[i]])), 100, 100);
        colorBtns[i].setIcon(imageIcon);
    }
    
    //method: pickColors
    //purpose: randomly picks circle button colors and the text color.
    public void pickColors()
    {
        colorTxt.setText(CLR_STR[rand.nextInt(5)]);
        answer = rand.nextInt(5);
        colorTxt.setForeground(COLORS[answer]);
        
        num = new Integer[]{0,1,2,3,4};
        Collections.shuffle(Arrays.asList(num));
        ImageIcon imageIcon;
        
        for(int i = 0; i < 5; i++)
        {
            imageIcon = scaleImg(new ImageIcon(getClass().getResource(CLR_PATH[num[i]])), 100, 100);
            colorBtns[i].setIcon(imageIcon);
        }
    }
    
    //method: ImageIcon
    //purpose: size the circle image
    public ImageIcon scaleImg(ImageIcon icon, int w, int h)
    {
        Image image = icon.getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    
    //method: currentDate
    //purpose: sets the time on the panel
    public void currentDate()
    {
        dateTxt.setText(DateFormat.getDateTimeInstance().format(new Date()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateTxt = new javax.swing.JTextField();
        colorTxt = new javax.swing.JLabel();
        color1 = new javax.swing.JLabel();
        color2 = new javax.swing.JLabel();
        color3 = new javax.swing.JLabel();
        color4 = new javax.swing.JLabel();
        color5 = new javax.swing.JLabel();
        rounds = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        skipBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 400));

        dateTxt.setEditable(false);
        dateTxt.setText("Date & Time");

        colorTxt.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        colorTxt.setText("COLOR");

        rounds.setText("Round:1");

        scoreLabel.setText("Score:0");

        skipBtn.setText("Skip");
        skipBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rounds)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(skipBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(color2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scoreLabel)
                        .addGap(209, 209, 209)
                        .addComponent(colorTxt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(color1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155)
                        .addComponent(color3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(color5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(color4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rounds)
                    .addComponent(skipBtn))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scoreLabel)
                            .addComponent(colorTxt))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(color1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(color2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(color3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(color5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(color4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void skipBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipBtnActionPerformed
        gameOver(true);
    }//GEN-LAST:event_skipBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel color1;
    private javax.swing.JLabel color2;
    private javax.swing.JLabel color3;
    private javax.swing.JLabel color4;
    private javax.swing.JLabel color5;
    private javax.swing.JLabel colorTxt;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JLabel rounds;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JButton skipBtn;
    // End of variables declaration//GEN-END:variables
}
