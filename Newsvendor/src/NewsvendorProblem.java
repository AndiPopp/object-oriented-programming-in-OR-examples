import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * A simple class solving a newsvendor problem defined in the
 * main method.
 * @author Andreas Popp
 */
public class NewsvendorProblem {
	public static void main(String[] args) {
		//input data
		double p = 16;
		double c = 11;
	
		//demand distribution
		NormalDistribution demand = new NormalDistribution(75, 25);
		
		//calculate and print critical fractile
		double crit = (p-c)/p;
		System.out.println("Critical fractile: " + crit);
		
		//calculate and print solution
		double q = demand.inverseCumulativeProbability(crit);
		System.out.println("q* = " + q);
	}
}
