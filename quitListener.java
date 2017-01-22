import java.awt.event.*;
import javax.swing.*;

public class quitListener implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
    //While the quit button is click, the program end.
    System.exit(0);
  }
}
