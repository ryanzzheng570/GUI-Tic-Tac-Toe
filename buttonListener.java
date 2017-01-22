import java.awt.event.*;
import javax.swing.*;

class buttonListener implements ActionListener 
{
  //Local variables
  private int row,col = 0;
  
  public static final String PLAYER_X = "X"; // player using "X"
  public static final String PLAYER_O = "O"; // player using "O"
  public static final String EMPTY = " ";  // empty cell
  public static final String TIE = "T"; // game ended in a tie
  
  private String player;   // current player (PLAYER_X or PLAYER_O)
  
  public void actionPerformed(ActionEvent event)
  {
    //The free squares decrement each time the botton is pressed
    TicTacToeFrame.numFreeSquares--; 
    
    //If the current turn is X's and there is no winner
    if(TicTacToeFrame.status.getText().equals("X's Turn") && (TicTacToeFrame.winner == null || TicTacToeFrame.winner == EMPTY))
    {
      //Get the botton
      JButton button = ((JButton)event.getSource());
      
      //Change the text of the botton to X, and make it not able to press
      button.setText("X");
      button.setEnabled(false);      
      
      //Store the row and col for the pressed botton
      for(int i=0; i<3; i++)
      {
        for(int j=0; j<3; j++)
        {
          if(event.getSource() == TicTacToeFrame.buttons[i][j])
          {    
            row = i;
            col = j;
          }
        }
      }   
      
      //Check if winner occured 
      if(haveWinner(row, col))
      {
        for(int i=0; i<3; i++)
        {
          for(int j=0; j<3; j++)
          {
            TicTacToeFrame.buttons[i][j].setEnabled(false);
          }
        }
        TicTacToeFrame.winner = PLAYER_X;
        TicTacToeFrame.status.setText("X win");
      }
      else
      {
        //Change to O's turn if there is no winner
        TicTacToeFrame.status.setText("O's Turn");
      }
      
      //If there is no winner and the number of free squares left is 0, then it's Tie
      if(TicTacToeFrame.winner == null && TicTacToeFrame.numFreeSquares == 0)
      {
        TicTacToeFrame.winner = TIE; 
        TicTacToeFrame.status.setText("TIE");
      }
    }
    //If the current turn is O's and there is no winner 
    else if(TicTacToeFrame.status.getText().equals("O's Turn") && (TicTacToeFrame.winner == null || TicTacToeFrame.winner == EMPTY))
    {
      //Set the botton's text to O and disable the button
      JButton button = ((JButton)event.getSource());
      button.setText("O");
      button.setEnabled(false); 
      
      //Find the row and col of the botton that is clicked
      for(int i=0; i<3; i++)
      {
        for(int j=0; j<3; j++)
        {
          if(event.getSource() == TicTacToeFrame.buttons[i][j])
          {    
            row = i;
            col = j;
          }
        }
      }   
      
      //Check if there's a winner
      if(haveWinner(row, col))
      {
        for(int i=0; i<3; i++)
        {
          for(int j=0; j<3; j++)
          {
            TicTacToeFrame.buttons[i][j].setEnabled(false);
          }
        }
        TicTacToeFrame.winner = PLAYER_O;
        TicTacToeFrame.status.setText("O win");
      }
      else
      {
        //Otherwise the current turn become X's turn 
        TicTacToeFrame.status.setText("X's Turn");
      }
      
      //It's a tie while there's no winner and no free squres left
      if(TicTacToeFrame.winner == null && TicTacToeFrame.numFreeSquares == 0)
      {
        TicTacToeFrame.winner = TIE; 
        TicTacToeFrame.status.setText("TIE");
      }
    }
  }
  
  private boolean haveWinner(int row, int col) 
  {
    // unless at least 5 squares have been filled, we don't need to go any further
    // (the earliest we can have a winner is after player X's 3rd move).
    if (TicTacToeFrame.numFreeSquares>4) return false;
    
    // Note: We don't need to check all rows, columns, and diagonals, only those
    // that contain the latest filled square.  We know that we have a winner 
    // if all 3 squares are the same, as they can't all be blank (as the latest
    // filled square is one of them).
    
    // check row "row"
    if (TicTacToeFrame.buttons[row][0].getText().equals(TicTacToeFrame.buttons[row][1].getText()) &&
        TicTacToeFrame.buttons[row][0].getText().equals(TicTacToeFrame.buttons[row][2].getText())) return true;
    
    // check column "col"
    if (TicTacToeFrame.buttons[0][col].getText().equals(TicTacToeFrame.buttons[1][col].getText()) &&
        TicTacToeFrame.buttons[0][col].getText().equals(TicTacToeFrame.buttons[2][col].getText()) ) return true;
    
    // if row=col check one diagonal
    if (row==col)
      if ( TicTacToeFrame.buttons[0][0].getText().equals(TicTacToeFrame.buttons[1][1].getText()) &&
          TicTacToeFrame.buttons[0][0].getText().equals(TicTacToeFrame.buttons[2][2].getText()) ) return true;
    
    // if row=2-col check other diagonal
    if (row==2-col)
      if ( TicTacToeFrame.buttons[0][2].getText().equals(TicTacToeFrame.buttons[1][1].getText()) &&
          TicTacToeFrame.buttons[0][2].getText().equals(TicTacToeFrame.buttons[2][0].getText())) return true;
    
    // no winner yet
    return false;
  }
}