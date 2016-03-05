/***************************************************************
* file: Hangman.java
* author: Team Water Bottle
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project - Checkpoint 1
* date last modified: 1/31/2016
*
* purpose: The main JFrame of our class that holds all the panels.
* Mainly for switching between the panels. 
*
****************************************************************/ 
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MainMenu extends javax.swing.JFrame 
{
    private CardLayout cl;
    private Timer timer;
    private Hangman hangman;
    private HighScores scores;
    private ArrayList<javax.swing.JLabel> scoreLabels;
    /**
     * Creates new form Hangman
     */
    public MainMenu() throws IOException 
    {
        initComponents();
        scores = new HighScores();
        
        scoreLabels = new ArrayList<javax.swing.JLabel>();
        scoreLabels.add(score1);
        scoreLabels.add(score2);
        scoreLabels.add(score3);
        scoreLabels.add(score4);
        scoreLabels.add(score5);
        
        cl = new CardLayout();
        
        mainPanel.setLayout(cl);
        mainPanel.add("splash card", splashPanel);
        mainPanel.add("menu card", menuPanel);
        mainPanel.add("high scores", highScores);
        mainPanel.add("credits card", creditsPanel);
        mainPanel.add("game over", gameOver);
        mainPanel.add("new high scores", saveHighScore);
        
        //purpose: key bindings
        mainPanel.getInputMap(mainPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "exit");
        mainPanel.getActionMap().put("exit", exit);
        
        mainPanel.getInputMap(mainPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "credits");
        mainPanel.getActionMap().put("credits", credits );
        
        //place center of the screen
        this.setLocationRelativeTo(null);
        timer = new Timer(3000, new TimerListener());
        timer.setRepeats(false);
        timer.start();
        
        //purpose: tool tips
        playBtn.setToolTipText("Click this button to start mini games.");
        highScoreBtn.setToolTipText("Click this button to see high scores.");
        creditsBtn.setToolTipText("Click this button to see credits.");
        
        backBtn1.setToolTipText("Click this button to go back to the menu.");
        backBtn.setToolTipText("Click this button to go back to the menu.");
        
        saveScoreBtn.setToolTipText("Click this button to save your high score.");
        endGameBtn.setToolTipText("Click this button to go back to the menu.");
        
        nameDisplayTxt.setToolTipText("Enter your name here");
        saveBtn.setToolTipText("Click this button to save your high score");
    }
    
    //purpose: action for key binding of escape
    Action exit= new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println("exit");
            System.exit(0);
            
            throw new UnsupportedOperationException("Not supported yet."); 
        }

    };
    
    //purpose: action for key binding of show credits
    Action credits= new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            JOptionPane.showMessageDialog(null, "Timothy Ngo, 009980659\nJose Marquez, 009990552"
                    + "\nCS 245 Project \nWinter 2016", "Credits", JOptionPane.PLAIN_MESSAGE);
            
            System.out.println("credits");
            
            if(JOptionPane.OK_OPTION == 0) {
                return;
            }
            
            throw new UnsupportedOperationException("Not supported yet."); 
        }

    };
    
    //class:TimerListener
    //purpose:Listener for the swing timer.
    class TimerListener implements ActionListener
    {
        //method:actionPerformed
        //purpose:Goes to menu after timer finishes.
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            goMenu();
        }
    }
    //method:goSplash
    //purpose:Switches to the splash screen.
    public void goSplash()
    {
        cl.show(mainPanel, "splash card");  
    }
    //method:goMenu
    //purpose:Switches to the menu screen.
    public void goMenu()
    {
        cl.show(mainPanel, "menu card");
    }
    //method:startGame()
    //purpose:Creates a new hangman and shows it.
    public void startGame()
    {
        hangman = new Hangman(cl, mainPanel, scoreLabel,newHSLabel, scores, saveScoreBtn);
        mainPanel.add("game card", hangman);
        cl.show(mainPanel, "game card");
    }
    //method:goHighScores
    //purpose:Switches to the high scores screen.
    public void goHighScores()
    {
        for(int i = 0; i < 5; i++)
        {
            scoreLabels.get(i).setText(scores.getScores()[i]);
        }
        cl.show(mainPanel, "high scores");
    }
    //method:goCredits
    //purpose:Switches to the credits screen.
    public void goCredits()
    {
        cl.show(mainPanel, "credits card");
    }
    
    //method: goSaveHighScores
    //purpose: Switches to update highscore
    public void goSaveHighScores(){
        
        cl.show(mainPanel, "new high scores");
        
    }
    
    
  

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        splashPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        playBtn = new javax.swing.JButton();
        highScoreBtn = new javax.swing.JButton();
        creditsBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        highScores = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        backBtn1 = new javax.swing.JButton();
        score1 = new javax.swing.JLabel();
        score2 = new javax.swing.JLabel();
        score3 = new javax.swing.JLabel();
        score4 = new javax.swing.JLabel();
        score5 = new javax.swing.JLabel();
        creditsPanel = new javax.swing.JPanel();
        name1 = new javax.swing.JLabel();
        name2 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        gameOver = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        endGameBtn = new javax.swing.JButton();
        scoreLabel = new javax.swing.JLabel();
        newHSLabel = new javax.swing.JLabel();
        saveScoreBtn = new javax.swing.JButton();
        saveHighScore = new javax.swing.JPanel();
        saveBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        nameDisplayTxt = new javax.swing.JTextField();
        newHSLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        mainPanel.setPreferredSize(new java.awt.Dimension(600, 400));

        splashPanel.setBackground(new java.awt.Color(0, 0, 0));
        splashPanel.setMaximumSize(new java.awt.Dimension(600, 400));
        splashPanel.setMinimumSize(new java.awt.Dimension(600, 400));
        splashPanel.setPreferredSize(new java.awt.Dimension(600, 400));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CS 245 Quarter Project");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("By:Team Water Bottle");

        javax.swing.GroupLayout splashPanelLayout = new javax.swing.GroupLayout(splashPanel);
        splashPanel.setLayout(splashPanelLayout);
        splashPanelLayout.setHorizontalGroup(
            splashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(splashPanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, splashPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(173, 173, 173))
        );
        splashPanelLayout.setVerticalGroup(
            splashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(splashPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(66, 66, 66))
        );

        menuPanel.setBackground(new java.awt.Color(0, 0, 0));
        menuPanel.setMaximumSize(new java.awt.Dimension(600, 400));
        menuPanel.setMinimumSize(new java.awt.Dimension(600, 400));
        menuPanel.setPreferredSize(new java.awt.Dimension(600, 400));

        playBtn.setBackground(new java.awt.Color(0, 0, 0));
        playBtn.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        playBtn.setForeground(new java.awt.Color(255, 255, 255));
        playBtn.setText("Play");
        playBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playBtnActionPerformed(evt);
            }
        });

        highScoreBtn.setBackground(new java.awt.Color(0, 0, 0));
        highScoreBtn.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        highScoreBtn.setForeground(new java.awt.Color(255, 255, 255));
        highScoreBtn.setText("HIGHSCORES");
        highScoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highScoreBtnActionPerformed(evt);
            }
        });

        creditsBtn.setBackground(new java.awt.Color(0, 0, 0));
        creditsBtn.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        creditsBtn.setForeground(new java.awt.Color(255, 255, 255));
        creditsBtn.setText("Credits");
        creditsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditsBtnActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bottle.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(352, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(highScoreBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(creditsBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(playBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(playBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highScoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(creditsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        highScores.setPreferredSize(new java.awt.Dimension(600, 400));

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 48)); // NOI18N
        jLabel5.setText("HIGHSCORES");

        backBtn1.setText("Back");
        backBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn1ActionPerformed(evt);
            }
        });

        score1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        score1.setText("Highscore1");

        score2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        score2.setText("Highscore2");

        score3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        score3.setText("Highscore3");

        score4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        score4.setText("Highscore4");

        score5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        score5.setText("Highscore5");

        javax.swing.GroupLayout highScoresLayout = new javax.swing.GroupLayout(highScores);
        highScores.setLayout(highScoresLayout);
        highScoresLayout.setHorizontalGroup(
            highScoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, highScoresLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(backBtn1)
                .addContainerGap(448, Short.MAX_VALUE))
            .addGroup(highScoresLayout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addGroup(highScoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(score5, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(score4, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(score3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(score2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(score1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        highScoresLayout.setVerticalGroup(
            highScoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(highScoresLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(score1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(score2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(score3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(score4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(score5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(backBtn1)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        creditsPanel.setPreferredSize(new java.awt.Dimension(600, 400));

        name1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        name1.setText("Timothy Ngo, 009980659");

        name2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        name2.setText("Jose Marquez, 009990552");

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Credits");
        jLabel6.setToolTipText("");

        javax.swing.GroupLayout creditsPanelLayout = new javax.swing.GroupLayout(creditsPanel);
        creditsPanel.setLayout(creditsPanelLayout);
        creditsPanelLayout.setHorizontalGroup(
            creditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creditsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, creditsPanelLayout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addGroup(creditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(creditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, creditsPanelLayout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27))))
                .addGap(184, 184, 184))
        );
        creditsPanelLayout.setVerticalGroup(
            creditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creditsPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addGap(28, 28, 28))
        );

        gameOver.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Game Over");

        endGameBtn.setBackground(new java.awt.Color(0, 0, 0));
        endGameBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        endGameBtn.setForeground(new java.awt.Color(255, 255, 255));
        endGameBtn.setText("End Game");
        endGameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endGameBtnActionPerformed(evt);
            }
        });

        scoreLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        scoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        scoreLabel.setText("Score:0");

        newHSLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        newHSLabel.setForeground(new java.awt.Color(255, 255, 255));
        newHSLabel.setText("New High Score!");
        newHSLabel.setEnabled(false);

        saveScoreBtn.setBackground(new java.awt.Color(0, 0, 0));
        saveScoreBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        saveScoreBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveScoreBtn.setText("Save");
        saveScoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveScoreBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gameOverLayout = new javax.swing.GroupLayout(gameOver);
        gameOver.setLayout(gameOverLayout);
        gameOverLayout.setHorizontalGroup(
            gameOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameOverLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(scoreLabel)
                .addContainerGap(256, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameOverLayout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addGroup(gameOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameOverLayout.createSequentialGroup()
                        .addGroup(gameOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(gameOverLayout.createSequentialGroup()
                                .addComponent(saveScoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(endGameBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(newHSLabel))
                        .addGap(30, 30, 30)))
                .addGap(131, 131, 131))
        );
        gameOverLayout.setVerticalGroup(
            gameOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameOverLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scoreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newHSLabel)
                .addGap(35, 35, 35)
                .addGroup(gameOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endGameBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveScoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        saveHighScore.setBackground(new java.awt.Color(0, 0, 0));

        saveBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Name");

        nameDisplayTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameDisplayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameDisplayTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameDisplayTxtActionPerformed(evt);
            }
        });

        newHSLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        newHSLabel1.setForeground(new java.awt.Color(255, 255, 255));
        newHSLabel1.setText("New High Score!");

        javax.swing.GroupLayout saveHighScoreLayout = new javax.swing.GroupLayout(saveHighScore);
        saveHighScore.setLayout(saveHighScoreLayout);
        saveHighScoreLayout.setHorizontalGroup(
            saveHighScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saveHighScoreLayout.createSequentialGroup()
                .addGroup(saveHighScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(saveHighScoreLayout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(saveHighScoreLayout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addGroup(saveHighScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newHSLabel1)
                            .addGroup(saveHighScoreLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nameDisplayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        saveHighScoreLayout.setVerticalGroup(
            saveHighScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, saveHighScoreLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(newHSLabel1)
                .addGap(49, 49, 49)
                .addGroup(saveHighScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameDisplayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(splashPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(highScores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(creditsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(gameOver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(saveHighScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(splashPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(highScores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(creditsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(gameOver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(saveHighScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playBtnActionPerformed
        startGame();    
    }//GEN-LAST:event_playBtnActionPerformed

    private void backBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn1ActionPerformed
        goMenu();
    }//GEN-LAST:event_backBtn1ActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        goMenu();
    }//GEN-LAST:event_backBtnActionPerformed

    private void highScoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highScoreBtnActionPerformed
        goHighScores();
    }//GEN-LAST:event_highScoreBtnActionPerformed

    private void creditsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditsBtnActionPerformed
        goCredits();
    }//GEN-LAST:event_creditsBtnActionPerformed

    private void endGameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endGameBtnActionPerformed
        goMenu();
    }//GEN-LAST:event_endGameBtnActionPerformed

    private void saveScoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveScoreBtnActionPerformed
        
        goSaveHighScores();
    }//GEN-LAST:event_saveScoreBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        
        String name = nameDisplayTxt.getText().toString();
        hangman.colorGame().setScore(name);
        nameDisplayTxt.setText("");
        goMenu();
        
    }//GEN-LAST:event_saveBtnActionPerformed

    private void nameDisplayTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameDisplayTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameDisplayTxtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
           {
               try
               {
                    new MainMenu().setSize(600,400);
                    new MainMenu().setVisible(true);
               }catch(IOException ex)
               {
                ex.printStackTrace();
               }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton backBtn1;
    private javax.swing.JButton creditsBtn;
    private javax.swing.JPanel creditsPanel;
    private javax.swing.JButton endGameBtn;
    private javax.swing.JPanel gameOver;
    private javax.swing.JButton highScoreBtn;
    private javax.swing.JPanel highScores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name2;
    private javax.swing.JTextField nameDisplayTxt;
    private javax.swing.JLabel newHSLabel;
    private javax.swing.JLabel newHSLabel1;
    private javax.swing.JButton playBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JPanel saveHighScore;
    private javax.swing.JButton saveScoreBtn;
    private javax.swing.JLabel score1;
    private javax.swing.JLabel score2;
    private javax.swing.JLabel score3;
    private javax.swing.JLabel score4;
    private javax.swing.JLabel score5;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JPanel splashPanel;
    // End of variables declaration//GEN-END:variables
}
