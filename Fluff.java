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
  
  public String getHeadline() {
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

  //call this function to return the string for the scientist jlabel
  
  public static String getScience(String type, double percentage, String city){
    String finalS = "";
    String[] person = {"Experts ", "Scientists ", "Meteorologists ", "Specialists "};
    String[] verb = {"predict ", "expect ", "anticipate ", "foresee ", "report "};
    String[] adj = {" severe ", " mild ", " major ", " fatal ", " intense ", "", " strong "};
    finalS = person[r.nextInt(person.length)]+verb[r.nextInt(verb.length)]+"a " + Math.round(percentage) +"% chance of " + adj[r.nextInt(adj.length)] + type + " weather in " +city;
    return finalS;
  }
 /*
  public static void main(String[] args){
    new Fluff();
  }
  */
}
