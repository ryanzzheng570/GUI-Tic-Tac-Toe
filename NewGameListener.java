import java.awt.event.*;
import javax.swing.*;

public class NewGameListener implements ActionListener
{
  //Local Variables
  private int counter = 0;
  
  public void actionPerformed(ActionEvent event)
  {
    for(int i=0; i<3; i++)
    {
      for(int j=0; j<3; j++)
      {   
        //Set bottons to be clickable
        TicTacToeFrame.buttons[i][j].setText("");
        TicTacToeFrame.buttons[i][j].setEnabled(true);
      }
    }
    
    //Assign all values back to original state
    TicTacToeFrame. winner = null;
    TicTacToeFrame.numFreeSquares = 9;
    TicTacToeFrame.status.setText("X's Turn");
    TicTacToeFrame.frame.setVisible(true);
    
    //If the starting menu is clicked, it will disappear
    if(counter == 0)
    {
      TicTacToeFrame.textPane.add(TicTacToeFrame.newGame);
      TicTacToeFrame.textPane.add(TicTacToeFrame.quit);
      TicTacToeFrame.startFrame.setVisible(false);
    }
    counter ++ ;
  }
}
