import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WeatherMan extends JPanel implements ActionListener{
 
 public int turn = 0; // check when game is over
 public int maxTurns = 20;
 public boolean fatal = false; // double profit if fatal weather is predicted, double loss and possible job loss if not
 public JFrame w;
 public JButton submit;
 
 
 public WeatherMan(){
  w = new JFrame();
  w.setSize(800, 600);
  w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  w.setResizable(false);
  w.setLayout(null);
  w.setContentPane(this);
  submit = new JButton("Go!");
  submit.setBounds(100,50,350,275);
  submit.addActionListener(this);
  w.add(submit);
  w.setVisible(true);
 } 
 
 
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == submit && turn < maxTurns){
       System.out.println("Next Turn");
      // do all the calculations here, and eventually bring up results panel.
       //this is where the rest of the calculations are called with their repective arguments (like player input)
       turn+=1;
       if(turn == maxTurns){
       submit.setText("End Game!");
       }
       }
      else if (e.getSource() == submit && turn >= maxTurns){
      //bring up gameOver panel
        System.out.println("game over");
      }
             
   }
 
 public static void main(String[] args){
 new WeatherMan();
 }


}
