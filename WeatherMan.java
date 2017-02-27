import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class WeatherMan extends JPanel implements ActionListener {
    
    //UI Variables
    JFrame w;
    JButton submit, next;
    JSlider input;
    JPanel bottomPanel, pCheck, sciencePanel, result, bottomPanelInput;
    JLabel scienceText = new JLabel();
    JTextArea scienceTextArea, rFinal, tCheck;


    private Font font = new Font("serif", Font.PLAIN, 25);
    public int turn = 0; // check when game is over
    public int maxTurns = 20;
    public boolean fatal = false;
    // double profit if fatal weather is predicted, double loss and possible job loss if not
    

    private double check = 50000.00; //this is your money
    private successOrFail out;
    private double sPercent;
    private String thing;
    private City city;
    private numGenerator a;
    private String cityN;
    
    int height = 600;
    int width = 800;


    public WeatherMan() {
        //Window and main Panel stuff
        w = new JFrame();
        w.setSize(width, height);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setResizable(true);
        w.setContentPane(this);
        setLayout(new BorderLayout());

        //get window size
        Rectangle r = w.getBounds();
        double currentHeight = r.height;
        double currentWidth = r.width;


        //initial setup:
        city = new City();
        cityN = city.nameGetter(0);
        a = new numGenerator(city);
        sPercent = (int) a.getPercent();
        thing = a.getEvent();
        

        
        //sData (science data) is important
        String sData = Fluff.getScience(thing, sPercent, cityN);


        //set up UI
        next = new JButton("Next");
        next.setVisible(false);
        next.addActionListener(this);
            
        submit = new JButton("50");
        submit.addActionListener(this);
        
        input = new JSlider();
        input.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                String a = "" + input.getValue();
                submit.setText(a);
            }
        });



        scienceTextArea = new JTextArea();
        scienceTextArea.setText(sData);
        scienceTextArea.setFont(font);
        scienceTextArea.setLineWrap(true);
        scienceTextArea.setWrapStyleWord(true);
        scienceTextArea.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent ce) {

                System.out.println("I've changed size");

            }

        });

        rFinal = new JTextArea();
        rFinal.setText("");
        rFinal.setFont(font);
        rFinal.setLineWrap(true);
        rFinal.setWrapStyleWord(true);

        tCheck = new JTextArea();
        tCheck.setText("" + check);
        tCheck.setFont(font);
        tCheck.setLineWrap(true);
        tCheck.setWrapStyleWord(true);
        //adding scrollpanes for the text areas
        JScrollPane scrollPane = new JScrollPane(scienceTextArea);
        scienceTextArea.setOpaque(false);
        scienceTextArea.setEditable(false);
        scienceTextArea.setFocusable(false);

        JScrollPane scrollPanee = new JScrollPane(rFinal);
        rFinal.setOpaque(false);
        rFinal.setEditable(false);
        rFinal.setFocusable(false);

        JScrollPane scrollpaneee = new JScrollPane(tCheck);
        tCheck.setOpaque(true);
        tCheck.setEditable(false);
        tCheck.setFocusable(false);


        bottomPanelInput = new JPanel();
        bottomPanelInput.add(input, BorderLayout.PAGE_END);
        bottomPanelInput.add(submit, BorderLayout.PAGE_END);



        bottomPanel = new JPanel();
        bottomPanel.add(bottomPanelInput, BorderLayout.PAGE_END);
        bottomPanel.add(next, BorderLayout.LINE_END);
        
        sciencePanel = new JPanel();
        scienceTextArea.setPreferredSize(new Dimension(200, (int) currentHeight));
        sciencePanel.add(scienceTextArea, BorderLayout.PAGE_END);
        
        result = new JPanel();
        rFinal.setPreferredSize(new Dimension(200, (int) currentHeight));
        result.add(rFinal, BorderLayout.PAGE_END);
        
        pCheck = new JPanel();
        pCheck.add(tCheck, BorderLayout.LINE_END);



        
        //add to main Panel
        w.add(pCheck, BorderLayout.PAGE_START);
        w.add(bottomPanel, BorderLayout.PAGE_END);
        w.add(sciencePanel, BorderLayout.LINE_START);
        w.add(result, BorderLayout.LINE_END);
        //w.add(pCheck,BorderLayout.LINE_END); //I DON'T KNOW HOW TO ADD THIS SO THAT RESULT DOESN'T GO AWAY AND I DON'T KNOW HOW TO MAKE RESULT FILL UP MORE OF THE SCREEN. 
        //ON A SCALE OF 1 TO GAVRI THIS CODE WORKS WORSE THAN GAVRI 
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^   <---------Not anymore
        
        w.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit && turn < maxTurns) {
            next.setVisible(true);
            bottomPanelInput.setVisible(false);

            System.out.println("Next Turn");
            // do all the calculations here, and eventually bring up results panel.
            //this is where the rest of the calculations are called with their repective arguments (like player input)
            double UI = input.getValue();

            out = new successOrFail(this, check, city, UI, sPercent);
            tCheck.setText("" + (double)((int)(check * 100)) / 100);
                rFinal.setText(Fluff.getResult(out.getOutcome(), thing, cityN));
            turn += 1;

            
        }

        else if (e.getSource() == next && turn < maxTurns) {
            bottomPanelInput.setVisible(true);
            next.setVisible(false);            
            System.out.println("Next Button Clicked");
           if (turn == maxTurns) {
                submit.setText("End Game!");
            } else {
                
              
                City city = new City();
                numGenerator a = new numGenerator(city);
                sPercent = a.getPercent();
                thing = a.getEvent();
                cityN = city.nameGetter(3);
                scienceTextArea.setText(Fluff.getScience(thing, sPercent, cityN));
                rFinal.setText("");
                //scienceTextArea.setText(Fluff.getScience(thing,sPercent,cityN))


            }


        }



    }

    public void setCheck(double val) {
        check = val;
        System.out.println("Changed the check to " + val +"!");
    }


    public static void main(String[] args) {

        new WeatherMan();
    }


}
