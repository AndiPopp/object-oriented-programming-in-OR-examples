package lotsizing;

public class DynamicLotsizingExample {

	public static void main(String[] args){
		DynamicLotsizingProblem exampleProblem = example();
		exampleProblem.solve();
		System.out.println(exampleProblem.getSolution());
	}
	
	//construct the example problem
	private static DynamicLotsizingProblem example(){
		
		//periods with demands
		Period[] periods = new Period[6];
		periods[0] = new Period(20);
		periods[1] = new Period(15);
		periods[2] = new Period(22);
		periods[3] = new Period(28);
		periods[4] = new Period(19);
		periods[5] = new Period(45);
		
		//build and return the example problem
		return new DynamicLotsizingProblem(
				50, 1, periods);
	}
}
