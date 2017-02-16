import java.util.Random;

public class City {

    double rain = (Math.random() * (10-1) + 1);
    double snow = (Math.random() * (10-1) + 1);
    double heatWave = (Math.random() * (10-1) + 1);
    double hail= (Math.random() * (10-1) + 1);
    double tsunami= (Math.random() * (10-1) + 1);
    double drought= (Math.random() * (10-1) + 1);
    double volcano= (Math.random() * (10-1) + 1);
    double flooding= (Math.random() * (10-1) + 1);
    double hurricane= (Math.random() * (10-1) + 1);
    double tornado= (Math.random() * (10-1) + 1);
    String name = nameGetter(1);

    public City() {
        
    }

    public double[] getNumbers() {
        double a[] = {
            rain, // you had the array in the parameter before 
            snow,
            heatWave,
            hail,
            tsunami,
            drought,
            volcano,
            flooding,
            hurricane,
            tornado
        };
        return a;
    }

   /* public City returnCity() {
     //returns a city with a random name (String Getter function) and doubles 1-10 used for weather conditions of that city
        return new City(nameGetter(1),(Math.random() * (10-1) + 1), (Math.random() * (10-1) + 1),(Math.random() * (10-1) + 1),(Math.random() * (10-1) + 1),(Math.random() * (10-1) + 1),(Math.random() * (10-1) + 1),(Math.random() * (10-1) + 1),(Math.random() * (10-1) + 1),(Math.random() * (10-1) + 1),(Math.random() * (10-1) + 1));
    }*/
    //recycled code from mapGenerator
    public String nameGetter(int length) {
        String[] prefix = {
            "Los ",
            "Saint ",
            "New ",
            "Old ",
            "Little ",
            "South ",
            "North ",
            "West ",
            "East "

        };
        String[] pre = {
            "Mel",
            "Lon",
            "Long",
            "Middle",
            "Bei",
            "Tok",
            "York",
            "Acro",
            "Spring",
            "Nan",
            "San",
            "Cape",
            "Fair",
            "Rich",
            "Kings",
            "Glen",
            "Bost",
            "Rekt",
            "Ply",
            "Wat",
            "Great",
            "Wig",
            "Black",
            "White",
            "Red",
            "Blue",
            "Wes",
            "Leo",
            "John"
        };
        String[] suf = {
            "lin",
            " City",
            "andria",
            "lore",
            "don",
            "neck",
            "jing",
            "polis",
            "ville",
            "ford",
            "furt",
            "shire",
            "field",
            "burg",
            "bury",
            "chester",
            "town",
            "park",
            "side",
            "wood",
            "gelos",
            "ston",
            "port",
            "dale",
            "thorp",
            "kirk",
            "gate",
            "on",
            "berg",
            "cott",
            "hill",
            "holm",
            "mouth",
            "ness",
            "pool",
            "ster",
            "wick",
            "stead",
            "worth",
            "dom",
            "edi"
        };
        Random random = new Random();
        if (random.nextInt(10) < 5) {
            name = prefix[random.nextInt(prefix.length)] + pre[random.nextInt(pre.length)] + suf[random.nextInt(suf.length)];
        } else {
            name = pre[random.nextInt(pre.length)] + suf[random.nextInt(suf.length)];
        }
        return name;
    }
}
