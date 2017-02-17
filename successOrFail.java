public class successOrFail //extends numGenerator 
{
 private double currentCheck; // set equal to the amount he made before this turn. 
 private double actual;
 private boolean outcome; 
 private double userInput;

 public successOrFail(WeatherMan wm, double check, City weather, double UserInput, double getPercent) 
 {
  
  //super(weather); // wait to add the climate class to compile. 
  this.userInput = UserInput;
  currentCheck = check; 
  System.out.println("Current Check: "+currentCheck);
  actual = 10.0*(Math.random() * (10-1) + 1);
  double raise;
  System.out.println("Actual: "+actual + " getPercent "+ getPercent);
  double aDif = (getPercent-actual);

  if(aDif < 0) outcome = false; 
  else if (aDif >= 0 ) outcome = true; 
  

  
  //raise = Math.abs(userInput - actual)/100.0; 
/*
  raise = UserInput - (actual / getPercent);
  // UI = 60% actual 70% and getPercent is 80%, then outcome = false, so raise = 
  // 60 - (70/80) = 78.5;
  //^^^ This works for some reason, i guess.
  
  
  if(!outcome && userInput > 30) raise *= -1;

  if(userInput == getPercent) raise = 0; 
  
  System.out.println("outcome: "+outcome+" Raise: " + raise);

  */
  System.out.println(outcome); 
raise = Math.abs(UserInput - getPercent); 
  
  if(outcome && getPercent > 50)  //if it happens and scientists are right
  {// raise
    if(UserInput < 50){ // you were wrong
      raise = (-1)*(getPercent-UserInput);
    }
    else if(UserInput < getPercent){
      raise = (-1)*Math.abs(UserInput-getPercent);
    }
    else{
      raise = (1)*Math.abs(UserInput-getPercent);
    }
  }

  else if(outcome && getPercent < 50) //happens and scientists are wrong
   {
  if(UserInput > 50){ // you were right
      raise = (1)*Math.abs(getPercent-UserInput);
    }
    else if(getPercent < UserInput){ //they guess lower than you
      raise = (-1)*Math.abs(UserInput-getPercent);
    }
    else{ // they guess more than you and doesnt happen
      raise = (1)*Math.abs(UserInput-getPercent);
    }   
  }
  else if (!outcome && getPercent > 50) // doesn't happen and scientists are wrong
  {
    if(UserInput > 50) {// you are also wrong 
      raise = (-1)*Math.abs(getPercent-UserInput);
    }
    else if (UserInput > getPercent) {// you said more than them.
      raise = (-1)*Math.abs(getPercent-UserInput);
    } 
    else
    {
      raise = (1)*Math.abs(getPercent-UserInput);
    }
  }
    else if (!outcome && getPercent<50)// doesn't happen and the scientits are right
    {
      if(UserInput > 50){// you were wrong
        raise = (-1)*Math.abs(getPercent-UserInput);
      }
      else if (UserInput < getPercent){// you said more than the scientits
        raise = (-1)*Math.abs(getPercent-UserInput);
      }
      else{ raise = (1)*Math.abs(getPercent-UserInput);}
    }

   
 
  
  currentCheck += (currentCheck*raise);
  System.out.println("currentCheck: "+ currentCheck);
  wm.setCheck(currentCheck); //cuz of static stuffs

 }
 public boolean getOutcome()
 {
  return outcome;
 }
}
