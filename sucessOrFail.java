public class sucessOrFail extends numGenerator 
{
 private double currentCheck; // set equal to the amount he made before this turn. 
 private double actual;
 private boolean outcome; 
 private double userInput;

 public sucessOrFail(WeatherMan wm, double check, City weather, double UserInput) 
 {
  
  super(weather); // wait to add the climate class to compile. 
  this.userInput = UserInput;
  currentCheck = check; 
  System.out.println("Current Check: "+currentCheck);
  actual = 10.0*(Math.random() * (10-1) + 1);
  double raise;
  System.out.println("Actual: "+actual + " getPercent "+ super.getPercent());
  double aDif = -1*(super.getPercent()-actual);

  if(aDif < 0) outcome = false; 
  else if (aDif >= 0 ) outcome = true; 
  
  userInput = userInput/10.0;
  
  raise = Math.abs(userInput - super.getPercent())/100.0; 

  if(!outcome) raise *= -1;
  
  System.out.println("outcome: "+outcome+" Raise: " + raise);
  
  currentCheck += (currentCheck*raise);
  System.out.println("currentCheck: "+ currentCheck);
  wm.setCheck(currentCheck); //cuz of static stuffs
 }
 public boolean getOutcome()
 {
  return outcome;
 }

}
