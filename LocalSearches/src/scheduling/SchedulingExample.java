package scheduling;

import localsearch.LocalSearches;

public class SchedulingExample {

	public static void main(String[] args) {
		//Enter data
		Job[] jobs = new Job[4];
		jobs[0] = new Job("A", 1, 8, 10);
		jobs[1] = new Job("B", 3, 0, 7);
		jobs[2] = new Job("C", 5, 6, 11);
		jobs[3] = new Job("D", 3, 1, 4);
		
		Schedule sched = new Schedule(jobs);
		
		LocalSearches.hillClimbing(sched);
	}
	
}
