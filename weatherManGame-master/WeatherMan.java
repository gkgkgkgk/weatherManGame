import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class WeatherMan extends JPanel implements ActionListener{
 
 public int turn = 0; // check when game is over
 public int maxTurns = 20;
 public boolean fatal = false; 
 // double profit if fatal weather is predicted, double loss and possible job loss if not
 JFrame w;
 JButton submit;
 JSlider input;


 private double check = 50000.00; //this is your money
 
 private double sPercent;
 private String thing; 
 private City city;
 private numGenerator a;
 private String cityN; 


 JLabel scienceText = new JLabel();
  JTextArea scienceTextArea;
 int height = 600;
 int width = 800;
 

 public WeatherMan(){    

   
   city = new City();
   cityN = city.nameGetter(0); 
   a  = new numGenerator(city);
  sPercent = (int)a.getPercent();
  thing = a.getEvent(); 
  w = new JFrame();
  w.setSize(width, height);
  w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  w.setResizable(true);
  setLayout(new BorderLayout());
  //PLEASE READ THIS GREG: 
  //https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
  w.setContentPane(this);

  
     Rectangle r = w.getBounds();
   double currentHeight = r.height;
   double currentWidth = r.width;
   
  
  
  submit = new JButton("50");
  //submit.setBounds(500,height - 75,100,50);
  submit.addActionListener(this);
  input = new JSlider();
  //input.setBounds(200, height - 100, 300, 100);

  input.addChangeListener(new ChangeListener() {
  public void stateChanged(ChangeEvent e) {
        String a = "" + input.getValue();
        submit.setText(a);
      }
    });

  String sData = Fluff.getScience(thing,sPercent,cityN);//GAVRI LOOK HERE
  scienceTextArea = new JTextArea();
  scienceTextArea.setText(sData); 
    scienceTextArea.setLineWrap(true);
    scienceTextArea.setWrapStyleWord(true);
    //scienceTextArea.setComponentOrientation(ComponentOrientation.CENTER);

  JScrollPane scrollPane = new JScrollPane(scienceTextArea);
  scienceTextArea.setOpaque(false);
  scienceTextArea.setEditable(false);
  scienceTextArea.setFocusable(false);


  //added a new panel to store the button and slider next to each other!
  //no need for absolute positioning anymore 
  JPanel bottomPanel = new JPanel();
  bottomPanel.add(input,BorderLayout.PAGE_END);
  bottomPanel.add(submit,BorderLayout.PAGE_END);
  JPanel sciencePanel = new JPanel();
  scienceTextArea.setPreferredSize(new Dimension(200, (int)currentHeight));
  sciencePanel.add(scienceTextArea,BorderLayout.PAGE_END);
  JPanel test = new JPanel();


  

  
  w.add(bottomPanel,BorderLayout.PAGE_END);
  w.add(sciencePanel,BorderLayout.LINE_START);

  scienceTextArea.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent ce) {

                System.out.println("I've changed size");

            }

        });


    w.setVisible(true);
 } 
 
 
public void actionPerformed(ActionEvent e) {
      if(e.getSource() == submit && turn < maxTurns){
       System.out.println("Next Turn");
      // do all the calculations here, and eventually bring up results panel.
       //this is where the rest of the calculations are called with their repective arguments (like player input)
       double UI = input.getValue();
       //City city = new City(); //just init the city so it can randomize
       //city = city.returnCity();
       new sucessOrFail(this, check, city, UI, sPercent);

       turn+=1;
       
       if(turn == maxTurns){
       submit.setText("End Game!");
       }
       else {
          City city = new City();
      numGenerator a  = new numGenerator(city);
      sPercent = a.getPercent();
      thing = a.getEvent();
      cityN = city.nameGetter(3); 
      scienceTextArea.setText(Fluff.getScience(thing,sPercent,cityN));
       }
       
       
       }

             
   }
   
   public void setCheck(double val){
   check = val;  
   }

 
 public static void main(String[] args){
   
 new WeatherMan();
 }


}