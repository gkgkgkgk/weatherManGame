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

 public double check = 50000.00; //this is your money
 
 JLabel scienceText;
 int height = 600;
 int width = 800;
 

 public WeatherMan(){
  w = new JFrame();
  w.setSize(width, height);
  w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  w.setResizable(false);
  setLayout(null);
  w.setLayout(null);
  w.setContentPane(this);

  submit = new JButton("50");
  submit.setBounds(500,height - 75,100,50);
  submit.addActionListener(this);
  input = new JSlider();
  input.setBounds(200, height - 100, 300, 100);
  input.addChangeListener(new ChangeListener() {
  public void stateChanged(ChangeEvent e) {
        String a = "" + input.getValue();
        submit.setText(a);
      }
    });
  scienceText = new JLabel();
  w.add(scienceText);

  w.add(input);
  w.add(submit);
  w.setVisible(true);
 } 
 
 
public void actionPerformed(ActionEvent e) {
      if(e.getSource() == submit && turn < maxTurns){
       System.out.println("Next Turn");
      // do all the calculations here, and eventually bring up results panel.
       //this is where the rest of the calculations are called with their repective arguments (like player input)
       double UI = input.getValue();
       City city = new City(); //just init the city so it can randomize
       //city = city.returnCity();
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
