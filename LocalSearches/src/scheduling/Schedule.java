package scheduling;

import localsearch.LocalSearchSolution;

public class Schedule extends LocalSearchSolution {
	
	//the actual sequence of jobs
	private Job[] sequence;

	//full parameter constructor
	public Schedule(Job[] sequence) {
		this.sequence = sequence;
	}
	
	//get the total tardiness of the schedule
	public int getTotalTardiness(){
		//sum variable
		int totalTardiness = 0;
		//variable representing to current period
		int currentPeriod = 0;
		//sum up the jobs' tardiness
		for(int i = 0; i < sequence.length; i++){
			//add the tardiness
			totalTardiness += sequence[i].getTardiness(currentPeriod);
			//set the completion date as opening date for the next job
			currentPeriod 
				= sequence[i].getCompletationDate(currentPeriod);
		}
		return totalTardiness;
	}
	
	//get all the schedules neighbours
	public Schedule[] getNeighbors(){
		//create the (empty) output array
		Schedule[] neighbors = new Schedule[sequence.length-1];
		//iterate through the jobs i and i+1 to be swapped
		for (int i = 0; i < sequence.length-1; i++){
			neighbors[i] = new Schedule(swapJobs(i));
		}
		return neighbors;
	}
	
	//creates a new Job array swapping jobs i and i+1
	private Job[] swapJobs(int i){
		//create new job array
		Job[] newSequence = new Job[sequence.length];
		//copy each element by reference, swapping the desiganted
		for(int j = 0; j < sequence.length; j++){
			if (j == i){
				newSequence[j] = sequence[i+1];
			}
			else if(j == i+1){
				newSequence[j] = sequence[i];
			}
			else{
				newSequence[j] = sequence[j];
			}
		}
		return newSequence;
	}
	
	//get a string representation of the schedule
	public String toString(){
		String output = "";
		for(Job job : sequence){
			output = output + " " + job.getName();
		}
		return output;
	}

	@Override
	public double calcObjective() {
		return getTotalTardiness();
	}

	@Override
	public boolean toMaximize() {
		return false;
	}

	@Override
	public void print() {
		System.out.print(toString());
		System.out.print(" => Tardiness: ");
		this.printObjective();
	}
}
