import javax.management.RuntimeErrorException;

public class SimpleInterestCalculator {

	public static double calculateInterest(double p, double t, int age) {
		double rateOfInterest = 5.3d;
		
		if(t <365) {
			rateOfInterest = 5.2d;
		}
		if(p > 500000 && t <730) {
			throw new RuntimeErrorException(null, "Tenure should not be less than 2 years and principal not more than 500000");
		}
		
		if(age >60) {
			rateOfInterest = Double.sum(0.1d, rateOfInterest);
		}
		double sinterest = (p * t/365 * rateOfInterest)/100;
		return sinterest;
	}

}
