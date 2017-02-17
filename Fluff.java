import java.util.Random;
public class Fluff {
  /*
  public Fluff(){
    for(int i = 0; i < 5; i++){
    System.out.println(getScience("meteor", 50.0));
    }
  }
  */
  
  static Random r = new Random();
  
  //call this to get a random headline for the background UI
  
  public static String getHeadline() {
        String[] a = {
            "Study Reveals: Babies Are Stupid",
            "World Death Rate Holding Steady at 100 Percent",
            "Perky ‘Canada’ has own government, laws",
            "CIA Realizes It’s Been Using Black Highlighters All These Years",
            "Drugs Win Drug War",
            "Kitten Thinks of Nothing But Murder All Day",
            "Fall Canceled After 3 Billion Seasons",
            "God Answers Prayers of Paralyzed Little Boy: ‘No,’ Says God",
            "Archaeological Dig Uncovers Ancient Race Of Skeleton People",
            "Missipi's Literacy Program Shows Improvement",
            "'I Thought He Was Going to Kill Me': One Woman’s Harrowing Misunderstanding of How Haircuts Work",
            "One Armed Man Applauds the Kindness of Strangers",
            "Homocide Victems Rarely Talk to Police",
            "Man Tried to Sell Himself on Ebay",
            "Grass Growing Fast After Rain",
            "Sunderland Firefighters Rescue Duck from Lake",
            "Bugs Flying Around With Wings are Flying Bugs",
            "City Unsure why Sewer Smells",
            "City to Pay 250,000$ to Advertise Lack of Funds"
        };

        return a[r.nextInt(a.length)];
    }

    public static String getResult(boolean outcome, String type, String city)
    {
      String finalS = "";
      String piece = "";
      if(!(type.equals("volcano") || type.equals("tsunami") || type.equals("flooding") || type.equals("drought") || type.equals("hurricane") || type.equals("tornado") || type.equals("heat wave") )){
      if(outcome) finalS = "It " + type + "ed in " + city + " yesterday";
      else finalS = "It did not " + type + " in " + city + " yesterday"; 
    }
    else
    {
      if(outcome) piece = "did indeed";
      else piece = "did not in fact"; 

      switch (type)// i made this a switch because we can make these more personalized (i.e volcanos erupt...... )
      {
        case "volcano": 
        finalS = "the volcano " + piece + " erupt yesterday in " + city; 
        break; 

        case "tsunami": 
        finalS = "the tsunami " + piece + " occur yesterday in " + city; 
        break; 

        case "drought": 
        finalS = "the " + type + " " + piece + " occur yesterday in " + city; 
        break; 

        case "tornado": 
        finalS = "the " + type + " " + piece + " occur yesterday in " + city; 
        break; 

        case "hurricane": 
        finalS = "the " + type + " " + piece + " occur yesterday in " + city; 
        break; 

        case "flooding": 
        finalS = "the " + type + " " + piece + " occur yesterday in " + city; 
        break; 
        case "heat wave": 
        finalS = "the " + type + " " + piece + " occur yesterday in " + city; 
        break; 
        
        default: //this shouldn't happen 
        finalS = "on a scale of 1 to Gavri this code is working just as well as Gavri "; 
        break; 
      }
    }
      return finalS; 
    }
  //call this function to return the string for the scientist JTextArea
  
  public static String getScience(String type, double percentage, String city){
    String finalS = "";
    String[] person = {"Experts ", "Scientists ", "Meteorologists ", "Specialists "};
    String[] verb = {"predict ", "expect ", "anticipate ", "foresee ", "report "};
    String[] adj = {" severe ", " mild ", " major ", " fatal ", " intense ", "", " strong "};
    finalS = person[r.nextInt(person.length)]+verb[r.nextInt(verb.length)]+"a " + Math.round(percentage) +"% chance of " + adj[r.nextInt(adj.length)] + type + " weather in " +city;
    return finalS;
  }

}
