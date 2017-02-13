import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WeatherMan extends JPanel implements ActionListener{
 
 public int turn = 0; // check when game is over
 public boolean fatal = false; // double profit if fatal weather is predicted, double loss and possible job loss if not
 public JFrame w;
 public WeatherMan(){
  w = new JFrame();
  w.setSize(800, 600);
  w.setVisible(true);
 } 
 
 
   public void actionPerformed(ActionEvent e) {
               
   }
 
 public static void main(String[] args){
 new WeatherMan();
 }


}
