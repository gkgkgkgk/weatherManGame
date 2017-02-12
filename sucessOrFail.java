public class sucessOrFail extends numGenerator
{
	private double currentCheck; // set equal to the amount he made before this turn. 
	private double actual;
	private boolean outcome; 

	public sucessOrFail(int check) 
	{

		super(/* insert the climate object here*/);

		currentCheck = check; 
		actual = Math.random() * (10-1) + 1;
		double raise;
		double aDif = -1*(actual-super.getPercent())/100;

		raise = aDif*currentCheck; 
		currentCheck += raise; 

		if(raise < 0) outcome = false; 
		else if (raise > 0 )outcome = true; 
		else outcome = null;


	}
	public boolean getOutcome()
	{
		return outcome;
	}

}