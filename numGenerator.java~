public class numGenerator 
{
 String type[];
 double percent;
 int point; 
 public numGenerator(City weather)
 {
  //rain, snow, heat wave, hail, tsunami, drought, volcano, flooding, hurricane, tornado
  type = {"rain","snow","heat wave","hail", "tsunami","drought","volcano", "flooding", "hurricane", "tornado"}; 
  point = (int)(Math.random() * (9))
  type[point];

  percent = Math.random() * (10-1) + 1; 

  percent *= weather.getNumbers(point);
 }
 public double getPercent()
 {
  return percent;
 }
}