package cpm;

import jobs.Job;
import jobs.PDMProblem;

public class CPMExample {
	
	public static void main(String[] args){
		PDMProblem P = example();
		P.printSolution();
	}
	
	private static PDMProblem example(){
		Job[] jobs = new Job[6];
		//construct jobs
		jobs[0] = new Job("A", 3);
		jobs[1] = new Job("B", 1);
		jobs[2] = new Job("C", 8);
		jobs[3] = new Job("D", 4);
		jobs[4] = new Job("E", 2);
		jobs[5] = new Job("F", 5);
		//set predecessors and successors
		//Job A
		jobs[0].addSucc(jobs[1]);
		jobs[0].addSucc(jobs[2]);
		//Job B
		jobs[1].addPred(jobs[0]);
		jobs[1].addSucc(jobs[3]);
		jobs[1].addSucc(jobs[4]);
		//Job C
		jobs[2].addPred(jobs[0]);
		jobs[2].addSucc(jobs[5]);
		//Job D
		jobs[3].addPred(jobs[1]);
		jobs[3].addSucc(jobs[5]);
		//Job E
		jobs[4].addPred(jobs[1]);
		jobs[4].addSucc(jobs[5]);
		//Job F
		jobs[5].addPred(jobs[2]);
		jobs[5].addPred(jobs[3]);
		jobs[5].addPred(jobs[4]);
		
		return new PDMProblem(jobs);
	}
}
