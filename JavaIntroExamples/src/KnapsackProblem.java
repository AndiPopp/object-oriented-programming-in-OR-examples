public class KnapsackProblem {
	public static void main(String[] args) {
		//input data
		double[] value = {8, 3, 9, 8, 2, 6, 4, 2};
		double[] weight = {4, 2, 7, 7, 2, 8, 6, 5};
		double capacity = 16;
		//decision variable
		boolean[] packed = new boolean[8];

		//variable to sum up the total value
		double totalValue = 0;
		
		//iterate through the items
		for (int i = 0;i < packed.length;i++){
			//check if item fits
			if (weight[i] < capacity){
				//switch the pack variable
				packed[i] = true;
				//reduce the capacity
				capacity -= weight[i];
				//add the value
				totalValue += value[i];
			}
		}
		
		//print the solution to console as 0/1
		System.out.print("x: ");
		//iterate through the items again
		for (int i = 0;i < packed.length;i++){
			if (packed[i]){
				System.out.print("1 ");
			}else{
				System.out.print("0 ");
			}
		}
		System.out.println();
		
		//print the total value to console
		System.out.println("Total value: " 
				+ totalValue);
	}
}
