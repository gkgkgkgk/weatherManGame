//num generator
public class numGenerator
{
 String type[] = {"rain","snow","heat wave","hail", "tsunami","drought","volcano", "flooding", "hurricane", "tornado"} ;
 double percent;
 int point; 
 String finalType;
 public numGenerator(City weather)
 {
  //rain, snow, heat wave, hail, tsunami, drought, volcano, flooding, hurricane, tornado

  point = (int)(Math.random() * (9));
  finalType = type[point];

  percent = Math.random() * (10-1) + 1; 
  double[] cityA = weather.getNumbers();// city array = cityA
  percent *= cityA[point];
 }

 public double getPercent()
 {
  return percent;
 }
}