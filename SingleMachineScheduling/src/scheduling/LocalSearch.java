package scheduling;

//This class can solve single machine scheduling problems
public class LocalSearch {

	public static void main(String[] args) {
		//Enter data
		Job[] jobs = new Job[4];
		jobs[0] = new Job("A", 1, 8, 10);
		jobs[1] = new Job("B", 3, 0, 7);
		jobs[2] = new Job("C", 5, 6, 11);
		jobs[3] = new Job("D", 3, 1, 4);
		
		//remember the current schedule; 
		//initialize with null, it will be set in the loop
		Schedule currentSchedule = null;
		
		//remember the best schedule in the neighborhood;
		//initialize with the starting schedule, because
		// it is currently the best one found
		Schedule bestSchedule = new Schedule(jobs);
		
		//iterate as long as you find better schedules
		while (bestSchedule != currentSchedule){
			//start by setting the current schedule to the
			//best schedule from the previous iteration
			currentSchedule = bestSchedule;
			
			//look through the neighbors
			for(Schedule neighbor : currentSchedule.getNeighbors()){
				//if this schedule is better, save it as best
				if (neighbor.getTotalTardiness() 
						< bestSchedule.getTotalTardiness()){
					
					bestSchedule = neighbor;
				}
			}
		}
		
		//We found a locally optimal schedule;
		//Print this schedule to the console
		System.out.println("Best schedule:" 
				+ bestSchedule.toString());
		System.out.println("Total tardiness: " 
				+ bestSchedule.getTotalTardiness());
	}
	
}
