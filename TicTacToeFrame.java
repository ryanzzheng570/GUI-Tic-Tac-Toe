import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * A class modelling a tic-tac-toe (noughts and crosses, Xs and Os) game in a very
 * simple GUI window.
 */

public class TicTacToeFrame
{    
  
  public static int numFreeSquares = 9; //Maximum square is 9
  public static String winner; //One winner
  public static int row, col = 0;
  
  public static JTextArea status; // text area to print game status
  public static JFrame frame; //A window frame
  public static JFrame startFrame; //The starting frame
  
  //JPanel for button, text
  private JPanel allPanel; 
  private JPanel buttonPane;
  public static JPanel textPane;
  private JPanel startPane;
  
  //Border to sperate 9 squares
  private Border lineBorder;
  
  //Buttons to show O or X, and new game, quit
  public static JButton[][] buttons; 
  public static JButton newGame;
  public static JButton quit;
  
  /** 
   * Constructs a new Tic-Tac-Toe board and sets up the basic
   * JFrame containing a JTextArea in a JScrollPane GUI.
   */
  public TicTacToeFrame() 
  { 
    //Contruct the tic tac toe menu and set the size the length 300, width 100.
    startFrame = new JFrame("Tic Tac Toe Game Menu");
    startFrame.setSize(300,100);
    startFrame.setLocationRelativeTo(null); 
    
    //Create the buttons to let user to choose to have a new game or quit the game
    newGame = new JButton("New (or Alt-N)");
    quit = new JButton("Quit (or Alt-Q)");
    
    //Set both botton to size 50,70
    newGame.setSize(50,70);
    quit.setSize(50,70);
    
    //Add action listener and set Mnemonic to each botton
    newGame.addActionListener(new NewGameListener());
    newGame.setMnemonic(KeyEvent.VK_N);
    quit.addActionListener(new quitListener());
    quit.setMnemonic(KeyEvent.VK_Q);
    
    //Create the starting pane and set the layout 
    startPane = new JPanel();
    startPane.setLayout(new GridLayout(1, 2, 0, 1));
    startPane.add(newGame, BorderLayout.CENTER);
    startPane.add(quit, BorderLayout.CENTER);
    
    //Add the pane into the frame
    startFrame.add(startPane);
    startFrame.setVisible(true);
    
    //Contruct the Tic Tac Toe game frame with a size 500,500
    frame = new JFrame("TicTacToe"); 
    frame.setSize(500, 500); 
    frame.setLocationRelativeTo(null); 
    
    //Define the panel and set GridLayout to 3 by 3 
    allPanel = new JPanel();
    buttonPane = new JPanel();
    textPane = new JPanel();
    buttonPane.setLayout(new GridLayout(3, 3)); 
    
    
    //create a border line 
    lineBorder = new LineBorder(Color.black, 2); 
 
    //create an array of labels which will display X or O    
    buttons = new JButton[3][3];
    
    //Assign the buttons with action listener
    for(int i=0; i<3; i++)
    {
      for(int j=0; j<3; j++)
      {
        buttons[i][j] = new JButton(" ");
        buttonListener bL = new buttonListener();
        buttons[i][j].addActionListener(bL);
        buttons[i][j].setBorder(lineBorder);
        buttonPane.add(buttons[i][j]);
      }
    }       
    
    // Starting with X's turn
    status = new JTextArea("X's Turn");
    status.setSize(50,70);
    JScrollPane scroll = new JScrollPane(status);
    textPane.add(scroll);
    
   //Add contents to the panel and add panel to the frame 
    allPanel.setLayout(new BorderLayout());  
    allPanel.add(buttonPane, BorderLayout.CENTER);
    allPanel.add(textPane, BorderLayout.SOUTH);    
    frame.add(allPanel);       
    frame.setVisible(false);
    frame.toFront();
  }
  
}