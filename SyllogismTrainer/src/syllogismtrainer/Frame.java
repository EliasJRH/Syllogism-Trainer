package syllogismtrainer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Frame extends javax.swing.JFrame {

    File nounFile = new File("nounlist.txt"); //file that contains all the nouns
    Scanner nounFinder = null; //scanner to get the three nouns for the three statements
    Scanner getLengthOfFile = null; //scanner that gets the length of the file
    String subject, predicate, middle, currentWord; //string variables to store subject, predicate and middle terms 
    ArrayList<String> moods = new ArrayList<String>(); //array list to hold moods
    String[] userMoods = new String[3];
    int lineCount, fileSize, statementCount = 0; //int for the reading the file
    boolean firstClick = true; //boolean to check for the first mouse click
    public int p1x, p1y, p2x, p2y; //ints for the initial and final x and y positions of the mouse
    boolean subjectDistribution = false, predicateDistribution = false, middleDistribution = false; //booleans for the first two statements to see whether the subject predicat eand middle are distributed
    boolean subjectDistributionCheck = false, predicateDistributionCheck = false; //booleans to check in the final statment if the subject and predicate are distributed 
    boolean userMaj = false, userMin = false, userMid = false, userAffir = false, userExclu = false, userExis = false, userValid = false; //booleans for the users choices of fallacies
    boolean actualMaj = false, actualMin = false, actualMid = false, actualAffir = false, actualExclu = false, actualExis = false, actualValid = false; //booleans for the actual fallacies
    int actualFigure;

    public Frame() {
        initComponents();
    } //constructor for the frame

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        venLabel = new javax.swing.JLabel();
        statementTwo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        newStatementButton = new javax.swing.JButton();
        statementThree = new javax.swing.JLabel();
        statementOne = new javax.swing.JLabel();
        drawingLabel = new javax.swing.JLabel();
        clearVen = new javax.swing.JButton();
        minorButton = new javax.swing.JRadioButton();
        middleButton = new javax.swing.JRadioButton();
        affirmativeButton = new javax.swing.JRadioButton();
        exclusiveButton = new javax.swing.JRadioButton();
        existentialButton = new javax.swing.JRadioButton();
        majorButton = new javax.swing.JRadioButton();
        validButton = new javax.swing.JRadioButton();
        correctVen = new javax.swing.JLabel();
        firstNounText = new javax.swing.JLabel();
        secondNounText = new javax.swing.JLabel();
        thirdNounText = new javax.swing.JLabel();
        secondCorrectNounText = new javax.swing.JLabel();
        thirdCorrectNounText = new javax.swing.JLabel();
        firstCorrectNounText = new javax.swing.JLabel();
        howDoIDoThisButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userFigure = new javax.swing.JSpinner();
        userMood2 = new javax.swing.JSpinner();
        userMood3 = new javax.swing.JSpinner();
        userMood1 = new javax.swing.JSpinner();
        howDoIUseThisButton = new javax.swing.JButton();
        checkAnswerButton = new javax.swing.JButton();
        correctAnswer = new javax.swing.JLabel();
        actualExistentialRButton = new javax.swing.JRadioButton();
        actualMajorRButton = new javax.swing.JRadioButton();
        actualMinorRButton = new javax.swing.JRadioButton();
        actualMiddleRButton = new javax.swing.JRadioButton();
        actualAffirmativeRButton = new javax.swing.JRadioButton();
        actualExclusiveRButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Syllogism Trainer V1");
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setName("Syllogism Trainer V1"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        venLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/syllogismtrainer/ven.png"))); // NOI18N
        venLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                venLabelMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                venLabelMouseMoved(evt);
            }
        });
        venLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                venLabelMouseReleased(evt);
            }
        });
        getContentPane().add(venLabel);
        venLabel.setBounds(40, 310, 330, 310);

        statementTwo.setFont(new java.awt.Font("Corbel Light", 1, 24)); // NOI18N
        statementTwo.setText("Minor statement");
        getContentPane().add(statementTwo);
        statementTwo.setBounds(40, 120, 470, 30);

        jLabel2.setFont(new java.awt.Font("Corbel Light", 1, 36)); // NOI18N
        jLabel2.setText("Syllogism Trainer V1");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(330, 10, 320, 48);

        newStatementButton.setText("New Statements");
        newStatementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newStatementButtonActionPerformed(evt);
            }
        });
        getContentPane().add(newStatementButton);
        newStatementButton.setBounds(30, 200, 170, 50);

        statementThree.setFont(new java.awt.Font("Corbel Light", 1, 24)); // NOI18N
        statementThree.setText("Concluding statement");
        getContentPane().add(statementThree);
        statementThree.setBounds(40, 160, 470, 30);

        statementOne.setFont(new java.awt.Font("Corbel Light", 1, 24)); // NOI18N
        statementOne.setText("Major statement");
        getContentPane().add(statementOne);
        statementOne.setBounds(40, 90, 470, 30);

        drawingLabel.setBackground(new java.awt.Color(255, 102, 102));
        drawingLabel.setForeground(new java.awt.Color(102, 51, 0));
        getContentPane().add(drawingLabel);
        drawingLabel.setBounds(40, 310, 330, 310);

        clearVen.setText("Clear Ven");
        clearVen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearVenActionPerformed(evt);
            }
        });
        getContentPane().add(clearVen);
        clearVen.setBounds(380, 610, 110, 40);

        minorButton.setText("Minor");
        minorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minorButtonActionPerformed(evt);
            }
        });
        getContentPane().add(minorButton);
        minorButton.setBounds(380, 420, 120, 28);

        middleButton.setText("Middle");
        middleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middleButtonActionPerformed(evt);
            }
        });
        getContentPane().add(middleButton);
        middleButton.setBounds(380, 450, 120, 28);

        affirmativeButton.setText("Affirmative");
        affirmativeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                affirmativeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(affirmativeButton);
        affirmativeButton.setBounds(380, 480, 120, 28);

        exclusiveButton.setText("Exclusive");
        exclusiveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exclusiveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exclusiveButton);
        exclusiveButton.setBounds(380, 510, 120, 28);

        existentialButton.setText("Existential");
        existentialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                existentialButtonActionPerformed(evt);
            }
        });
        getContentPane().add(existentialButton);
        existentialButton.setBounds(380, 540, 120, 28);

        majorButton.setText("Major");
        majorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                majorButtonActionPerformed(evt);
            }
        });
        getContentPane().add(majorButton);
        majorButton.setBounds(380, 390, 120, 28);

        validButton.setText("Valid");
        validButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validButtonActionPerformed(evt);
            }
        });
        getContentPane().add(validButton);
        validButton.setBounds(380, 570, 60, 28);

        correctVen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/syllogismtrainer/ven.png"))); // NOI18N
        getContentPane().add(correctVen);
        correctVen.setBounds(550, 60, 330, 310);

        firstNounText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstNounText.setText("First noun");
        getContentPane().add(firstNounText);
        firstNounText.setBounds(0, 290, 100, 16);

        secondNounText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secondNounText.setText("Second noun");
        getContentPane().add(secondNounText);
        secondNounText.setBounds(300, 290, 120, 20);

        thirdNounText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirdNounText.setText("Third noun");
        getContentPane().add(thirdNounText);
        thirdNounText.setBounds(130, 630, 140, 20);

        secondCorrectNounText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secondCorrectNounText.setText("Second correct noun");
        getContentPane().add(secondCorrectNounText);
        secondCorrectNounText.setBounds(830, 60, 110, 16);

        thirdCorrectNounText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thirdCorrectNounText.setText("Third correct noun");
        getContentPane().add(thirdCorrectNounText);
        thirdCorrectNounText.setBounds(660, 380, 110, 16);

        firstCorrectNounText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstCorrectNounText.setText("First correct noun");
        getContentPane().add(firstCorrectNounText);
        firstCorrectNounText.setBounds(480, 60, 110, 16);

        howDoIDoThisButton.setText("How do I do this?");
        howDoIDoThisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                howDoIDoThisButtonActionPerformed(evt);
            }
        });
        getContentPane().add(howDoIDoThisButton);
        howDoIDoThisButton.setBounds(730, 550, 190, 90);

        jLabel1.setText("Mood:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(380, 330, 41, 16);

        jLabel3.setText("Figure:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(380, 360, 50, 16);

        userFigure.setModel(new javax.swing.SpinnerNumberModel(1, 1, 4, 1));
        getContentPane().add(userFigure);
        userFigure.setBounds(430, 360, 50, 26);

        userMood2.setModel(new javax.swing.SpinnerListModel(new String[] {"A", "E", "I", "O"}));
        getContentPane().add(userMood2);
        userMood2.setBounds(480, 320, 50, 30);

        userMood3.setModel(new javax.swing.SpinnerListModel(new String[] {"A", "E", "I", "O"}));
        getContentPane().add(userMood3);
        userMood3.setBounds(540, 320, 50, 30);

        userMood1.setModel(new javax.swing.SpinnerListModel(new String[] {"A", "E", "I", "O"}));
        getContentPane().add(userMood1);
        userMood1.setBounds(420, 320, 50, 30);

        howDoIUseThisButton.setText("How do I use this?");
        howDoIUseThisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                howDoIUseThisButtonActionPerformed(evt);
            }
        });
        getContentPane().add(howDoIUseThisButton);
        howDoIUseThisButton.setBounds(530, 550, 190, 90);

        checkAnswerButton.setText("Check Answer");
        checkAnswerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAnswerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(checkAnswerButton);
        checkAnswerButton.setBounds(650, 490, 140, 50);

        correctAnswer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        correctAnswer.setText("_ _ _ - _");
        getContentPane().add(correctAnswer);
        correctAnswer.setBounds(680, 400, 90, 16);

        actualExistentialRButton.setText("Existential");
        actualExistentialRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualExistentialRButtonActionPerformed(evt);
            }
        });
        getContentPane().add(actualExistentialRButton);
        actualExistentialRButton.setBounds(730, 460, 90, 20);

        actualMajorRButton.setText("Major");
        actualMajorRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualMajorRButtonActionPerformed(evt);
            }
        });
        getContentPane().add(actualMajorRButton);
        actualMajorRButton.setBounds(640, 420, 90, 20);

        actualMinorRButton.setText("Minor");
        actualMinorRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualMinorRButtonActionPerformed(evt);
            }
        });
        getContentPane().add(actualMinorRButton);
        actualMinorRButton.setBounds(640, 440, 90, 20);

        actualMiddleRButton.setText("Middle");
        actualMiddleRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualMiddleRButtonActionPerformed(evt);
            }
        });
        getContentPane().add(actualMiddleRButton);
        actualMiddleRButton.setBounds(640, 460, 90, 20);

        actualAffirmativeRButton.setText("Affirmative");
        actualAffirmativeRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualAffirmativeRButtonActionPerformed(evt);
            }
        });
        getContentPane().add(actualAffirmativeRButton);
        actualAffirmativeRButton.setBounds(730, 420, 100, 20);

        actualExclusiveRButton.setText("Exclusive");
        actualExclusiveRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualExclusiveRButtonActionPerformed(evt);
            }
        });
        getContentPane().add(actualExclusiveRButton);
        actualExclusiveRButton.setBounds(730, 440, 90, 20);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //initializes all the components

    private void newStatementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newStatementButtonActionPerformed
        subjectDistribution = false; //resets all these booleans when the button is pressed
        predicateDistribution = false;
        middleDistribution = false;
        subjectDistributionCheck = false;
        predicateDistributionCheck = false;
        actualMaj = false;
        actualMin = false;
        actualMid = false;
        actualAffir = false;
        actualExclu = false;
        actualExis = false;
        actualValid = false;
        actualMajorRButton.setSelected(false);
        actualMinorRButton.setSelected(false);
        actualMiddleRButton.setSelected(false);
        actualAffirmativeRButton.setSelected(false);
        actualExclusiveRButton.setSelected(false);
        actualExistentialRButton.setSelected(false);
        correctAnswer.setText("_ _ _-_");
        moods.clear(); //clears the mood array list
        getFileSize(); //gets the size of the file
        getWords(); //gets the subject predicate and middle nouns
        writeStatements(); //calls the method to write the statements
        determineFallacies(); //calls the method to determine the fallacies
    }//GEN-LAST:event_newStatementButtonActionPerformed
    //button that generates new statements

    private void clearVenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearVenActionPerformed
        drawingLabel.repaint();
    }//GEN-LAST:event_clearVenActionPerformed
    //Label that erases the drawings made on the drawing labe; 

    private void venLabelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_venLabelMouseDragged
        Graphics g = drawingLabel.getGraphics(); //gets graphics of drawing label
        Graphics2D g2 = (Graphics2D) g; //gets the g2 graphics of the original graphocs
        g2.setStroke(new BasicStroke(3)); //increases thickness of line
        g2.setXORMode(Color.WHITE); //sets the color to be transparent
        if (firstClick) { //checks for the first click
            firstClick = false; //sets it to false
        } else {
            g2.drawLine(p1x, p1y, p2x, p2y); //draws over the old line with a transparent color
        }
        g2.setColor(Color.BLACK); //sets the line color to black
        p2x = evt.getX(); //gets the second x coord of mouse
        p2y = evt.getY(); //gets the second y coord of mouse
        g2.drawLine(p1x, p1y, p2x, p2y); //draws the new line
        //this listener fires whenever the mouse is dragged so it's constantly erasing and drawing new lines
    }//GEN-LAST:event_venLabelMouseDragged
    //Method to control movement of mouse while clicked

    private void venLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_venLabelMouseReleased
        firstClick = true; //sets firstClick back to true
        p1x = 0; //resets all the location variables
        p1y = 0;
        p2x = 0;
        p2y = 0;
    }//GEN-LAST:event_venLabelMouseReleased
    //Method to control mouse released

    private void venLabelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_venLabelMouseMoved
        p1x = evt.getX(); //gets initial x coord of mouse
        p1y = evt.getY(); //gets initial y coord of mouse
    }//GEN-LAST:event_venLabelMouseMoved
    //method that constantly gets initial x and y coordinates 

    private void minorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minorButtonActionPerformed
        if (userMin == false) {
            userMin = true;
        } else if (userMin) {
            userMin = false;
        }
    }//GEN-LAST:event_minorButtonActionPerformed
    //method for the minor butons

    private void majorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_majorButtonActionPerformed
        if (userMaj == false) {
            userMaj = true;
        } else if (userMaj) {
            userMaj = false;
        }
    }//GEN-LAST:event_majorButtonActionPerformed
    //method for major button

    private void middleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_middleButtonActionPerformed
        if (userMid == false) {
            userMid = true;
        } else if (userMid) {
            userMid = false;
        }
    }//GEN-LAST:event_middleButtonActionPerformed
    //method for middle button

    private void affirmativeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_affirmativeButtonActionPerformed
        if (userAffir == false) {
            userAffir = true;
        } else if (userAffir) {
            userAffir = false;
        }
    }//GEN-LAST:event_affirmativeButtonActionPerformed
    //method for affirmative 

    private void exclusiveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exclusiveButtonActionPerformed
        if (userExclu == false) {
            userExclu = true;
        } else if (userExclu) {
            userExclu = false;
        }
    }//GEN-LAST:event_exclusiveButtonActionPerformed
    //method for exclusive button

    private void existentialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_existentialButtonActionPerformed
        if (userExis == false) {
            userExis = true;
        } else if (userExis) {
            userExis = false;
        }
    }//GEN-LAST:event_existentialButtonActionPerformed
    //method for existential button

    private void validButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validButtonActionPerformed
        if (userValid == false) {
            userValid = true;
        } else if (userValid) {
            userValid = false;
        }
    }//GEN-LAST:event_validButtonActionPerformed
    //method for valid button

    private void checkAnswerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAnswerButtonActionPerformed
        drawStatements();
        displayFallacies();
        correctAnswer.setText(moods.get(0) + moods.get(1) + moods.get(2) + "-" + actualFigure);
    }//GEN-LAST:event_checkAnswerButtonActionPerformed
    //button to check and show the answer

    //action listeners for buttons so they can't get manuall selected
    private void actualMajorRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualMajorRButtonActionPerformed
        if (actualMajorRButton.isSelected()) {
            actualMajorRButton.setSelected(false);
        } else {
            actualMajorRButton.setSelected(true);
        }
    }//GEN-LAST:event_actualMajorRButtonActionPerformed

    private void actualMinorRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualMinorRButtonActionPerformed
        if (actualMinorRButton.isSelected()) {
            actualMinorRButton.setSelected(false);
        } else {
            actualMinorRButton.setSelected(true);
        }
    }//GEN-LAST:event_actualMinorRButtonActionPerformed

    private void actualMiddleRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualMiddleRButtonActionPerformed
        if (actualMiddleRButton.isSelected()) {
            actualMiddleRButton.setSelected(false);
        } else {
            actualMiddleRButton.setSelected(true);
        }
    }//GEN-LAST:event_actualMiddleRButtonActionPerformed

    private void actualAffirmativeRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualAffirmativeRButtonActionPerformed
        if (actualAffirmativeRButton.isSelected()) {
            actualAffirmativeRButton.setSelected(false);
        } else {
            actualAffirmativeRButton.setSelected(true);
        }
    }//GEN-LAST:event_actualAffirmativeRButtonActionPerformed

    private void actualExclusiveRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualExclusiveRButtonActionPerformed
        if (actualExclusiveRButton.isSelected()) {
            actualExclusiveRButton.setSelected(false);
        } else {
            actualExclusiveRButton.setSelected(true);
        }
    }//GEN-LAST:event_actualExclusiveRButtonActionPerformed

    private void actualExistentialRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualExistentialRButtonActionPerformed
        if (actualExistentialRButton.isSelected()) {
            actualExistentialRButton.setSelected(false);
        } else {
            actualExistentialRButton.setSelected(true);
        }
    }//GEN-LAST:event_actualExistentialRButtonActionPerformed

    private void howDoIDoThisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_howDoIDoThisButtonActionPerformed
        try {
            Desktop.getDesktop().browse(new URL("https://docs.google.com/document/d/1m_KvRpYu5MxOVIZUDOY8X7HgfVVchGv7OWY243b1W_U/edit?usp=sharing").toURI()); //Opens a url
        } catch (Exception f) { //catch exception to open url
            f.printStackTrace();
        }
    }//GEN-LAST:event_howDoIDoThisButtonActionPerformed
    //how do i do this button listener

    private void howDoIUseThisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_howDoIUseThisButtonActionPerformed
        File controlsFile = new File("Guide.txt"); //opens up the controls text file
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(controlsFile);
        } catch (IOException ex) {

        }
    }//GEN-LAST:event_howDoIUseThisButtonActionPerformed

    public boolean getFileSize() {
        fileSize = 0; //resets the size of the files
        try {
            getLengthOfFile = new Scanner(nounFile); //initializes scanner
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (getLengthOfFile.hasNextLine()) { //while loop to get the size of the file
            getLengthOfFile.nextLine(); //skips each line
            fileSize++; //adds one to file size
        }
        fileSize--; //subtracts the final count by one 
        return (true);
    } //method to retrieve the size of the file

    public boolean getWords() {
        lineCount = 0; //resets the line count
        try {
            nounFinder = new Scanner(nounFile); //gets the scanner to read the noun file
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        int firstWordNum = (int) (Math.random() * ((fileSize - 0) + 1)); //gets 3 random numbers for the subject predicate and middle term
        int secondWordNum = (int) (Math.random() * ((fileSize - 0) + 1));
        int thirdWordNum = (int) (Math.random() * ((fileSize - 0) + 1));
        while (nounFinder.hasNext()) {
            currentWord = nounFinder.nextLine();  //reads the current word
            if (lineCount == firstWordNum) { //checks if the line count number is equal to the first word number
                subject = currentWord; //if so the corresponding word variable to set to the current word
                firstNounText.setText(subject);
                firstCorrectNounText.setText(subject);
            }
            if (lineCount == secondWordNum) {
                predicate = currentWord;
                thirdNounText.setText(predicate);
                thirdCorrectNounText.setText(predicate);
            }
            if (lineCount == thirdWordNum) {
                middle = currentWord;
                secondNounText.setText(middle);
                secondCorrectNounText.setText(middle);
            }
            lineCount++; //the line count increases
        }
        return (true);
    } //method that gets the words that will be the subject predicate and middle terms

    public static String createAllStatement(String word1, String word2) {
        String statement = "";
        statement = "All " + word1 + " are " + word2;
        return (statement);
    } //method to write all (A) statements

    public static String createNoStatement(String word1, String word2) {
        String statement = "";
        statement = "No " + word1 + " are " + word2;
        return (statement);
    } //method to write no (E) statments 

    public static String createSomeStatement(String word1, String word2) {
        String statement = "";
        statement = "Some " + word1 + " are " + word2;
        return (statement);
    } //method to write some (I) statements

    public static String createSomeNotStatement(String word1, String word2) {
        String statement = "";
        statement = "Some " + word1 + " are not " + word2;
        return (statement);
    } //method to write some not (O) statements

    public void writeStatements() {
        correctVen.repaint();
        statementCount = 0; //resets the statement count
        actualFigure = (int) (Math.random() * ((4 - 1) + 1) + 1); //random int from 1 to 4 to get the figure of the statements
        for (int i = 0; i < 3; i++) { //for loop to get 3 random moods (A,E,I,O)
            int temp = ((int) (Math.random() * ((4 - 1) + 1)) + 1);
            if (temp == 1) {
                moods.add("A");
            } else if (temp == 2) {
                moods.add("E");
            } else if (temp == 3) {
                moods.add("I");
            } else if (temp == 4) {
                moods.add("O");
            }
        }
        for (int j = 0; j < moods.size(); j++) { //for loop that runs through each statement adding the corrent words for each statement
            if (statementCount == 0) { //if its the first statement
                if (moods.get(j).equals("A")) { //if its an all statement
                    if (actualFigure == 1 || actualFigure == 3) { //if its figure 1 or 3
                        statementOne.setText(createAllStatement(middle, subject)); //adds middle then subject
                        firstNounText.setText(middle); //changes which text is put where depending on the position
                        secondNounText.setText(subject);
                        firstCorrectNounText.setText(middle);
                        secondCorrectNounText.setText(subject);
                        middleDistribution = true; //if its an all statement only the first noun is distributed
                    } else if (actualFigure == 2 || actualFigure == 4) { //if its figure 2 or 4
                        statementOne.setText(createAllStatement(subject, middle)); //adds subject then middle
                        subjectDistribution = true;
                        firstNounText.setText(subject);
                        secondNounText.setText(middle);
                        firstCorrectNounText.setText(subject);
                        secondCorrectNounText.setText(middle);
                    } //this is the same for each condition of the first statement
                } else if (moods.get(j).equals("E")) { //if its a no statement
                    if (actualFigure == 1 || actualFigure == 3) {
                        statementOne.setText(createNoStatement(middle, subject));
                        firstNounText.setText(middle);
                        secondNounText.setText(subject);
                        firstCorrectNounText.setText(middle);
                        secondCorrectNounText.setText(subject);
                        middleDistribution = true; //if its a no statement, both nouns are distributed
                        subjectDistribution = true;
                    } else if (actualFigure == 2 || actualFigure == 4) {
                        statementOne.setText(createNoStatement(subject, middle));
                        firstNounText.setText(subject);
                        secondNounText.setText(middle);
                        firstCorrectNounText.setText(subject);
                        secondCorrectNounText.setText(middle);
                        subjectDistribution = true;
                        middleDistribution = true;
                    }
                } else if (moods.get(j).equals("I")) { //if its a some statement
                    if (actualFigure == 1 || actualFigure == 3) { //nothing is distributed in a some statement
                        firstNounText.setText(middle);
                        secondNounText.setText(subject);
                        firstCorrectNounText.setText(middle);
                        secondCorrectNounText.setText(subject);
                        statementOne.setText(createSomeStatement(middle, subject));
                    } else if (actualFigure == 2 || actualFigure == 4) {
                        statementOne.setText(createSomeStatement(subject, middle));
                        firstNounText.setText(subject);
                        secondNounText.setText(middle);
                        firstCorrectNounText.setText(subject);
                        secondCorrectNounText.setText(middle);
                    }
                } else if (moods.get(j).equals("O")) { //if its a some not statement
                    if (actualFigure == 1 || actualFigure == 3) {
                        statementOne.setText(createSomeNotStatement(middle, subject));
                        firstNounText.setText(middle);
                        secondNounText.setText(subject);
                        firstCorrectNounText.setText(middle);
                        secondCorrectNounText.setText(subject);
                        subjectDistribution = true; //if its a some not statement only the second noun is distributed
                    } else if (actualFigure == 2 || actualFigure == 4) {
                        statementOne.setText(createSomeNotStatement(subject, middle));
                        firstNounText.setText(subject);
                        secondNounText.setText(middle);
                        firstCorrectNounText.setText(subject);
                        secondCorrectNounText.setText(middle);
                        middleDistribution = true;
                    }
                }
            } else if (statementCount == 1) { //if its the second statement
                if (moods.get(j).equals("A")) { //if its an all statement
                    if (actualFigure == 1 || actualFigure == 2) { //if its figure 1 or 3
                        statementTwo.setText(createAllStatement(predicate, middle)); //adds predicate then middle
                        predicateDistribution = true;
                    } else if (actualFigure == 3 || actualFigure == 4) { //if its figure 2 or 4 
                        statementTwo.setText(createAllStatement(middle, predicate)); //adds middle then predicate
                        middleDistribution = true;
                    }
                } else if (moods.get(j).equals("E")) { //if its a no statement
                    if (actualFigure == 1 || actualFigure == 2) {
                        statementTwo.setText(createNoStatement(predicate, middle));
                        predicateDistribution = true;
                        middleDistribution = true;
                    } else if (actualFigure == 3 || actualFigure == 4) {
                        statementTwo.setText(createNoStatement(middle, predicate));
                        middleDistribution = true;
                        predicateDistribution = true;
                    }
                } else if (moods.get(j).equals("I")) { //if its a some statement
                    if (actualFigure == 1 || actualFigure == 2) {
                        statementTwo.setText(createSomeStatement(predicate, middle));
                    } else if (actualFigure == 3 || actualFigure == 4) {
                        statementTwo.setText(createSomeStatement(middle, predicate));
                    }
                } else if (moods.get(j).equals("O")) {
                    if (actualFigure == 1 || actualFigure == 2) {
                        statementTwo.setText(createSomeNotStatement(predicate, middle));
                        middleDistribution = true;
                    } else if (actualFigure == 3 || actualFigure == 4) {
                        statementTwo.setText(createSomeNotStatement(middle, predicate));
                        predicateDistribution = true;
                    }
                }
            } else if (statementCount == 2) {
                if (moods.get(j).equals("A")) { //if its an all statement
                    statementThree.setText(createAllStatement(subject, predicate)); //adds subject then predicate
                    subjectDistributionCheck = true;
                } else if (moods.get(j).equals("E")) { //if its a no statement
                    statementThree.setText(createNoStatement(subject, predicate));
                    subjectDistributionCheck = true;
                    predicateDistributionCheck = true;
                } else if (moods.get(j).equals("I")) { //if its a some statement
                    statementThree.setText(createSomeStatement(subject, predicate));
                } else if (moods.get(j).equals("O")) {
                    statementThree.setText(createSomeNotStatement(subject, predicate));
                    predicateDistributionCheck = true;
                }
            }
            statementCount++; //increases the statement count at the end of the loop
        }
    } //method that writes statements

    public void determineFallacies() {
        if (subjectDistribution == false && subjectDistributionCheck == true) {
            actualMaj = true;
        } //checks for major fallacy
        if (predicateDistribution == false && predicateDistributionCheck == true) {
            actualMin = true;
        } //checks for minor fallacy
        if (middleDistribution == false) {
            actualMid = true;
        } //checks for middle fallac6
        if (((moods.get(0).equals("E") || moods.get(0).equals("O")) || (moods.get(1).equals("E") || moods.get(1).equals("O"))) && (moods.get(2).equals("A") || moods.get(2).equals("I"))) {
            actualAffir = true;
        } //checks for affirmative fallacy
        if ((moods.get(0).equals("E") || moods.get(0).equals("O")) && (moods.get(1).equals("E") || moods.get(1).equals("O"))) {
            actualExclu = true;
        } //checks for exclusive fallacy
        if (((moods.get(0).equals("A") || moods.get(0).equals("E")) && (moods.get(1).equals("A") || moods.get(1).equals("E"))) && (moods.get(2).equals("I") || moods.get(2).equals("O"))) {
            actualExis = true;
        } //check for existential fallacy
        if (actualMaj == false && actualMin == false && actualMid == false && actualAffir == false && actualExclu == false && actualExis == false) {
            actualValid = true;
        } //if everything else if false, then it is valid
    } //method to retrieve the fallacies

    public void drawStatements() {
        Graphics g = correctVen.getGraphics(); //gets graphics of drawing label
        Graphics2D g2 = (Graphics2D) g; //gets the g2 graphics of the original graphocs
        g2.setStroke(new BasicStroke(3)); //increases thickness of line
        statementCount = 0; //resets the statement count
        for (int j = 0; j < moods.size(); j++) { //for loop that runs through each statement adding the corrent words for each statement
            if (statementCount == 0) { //if its the first statement
                if (moods.get(j).equals("A")) { //if its an all statement
                    if (actualFigure == 1 || actualFigure == 3) { //if its figure 1 or 3
                        g2.drawLine(29, 53, 125, 53);//lines are drawn depending on what and where the statement is
                        g2.drawLine(11, 108, 117, 108);
                        g2.drawLine(29, 155, 125, 155);
                    } else if (actualFigure == 2 || actualFigure == 4) { //if its figure 2 or 4
                        g2.drawLine(29, 53, 125, 53);
                        g2.drawLine(11, 108, 117, 108);
                        g2.drawLine(29, 155, 125, 155);
                    } //this is the same for each condition of the first statement
                } else if (moods.get(j).equals("E")) { //if its a no statement
                    if (actualFigure == 1 || actualFigure == 3) {
                        g2.drawLine(125, 53, 209, 53);
                        g2.drawLine(117, 108, 217, 108);
                        g2.drawLine(125, 155, 209, 155);
                    } else if (actualFigure == 2 || actualFigure == 4) {
                        g2.drawLine(125, 53, 209, 53);
                        g2.drawLine(117, 108, 217, 108);
                        g2.drawLine(125, 155, 209, 155);
                    }
                } else if (moods.get(j).equals("I")) { //if its a some statement
                    if (actualFigure == 1 || actualFigure == 3) {
                        g2.drawLine(156, 88, 166, 109);
                        g2.drawLine(165, 109, 188, 56);
                    } else if (actualFigure == 2 || actualFigure == 4) {
                        g2.drawLine(156, 88, 166, 109);
                        g2.drawLine(165, 109, 188, 56);
                    }
                } else if (moods.get(j).equals("O")) { //if its a some not statement
                    if (actualFigure == 1 || actualFigure == 3) {
                        g2.drawLine(71, 96, 90, 168);
                        g2.drawLine(49, 124, 105, 150);
                    } else if (actualFigure == 2 || actualFigure == 4) {
                        g2.drawLine(71, 96, 90, 168);
                        g2.drawLine(49, 124, 105, 150);
                    }
                }
            } else if (statementCount == 1) { //if its the second statement
                if (moods.get(j).equals("A")) { //if its an all statement
                    if (actualFigure == 1) { //if its figure 1 
                        g2.drawLine(259, 243, 198, 176);
                        g2.drawLine(164, 203, 225, 284);
                        g2.drawLine(110, 216, 185, 302);
                    } else if (actualFigure == 2) {
                        g2.drawLine(85, 261, 140, 177);
                        g2.drawLine(121, 292, 171, 199);
                        g2.drawLine(157, 302, 205, 215);
                    } else if (actualFigure == 3) { //if its figure 2 or 4 
                        g2.drawLine(116, 106, 53, 29);
                        g2.drawLine(19, 71, 70, 154);
                        g2.drawLine(154, 92, 124, 7);
                    } else if (actualFigure == 4) {
                        g2.drawLine(186, 98, 241, 7);
                        g2.drawLine(217, 111, 271, 20);
                        g2.drawLine(247, 139, 298, 43);
                    }
                } else if (moods.get(j).equals("E")) { //if its a no statement
                    if (actualFigure == 1 || actualFigure == 3) {
                        g2.drawLine(109, 116, 165, 200);
                        g2.drawLine(149, 100, 199, 171);
                        g2.drawLine(83, 144, 131, 211);
                    } else if (actualFigure == 2 || actualFigure == 4) {
                        g2.drawLine(140, 177, 186, 98);
                        g2.drawLine(171, 199, 217, 111);
                        g2.drawLine(205, 215, 247, 139);
                    }
                } else if (moods.get(j).equals("I")) { //if its a some statement
                    if (actualFigure == 1 || actualFigure == 3) {
                        g2.drawLine(120, 150, 113, 186);
                        g2.drawLine(113, 186, 162, 146);
                    } else if (actualFigure == 2 || actualFigure == 4) {
                        g2.drawLine(183, 167, 211, 178);
                        g2.drawLine(211, 178, 177, 124);
                    }
                } else if (moods.get(j).equals("O")) {
                    if (actualFigure == 1) {
                        g2.drawLine(214, 176, 218, 236);
                        g2.drawLine(185, 224, 237, 187);
                    } else if (actualFigure == 2) {
                        g2.drawLine(115, 231, 127, 184);
                        g2.drawLine(100, 186, 132, 226);
                    } else if (actualFigure == 3) {
                        g2.drawLine(98, 36, 156, 68);
                        g2.drawLine(159, 38, 97, 83);
                    } else if (actualFigure == 4) {
                        g2.drawLine(185, 71, 223, 35);
                        g2.drawLine(223, 64, 185, 45);
                    }
                }
            }
            statementCount++; //increases the statement count at the end of the loop
        }
    } //method to just draw the statements on the ven

    public void displayFallacies() {
        if (actualMaj) {
            actualMajorRButton.setSelected(true);
        }
        if (actualMin) {
            actualMinorRButton.setSelected(true);
        }
        if (actualMid) {
            actualMiddleRButton.setSelected(true);
        }
        if (actualAffir) {
            actualAffirmativeRButton.setSelected(true);
        }
        if (actualExclu) {
            actualExclusiveRButton.setSelected(true);
        }
        if (actualExis) {
            actualExistentialRButton.setSelected(true);
        }
        if (actualValid) {

        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    } //main method starts the frame

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton actualAffirmativeRButton;
    private javax.swing.JRadioButton actualExclusiveRButton;
    private javax.swing.JRadioButton actualExistentialRButton;
    private javax.swing.JRadioButton actualMajorRButton;
    private javax.swing.JRadioButton actualMiddleRButton;
    private javax.swing.JRadioButton actualMinorRButton;
    private javax.swing.JRadioButton affirmativeButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JButton checkAnswerButton;
    private javax.swing.JButton clearVen;
    private javax.swing.JLabel correctAnswer;
    private javax.swing.JLabel correctVen;
    private javax.swing.JLabel drawingLabel;
    private javax.swing.JRadioButton exclusiveButton;
    private javax.swing.JRadioButton existentialButton;
    private javax.swing.JLabel firstCorrectNounText;
    private javax.swing.JLabel firstNounText;
    private javax.swing.JButton howDoIDoThisButton;
    private javax.swing.JButton howDoIUseThisButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton majorButton;
    private javax.swing.JRadioButton middleButton;
    private javax.swing.JRadioButton minorButton;
    private javax.swing.JButton newStatementButton;
    private javax.swing.JLabel secondCorrectNounText;
    private javax.swing.JLabel secondNounText;
    private javax.swing.JLabel statementOne;
    private javax.swing.JLabel statementThree;
    private javax.swing.JLabel statementTwo;
    private javax.swing.JLabel thirdCorrectNounText;
    private javax.swing.JLabel thirdNounText;
    private javax.swing.JSpinner userFigure;
    private javax.swing.JSpinner userMood1;
    private javax.swing.JSpinner userMood2;
    private javax.swing.JSpinner userMood3;
    private javax.swing.JRadioButton validButton;
    private javax.swing.JLabel venLabel;
    // End of variables declaration//GEN-END:variables
}
