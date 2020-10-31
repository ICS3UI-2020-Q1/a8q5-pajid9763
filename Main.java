import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  JLabel guessLabel;
  JLabel outputLabel;

  JTextField numInput;

  JButton submitButton;
  JButton newButton;
  

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Guessing Game");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    // initialize the main JPanel 
    mainPanel = new JPanel();
    // turn on manual layouts 
    mainPanel.setLayout(null);
    // add the mainPanel to the JFrame 
    frame.add(mainPanel);

    // create the labels
    guessLabel = new JLabel("Guess the number between 0 and 100:");
    outputLabel = new JLabel();

    // set the location and size of the labels 
    guessLabel.setBounds(30, 30, 300, 25);
    outputLabel.setBounds(30, 160, 300, 25);

    // add the labels to the mainPanel 
    mainPanel.add(guessLabel);
    mainPanel.add(outputLabel);


    // initialize the JTextField 
    numInput = new JTextField();

    // set the location and size of the text field
    numInput.setBounds(30, 55, 270, 25);

    // add the JTextField to the mainPanel 
    mainPanel.add(numInput);


    // initialize the JButtons 
    submitButton = new JButton("Submit");
    newButton = new JButton("New Number");

    // add an ActionListener 
    submitButton.addActionListener(this);
    newButton.addActionListener(this);

    // give the buttons an action command 
    submitButton.setActionCommand("submit");
    newButton.setActionCommand("new");

    // set the location and size of the buttons 
    submitButton.setBounds(30, 100, 110, 40);
    newButton.setBounds(150, 100, 150, 40);

    // add the buttons to the mainPanel 
    mainPanel.add(submitButton);
    mainPanel.add(newButton);
 
  }
  // random input
  Random rand = new Random();

  // get the random number to guess
  int randInt = rand.nextInt(100) + 1;

  // create a method that can be called out to compare number to random
  public void finalNum(int x){
    // get text from numInput 
    String numInputText = numInput.getText();
    // convert String to int 
    int numInputChosen = Integer.parseInt(numInputText);
    
    if (numInputChosen == randInt){
      // output text to user
      outputLabel.setText("Your guess of " + numInputChosen + " is correct!");
        
      } else if (numInputChosen > randInt){
      // output text to user
      outputLabel.setText("Your guess of " + numInputChosen + " is too high!");
        
      } else if (numInputChosen < randInt){
      // output text to user
      outputLabel.setText("Your guess of " + numInputChosen + " is too low!");
      } 
  }
  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
      
      if(command.equals("submit")){
        // get text from numInput 
        String numInputText = numInput.getText();
        // convert String to int 
        int numInputChosen = Integer.parseInt(numInputText);
        
        // call upon the method 
        finalNum(numInputChosen);
      
        } else if (command.equals("new")){
          // get a new random number to guess
          randInt = rand.nextInt(100) + 1;
          // clear out the text field and the outputLabel
          numInput.setText("");
          outputLabel.setText("");

    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
