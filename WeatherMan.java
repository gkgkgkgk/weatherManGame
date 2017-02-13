import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class WeatherMan extends JPanel implements ActionListener{
 
 public int turn = 0; // check when game is over
 public int maxTurns = 20;
 public boolean fatal = false; // double profit if fatal weather is predicted, double loss and possible job loss if not
 JFrame w;
 JButton submit;
 JSlider input;
 JLabel value;
 public double check = 100000.00; //this is your money
  
 public WeatherMan(){
  w = new JFrame();
  w.setSize(800, 600);
  w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  w.setResizable(false);
  w.setLayout(null);
  w.setContentPane(this);
    value = new JLabel();
  submit = new JButton("Go!");
  submit.setBounds(100,50,350,275);
  submit.addActionListener(this);
  input = new JSlider();
  input.setBounds(400, 20, 200, 580);
  input.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        String a = "" + input.getValue();
        value.setText(a);
      }
    });


  w.add(value);
  w.add(input);
  w.add(submit);
  w.setVisible(true);
 } 
 
 
public void actionPerformed(ActionEvent e) {
      if(e.getSource() == submit && turn < maxTurns){
       System.out.println("Next Turn");
      // do all the calculations here, and eventually bring up results panel.
       //this is where the rest of the calculations are called with their repective arguments (like player input)
       double UI = 1.0;
       City city = new City("",1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0);
       new sucessOrFail(this, check, city, UI);

       turn+=1;
       
       if(turn == maxTurns){
       submit.setText("End Game!");
       }
       
       
       }
      else if (e.getSource() == submit && turn >= maxTurns){
      //bring up gameOver panel (IF I HAD ONE)
        System.out.println("game over");
      }
             
   }
   
   public void setCheck(double val){
   check = val;  
   }

 
 public static void main(String[] args){
 new WeatherMan();
 }


}