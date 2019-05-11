public class NewsvendorProblem {
	public static void main(String[] args) {
		//input data
		double p = 16;
		double c = 11;
		
		//calculate and print critical fractile
		double crit = (p-c)/p;
		System.out.println("Critical fractile: " + crit);
		
		//calculate and print solution
		double q = 50 + 50 * crit;
		System.out.println("q* = " + q);
	}
}
