/***************************************************************
* file: GamePanel.java
* author: Team Water Bottle
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project - Checkpoint 1
* date last modified: 1/31/2016
*
* purpose: The panel that contains the hangman game. 
*
****************************************************************/ 
import java.awt.CardLayout;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.Timer;
import java.text.DateFormat;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class GamePanel extends javax.swing.JPanel {
    //create instance of HangmanMethods class
    private HangmanMethods methods = new HangmanMethods();
    //CardLayout to switch between screens
    private CardLayout cl;
    //Highscores class to update scores
    private HighScores scores;
    private JPanel mainPanel;
    private JLabel finalScore;
    private JLabel newHS;
    //create stringBuilder to work with regular expressions
    private StringBuilder passwordHidden;
    private String password;
    
    /**
     * Creates new form gamePanel
     */
    public GamePanel(CardLayout layout, JPanel mPanel, JLabel score, JLabel nhs, HighScores hs) 
    {
        initComponents();    
        updateImage();
        getWord();
        
        finalScore = score;
        cl = layout;
        mainPanel = mPanel;
        newHS = nhs;
        scores = hs;
        
        updateLabels();
        
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentDate();
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();
    }
    
    //method: getWord
    //purpose:gets word from the HangmanMethods class
    public void getWord()
    {
        passwordHidden = new StringBuilder();
        password = methods.word();
        passwordHidden.append(password.replaceAll(".", "*"));
        wordField.setText(passwordHidden.toString());
    }

    //method: display
    //purpose: reveals the correctly guessed letters 
    public void display(char letter, String letter2)
    {
        int index= 0;
        boolean updated = false;
        while((index = password.toLowerCase().indexOf(letter, index)) != -1)
        {
            if(index == 0)
                passwordHidden.setCharAt(index, password.toUpperCase().charAt(index));
            else
                passwordHidden.setCharAt(index, password.charAt(index));
            index++;
            updated = true;
        }

        if(updated){
            wordField.setText(passwordHidden.toString());
            if(methods.completed())
                gameOver(false);
        }
    }

    //method: updateImage
    //purpose: updates image whenever there is a wrong guess
    public void updateImage(){
        
        int imageNumber = 6-methods.guessesLeft();
        
        if(imageNumber == 0){
            ImageIcon image = new ImageIcon(getClass().getResource("/hangman.png"));
            imageDisplay.setIcon(image);
        }

        if(imageNumber == 1){
            ImageIcon image = new ImageIcon(getClass().getResource("/head.png"));
            imageDisplay.setIcon(image);
        }

        if(imageNumber == 2){
            ImageIcon image = new ImageIcon(getClass().getResource("/torso.png"));
            imageDisplay.setIcon(image);
        }

        if(imageNumber == 3){
            ImageIcon image = new ImageIcon(getClass().getResource("/onearm.png"));
            imageDisplay.setIcon(image);
        }

        if(imageNumber == 4){
            ImageIcon image = new ImageIcon(getClass().getResource("/twoarms.png"));
            imageDisplay.setIcon(image);
        } 

        if(imageNumber == 5){
            ImageIcon image = new ImageIcon(getClass().getResource("/oneleg.png"));
            imageDisplay.setIcon(image);
        }
        if(imageNumber == 6){
            ImageIcon image = new ImageIcon(getClass().getResource("/twoleg.png"));
            imageDisplay.setIcon(image);
            gameOver(false);
        }
        updateLabels();
    }
    //method:updateLabels()
    //purpose:Updates the users current score and the number of tries remaining.
    public void updateLabels()
    {
        scoreLabel.setText("Score:"+methods.getScore());
        guessLabel.setText("Guesses:"+methods.guessesLeft());
    }
    //method:gameOver()
    //purpose:Handles the showing of the game over screen.
    public void gameOver(boolean skipped)
    {
        newHS.setVisible(false);
        if(skipped)
            finalScore.setText("Score:" + 0);
        else
        {
            finalScore.setText("Score:" + methods.getScore());
            try
            {
                //See if new score is a high score
                if(scores.addScore(methods.getScore(), "ABC"))
                    newHS.setVisible(true);
            }catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
        //Removes this panel instance from the main panel to enable creating new games.
        mainPanel.remove(this);
        cl.show(mainPanel, "game over");      
    }
    //method:currentDate
    //purpose:updates the current date on screen.
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

        jLabel1 = new javax.swing.JLabel();
        dateTxt = new javax.swing.JTextField();
        aBtn = new javax.swing.JButton();
        bBtn = new javax.swing.JButton();
        cBtn = new javax.swing.JButton();
        dBtn = new javax.swing.JButton();
        eBtn = new javax.swing.JButton();
        fBtn = new javax.swing.JButton();
        gBtn = new javax.swing.JButton();
        hBtn = new javax.swing.JButton();
        iBtn = new javax.swing.JButton();
        jBtn = new javax.swing.JButton();
        kBtn = new javax.swing.JButton();
        lBtn = new javax.swing.JButton();
        mBtn = new javax.swing.JButton();
        nBtn = new javax.swing.JButton();
        oBtn = new javax.swing.JButton();
        pBtn = new javax.swing.JButton();
        qBtn = new javax.swing.JButton();
        rBtn = new javax.swing.JButton();
        sBtn = new javax.swing.JButton();
        tBtn = new javax.swing.JButton();
        uBtn = new javax.swing.JButton();
        vBtn = new javax.swing.JButton();
        wBtn = new javax.swing.JButton();
        xBtn = new javax.swing.JButton();
        yBtn = new javax.swing.JButton();
        zBtn = new javax.swing.JButton();
        skipBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        wordField = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        imageDisplay = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        guessLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(600, 400));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Hangman");

        dateTxt.setEditable(false);
        dateTxt.setText("Date & Time");

        aBtn.setText("A");
        aBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aBtnActionPerformed(evt);
            }
        });

        bBtn.setText("B");
        bBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBtnActionPerformed(evt);
            }
        });

        cBtn.setText("C");
        cBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBtnActionPerformed(evt);
            }
        });

        dBtn.setText("D");
        dBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dBtnActionPerformed(evt);
            }
        });

        eBtn.setText("E");
        eBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eBtnActionPerformed(evt);
            }
        });

        fBtn.setText("F");
        fBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fBtnActionPerformed(evt);
            }
        });

        gBtn.setText("G");
        gBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gBtnActionPerformed(evt);
            }
        });

        hBtn.setText("H");
        hBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hBtnActionPerformed(evt);
            }
        });

        iBtn.setText("I");
        iBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iBtnActionPerformed(evt);
            }
        });

        jBtn.setText("J");
        jBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnActionPerformed(evt);
            }
        });

        kBtn.setText("K");
        kBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kBtnActionPerformed(evt);
            }
        });

        lBtn.setText("L");
        lBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lBtnActionPerformed(evt);
            }
        });

        mBtn.setText("M");
        mBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mBtnActionPerformed(evt);
            }
        });

        nBtn.setText("N");
        nBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nBtnActionPerformed(evt);
            }
        });

        oBtn.setText("O");
        oBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oBtnActionPerformed(evt);
            }
        });

        pBtn.setText("P");
        pBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pBtnActionPerformed(evt);
            }
        });

        qBtn.setText("Q");
        qBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qBtnActionPerformed(evt);
            }
        });

        rBtn.setText("R");
        rBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnActionPerformed(evt);
            }
        });

        sBtn.setText("S");
        sBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sBtnActionPerformed(evt);
            }
        });

        tBtn.setText("T");
        tBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tBtnActionPerformed(evt);
            }
        });

        uBtn.setText("U");
        uBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uBtnActionPerformed(evt);
            }
        });

        vBtn.setText("V");
        vBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vBtnActionPerformed(evt);
            }
        });

        wBtn.setText("W");
        wBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wBtnActionPerformed(evt);
            }
        });

        xBtn.setText("X");
        xBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xBtnActionPerformed(evt);
            }
        });

        yBtn.setText("Y");
        yBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yBtnActionPerformed(evt);
            }
        });

        zBtn.setText("Z");
        zBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zBtnActionPerformed(evt);
            }
        });

        skipBtn.setText("Skip");
        skipBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipBtnActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        wordField.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        wordField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wordField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wordField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(516, 168));

        imageDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        scoreLabel.setText("Score:");

        guessLabel.setText("Guesses:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scoreLabel)
                    .addComponent(guessLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scoreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guessLabel)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zBtn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(skipBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(aBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(bBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(eBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(gBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(hBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(iBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(kBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(mBtn))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(skipBtn))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aBtn)
                    .addComponent(bBtn)
                    .addComponent(cBtn)
                    .addComponent(dBtn)
                    .addComponent(eBtn)
                    .addComponent(fBtn)
                    .addComponent(gBtn)
                    .addComponent(hBtn)
                    .addComponent(iBtn)
                    .addComponent(jBtn)
                    .addComponent(kBtn)
                    .addComponent(lBtn)
                    .addComponent(mBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nBtn)
                    .addComponent(oBtn)
                    .addComponent(pBtn)
                    .addComponent(qBtn)
                    .addComponent(rBtn)
                    .addComponent(sBtn)
                    .addComponent(tBtn)
                    .addComponent(uBtn)
                    .addComponent(vBtn)
                    .addComponent(wBtn)
                    .addComponent(xBtn)
                    .addComponent(yBtn)
                    .addComponent(zBtn))
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    //methods:*BtnActionPerformed
    //purpose:Keyboard
    private void aBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aBtnActionPerformed
        aBtn.setEnabled(false);
        
        if(methods.checkLetter('A')){
            display('a', "a");
     
        }else{
            updateImage();
        }
    }//GEN-LAST:event_aBtnActionPerformed

    private void bBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBtnActionPerformed
        bBtn.setEnabled(false);
        
        if(methods.checkLetter('B')){
            display('b', "b");
        }else{
            updateImage();
        }
    }//GEN-LAST:event_bBtnActionPerformed

    private void cBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBtnActionPerformed
        cBtn.setEnabled(false);
        
        if(methods.checkLetter('C')){
            display('c', "c");
        }else{
            updateImage();
        }
    }//GEN-LAST:event_cBtnActionPerformed

    private void dBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dBtnActionPerformed
        dBtn.setEnabled(false);
        
        if(methods.checkLetter('D')){
            display('d', "d");
        }else{
            updateImage();
        }
    }//GEN-LAST:event_dBtnActionPerformed

    private void eBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eBtnActionPerformed
        eBtn.setEnabled(false);
        
        if(methods.checkLetter('E')){
            display('e', "e"); 
        }else{
            updateImage();
        }
    }//GEN-LAST:event_eBtnActionPerformed

    private void fBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fBtnActionPerformed
        fBtn.setEnabled(false);
        
        if(methods.checkLetter('F')){
            
         display('f', "f");

        }else{
            updateImage();
        }    }//GEN-LAST:event_fBtnActionPerformed

    private void gBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gBtnActionPerformed
        gBtn.setEnabled(false);
        
        if(methods.checkLetter('G')){
          display('g', "g"); 
        }else{
            updateImage();
        }
    }//GEN-LAST:event_gBtnActionPerformed

    private void hBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hBtnActionPerformed
        hBtn.setEnabled(false);
        
        if(methods.checkLetter('H')){
            display('h', "h");  
        }else{
            updateImage();
        }
    }//GEN-LAST:event_hBtnActionPerformed

    private void iBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iBtnActionPerformed
        iBtn.setEnabled(false);
        
        if(methods.checkLetter('I')){   
            display('i', "i");
        }else{
           updateImage();
        }
    }//GEN-LAST:event_iBtnActionPerformed

    private void jBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnActionPerformed
        jBtn.setEnabled(false);
        
        if(methods.checkLetter('J')){      
            display('j', "j");
        }else{
            updateImage();
        }
    }//GEN-LAST:event_jBtnActionPerformed

    private void kBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kBtnActionPerformed
        kBtn.setEnabled(false);
        
        if(methods.checkLetter('K')){
            display('k', "k");
        }else{
            updateImage();
        }    }//GEN-LAST:event_kBtnActionPerformed

    private void lBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lBtnActionPerformed
        lBtn.setEnabled(false);
        
        if(methods.checkLetter('L')){
            display('l', "l");
        }else{
            updateImage();
        }
    }//GEN-LAST:event_lBtnActionPerformed

    private void mBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mBtnActionPerformed
        mBtn.setEnabled(false);

        if(methods.checkLetter('M')){
            display('m', "m");
        }else{
            updateImage();
        }
    }//GEN-LAST:event_mBtnActionPerformed

    private void nBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nBtnActionPerformed
        nBtn.setEnabled(false);
        
        if(methods.checkLetter('N')){
            display('n', "n");
        }else{
            updateImage();
        }
    }//GEN-LAST:event_nBtnActionPerformed

    private void oBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oBtnActionPerformed
        oBtn.setEnabled(false);
        
        if(methods.checkLetter('O')){
           display('o', "o");
        }else{
            updateImage();
        }    }//GEN-LAST:event_oBtnActionPerformed

    private void pBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pBtnActionPerformed
        pBtn.setEnabled(false);
        
        if(methods.checkLetter('P')){
            display('p', "p");
        }else{
            updateImage();
        }
    }//GEN-LAST:event_pBtnActionPerformed

    private void qBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qBtnActionPerformed
        qBtn.setEnabled(false);
        
        if(methods.checkLetter('Q')){
            display('q', "q");
        }else{
            updateImage();
        }
    }//GEN-LAST:event_qBtnActionPerformed

    private void rBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnActionPerformed
        rBtn.setEnabled(false);
        
        if(methods.checkLetter('R')){
            display('r', "r");
        }else{
            updateImage();
        }
    }//GEN-LAST:event_rBtnActionPerformed

    private void sBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sBtnActionPerformed
        sBtn.setEnabled(false);
        
        if(methods.checkLetter('S')){
            display('s', "s");
        }else{
            updateImage();
        }
    }//GEN-LAST:event_sBtnActionPerformed

    private void tBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tBtnActionPerformed
        tBtn.setEnabled(false);
        
        if(methods.checkLetter('T')){ 
            display('t', "t");
        }else{
            updateImage();
        }
    }//GEN-LAST:event_tBtnActionPerformed

    private void uBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uBtnActionPerformed
        uBtn.setEnabled(false);
        
        if(methods.checkLetter('U')){
            display('u', "u");
        }else{
            updateImage();
        }    }//GEN-LAST:event_uBtnActionPerformed

    private void vBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vBtnActionPerformed
        vBtn.setEnabled(false);
        
        if(methods.checkLetter('V')){ 
           display('v', "v");
        }else{
            updateImage();
        }    }//GEN-LAST:event_vBtnActionPerformed

    private void wBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wBtnActionPerformed
        wBtn.setEnabled(false);
        
        if(methods.checkLetter('W')){
         display('w', "w");     
        }else{
            updateImage();
        }
    }//GEN-LAST:event_wBtnActionPerformed

    private void xBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xBtnActionPerformed
        xBtn.setEnabled(false);
        
        if(methods.checkLetter('X')){ 
            display('x', "x");
        }else{
            updateImage();
        }
    }//GEN-LAST:event_xBtnActionPerformed

    private void yBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yBtnActionPerformed
        yBtn.setEnabled(false);
        
        if(methods.checkLetter('Y')){
            display('y', "y");
        } else{
            updateImage();
        }  
    }//GEN-LAST:event_yBtnActionPerformed

    private void zBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zBtnActionPerformed
        zBtn.setEnabled(false);
        
        if(methods.checkLetter('Z')){
            display('z', "z");
        }else{
            updateImage();
        }
    }//GEN-LAST:event_zBtnActionPerformed
    //End keyboard
    //method:skipBtnActionPerformed
    //purpose:Skips to game over screen with a score of 0
    private void skipBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipBtnActionPerformed
       gameOver(true);      
    }//GEN-LAST:event_skipBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aBtn;
    private javax.swing.JButton bBtn;
    private javax.swing.JButton cBtn;
    private javax.swing.JButton dBtn;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JButton eBtn;
    private javax.swing.JButton fBtn;
    private javax.swing.JButton gBtn;
    private javax.swing.JLabel guessLabel;
    private javax.swing.JButton hBtn;
    private javax.swing.JButton iBtn;
    private javax.swing.JLabel imageDisplay;
    private javax.swing.JButton jBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton kBtn;
    private javax.swing.JButton lBtn;
    private javax.swing.JButton mBtn;
    private javax.swing.JButton nBtn;
    private javax.swing.JButton oBtn;
    private javax.swing.JButton pBtn;
    private javax.swing.JButton qBtn;
    private javax.swing.JButton rBtn;
    private javax.swing.JButton sBtn;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JButton skipBtn;
    private javax.swing.JButton tBtn;
    private javax.swing.JButton uBtn;
    private javax.swing.JButton vBtn;
    private javax.swing.JButton wBtn;
    private javax.swing.JLabel wordField;
    private javax.swing.JButton xBtn;
    private javax.swing.JButton yBtn;
    private javax.swing.JButton zBtn;
    // End of variables declaration//GEN-END:variables
}
