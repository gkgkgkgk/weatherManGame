import java.util.Random;

public class City {

    double rain;
    double snow;
    double heatWave;
    double hail;
    double tsunami;
    double drought;
    double volcano;
    double flooding;
    double hurricane;
    double tornado;
    String name;

    public City(String name, double rain, double snow, double heatWave, double hail, double tsunami, double drought, double volcano, double flooding, double hurricane, double tornado) {
        this.rain = rain;
        this.snow = snow;
        this.heatWave = heatWave;
        this.hail = hail;
        this.tsunami = tsunami;
        this.drought = drought;
        this.volcano = volcano;
        this.flooding = flooding;
        this.hurricane = hurricane;
        this.tornado = tornado;
        this.name = name;
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

    public City returnCity() {
     //returns a city with a random name (String Getter function) and doubles 1-10 used for weather conditions of that city
        return new City(nameGetter(1),(Math.random() * (10-1) + 1), (Math.random() * (10-1) + 1),(Math.random() * (10-1) + 1),(Math.random() * (10-1) + 1),(Math.random() * (10-1) + 1),(Math.random() * (10-1) + 1),(Math.random() * (10-1) + 1),(Math.random() * (10-1) + 1),(Math.random() * (10-1) + 1),(Math.random() * (10-1) + 1));
    }
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
