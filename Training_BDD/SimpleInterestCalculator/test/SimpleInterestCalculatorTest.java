

import org.junit.*;

public class SimpleInterestCalculatorTest {

	@Test
	public void ReturnSIforRateOfInterest() {
		
		double interestAmt = SimpleInterestCalculator.calculateInterest(5000,365,30);
		Assert.assertEquals(265, interestAmt,0.01);
		
	}
	
	@Test
	public void ReturnSIforAccordingToTenure() {
		
		double interestAmt = SimpleInterestCalculator.calculateInterest(6100,350,50);
		Assert.assertEquals(304.16, interestAmt,0.01);
		
	}	
	
	@Test
	public void ReturnSIforAccordingToTenureAge() {
		
		double interestAmt = SimpleInterestCalculator.calculateInterest(6100,300,65);
		Assert.assertEquals(326.71, interestAmt,0.01);
		
	}	
	
	@Test(expected = RuntimeException.class)
	public void ReturnSIforAccordingToTenureMore() {
		
		double interestAmt = SimpleInterestCalculator.calculateInterest(5032000,300,65);
		
		
	}

}
