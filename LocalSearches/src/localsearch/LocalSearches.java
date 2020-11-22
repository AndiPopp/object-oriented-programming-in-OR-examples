package localsearch;

public class LocalSearches {

	public static LocalSearchSolution hillClimbing(
			LocalSearchSolution start){
		
		LocalSearchSolution current = null;
		LocalSearchSolution best = start;
		
		while (best != current){
			
			//assume first that the current is the best
			current = best;
			current.print();
			
			//check neighbors for better solution
			for(LocalSearchSolution neighbor : current.getNeighbors()){
				if (current.toMaximize() && 
						neighbor.calcObjective() > best.calcObjective()){
					//maximizing version
					best = neighbor;
				}else if (!current.toMaximize() && 
						neighbor.calcObjective() < best.calcObjective()){
					//minimize version
					best = neighbor;
				}
			}
		}
		
		return best;
	}
}
